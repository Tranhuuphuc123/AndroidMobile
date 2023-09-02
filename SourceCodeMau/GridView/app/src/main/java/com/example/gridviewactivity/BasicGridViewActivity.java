package com.example.gridviewactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BasicGridViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_grid_view);

        // mảng dữ liệu giả đại diện đổ dữ liệu demo
        String[] array = new String[] {
                "one", "two", "three", "four", "five","six", "seven","eigth", "nine","ten"
        };
        List<String> list =   new ArrayList<String>(Arrays.asList(array));

        GridView grid = findViewById(R.id.gridViewBasic);
        grid.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,list));
    }
}