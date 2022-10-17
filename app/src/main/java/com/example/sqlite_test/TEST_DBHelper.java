package com.example.sqlite_test;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class TEST_DBHelper{ // 여기는 Bridge에 있는 insert같은 함수를 통해 데이터를 받아와서 실제 DB에 적재하는 부분

    public static synchronized TEST_DBHelper getInstance(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        if(INFOCAR_DBHelper.sInstance == null || INFOCAR_DBHelper.readableDataBase == null || INFOCAR_DBHelper.writeableDataBase == null){
            INFOCAR_DBHelper.sInstance = INFOCAR_DBHelper.getInstance(context.getApplicationContext(), name, factory, version);
        }

        return new TEST_DBHelper();
    }

    public void TEST_insert(String list, String count, boolean hidden){ // 데이터 실재로 받아와서 쿼리 작성하는 부분
        SQLiteDatabase db = INFOCAR_DBHelper.writeableDataBase;

        try {
            db.beginTransaction(); // 시작
            db.execSQL("INSERT INTO TESTDB VALUES (" + null + ", '" + list+"'"+", "+"'"+count+"'"+ ", "+"'"+ hidden+ "'" + ");");
            db.setTransactionSuccessful(); // 이걸 호출하면 트랜잭션 성공한것으로 앎 endTransaction 호출 하기전에 DB 작업 금지

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(db != null) db.endTransaction(); // db 널 아니면 시마이쳐주기
        }
    }

    public void TEST_hidden(){
        SQLiteDatabase db = INFOCAR_DBHelper.writeableDataBase;

        try {
            db.beginTransaction(); // 시작
            db.execSQL("UPDATE TESTDB SET isHidden = " + "'" + false + "'" + "WHERE isHidden = "+"'"+ true + "'"+" ;"); // isHidden이 true이면 전부 false로 변경
            db.setTransactionSuccessful(); // 이걸 호출하면 트랜잭션 성공한것으로 앎 endTransaction 호출 하기전에 DB 작업 금지

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(db != null) db.endTransaction(); // db 널 아니면 시마이쳐주기
        }
    }

    public void TEST_delete(){
        SQLiteDatabase db = INFOCAR_DBHelper.writeableDataBase;

        try {
            db.beginTransaction(); // 시작
            db.execSQL("DROP TABLE TESTDB ;"); // DELETE 말고 DROP
            db.setTransactionSuccessful(); // 이걸 호출하면 트랜잭션 성공한것으로 앎 endTransaction 호출 하기전에 DB 작업 금지

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(db != null) db.endTransaction(); // db 널 아니면 시마이쳐주기
        }

    }

}
