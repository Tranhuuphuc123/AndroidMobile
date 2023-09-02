package com.example.asignment1.sqlLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.asignment1.model.student;

import java.util.ArrayList;

public class DBController extends SQLiteOpenHelper {

    // khởi tạo database với tên androidSqlLite.db
    public DBController(Context context){
        super(context, "androidSqlLite.db", null,1);
    }

    // các method kế thừa lớp SQLiteOpenHelper
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // tiến hành create Table trên SQLite
        String query = "CREATE TABLE students(" +
                "rollno TEXT PRIMARY KEY, " +
                "name TEXT," +
                " term TEXT, " +
                "date TEXT )";

        sqLiteDatabase.execSQL(query);
    }

    // method cho phep xóa cơ sở dữ liệu khi cần
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String query = "DROP TABLE IF EXISTS students";
        sqLiteDatabase.execSQL(query);// thuc thi query
        // gọi lại onCreate để tạo mới csdl nếu không có drop table thì nó dùng vlaue cũ
        onCreate(sqLiteDatabase);
    }


    // các method tiến hành insert, delete, update...\
    // method insert
    public void insert(student st){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        // Khởi tọa ContentVlaues đặt giá trị cho cột trong bảng để thự hiện insert
        ContentValues contentValues = new ContentValues();
        contentValues.put("rollno", st.getRollno());
        contentValues.put("name", st.getName());
        contentValues.put("term", st.getTerm());
        contentValues.put("date", st.getDate());
        // tiến hành insert các trg thiết dặt vào sqlLite
        sqLiteDatabase.insert("students", null, contentValues);
        sqLiteDatabase.close();// hoàn thành thiết đặt insert
    }

  // method hiển thị tất cả dữ liệu
    public ArrayList<student> getAllstudents() {
        ArrayList<student> studentList = new ArrayList<student>();
        SQLiteDatabase database = this.getWritableDatabase();

        String selectQuery = "SELECT * FROM students";
        Cursor cursor = database.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()){
            do {
                student st = new student(
                        cursor.getString(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3)
                );
                studentList.add(st);
            } while (cursor.moveToNext());
        }
        // return Book list
        return studentList;
    }



}
