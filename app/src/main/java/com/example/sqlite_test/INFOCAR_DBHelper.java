package com.example.sqlite_test;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class INFOCAR_DBHelper extends SQLiteOpenHelper { // INFOCAR_DBHelper 부분. 한마디로 테이블 생성하고 업데이터 하는 부분담당

    public static INFOCAR_DBHelper sInstance;
    public static SQLiteDatabase writeableDataBase;
    public static SQLiteDatabase readableDataBase;

    public static final int DB_VERSION =1;

    public static synchronized INFOCAR_DBHelper getInstance(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        if(sInstance == null){
            sInstance = new INFOCAR_DBHelper(context.getApplicationContext(),name,factory,1);
           writeableDataBase = sInstance.getWritableDatabase();
           readableDataBase = sInstance.getReadableDatabase();
        }
        return sInstance;
    } //싱글톤 패턴 맨날 호출될때마다 new 하는게 아니라 없으면 만들고 있으면 자기꺼 리턴

    public static void closeDBHelper(){ // 디비 close
        try{
            if(sInstance!=null){
                writeableDataBase.close();
                writeableDataBase = null;
                readableDataBase.close();
                readableDataBase = null;
                sInstance.close();
                sInstance = null;

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public INFOCAR_DBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, @Nullable int version) {
        super(context, "testDB", null,DB_VERSION);
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("CREATE TABLE IF NOT EXISTS TESTDB (_id INTEGER PRIMARY KEY AUTOINCREMENT, list TEXT , count TEXT , isHidden INTEGER);");
    } // 인포카는 여기다가 CREATE 적었다...

    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    @Override // DB 버전이 바뀌었을 때 실행됨 DB_VERSION이 변수 infocar 코드 참고하자
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS TESTDB;");
        onCreate(db);
    }
}
