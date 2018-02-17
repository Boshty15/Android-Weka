package com.example.bostjan.projekt;

import android.app.Activity;
import android.app.Application;

import com.example.lib.DataAll;
import com.example.lib.Igralec;

/**
 * Created by Bostjan on 15/01/2018.
 */

public class AppMy extends Application {
    int x;
    DataAll a;

    @Override
    public void onCreate() {
        super.onCreate();

        a= DataAll.scenarijA();


    }
    public Igralec getIgralec(){
        return a.getIgralec();
    }

}
