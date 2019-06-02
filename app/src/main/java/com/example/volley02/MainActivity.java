package com.example.volley02;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    //FrameLayout에 각 메뉴의 Fragmet를 바꿔줌
    private FragmentManager fragmentManager = getSupportFragmentManager();
    //4개의 메뉴에 들어갈 Fragment
    private MyFragment myFragment = new MyFragment();
    private MessageFragment messageFragment = new MessageFragment();
    private SocialFragment socialFragment = new SocialFragment();
    private FriendFragment friendFragment = new FriendFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        //첫 화면
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frame_layout, socialFragment).commitAllowingStateLoss();

        //bottomNavigationView의 아이템 선택시 호출될 리스너 등록
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                FragmentTransaction transaction1 = fragmentManager.beginTransaction();
                switch (menuItem.getItemId()){
                    case R.id.navigation_social:{
                        transaction1.replace(R.id.frame_layout, socialFragment).commitAllowingStateLoss();
                        break;
                    }
                    case R.id.navigation_friend:{
                        transaction1.replace(R.id.frame_layout, friendFragment).commitAllowingStateLoss();
                        break;
                    }
                    case R.id.navigation_message:{
                        transaction1.replace(R.id.frame_layout, messageFragment).commitAllowingStateLoss();
                        break;
                    }
                    case R.id.navigation_my:{
                        transaction1.replace(R.id.frame_layout, myFragment).commitAllowingStateLoss();
                        break;
                    }
                }

                return true;
            }
        });

    }
}
