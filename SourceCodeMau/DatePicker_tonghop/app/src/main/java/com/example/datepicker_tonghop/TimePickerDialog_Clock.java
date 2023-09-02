package com.example.datepicker_tonghop;
/*tieemf hiểu dạngtimepicker dialog dạng hiển thị kiểu giờ phút giây với
biểu tương đồng hồ clock*/
import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class TimePickerDialog_Clock extends AppCompatActivity {
    private TextView txt_datepicker_clock;
    private TimePickerDialog.OnTimeSetListener timeListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_picker_dialog_clock);
        // gọi init
        init();


        //  tiến hành xử lý sự kiện hiển thị timepickerdiaog khi nhấn txt_timepicker_clock
        txt_datepicker_clock.setOnClickListener(view->{
            Calendar cal= Calendar.getInstance();
            int hour = cal.get(Calendar.HOUR_OF_DAY);
            int minutes = cal.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog= new TimePickerDialog(TimePickerDialog_Clock.this,timeListener,hour,minutes,false);
            timePickerDialog.show();
        });

        // tien hành xử lý sự kiện ghi nhận thông tin values vừa choose ở hoojp thoại timepickerdiaog lên txt_timepicker_clock
        timeListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hour, int minute) {
                //hour:minutes
                String time = hour+"h: "+minute+"'";
                txt_datepicker_clock.setText(time);
            }
        };
    }

    // ánh xạ id
    public void init(){
        txt_datepicker_clock = (TextView) findViewById(R.id.txt_timePickerDialog_clock);
    }
}