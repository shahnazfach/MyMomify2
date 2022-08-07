package com.shahnazfachri.mymomify;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.shahnazfachri.mymomify.Databases.Database;
import com.shahnazfachri.mymomify.Models.NoteModel;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import static java.util.Objects.requireNonNull;

public class addnote extends AppCompatActivity {
    private EditText etTitle;
    private EditText etContent;

    private Database db;
    private boolean isEdit = false;
    private int noteID;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addnote);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setBackgroundDrawable(getResources().getDrawable((R.drawable.gradient_background)));

        }


        requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Add Note");


        db = new Database(this);
        Intent dataIntent = getIntent();
        isEdit = dataIntent.getBooleanExtra("isEdit", false);

        etTitle = findViewById(R.id.et_title);
        etContent = findViewById(R.id.et_content);
        Button btnDelete = findViewById(R.id.btn_delete);
        Button btnSave = findViewById(R.id.btn_save);

        if (isEdit) {
            int id = dataIntent.getIntExtra("noteID", 0);
            if (id != 0) {
                NoteModel noteModel = db.getNote(id);
                noteID = id;
                etTitle.setText(noteModel.getNoteTitle());
                etContent.setText(noteModel.getNoteContent());
            }

            btnDelete.setVisibility(View.VISIBLE);
        } else {
            btnDelete.setVisibility(View.GONE);
        }

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteNote();
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = etTitle.getText().toString();
                String note = etContent.getText().toString();
                if (isInputValid()) {
                    if (isEdit) {
                        updateNote(noteID, title, note);
                    } else {
                        saveNote(title, note);
                    }
                }
            }
        });
    }

    private boolean isInputValid() {
        if (TextUtils.isEmpty(etTitle.getText()) || TextUtils.isEmpty(etContent.getText())) {
            if (TextUtils.isEmpty(etTitle.getText())) {
                etTitle.setError("Judul tidak boleh kosong!");
            }

            if (TextUtils.isEmpty(etContent.getText())) {
                etContent.setError("Catatan kosong");
            }

            return false;
        }

        return true;
    }

    private void saveNote(String title, String content) {
        Calendar calendar = Calendar.getInstance();
        @SuppressLint("SimpleDateFormat") SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy, HH:mm");

        String date = sdf.format(calendar.getTime());

        NoteModel noteModel = new NoteModel(title, content, date);
        int success = db.addNote(noteModel);

        String message = "Gagal menyimpan catatan";

        if (success != 0) {
            message = "Catatan tersimpan!";
            finish();
        }

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void updateNote(int noteID, String title, String note) {
        NoteModel noteModel = new NoteModel(noteID, title, note);
        int success = db.updateNote(noteModel);

        String message = "Catatan gagal diupdate";

        if (success != 0) {
            message = "Update catatan sukses!";
            finish();
        }

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void deleteNote() {
        int success = db.deleteNote(noteID);
        String message = "Catatan gagal dihapus";
        if (success != 0) {
            message = "Catatan berhasil dihapus";
            finish();
        }

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
