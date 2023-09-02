package com.example.alertdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btn1, btn2, btn3, btn_Items, btn_form, btn_Single, btnMultiChoiceItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // gọi class init
        init();


        // xử lý sự kiện chuyển giao diện cho từng button - viết kiểu Listener Anonymous
//        btn1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                final AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
//                alertDialog.setTitle("One Button");
//                alertDialog.setMessage("Are you happy?");
//                alertDialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        showToast("OK");
//                        dialogInterface.cancel();
//                    }
//                });
//                alertDialog.create();
//                alertDialog.show();
//            }
//        });

        // sự kiện đầu tiền với alert đầy đủ và giải thích chi tiết nhất tham khảo
        // Sự kiện buton1 (xử lý sk kiểu Listener Anonymous _ viêt cách lambda)
        btn1.setOnClickListener(view->{
            // khởi tạo alertdialog và builder của alert
            final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

            // xây dựng các title và ội dung bên trong
            builder.setTitle("One Button");
            builder.setMessage("Are you happy?");

            // set icon cho alert dialog
            builder.setIcon(R.drawable.alert);
            // xử lý sự kiện khi nhấn nút ok nó sẽ hiển ra thông báo ok
            builder.setPositiveButton("Ok", (dialogInterface, i) -> {
                showToast("OK");
                dialogInterface.cancel();
            });
            // thuộc tính setCaceledOnTouchOutside() có chức năng hủy alert dialog khi nhấn ở vùng bên ngoài hộp thoại
            AlertDialog alertDialog = builder.create();
            alertDialog.setCanceledOnTouchOutside(true);
            alertDialog.show();
        });



        // Sự kiện buton2 (xử lý sk kiểu Listener Anonymous _ viêt cách lambda)
        btn2.setOnClickListener(view->{
            final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Two Button");
            builder.setMessage("Are you happy?");
            // thiết lặp icon
            builder.setIcon(R.drawable.heart);
            builder.setPositiveButton("Ok", (dialogInterface, i) -> {
                showToast("OK");
                dialogInterface.cancel();
            });
            builder.setNegativeButton("No",(dialogInterface, i) -> {
                showToast("No");
                dialogInterface.cancel();
            });

            //thiết lặp tắt hộp thaoij khi click vùng bên ngoài
            AlertDialog alertDialog = builder.create();
            alertDialog.setCanceledOnTouchOutside(true);
            alertDialog.show();
        });

        // Sự kiện buton3 (xử lý sk kiểu Listener Anonymous _ viêt cách lambda)
        btn3.setOnClickListener(view->{
            final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Three Button");
            builder.setMessage("Are you happy?");
            // thiết lặp icon
            builder.setIcon(R.drawable.alert);
            builder.setPositiveButton("Ok", (dialogInterface, i) -> {
                showToast("OK");
                dialogInterface.cancel();
            });
            builder.setNegativeButton("No",(dialogInterface, i) -> {
                showToast("No");
                dialogInterface.cancel();
            });
            builder.setNeutralButton("Cancel",(dialogInterface, i) -> {
                showToast("Cancel");
                dialogInterface.cancel();
            });

            // thiết lặp tắt alert khi nhấn vùng ngoài
            AlertDialog alertDialog = builder.create();
            alertDialog.setCanceledOnTouchOutside(true);
            alertDialog.show();
        });


        // xử lý sự kiện buttonForm(viết kiểu lambda)



    }// end OnCreate method




    //method ánh xạ id
    public void init(){
        btn1 = (Button)findViewById(R.id.btn_oneButton);
        btn2 = (Button)findViewById(R.id.btn_twoButton);
        btn3 = (Button)findViewById(R.id.btn_threeButton);
        btn_Items = (Button)findViewById(R.id.btn_alertItem);
        btn_form = (Button)findViewById(R.id.btn_alertWithForm);
        btn_Single = (Button)findViewById(R.id.btn_alertSingle);
        btnMultiChoiceItems = (Button)findViewById(R.id.btn_alertMulti);
    }


    // tạo hàm shoToast
    public void showToast(String msg){
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
    }
}