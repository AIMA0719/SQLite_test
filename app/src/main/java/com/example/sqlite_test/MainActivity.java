package com.example.sqlite_test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "main";
    private INFOCAR_DBHelper myDBHelper;
    private SQLiteDatabase db;
    private EditText edtName, edtNumber;
    private Button btnUpdate, btnInsert, btnSelect, btnDelete;
    public RecyclerView recyclerView;
    private final String list = "";
    private final List<TEST> testList = new ArrayList<>();
    private final Main_Adapter main_adapter = new Main_Adapter(testList, this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("디비 테스트");

        edtName = findViewById(R.id.edtName);
        edtNumber = findViewById(R.id.edtNumber);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnInsert = findViewById(R.id.btnInsert);
        btnSelect = findViewById(R.id.btnSelect);
        btnDelete = findViewById(R.id.btnDelete);
        recyclerView = findViewById(R.id.recycler_view);

        myDBHelper = INFOCAR_DBHelper.getInstance(this,"test.db",null,INFOCAR_DBHelper.DB_VERSION); // DB 생성


    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void onResume() {
        super.onResume();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(main_adapter);

        btnUpdate.setOnClickListener(v -> {
//            myDBHelper.onUpgrade(db,1,2);
//            db.close();
            // version 업그레이드 하면 Add column
        });

        btnInsert.setOnClickListener(v -> {
            new TEST_DataBirdge().TestInsert(new TEST(0, edtName.getText().toString(), edtNumber.getText().toString(),true));
            testList.add(new TEST(edtName.getText().toString(),edtNumber.getText().toString()));
            main_adapter.notifyDataSetChanged();
        });

        btnSelect.setOnClickListener(v ->{

            //new TEST_DataBirdge().TestSelect(this);
            // if(testList.get()) // false로 바꾸고 false 면 recyclerview에서 remote 하는 로직
            //main_adapter.notifyDataSetChanged();
        });

        btnDelete.setOnClickListener(v ->{
            new TEST_DataBirdge().TestDelete(this);

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
