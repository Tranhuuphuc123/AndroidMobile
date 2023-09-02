package com.example.datepicker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    CalendarView calendarView;
    Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // khởi tạo calender dạng date kiểu lịch
        calendarView = findViewById(R.id.calenderView);

        // xử lý sự kiện lấy ngày tháng năm người dùng chọn
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int day) {
                String msg = "Selected date day: " + day + " /Month: " + (month+1) + " /year: " + year;
                showToast(msg);
            }
        });

        // viết kiểu lambda

       /* calendarView.setOnDateChangeListener((@NonNull calendarView, int year, int month, int day) -> {
            String msg = "Selected date day: " + day + " /Month: " + (month + 1) + " /year: " + year;
            showToast(msg);
        });*/
    }



    // xây dựng hàm showToast
    public void showToast(String msg){
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
    }
}
