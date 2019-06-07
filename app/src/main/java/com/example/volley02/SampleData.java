package com.example.volley02;


import java.util.ArrayList;

public class SampleData {

    ArrayList<Social> items = new ArrayList<>();

    public ArrayList<Social> getItems() {

        Social social1 = new Social("http://static.hubzum.zumst.com/hubzum/2018/02/06/09/962ec338ca3b4153b037168ec92756ac.jpg",
                "Black Panther");
        Social social2 = new Social("https://t1.daumcdn.net/cfile/tistory/0138F14A517F77713A",
                "Iron Man 3");
        Social social3 = new Social("https://i.ytimg.com/vi/5-mWvUR7_P0/maxresdefault.jpg",
                "Ant Man");

        items.add(social1);
        items.add(social2);
        items.add(social3);

        items.add(social1);
        items.add(social2);
        items.add(social3);

        items.add(social1);
        items.add(social2);
        items.add(social3);

        return items;
    }

}
