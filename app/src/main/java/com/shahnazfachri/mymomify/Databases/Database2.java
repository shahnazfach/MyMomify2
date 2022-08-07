package com.shahnazfachri.mymomify.Databases;
import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.shahnazfachri.mymomify.Models.ReportModel;

import java.util.ArrayList;
import java.util.List;

public class Database2 extends SQLiteOpenHelper {

    private static final int DB_VERSION = 2;
    private static final String DB_NAME = "ReportAppDB";
    private static final String TABLE_REPORT = "tb_report";

    private static final String KEY_REPORT_ID;

    static {
        KEY_REPORT_ID = "id2";
    }

    private static final String KEY_REPORT_TXTNAMABUNDA = "namabunda";
    private static final String KEY_REPORT_TXTBERATBADAN = "beratbadan";
    private static final String KEY_REPORT_TXTANAKKEBERAPA = "anakkeberapa";
    private static final String KEY_REPORT_TXTTANGGALLAHIR = "tanggallahir";
    private static final String KEY_REPORT_PREDIKSIKELAHIRAN = "prediksikelahiran";


    public Database2(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db2) {
        String query = "CREATE TABLE " + TABLE_REPORT + " (" +
                KEY_REPORT_ID + " INTEGER PRIMARY KEY, " +
                KEY_REPORT_TXTNAMABUNDA + " TEXT, " +
                KEY_REPORT_TXTBERATBADAN + " TEXT, " +
                KEY_REPORT_TXTANAKKEBERAPA + " TEXT, " +
                KEY_REPORT_TXTTANGGALLAHIR + " TEXT ," +
                KEY_REPORT_PREDIKSIKELAHIRAN + " TEXT " + ")";

        db2.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db2, int oldVersion, int newVersion) {
        if (oldVersion >= newVersion)
            return;
        db2.execSQL("DROP TABLE IF EXISTS " + TABLE_REPORT);

        onCreate(db2);
    }

    public int addReport(ReportModel reportModel) {
        SQLiteDatabase db2 = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(KEY_REPORT_TXTNAMABUNDA, reportModel.getTxtNamaBunda());
        values.put(KEY_REPORT_TXTBERATBADAN, reportModel.getTxtBeratBadan());
        values.put(KEY_REPORT_TXTANAKKEBERAPA, reportModel.getTxtAnakKeBerapa());
        values.put(KEY_REPORT_TXTTANGGALLAHIR, reportModel.getTxtTanggalLahir());
        values.put(KEY_REPORT_PREDIKSIKELAHIRAN, reportModel.getReportPrediksiKelahiran());

        long ID = db2.insert(TABLE_REPORT, null, values);
        db2.close();

        return (int) ID;
    }

    public List<ReportModel> getReports() {
        List<ReportModel> reportList = new ArrayList<>();
        String query = "SELECT * FROM " + TABLE_REPORT;

        SQLiteDatabase db2 = this.getWritableDatabase();
        @SuppressLint("Recycle") Cursor cursor = db2.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                int id2 = cursor.getInt(0);
                String namabunda = cursor.getString(1);
                String beratbadan = cursor.getString(2);
                String anakkeberapa = cursor.getString(3);
                String tanggallahir = cursor.getString(4);
                String prediksikelahiran = cursor.getString(5);

                ReportModel reportModel = new ReportModel(id2,namabunda, beratbadan,anakkeberapa,tanggallahir, prediksikelahiran);

                reportList.add(reportModel);
            } while (cursor.moveToNext());
        }

        return reportList;
    }

    public ReportModel getReport(int id2) {
        SQLiteDatabase db2 = this.getReadableDatabase();

        @SuppressLint("Recycle") Cursor cursor = db2.query(TABLE_REPORT, new String[] {
                KEY_REPORT_ID,
                KEY_REPORT_TXTNAMABUNDA,
                KEY_REPORT_TXTBERATBADAN,
                KEY_REPORT_TXTANAKKEBERAPA,
                KEY_REPORT_TXTTANGGALLAHIR,
                KEY_REPORT_PREDIKSIKELAHIRAN

        }, KEY_REPORT_ID + "=?", new String[]{String.valueOf(id2)}, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }

        assert cursor != null;
        int reportID = cursor.getInt(0);
        String namabunda = cursor.getString(1);
        String beratbadan = cursor.getString(2);
        String anakkeberapa = cursor.getString(3);
        String tanggallahir = cursor.getString(4);
        String prediksikelahiran = cursor.getString(5);

        return new ReportModel(reportID,namabunda,beratbadan,anakkeberapa,tanggallahir, prediksikelahiran);
    }

    public int updateReport(ReportModel reportModel) {
        SQLiteDatabase db2 = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(KEY_REPORT_TXTNAMABUNDA, reportModel.getTxtNamaBunda());
        values.put(KEY_REPORT_TXTBERATBADAN, reportModel.getTxtBeratBadan());
        values.put(KEY_REPORT_TXTANAKKEBERAPA, reportModel.getTxtAnakKeBerapa());
        values.put(KEY_REPORT_TXTTANGGALLAHIR, reportModel.getTxtTanggalLahir());
        values.put(KEY_REPORT_PREDIKSIKELAHIRAN, reportModel.getReportPrediksiKelahiran());

        return db2.update(TABLE_REPORT, values, KEY_REPORT_ID + "=?",
                new String[]{String.valueOf(reportModel.getReportID())});
    }

    public int deleteReport(int id2) {
        SQLiteDatabase db2 = this.getWritableDatabase();
        int ID = db2.delete(TABLE_REPORT, KEY_REPORT_ID + "=?",
                new String[]{String.valueOf(id2)});
        db2.close();

        return ID;
    }
}
