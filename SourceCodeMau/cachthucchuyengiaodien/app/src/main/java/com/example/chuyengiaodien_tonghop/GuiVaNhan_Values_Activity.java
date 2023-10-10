package com.example.chuyengiaodien_tonghop;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class GuiVaNhan_Values_Activity extends AppCompatActivity{
    private Button btn_changeTop, btn_changeBottom;
    private TextView txt_top, txt_bottom;


    // tạo các định nghĩa đánh dấu thời điểm ghi nhận thay đổi cho chừng trường hợp
    public  static final int REQUEST_CODE_TOP = 999;
    public   static final int REQUEST_CODE_BOTTOM = 998;

    public static final  int RESULT_CODE_UPPER = 100;
    public static final int RESULT_CODE_LOWER = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gui_va_nhan_values);
        // gọi init
        init();
        // xử lý sự kiện
        /*startActivityForResult:
         ==> Phương thức này thường được sử dụng để bắt đầu một hoạt động (activity) mới và sau đó nhận kết quả
         từ hoạt động đó khi hoạt động đó hoàn thành.*/
        btn_changeTop.setOnClickListener(view->{
            Intent intent = new Intent(GuiVaNhan_Values_Activity.this, Result_GuivaNhan.class);
            startActivityForResult(intent,REQUEST_CODE_TOP);
        });

         /*startActivityForResult:
         ==> Phương thức này thường được sử dụng để bắt đầu một hoạt động (activity) mới và sau đó nhận kết quả
         từ hoạt động đó khi hoạt động đó hoàn thành.*/
        btn_changeBottom.setOnClickListener(view->{
            Intent intent = new Intent(GuiVaNhan_Values_Activity.this, Result_GuivaNhan.class);
            startActivityForResult(intent,REQUEST_CODE_BOTTOM);
        });

    }


    /*override method để nhận dữ liệu thay đổi và ghi nhận vào txt view để hiển thị nội dung vừa thay đổi
    * + trong đó:
    *  ++ requestCode: kết quả gửi đi
    *  ++ resultCode: giá trị nhận về
    *  ++ data: lớp Intent nơi thay đổi value mà ta nhận về  */

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String title = data.getStringExtra("yourtitle");
        if(requestCode== REQUEST_CODE_TOP){
            if(resultCode == RESULT_CODE_UPPER){
                txt_top.setText(title.toUpperCase());
            }else if(resultCode==RESULT_CODE_LOWER){
                txt_top.setText(title.toLowerCase());
            }
        }

        if(requestCode == REQUEST_CODE_BOTTOM){
            if(resultCode == RESULT_CODE_UPPER){
                txt_bottom.setText(title.toUpperCase());
            }else if(resultCode==RESULT_CODE_LOWER){
                txt_bottom.setText(title.toLowerCase());
            }
        }
    }




    /*method liên kết id*/
    public void init(){
        btn_changeTop = (Button) findViewById(R.id.btn_changetop);
        btn_changeBottom = (Button) findViewById(R.id.btn_changebottom);
        txt_top = (TextView) findViewById(R.id.txt_top);
        txt_bottom = (TextView) findViewById(R.id.txt_bottom);
    }

    /*ethod showToast*/
    public void showToast(String msg){
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
    }
}