package com.example.databaseactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.databaseactivity.Model.Book;
import com.example.databaseactivity.SQLLite.DBController;

public class NewBookActivity extends AppCompatActivity {
    EditText bookName;
    Button btnInsert, btnReset;
    DBController controller = new DBController(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_book);

        bookName = findViewById(R.id.editTextName);
        btnInsert = findViewById(R.id.buttonInsert);
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!bookName.getText().toString().isEmpty()) {
                    Book b = new Book(bookName.getText().toString(), 3);
                    controller.insertBook(b);
                    Intent intent = new Intent(NewBookActivity.this,MainActivity.class);
                    startActivity(intent);
                }else{
                    bookName.setError("Enter Book Name");
                }
            }
        });

        btnReset = findViewById(R.id.buttonDelete);
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bookName.setText("");
                bookName.setFocusable(true);
            }
        });

    }
}