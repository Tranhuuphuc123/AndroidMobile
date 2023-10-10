package com.example.chuyengiaodien_tonghop;
/*tiềm hiểu về các lớp iNtent: Implicitly và Explicitly Intent*/
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/*trng bài này tôi sẽ xử lý sự kiện các button bằng cách Implicit Intent là một loại Intent trong Android được
sử dụng khi bạn muốn thực hiện một hành động mà không cần chỉ định một thành phần (component) cụ thể để xử lý nó.
 => cách thức này không cần tạo ra các priavte Buton, init()
 => hãy xem cách làm sao
*/
public class ImplicitlyAndExplicitlyIntent extends AppCompatActivity implements  View.OnClickListener{
    // tạo ra mảng chứa các ánh xạ id của button
    private int[] listButton = {
            R.id.btn_show,
            R.id.btn_send,
            R.id.btn_call,
            R.id.btn_view,
            R.id.btn_galary
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicitly_and_explicitly_intent);

        // xử lý sự kiện cho các button với kiểu Intent Implicit Intent:
        for(int item: listButton){
            Button btn = (Button) findViewById(item);
            btn.setOnClickListener(this);
        }

    }


    /*method xử lý sự kiện chuyển giáo diện: dùng kiểu Activity listener kế thừa thêm
     * implement View.Onlistener*/
    @Override
    public void onClick(View v) {
        Intent myIntent = new Intent();
        // Chức năng show and send đã đc lam ở bài MainActivityL chuyên iao diện và gửi nhận dữ liệu
        if(v.getId()==R.id.btn_show){
            // tạo cách thức chuyển đến giao diện là một website
             myIntent.setAction(Intent.ACTION_VIEW);
             myIntent.setData(Uri.parse("https://www.google.com.vn/"));
             startActivity(myIntent);
        }else if(v.getId()==R.id.btn_send){
           // tạo chức năng gửi tin nhắn chọn lựa cách hộp thọi message như zalo, message
            myIntent.setAction(Intent.ACTION_SENDTO);
            myIntent.setData(Uri.parse("sms:0962428167"));
            myIntent.putExtra("sms_body","hello re you ok?");
            startActivity(myIntent);
        }else if(v.getId()==R.id.btn_call){
            //thực hiện mootj cuộc gọi điện thoại
//            myIntent.setAction(Intent.ACTION_CALL);
//            myIntent.setData(Uri.parse("tel:0962428167"));
//            startActivity(myIntent);
        }else if(v.getId()==R.id.btn_view){
            // tạo chức năng chuyển đến danh bạ điện thoai(ds liên hệ trong điện thoại)
            myIntent.setAction(Intent.ACTION_VIEW);
            myIntent.setData(Uri.parse("content://contacts/people/"));
            startActivity(myIntent);
        }else if(v.getId()==R.id.btn_galary){
            // show đến mục galary ảnh trong điện thoại
            myIntent.setAction(Intent.ACTION_PICK);
            myIntent.setData(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivity(myIntent);
        }
    }


    /*method showToast*/
    public void showToast(String msg){
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
    }







    /*các cách viết khác nhau xử lớp onClick
    *  1/ btn_show:
    *   if(v.getId()==R.id.btn_show){
            // tạo cách thức chuyển đến giao diện là một website
            Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com.vn/"));
            startActivity(myIntent); // thục thi câu lệnh chuyển

         ## cách 02:
         * Intent myIntent = new Intent();
        // Chức năng show and send đã đc lam ở bài MainActivityL chuyên iao diện và gửi nhận dữ liệu
        if(v.getId()==R.id.btn_show){
            // tạo cách thức chuyển đến giao diện là một website
             myIntent.setAction(Intent.ACTION_VIEW);
             myIntent.setData(Uri.parse("https://www.google.com.vn/"));
             startActivity(myIntent);


       2/ btn_send:
       * else if(v.getId()==R.id.btn_send){
           // tạo chức năng gửi tin nhắn chọn lựa cách hộp thọi message như zalo
            myIntent.setAction(Intent.ACTION_SEND);
            myIntent.putExtra(Intent.EXTRA_TEXT, "Hello");
            myIntent.setType("text/plain");
            startActivity(myIntent);
       *
    * */
}