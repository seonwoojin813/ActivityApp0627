package com.tjoeun.activityapp0627;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    //생성자 - Context를 넘겨받아서 상위 클래스를 호출
    public DBHelper(Context context){
        super(context, "database.sqlite", null, 1);
    }

    //처음 사용할려고 했을 때 호출되는 메소드
    @Override
    public void onCreate(SQLiteDatabase db){
        //테이블을 만들고 샘플 데이터를 삽입
        String sql = "create table soccer(" +
                "_id integer primary key autoincrement, " +
                "nation text, player text)";
        //SQL 실행
        db.execSQL(sql);

        //샘플 데이터 삽입
        db.execSQL("insert into soccer(nation, player) " +
                "values('대한민국', '손흥민')");
        db.execSQL("insert into soccer(nation, player) " +
                "values('대한민국', '이강인')");
        db.execSQL("insert into soccer(nation, player) " +
                "values('일본', '사카이')");
        db.execSQL("insert into soccer(nation, player) " +
                "values('일본', '쿠보')");
        db.execSQL("insert into soccer(nation, player) " +
                "values('이란', '아즈문')");
        db.execSQL("insert into soccer(nation, player) " +
                "values('이란', '모하라미')");

    }

    //데이터베이스 버전이 변경되었을 떄 호출되는 메소,
    @Override
    public void onUpgrade(
            SQLiteDatabase db, int oldVersion, int newVersion){
        //테이블을 삭제하고 다시 생성
        db.execSQL("drop table soccer");
        onCreate(db);


    }


}
