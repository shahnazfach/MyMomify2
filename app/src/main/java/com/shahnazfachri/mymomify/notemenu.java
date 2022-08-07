package com.shahnazfachri.mymomify;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.RequiresApi;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.shahnazfachri.mymomify.Adapters.NoteAdapter;
import com.shahnazfachri.mymomify.Databases.Database;
import com.shahnazfachri.mymomify.Models.NoteModel;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import static java.util.Objects.requireNonNull;

public class notemenu extends AppCompatActivity {
    private RecyclerView rvList;
    private TextView tvEmpty;

    private Database db;
    private NoteAdapter adapter;


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notemenu);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setBackgroundDrawable(getResources().getDrawable((R.drawable.gradient_background)));

        }


        requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Catatan Kehamilan");

        db = new Database(this);

        rvList = findViewById(R.id.rv_list);
        tvEmpty = findViewById(R.id.tv_empty);
        FloatingActionButton fabAdd = findViewById(R.id.fab_add);

        adapter = new NoteAdapter(this);
        rvList.setLayoutManager(new LinearLayoutManager(this));
        rvList.setAdapter(adapter);

        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(notemenu.this, addnote.class));
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        getNotes();
    }

    private void getNotes() {
        List<NoteModel> notes = db.getNotes();
        adapter.setNotes(notes);

        if (notes.size() != 0) {
            tvEmpty.setVisibility(View.GONE);
            rvList.setVisibility(View.VISIBLE);
        } else {
            tvEmpty.setVisibility(View.VISIBLE);
            rvList.setVisibility(View.GONE);
        }
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
