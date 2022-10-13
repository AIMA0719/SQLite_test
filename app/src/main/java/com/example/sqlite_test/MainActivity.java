package com.example.sqlite_test;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "main";
    private INFOCAR_DBHelper myDBHelper;
    private SQLiteDatabase db;
    private EditText edtName, edtNumber, edtNameResult, edtNumberResult;
    private Button btnUpdata, btnInsert, btnDelete;
    private String list = "";
    private String count = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("디비 테스트");

        edtName = findViewById(R.id.edtName);
        edtNumber = findViewById(R.id.edtNumber);
        edtNameResult = findViewById(R.id.edtNameResult);
        edtNumberResult = findViewById(R.id.edtNumberResult);
        btnUpdata = findViewById(R.id.btnInit);
        btnInsert = findViewById(R.id.btnInsert);
        btnDelete = findViewById(R.id.btnSelect);

        myDBHelper = INFOCAR_DBHelper.getInstance(this,"test.db",null,INFOCAR_DBHelper.DB_VERSION); // DB 생성
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();

        btnUpdata.setOnClickListener(v -> {
            myDBHelper.onUpgrade(db,1,2);
            db.close();
        });

        btnInsert.setOnClickListener(v -> {
            new TEST_DataBirdge().TestInsert(new TEST(0, edtName.getText().toString(), edtNumber.getText().toString(),false));
        });

        btnDelete.setOnClickListener(v ->{
            new TEST_DataBirdge().TestDelete(this,list);
        });
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onRestart(){
        super.onRestart();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        INFOCAR_DBHelper.closeDBHelper();
    }
}
