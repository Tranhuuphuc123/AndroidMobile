package com.example.kienthuctonghopactivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


/*Trong bài này ta sé xử lý Textview cùng các thuộc tính bên phần Activity này chứ không xay dựng nó bên Layout nữa */


public class WidgetTextviewActivity extends AppCompatActivity {

    private TextView text1;
    private  TextView text2; // tạo giá biến TextView tên text2 để tiến haành set thuộc tính cho TextView two bên layout
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // thuộc tính dẫn suorce file activity_widget_textview vào
        setContentView(R.layout.activity_widget_textview);

        /*================Mục thiết lập cho Text1====================================*/
        /* thực hiên tương tác với tp textview bên layout: cách là dùng findViewBy
         dấn đến R(Resource), id(mã id), tvOne(chinnh là id thiết lập cho textview bên layout)
         ==> lưu ý cần ép kiểu cùng về một kiểu dl là Textiew*/
        text1 = (TextView)findViewById(R.id.tvOne);
        // thiết lặp nội dugn textview bên Activity
        text1.setText("Thay đổi nội dung TextView bên Activity");
        //nhận giá trị hay lấy giá trị bên layout/setText vừa gán với getText() cho Activity
        ShowToast(text1.getText().toString());


        /*================Mục thiết lập cho Text2====================================*/
        // tiến hành kết nối với id của textview Two bên layout
        text2 = (TextView)findViewById(R.id.tvTwo);
        /* thiết lặp nội dung textview two bên Activity
        * ==>Note: do TextView 2 chưa thiết lập gì bên layout trong phần này ta
        * sẽ tiến hành thiết lập nhưng thiết lập bên Activity:
        * */
        text2.setText("Nội dung TextView 2");
        text2.setGravity(Gravity.CENTER_HORIZONTAL);
        text2.setTextSize(20);
        text2.setBackgroundColor(Color.parseColor("#00FF33"));
        // tất cả đều in hoa
        text2.setAllCaps(true);
        // in đậm
        text2.setTypeface(text2.getTypeface(), Typeface.BOLD);
        //nhận giá trị hay lấy giá trị bên layout/setText vừa gán với getText() cho Activity
        ShowToast(text2.getText().toString());

    }

    public void ShowToast(String msg){
        /*
        * Đây là phương thức tạo một đối tượng Toast cho method ShowToast()
        * => trong đó"
        *   + Toast: là một loại thông báo ngắn tạm thời xuất hiện trên màn hình của thiết bị di động
        *   + makeText: là method tĩnh dùng để gọi và khởi tạo đối tượng cho Toast
        *   + getApplicationContext(): Đây là một phương thức để lấy ra Context(nội dung) của ứng dụng.
        *   + msg: Đây là một thông điệp, tức là chuỗi ký tự (String) muốn hiển thị trên Toast.
        *   + Toast.LENGH_SHORT: xét thời gian hiển thị trên giao diện layout(xem lại bài log and Toast)
        *   + show(): gọi toast và hiển thị chuỗi ký tự mà Toast vừa nhận
         * */
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
    }
}