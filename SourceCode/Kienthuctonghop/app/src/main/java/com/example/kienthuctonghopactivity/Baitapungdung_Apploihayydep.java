package com.example.kienthuctonghopactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class Baitapungdung_Apploihayydep extends AppCompatActivity {

    private Button button;
    private TextView textView;

    // tạo một arraylist chứa các câu danh ngôn
    ArrayList<String> list_danhngon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baitapungdung_apploihayydep);

        init();
    }

    // tọa init ánh xạ các icon
    public void init(){
        button=(Button) findViewById(R.id.btn_button);
        textView=(TextView) findViewById(R.id.txtView);

        // liệt kê các câu danh ngôn-> lưu ý khởi tạo vùng nhớ cho nó trc tiên
        list_danhngon = new ArrayList<String>();
        list_danhngon.add("Cá không ăn muối cá ươn");
        list_danhngon.add("Công cha nghĩa mẹ như núi sâu thác nguồn");
        list_danhngon.add("Mẹ là tất cả, cha công đức vô lượng");
        list_danhngon.add("phật pháp nhiệm màu");
        list_danhngon.add("Khiêm tốn là đức tính tốt đẹp");
    }


    // xây dựng method xử lý onClick của button
    public void ShowButton(View v){
        /*tạo CountDownTimer: linh hoạt thời gian xuất hiên
          => cấu trúc CountDownTimer:
                    CountDownTimer <name> = new CountDownTimer(<time1>, <time2>){
                        @Override
                        public void onTick(long millisUntilFinished){
                           ...
                        }

                        @override
                        public void onFinish(){
                          ......
                        }
                    }
        * => có 2 method:
        *  + ontick: cứ khoản time2 th nó sẽ thiết lặp thời gian xuất hiện cho sau time2
           + onFinish: cứ time1 thì nó sẽ xuất hiên
        * */
        CountDownTimer countDownTimer = new CountDownTimer(10000,2000) {
            @Override
            public void onTick(long l) {
                /*lôi các câu danh ngôn đưa vào txtView để xuất rA
                 * => LƯU Ý: VỚI Arraylist thì nó tg đường mảng array vị trí đầu tiền sẽ là 0->n
                 * => Tuy nhiên mục đích của đề bài là nấn nút show và nó xé xuất hiện lần lượt các câu danh ngôn một cách
                 * ngẫu nhiên nên nhớ rằng kiến thức java số ngẫu nhiên là Random:
                 *   + khởi tạo Random số ngẫu nhiên
                 *   + lưu ý với random.nextIn(values)=> values phải là một giá trị thg là tổng các phần tử trong arraylist
                 * để nó quét hết sl rồi phát ngẫu nhiên từng cái, vì vậy để chắc cú thay vì tự cộng tùm lùm thiếu chính xác
                 * ta dùng  arraylist_name.size(): tức lấy tên arraylist kết nối hàm size() là lấy đc tổng một cách chính xác
                 *   + sử dụng + " " (tức là xét string chuyển values thành chuỗi)
                 * nhâất
                 *
                 * */
                Random values_ngaunhien = new Random();
                // thiết lặp các text xuất hiện ngẫu nhiên
                textView.setText(list_danhngon.get(values_ngaunhien.nextInt(list_danhngon.size())) + "");



                /* thiết lặp cho vị trí xuất hiện bất kỳ  trên màn hình
                 * => làm như sau:
                 *   + đầu tiên tạo ra một số number gán các values (cụ thể tổng số phần tử trong arraylist có đc
                 *  cho number này)
                 *   + dùng switch-case để lặp lận các th: vd pt thứ 0 nằm ở giữa, thứ 1 nằm bền trái..
                 *   + dùng gravity để định vị trí tường ứng
                 * */
                int num = values_ngaunhien.nextInt(5);
                switch (num){
                    case 0:
                        textView.setGravity(Gravity.CENTER);
                        break;
                    case 1:
                        textView.setGravity(Gravity.TOP);
                        break;
                    case 2:
                        textView.setGravity(Gravity.BOTTOM);
                        break;
                    case 3:
                        textView.setGravity(Gravity.LEFT);
                        break;
                    case 4:
                        textView.setGravity(Gravity.RIGHT);
                        break;
                }

                /* thiết lặp kích cỡ bất ký: -> nghĩa là nó to nhỏ một cách ngẫu nhiên
                 * => tại sao lại + 20, vì bản chất random là nó phát ngẫu nhin vd 20 kích cỡ 20 thì ok nhưng
                 * nó nhảy bất ngờ thành 0 hoặc 0 1 2 3dp thì nó quá nhỏ nên +20 để lun đảm bảo giá trị
                 * dù random ngẫu nhiên là 0dp thì nó vẫn đảm bảo 0 +20 đc 20dp là kích cỡ nhỏ nhất xuất hiện */
                textView.setTextSize(values_ngaunhien.nextInt(20) + 20);


                /*xét màu sắc ngẫu nhiền
                 * giải Thích code cấu truc rgb(red, green, blue)-> đó là 3 màu cơ bản đc thiết lp từ màu tối tới sáng(0-255)
                 * nhiệm vụ để tạo ra màu ngẫu nhiên thì cho random từng mảng màu đó random các số 0-255 để tùy chình
                 * các màu săc khác nhau thay thế dựa vào việc random các giá trị 0-255*/
                textView.setTextColor(Color.rgb(values_ngaunhien.nextInt(255), values_ngaunhien.nextInt(255), values_ngaunhien.nextInt(20)));

                //thiết lặp setClickable có chức năng khóa button khi thực hiện CountDownTimer
                button.setClickable(false);

            }

            @Override
            public void onFinish() {
                // sau khaorn thư gian time1 ức 10s thì button sẽ đc mở để nhấn lại bt
                button.setClickable(true);
            }
        };

        countDownTimer.start();

        /*thiết lặp CounDownTimer: thiết lặp thời gian tướng tác*/
    }

    // xây dựng method Toast
    public void showToast(String msg){
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
    }
}