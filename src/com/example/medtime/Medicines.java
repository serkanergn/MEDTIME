package com.example.medtime;

import java.util.Date;

public class Medicines {
	int id;
	String medName;
	int dosage;
    Date time;

    
    
    
	public Medicines() {
		super();
	}

	public Medicines(int id, String medName, int dosage, Date time) {
		super();
		this.id = id;
		this.medName = medName;
		this.dosage = dosage;
		this.time = time;

	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMedName() {
		return medName;
	}
	public void setMedName(String medName) {
		this.medName = medName;
	}
	public int getDosage() {
		return dosage;
	}
	public void setDosage(int dosage) {
		this.dosage = dosage;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	
    
    }
