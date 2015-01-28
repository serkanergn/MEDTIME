package com.example.medtime;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Veritabani extends SQLiteOpenHelper {

	private static final String DATABASE_NAME = "DB_MEDTIME";
	private static final String TABLE_MEDICINE = "medicine";
	private static final String ID = "id";
	private static final String MEDNAME = "medName";
	private static final String DOSAGE = "dosage";
	private static final String TIME = "time";
	private static final int SURUM = 1;
	private SQLiteDatabase db;

	public Veritabani(Context cont) {
		super(cont, DATABASE_NAME, null, SURUM);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String CREATE_TABLE = "CREATE TABLE " + TABLE_MEDICINE + "(" + ID
				+ " INTEGER PRIMARY KEY AUTOINCREMENT," + MEDNAME
				+ " VARCHAR2(50)," + DOSAGE + " NUMBER," + TIME + " DATE" + ")";
		db.execSQL(CREATE_TABLE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_MEDICINE);
		onCreate(db);
	}

	public void insertMedicine(Medicines medicine) {
		db = this.getWritableDatabase();

		ContentValues values = new ContentValues();

		values.put("medName", medicine.getMedName());
		values.put("dosage", medicine.getDosage());
		// values.put("time", medicine.time.toString());

		db.insert(TABLE_MEDICINE, null, values);
		db.close();
	}

	public void deleteMedicine(int id) { // id si belli olan row u silmek için

		SQLiteDatabase db = this.getWritableDatabase();
		db.delete(TABLE_MEDICINE, ID + " = ?",
				new String[] { String.valueOf(id) });
		db.close();
	}

	public int getMedicineCount() {
		String countQuery = "SELECT  * FROM " + TABLE_MEDICINE;
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery(countQuery, null);

		int count = cursor.getCount();
		cursor.close();
		db.close();
		// return count

		return count;
	}

}
