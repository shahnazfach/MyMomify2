package com.shahnazfachri.mymomify;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.shahnazfachri.mymomify.Databases.Database2;
import com.shahnazfachri.mymomify.Models.ReportModel;

import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.Calendar;
import java.util.Locale;

import static java.util.Objects.requireNonNull;


public class home extends AppCompatActivity {

    DatePickerDialog datePickerDialog,datepickerdialog, setClickListener;
    SimpleDateFormat dateFormatter;
    TextView DateResult, txtPrediksiKelahiran, txtTglLahir;
    TextView Datebaru;
    EditText cyclelength, txtNamaBunda,txtBeratBadan,txtAnakKeBerapa,periodlength, etTglLahir;
    Button btDatePicker,dateTglLahir, dateHPHT;
    Button simpan;
    Button hapus;
    ActionBar actionBar ;


    private Database2 db2;
    private boolean isEdit2 = false;
    private int reportID;


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(@NonNull Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setBackgroundDrawable(getResources().getDrawable((R.drawable.gradient_background)));

        }
        requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Data Kehamilan");

        db2 = new Database2(this);
        Intent dataIntent = getIntent();
        isEdit2 = dataIntent.getBooleanExtra("isEdit2", false);

        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);

        txtNamaBunda = (EditText) findViewById(R.id.txtNamaBunda);
        txtBeratBadan = (EditText) findViewById(R.id.txtBeratBadan);
        txtAnakKeBerapa = (EditText) findViewById(R.id.txtAnakKeBerapa);
        txtPrediksiKelahiran = (TextView) findViewById(R.id.txtPrediksiKelahiran);
        txtTglLahir = (TextView) findViewById(R.id.txtTglLahir);
        etTglLahir = (EditText) findViewById(R.id.etTglLahir);
        simpan = (Button) findViewById(R.id.btn_simpan);
        hapus = (Button) findViewById(R.id.btn_hapus);
        btDatePicker = (Button) findViewById(R.id.dateHPHT);
        dateTglLahir = (Button) findViewById(R.id.dateTglLahir);
        if (isEdit2) {
            int id2 = dataIntent.getIntExtra("reportID", 0);
            if (id2 != 0) {
                ReportModel reportModel = db2.getReport(id2);
                reportID = id2;
                txtNamaBunda.setText(reportModel.getTxtNamaBunda());
                txtBeratBadan.setText(reportModel.getTxtBeratBadan());
                txtAnakKeBerapa.setText(reportModel.getTxtAnakKeBerapa());
                txtPrediksiKelahiran.setText(reportModel.getReportPrediksiKelahiran());
                etTglLahir.setText(reportModel.getTxtTanggalLahir());

                
            }

            hapus.setVisibility(View.VISIBLE);
        } else {
            hapus.setVisibility(View.GONE);
        }

        hapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteReport();
            }
        });

        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String namabunda = txtNamaBunda.getText().toString();
                String tanggallahir = etTglLahir.getText().toString();
                String beratbadan = txtBeratBadan.getText().toString();
                String anakkeberapa = txtAnakKeBerapa.getText().toString();
                String prediksikelahiran = txtPrediksiKelahiran.getText().toString();

                if (isInputValid()) {
                    if (isEdit2) {
                        updateReport(reportID, namabunda,tanggallahir,beratbadan,anakkeberapa,prediksikelahiran);
                    } else {
                        saveReport(namabunda,tanggallahir,beratbadan,anakkeberapa, prediksikelahiran);
                    }
                }
            }
        });

        dateTglLahir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTglLahir();
            }
        });

        btDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                showDateDialog();
            }
        });
    }

    private void showTglLahir() {
        Calendar calendar = Calendar.getInstance();
        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Calendar date = Calendar.getInstance();
                date.set(year, month, dayOfMonth);
                etTglLahir.setText(dateFormatter.format(date.getTime()));
            }
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));

        datePickerDialog.show();
    }

    public void showDateDialog(){

        Calendar newCalendar = Calendar.getInstance();
        datepickerdialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            @SuppressLint("SetTextI18n")
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {


                Calendar newdatee = Calendar.getInstance();
                newdatee.set((year + 1),(monthOfYear - 3 ) , (dayOfMonth + 7) );
                txtPrediksiKelahiran.setText("Prediksi Kelahiran : " + dateFormatter.format(newdatee.getTime()));

            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datepickerdialog.show(); }




    private boolean isInputValid() {
        if (TextUtils.isEmpty(txtAnakKeBerapa.getText()) || TextUtils.isEmpty(txtBeratBadan.getText())) {
            if (TextUtils.isEmpty(txtAnakKeBerapa.getText())) {
                txtAnakKeBerapa.setError("Harus diisi!");
            }

            if (TextUtils.isEmpty(txtBeratBadan.getText())) {
                txtBeratBadan.setError("Harus diisi!");
            }

            return false;
        }

        return true;
    }

    private void saveReport(String namabunda, String tanggallahir,String beratbadan, String anakkeberapa, String prediksikelahiran) {

        ReportModel reportModel = new ReportModel(namabunda,tanggallahir,beratbadan,anakkeberapa,prediksikelahiran);
        int success = db2.addReport(reportModel);

        String message = "Gagal menyimpan report";

        if (success != 0) {
            message = "Report tersimpan!";
            finish();
        }

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void updateReport(int reportID,String namabunda, String beratbadan,String anakkeberapa,String tanggallahir, String prediksikelahiran) {
        ReportModel reportModel = new ReportModel(reportID,namabunda, beratbadan,anakkeberapa,tanggallahir, prediksikelahiran);
        int success = db2.updateReport(reportModel);

        String message = "Report gagal diupdate";

        if (success != 0) {
            message = "Report catatan sukses!";
            finish();
        }

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void deleteReport() {
        int success = db2.deleteReport(reportID);
        String message = "Report gagal dihapus";
        if (success != 0) {
            message = "Report berhasil dihapus";
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