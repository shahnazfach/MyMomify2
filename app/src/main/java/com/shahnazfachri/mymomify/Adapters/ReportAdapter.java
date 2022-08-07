package com.shahnazfachri.mymomify.Adapters;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shahnazfachri.mymomify.Models.ReportModel;
import com.shahnazfachri.mymomify.R;
import com.shahnazfachri.mymomify.home;

import java.util.ArrayList;
import java.util.List;

public class ReportAdapter extends RecyclerView.Adapter<ReportAdapter.ViewHolder> {
    private Context context;
    private List<ReportModel> report;

    public ReportAdapter(Context context) {
        this.context = context;
        this.report = new ArrayList<>();
    }
    public void setReport(List<ReportModel> report) {
        this.report = report;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public ReportAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.list_itemreport, viewGroup, false);
        return new ReportAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ReportAdapter.ViewHolder viewHolder, int i) {
        final ReportModel reportModel = report.get(i);

        viewHolder.tv_namabunda.setText(reportModel.getTxtNamaBunda());
        viewHolder.tv_tgllahir.setText(reportModel.getTxtTanggalLahir());
        viewHolder.tv_beratbadan.setText(reportModel.getTxtBeratBadan());
        viewHolder.tv_anakkeberapa.setText(reportModel.getTxtAnakKeBerapa());
        viewHolder.tv_prediksilahir.setText(reportModel.getReportPrediksiKelahiran());


        viewHolder.cpItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, home.class);
                intent.putExtra("isEdit2", true);
                intent.putExtra("reportID", reportModel.getReportID());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return report.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cpItem;
        private TextView tv_namabunda,
                tv_tgllahir,
                tv_beratbadan,
                tv_anakkeberapa,
                tv_prediksilahir;
        ViewHolder(@NonNull View itemView) {
            super(itemView);
            cpItem = itemView.findViewById(R.id.cp_item);
            tv_namabunda = itemView.findViewById(R.id.tv_namabunda);
            tv_tgllahir = itemView.findViewById(R.id.tv_tgllahir);
            tv_beratbadan = itemView.findViewById(R.id.tv_beratbadan);
            tv_anakkeberapa = itemView.findViewById(R.id.tv_anakkeberapa);
            tv_prediksilahir = itemView.findViewById(R.id.tv_prediksilahir);

        }
    }

}
