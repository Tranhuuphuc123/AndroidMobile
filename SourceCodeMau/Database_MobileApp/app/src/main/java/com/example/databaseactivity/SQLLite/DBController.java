package com.example.databaseactivity.SQLLite;
// xây dựng cỡ sở dữ liệu với SQLLite

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.databaseactivity.Model.Book;

import java.util.ArrayList;

public class DBController extends SQLiteOpenHelper {

   // contructor
    public DBController(Context context){
        super(context, "androidsqllite.db", null,1);
    }

    // method khởi tạo csdl của SQL Lite
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE books(bookId INTEGER PRIMARY KEY AUTOINCREMENT, bookName TEXT, bookImage INTEGER)";
        sqLiteDatabase.execSQL(query);
    }

    // method cho phép xóa csdl SQL Lite khi cần
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // xd câu lệnh sql xóa csdl neu nó không tồn tại
        String query = "DROP TABLE IF EXISTS books";
        // thực thi câu lệnh query
        sqLiteDatabase.execSQL(query);
        // sau khi xóa bảng nó tiến hành gọi lại onCreate để tạo bảng mới-> nếu khong drop table thì nó dùng csdl cũ
        onCreate(sqLiteDatabase);
    }



    /* xây dựng các câu lệnh chức năng CRUD_Find trong sqlLite*/
    // thực thi insert dl
    public void insertBook(Book book){
        // kởi tạo SQLLite(dạng csdl như file text tự xây dựng trong class)
        SQLiteDatabase database = this.getWritableDatabase();
        //Đối tượng ContentValues được sử dụng để đặt giá trị cho cột trong bảng khi thực hiện các hoạt động thêm dữ liệu.
        ContentValues values = new ContentValues();
        //put chính là thiết lặp đặt value có tên bookName cho table nhận ở model book.getName
        values.put("bookName", book.getName());
        //tiến hành insert thực thi insert vào bảng dl SQLLite có tên books
        database.insert("books", null,values);
        // đóng kết nói sql khi nó hoàn thành thêm values xong
        database.close();
    }


    // thực thi update csdl trong SQLLite
    public int updateBook(Book book){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("bookName", book.getName());
        return database.update("books",values,"bookId" + "=?", new String[]{
                book.getId()+""
        });
    }

    public void deleteBook(Book book) {
        SQLiteDatabase database = this.getWritableDatabase();
        String deleteQuery = "DELETE FROM  books where bookId="+ book.getId();
        Log.d("query", deleteQuery);
        database.execSQL(deleteQuery);
    }

    public ArrayList<Book> getAllBooks() {
        ArrayList<Book> bookList = new ArrayList<Book>();
        SQLiteDatabase database = this.getWritableDatabase();

        String selectQuery = "SELECT * FROM books";
        Cursor cursor = database.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()){
            do {
                Book book = new Book(cursor.getInt(0),cursor.getString(1),cursor.getInt(2));
                bookList.add(book);
            } while (cursor.moveToNext());
        }

        // return Book list
        return bookList;
    }

    public Book getBookInfo(String id) {
        //Mo du lieu de doc du lieu tu CSDL
        SQLiteDatabase database = this.getReadableDatabase();
        //Thuc thi cau lenh truy van du lieu
        String selectQuery = "SELECT * FROM books where bookId ="+ id;
        Cursor cursor = database.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Book book = new Book(cursor.getInt(0),cursor.getString(1),cursor.getInt(2));
                return book;
            } while (cursor.moveToNext());
        }
        return null;
    }


}
