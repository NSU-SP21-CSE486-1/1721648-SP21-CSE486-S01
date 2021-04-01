package com.example.pickerfortime;

import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

public abstract class onTimeSet extends AppCompatActivity {
    public abstract void onTimeSet(TimePicker view, int hourOfDay, int minute);
}
