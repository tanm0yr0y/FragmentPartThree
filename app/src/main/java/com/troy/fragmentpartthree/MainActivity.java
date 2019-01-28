package com.troy.fragmentpartthree;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements FragmentA.Communicator {


    FragmentA fragmentA;
    FragmentB fragmentB;
    FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = getSupportFragmentManager();
        fragmentA = (FragmentA) manager.findFragmentById(R.id.fragment);
        fragmentA.setCommunicator(this);

    }

    @Override
    public void respond(int index) {
        fragmentB =(FragmentB) manager.findFragmentById(R.id.fragment2);

        if(fragmentB != null && fragmentB.isVisible()) {
            fragmentB.changeData(index);
        }
        else {
            Intent intent = new Intent(this, Activity2.class);
            intent.putExtra("position", index);

            Log.d("RRR", "starting activity2");

            startActivity(intent);

        }
    }
}
