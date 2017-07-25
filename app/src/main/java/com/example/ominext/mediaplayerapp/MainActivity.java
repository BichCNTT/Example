package com.example.ominext.mediaplayerapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
//1. List bài hát: 1 recyclerView trong đó có: row (row là fragment) , mỗi row có 1 cái ctrúc dliệu, 1 cái adapter, dữ liệu sẽ được lưu trong sqlite
//view pager with fragment để chuyển đổi giữa 2 màn hình (màn hình tiếp theo cũng là fragment)
//1 nút play, 1 nút pause, 1 nút next bài, 1 nút prev, 1 nút lặp lại, 1 nút cho phát ngẫu nhiên
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
