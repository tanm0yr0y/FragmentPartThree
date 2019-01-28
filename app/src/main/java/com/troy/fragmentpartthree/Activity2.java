package com.troy.fragmentpartthree;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class Activity2 extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        Intent intent = getIntent();
        int position = intent.getIntExtra("position", 0);
        FragmentB fragmentB =(FragmentB) getSupportFragmentManager().findFragmentById(R.id.fragment2);
        if(fragmentB != null) {
            Log.d("RRR", "changing data");
            fragmentB.changeData(position);
        }

    }
}
