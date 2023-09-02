package com.example.datepicker_tonghop;

/*Tiềm hiểu dạng DatePickerDialog dạng hiển thị kiểu
 cuốn lịch Calender*/

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class DatePickerDialog_Calender extends AppCompatActivity {
    private TextView txt_datepicker_calender;
    private DatePickerDialog.OnDateSetListener datepickerListenser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_picker_dialog_calender);
        // gọi init
        init();

        // tiến hành xử lý sự kiện khi nhấn nút txt_datepicker_calender
        txt_datepicker_calender.setOnClickListener(view->{
            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog dialog = new DatePickerDialog(DatePickerDialog_Calender.this, datepickerListenser, year, month,day);
            dialog.show();
        });

        // xử lý sự kiện trực tiếp ghi nhận values cho hộp thoại DatePicker_Calender vào txt_dateppicker_calender
        datepickerListenser = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                // dd/mm/yyyy
                String date = day+"/"+(month+1)+"/"+year;
                txt_datepicker_calender.setText(date);
            }
        };
    }


    // ánh xạ id
    public void init(){
        txt_datepicker_calender = (TextView) findViewById(R.id.txt_datepickerDialog_calender);
    }

    // showToast
    public void showToast(String msg){
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
    }
}