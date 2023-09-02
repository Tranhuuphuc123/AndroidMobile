package EventListener;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.kienthuctonghopactivity.R;

public class event_class implements View.OnClickListener {
    @Override
    public void onClick(View view) {
        // khởi tạo Textview để ánh xạ id txtView bên layout
        TextView txtView = (TextView) view.getRootView().findViewById(R.id.txtview);
        // sử dụng if-else để xử lý sự kiện
        // dùng if-else để xử lý
        if((view.getId())== R.id.btn1){
            txtView.setText("Inline Listener");
        }else if (view.getId() == R.id.btn2) {
            txtView.setText("Inline Anonymous Listener");
        } else if (view.getId() == R.id.btn3) {
            txtView.setText("Activity Listener");
        } else if (view.getId() == R.id.btn4) {
            txtView.setText("Listener Variable");
        } else if (view.getId() == R.id.btn5) {
            txtView.setText("Excplicit Listener class");
        }
    }

}
