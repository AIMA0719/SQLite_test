package com.example.sqlite_test;

import android.content.Context;
import android.util.Log;

public class TEST_DataBirdge { //이건 메인 엑티비티나 프래그먼트에서 쓰는 insert 함수를 선언
    //한마디로 DB에 쿼리를 하는 TEST_DBHelper 와 사용자가 실제 입력하는 프래그먼트 사이에 데이터 연결다리 역할을 해준다라고 이해함

    Context context;

    public void TestInsert(TEST test){
        Log.e("TAG", test.toString());
        TEST_DBHelper test_dbHelper = TEST_DBHelper.getInstance(context,"test.db",null,INFOCAR_DBHelper.DB_VERSION); //객체 생성
        test_dbHelper.TEST_insert(test.list, test.count, test.hidden); //TEST_DEHelper의 insert 함수를 통해 넣어준다.
    }

    public void TestDelete(Context context){
        TEST_DBHelper test_dbHelper = TEST_DBHelper.getInstance(context,"test.db",null,INFOCAR_DBHelper.DB_VERSION);
        test_dbHelper.TEST_delete();
    }


}


