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

    public String getList(){
        return list;
    }

    public String getCount(){
        return count;
    }

//    public String setList(){
//        return this.list = list;
//    }
//
//    public int setCount(){
//        return this.count = count;
//    }


    @Override
    public String toString() {
        return "TEST{" +
                "list='" + list + '\'' +
                ", count='" + count + '\'' +
                ", id=" + id +
                '}';
    }
}
