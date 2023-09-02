package com.example.datepicker_tonghop;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class TimePickerDialog_Spinder extends AppCompatActivity {
    private TextView mDisplayDate;
    private TimePickerDialog.OnTimeSetListener mTimeSetListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_picker_dialog_spinder);

        mDisplayDate = (TextView) findViewById(R.id.txt_timePickerDialog_spinder);
        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                int hour = calendar.get(Calendar.HOUR_OF_DAY);
                int minute = calendar.get(Calendar.MINUTE);
                TimePickerDialog timePickerDialog = new
                        TimePickerDialog(TimePickerDialog_Spinder.this,mTimeSetListener,hour,minute,false);
                timePickerDialog.show();
            }
        });
        mTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hour, int miniutes) {
                //dd/mm/yyyy
                String time = hour+"h : "+miniutes+"'";
                mDisplayDate.setText(time);
            }
        };
    }
}