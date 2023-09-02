package com.example.datepicker_tonghop;
/*bài này tiềm hiểu về hộp thoại datePicker Dialog dạng Spinder là dạng
* chọn ngày kiểu máy quay xoay chọn các ngày/tháng/năm
*  */


import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class DatePickerDialog_Spinder extends AppCompatActivity {
    private TextView txt_datepicker;
    private DatePickerDialog.OnDateSetListener dateSetListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datepicker_dialog_spinder);

        txt_datepicker = (TextView)findViewById(R.id.txt_datepickerDialog);

        // tiến hành xử lý sự kiện cho txt_datePicker khi nhấn txt_datepicker nó sẽ hiển thị DatePicker Dialog
        txt_datepicker.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // lớp calender
                Calendar cal = Calendar.getInstance();
                int year =  cal.get(Calendar.YEAR);
                int month =  cal.get(Calendar.MONTH);
                int day =  cal.get(Calendar.DAY_OF_MONTH);

                // DatePickerDialog là chế độ chọn ngày/tháng/năm theo kiểu kiểu xem ngày lịch bt có thể tour tùy  chọn
                /*giải thích code bên dưới
                 + DatePicker_Dialog.this: tên class
                 + android.R.style.Theme_Holo_Dialog_MinWidth:  Đây là kiểu giao diện (style) được áp dụng cho hộp thoại DatePickerDialog.
                 các kiểu giao diện này thg có sẵn(tiềm hiểu thêm???)
                * */
                DatePickerDialog dialog = new DatePickerDialog(DatePickerDialog_Spinder.this, android.R.style.Theme_Holo_Dialog_MinWidth, dateSetListener, year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        // xử lý trực tiêp cho hộp thoại date Picker Dialog: khi hiển thị ra theo dạng: đ/mm/yyyy
        dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                //thiết lặp dạng ngày tháng năm: dd/mm//yyyy
                String date = day+"/"+(month+1)+"/"+year;
                // chỗ này dùng để ghi nhân value khi chọn trên hộp thoại datePicker nó ghi nhận và hiển thị ở ô txt_datepicker
                txt_datepicker.setText(date);
            }
        };

    }// end OnCreate



}// end clasd