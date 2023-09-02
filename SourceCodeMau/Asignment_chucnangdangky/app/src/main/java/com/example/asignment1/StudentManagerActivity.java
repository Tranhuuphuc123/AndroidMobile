package com.example.asignment1;
import androidx.appcompat.app.AppCompatActivity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asignment1.adapter.StudentAdapter;
import com.example.asignment1.model.student;
import com.example.asignment1.sqlLite.DBController;

import java.util.ArrayList;
import java.util.Calendar;

public class StudentManagerActivity extends AppCompatActivity {

    private TextView txt_datepiker;
    private Button btn_date, btn_hide;
    private DatePickerDialog.OnDateSetListener dateListener;

    private EditText editRollno, editStudentName;
    private RadioGroup radioGroup;
    private RadioButton radioButtonShort, radioButtonLong;
    private DBController dbController;
    private ListView listView;
    private ArrayList<student> studentList;
    private StudentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_manager);


         /* thiết lặp bàn phím ảo trong file Activity.class
         + SOFT_INPUT_STATE_ALWAYS_VISIBLE: cơ chế hiển thị bàn phím ảo
         + WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE: cơ chế tg thích khi bật bàn phím ảo nó tg thích với các view khác không che mất nó đi
        */
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE| WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

        // gọi init ánh xạ các id
        init();

        // xử lý su kiện ẩn bàn phím ảo
        btn_hide.setOnClickListener(view->hide_keyboard());

        // xử lý sự kiện khi nhấn nút date hiện lên hộp thoại Datepicker
        btn_date.setOnClickListener(view->{
            Calendar cal = Calendar.getInstance();
            int year = cal.get(Calendar.YEAR);
            int month = cal.get(Calendar.MONTH);
            int day = cal.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog dialog = new DatePickerDialog(StudentManagerActivity.this, dateListener, year, month, day);
            dialog.show();
        });

        // xử lý sự kiện gán value khi chọn date picker vào txt_date
        dateListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                String date = day+"/"+(month+1)+"/"+year;
                txt_datepiker.setText(date);
            }
        };


        // xử lý sự kiện khi nhấn nút add thêm các trường dữ liệu
        Button btn_add = (Button) findViewById(R.id.btn_add);
        btn_add.setOnClickListener(view->{
            String rollNo = editRollno.getText().toString();
            String studentName = editStudentName.getText().toString();
            String term = radioButtonShort.isChecked() ? "short-term" : "long-term";
            String date = txt_datepiker.getText().toString();

            // kiểm tra các values có tồn tại thì thực insert
            if(!rollNo.isEmpty() && !studentName.isEmpty() && !term.isEmpty() && !date.isEmpty()){
                // khởi tạo lớp model student
                student st = new student(rollNo, studentName, term, date);
                // tiến hanh insert vao sqlIte
                dbController = new DBController(this);
                dbController.insert(st);
                //sau khi insert xong đổ liền cho list view nó nhận
                studentList.add(st);

                // hiên thị thông báo thành công
                showToast("Student added successfully!");

                // tiến hanh xóa các trg dữ liệu đi khi thêm thành công
                editRollno.setText("");
                editStudentName.setText("");
                radioGroup.check(R.id.radioButton_short);
                txt_datepiker.setText("");

            }else{
                showToast(("student added failed!"));
            }
        });

        // hiển thị dữ liệu lên listview
        displayListView();

    }// end Oncreate

    /*xử lý sự kiện datepicker*/

    /*method hiển thị dữ liệu ra listView*/
    public void  displayListView(){
        // khởi tạo DBController tương tác cơ sở dữ liệu
         dbController = new DBController(this);
         /* list view nhận đc các thông tin vừa insert insert rồi tiến hánh lk dbcontroller
         dùng method getALlStudent hiển thị dl lên listview trên giao diện*/
         studentList = dbController.getAllstudents();
         adapter = new StudentAdapter(this, studentList);
         listView.setAdapter(adapter);
    }


    /*mehtod xử lý ẩn bàn phím ảo*/
    public void hide_keyboard(){
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        /*this.getCurrentFocus().getWindowToken(), 0: nghĩa là liên kết đến các focus cụ thể
         * là các edit text khi ấn vào ấy-> nghĩa là khi nhập nd trong edit text thì ta mún ấn nút ẩn nó sẽ ẩn đi bàn phím ảo
         * chứ không để hiện hoài, thì bắt sự kiện focus chính là ở nút edit text */
        inputMethodManager.hideSoftInputFromWindow(this.getCurrentFocus().getWindowToken(), 0);
    }


    /* xây dựng function ánh xạ id*/
    public void init(){
        txt_datepiker = (TextView)findViewById(R.id.txt_date);
        btn_date=(Button) findViewById(R.id.btn_date);
        editRollno = (EditText) findViewById(R.id.edit_rollno);
        editStudentName = (EditText) findViewById(R.id.edit_StudentName);
        radioGroup = (RadioGroup) findViewById(R.id.radiogroup_select);
        btn_hide= (Button) findViewById(R.id.btn_hide_keyboard);
        radioButtonShort = (RadioButton) findViewById(R.id.radioButton_short);
        radioButtonLong = (RadioButton) findViewById(R.id.radioButton_long);
        listView = (ListView) findViewById(R.id.listview);
    }


    /* xây dựng funtion showToast*/
    public void showToast(String msg){
        Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
    }

}//end class