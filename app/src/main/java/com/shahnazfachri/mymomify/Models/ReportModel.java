package com.shahnazfachri.mymomify.Models;

public class ReportModel {
    private int reportID;
    private String txtNamaBunda;
    private String txtBeratBadan;
    private String txtAnakKeBerapa;
    private String txtTanggalLahir;
    private String reportPrediksiKelahiran;


    public ReportModel(int reportID,
                       String txtNamaBunda,
                       String txtTanggalLahir,
                       String txtBeratBadan,
                       String txtAnakKeBerapa,
                       String reportPrediksiKelahiran
                       )
    {
        this.reportID = reportID;
        this.txtNamaBunda = txtNamaBunda;
        this.txtTanggalLahir = txtTanggalLahir;
        this.txtBeratBadan = txtBeratBadan;
        this.txtAnakKeBerapa = txtAnakKeBerapa;
        this.reportPrediksiKelahiran = reportPrediksiKelahiran;

    }
    public ReportModel(String txtNamaBunda,
                       String txtTanggalLahir,
                       String txtBeratBadan,
                       String txtAnakKeBerapa,
                       String reportPrediksiKelahiran)
    {
        this.txtNamaBunda = txtNamaBunda;
        this.txtTanggalLahir = txtTanggalLahir;
        this.txtBeratBadan = txtBeratBadan;
        this.txtAnakKeBerapa = txtAnakKeBerapa;
        this.reportPrediksiKelahiran = reportPrediksiKelahiran;

    }

    public int getReportID() {
        return reportID;
    }

    public void setReportID(int reportID) {
        this.reportID = reportID;
    }

    public String getTxtNamaBunda() {
        return txtNamaBunda;
    }

    public void setTxtNamaBunda(String txtNamaBunda) {
        this.txtNamaBunda = txtNamaBunda;
    }

    public String getTxtBeratBadan() {
        return txtBeratBadan;
    }

    public void setTxtBeratBadan(String txtBeratBadan) {
        this.txtBeratBadan = txtBeratBadan;
    }

    public String getTxtAnakKeBerapa() {
        return txtAnakKeBerapa;
    }

    public void setTxtAnakKeBerapa(String txtAnakKeBerapa) {
        this.txtAnakKeBerapa = txtAnakKeBerapa;
    }

    public String getTxtTanggalLahir() {
        return txtTanggalLahir;
    }

    public void setTxtTanggalLahir(String txtTanggalLahir) {
        this.txtTanggalLahir = txtTanggalLahir;
    }

    public String getReportPrediksiKelahiran() {
        return reportPrediksiKelahiran;
    }

    public void setReportPrediksiKelahiran(String reportPrediksiKelahiran) {
        this.reportPrediksiKelahiran = reportPrediksiKelahiran;
    }
}


