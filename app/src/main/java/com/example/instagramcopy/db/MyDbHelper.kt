package com.example.instagramcopy.db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.instagramcopy.models.Data2

class MyDbHelper(context: Context): SQLiteOpenHelper(context,"db_name",null,1), DbInterface {
    override fun onCreate(db: SQLiteDatabase?) {
        val videoQuery = "create table video_table(id integer not null primary key autoincrement unique, video text not null)"
        db?.execSQL(videoQuery)
    }
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {}

    override fun addVideo(data2: Data2) {
        val database = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put("video", data2.video)
        database.insert("video_table", null, contentValues)
        database.close()
    }
    override fun showVideos(): List<Data2> {
        val list = ArrayList<Data2>()
        val database = this.readableDatabase
        val query = "select * from video_table"
        val cursor = database.rawQuery(query, null)
        if (cursor.moveToFirst()){
            do {
                list.add(
                    Data2(
                        cursor.getInt(0),
                        cursor.getString(1)
                    )
                )
            }while (cursor.moveToNext())
        }
        return list
    }
}