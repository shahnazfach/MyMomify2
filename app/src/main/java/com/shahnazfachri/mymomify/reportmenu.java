package com.shahnazfachri.mymomify;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.RequiresApi;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.shahnazfachri.mymomify.Adapters.ReportAdapter;
import com.shahnazfachri.mymomify.Databases.Database2;
import com.shahnazfachri.mymomify.Models.ReportModel;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.requireNonNull;

public class reportmenu extends AppCompatActivity {
    private RecyclerView rtList;
    private TextView rtEmpty;

    private Database2 db2;
    private ReportAdapter adapters;
    private List<ReportModel> report = new ArrayList<>();

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reportmenu);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setBackgroundDrawable(getResources().getDrawable((R.drawable.gradient_background)));

            requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Riwayat Kehamilan");
        }
        db2 = new Database2(this);

        rtList = findViewById(R.id.rt_list);
        rtEmpty = findViewById(R.id.rt_empty);
        FloatingActionButton rtAdd = findViewById(R.id.rt_add);

        adapters = new ReportAdapter(this);
        rtList.setLayoutManager(new LinearLayoutManager(this));
        rtList.setAdapter(adapters);

        rtAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(reportmenu.this, home.class));
            }
        });
    }
    @Override
    protected void onResume() {
        super.onResume();
        getReports();
    }

    private void getReports() {
        List<ReportModel> report = db2.getReports();
        adapters.setReport(report);

        if (report.size() != 0) {
            rtEmpty.setVisibility(View.GONE);
            rtList.setVisibility(View.VISIBLE);
        } else {
            rtEmpty.setVisibility(View.VISIBLE);
            rtList.setVisibility(View.GONE);
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





