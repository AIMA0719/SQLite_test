package com.example.sqlite_test;

public class TEST {  // 객체 만들기
    public String list;
    public String count;
    public int id;
    public boolean hidden;

    public TEST(int id,String list, String count,boolean hidden){
        this.id = id;
        this.list = list;
        this.count = count;
        this.hidden = hidden;
    }

    public TEST(String list, String count) {
        this.list = list;
        this.count = count;
    }

    public TEST() {

    }

    public String getList(){return list;}

    public String getCount(){
        return count;
    }

    public boolean getHidden() { return hidden; }
}
