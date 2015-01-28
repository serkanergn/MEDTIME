package com.example.medtime;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

//import android.app.AlarmManager;

public class MedicineAdding extends Activity {

	Context c = this;
	Button btn_add;
	TextView Name, dosage, time;
	Veritabani v1;

	// AlarmManager a = (AlarmManager)
	// c.getSystemService(Context.ALARM_SERVICE);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_medicine_adding);

		v1 = new Veritabani(this);
		btn_add = (Button) findViewById(R.id.btn_addMed);
		Name = (TextView) findViewById(R.id.txt_MedName);
		dosage = (TextView) findViewById(R.id.txt_dosage);
		time = (TextView) findViewById(R.id.txt_time);

		btn_add.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				System.out.println("add button alaný");
				Medicines medicine = new Medicines();
				medicine.setId(9999);
				medicine.setMedName(Name.getText().toString());
				medicine.setDosage(Integer
						.parseInt(dosage.getText().toString()));
				medicine.setTime(null);
				v1.insertMedicine(medicine);

				Toast.makeText(c, "Medicine Count:" + v1.getMedicineCount(),
						Toast.LENGTH_LONG).show();
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.medicine_adding, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	// public void insertMedicine(Medicines medicine) {
	// System.out.println("insert alaný");
	// SQLiteDatabase db = v1.getWritableDatabase();
	// System.out.println("db baðlandý");
	// ContentValues values = new ContentValues();
	//
	// values.put("medName", medicine.getMedName());
	// values.put("dosage", medicine.getDosage());
	//
	// // values.put("time", medicine.getTime().toString());
	//
	// db.insertOrThrow("medicine", null, values);
	//
	// throw new NullPointerException();
	// }
}
