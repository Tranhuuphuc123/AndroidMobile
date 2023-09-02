package com.example.kienthuctonghopactivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DebugActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debug);
        String str = "Log and Toast";

        /*sử dụng Log để ghi nhận thông tin cho str  thông qua tag(tương ứng key)
        trong từ khóa: Log.d(tag, <tên biến>)*/
        //****Note****
        /*có vấn để là khi build project trên ứng dụng chỉ hiển thị nd của layout thui
        * vậy log xem ở đấu:
        *  + bấm LogCat
        *  + mục search nhập tag: trainingAndroid
        *  + thông tin Log anbd Toast sẽ hiện ra kềm value của str:"Log and Toast*
           + có thể bấm vào biểu tượng filter để lưu lại tag cho lần sao d tiềm kiếm
           mà không cần nhập lại lần nữa
         */

        Log.d("trainingAndroid", str);


        /*Sử dụng Toast
        * + Lưu ý: Toast sẽ hiển thị nội dung lên thằng layout trên giao diện của máy ảo
        * hay máy thật lun
        *
        * + cấu trúc Toast:
        *  Toast.makeText(Context context, charSequence, int duration)
        *  > trong đó:
            + Context: tên của activity java.this:
                vd lấy tên DebugActivity.java
                 ~ DebugActivity.this

             + charSequenceText: dẫn value vào(có thể lấy biến cóa value thiết lập trc đó)
             + duration: hiển thị thời gian sống cho nó
                  ++ Toast.LENGTH_LONG: Thời gian dài
                  ++ Toast.LENGTH_SHORT: Thời gian ngắn
               ==> với thiết lập như vd khi build project vói layout thiết kế trc đó
            nó sẽ hiện thị một thông tin thông báo Toast lên có nội dung của biến
            str ="Log and Toast" lên trong một thời gian ngắn đúng với tinh thần
            của một thông báo
        * */
        //==> thêm thuộc tính show() để hiển thị ra màn hình
        Toast.makeText(DebugActivity.this,str,Toast.LENGTH_LONG).show();

    }

}