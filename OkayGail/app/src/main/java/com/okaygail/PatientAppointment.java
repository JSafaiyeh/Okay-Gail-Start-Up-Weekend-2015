package com.okaygail;

import android.graphics.drawable.Drawable;

public class PatientAppointment {

    private Drawable patientPhoto;
    private String name;
    private String time;

    public PatientAppointment(Drawable patientPhoto, String name, String time) {
        this.patientPhoto = patientPhoto;
        this.name = name;
        this.time = time;
    }

    public Drawable getPatientPhoto() {
        return patientPhoto;
    }

    public void setPatientPhoto(Drawable patientPhoto) {
        this.patientPhoto = patientPhoto;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
