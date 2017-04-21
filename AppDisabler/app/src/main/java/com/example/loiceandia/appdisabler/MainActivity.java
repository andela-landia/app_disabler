package com.example.loiceandia.appdisabler;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "TaskManager";
    public ActivityManager managr;

    public void getRunningApps() {
        List<PackageInfo> apps = getPackageManager().getInstalledPackages(0);
        for (PackageInfo pkgApps : apps) {
            Log.d(TAG, "Installed package :" + pkgApps.packageName);
            if(pkgApps.packageName.contains("kipfit")) {
//                final String act = pkgApps.activities[0].parentActivityName;
//                Log.d(TAG, "activity :" + act);
//                try {
//                    Runtime.getRuntime().exec("pm disable com.kipfit/" + act);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
                Intent LaunchApp = getPackageManager().getLaunchIntentForPackage("com.kipfit");
                startActivity(LaunchApp);
                managr.killBackgroundProcesses(pkgApps.packageName);
            }
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getRunningApps();
        setContentView(R.layout.activity_main);
    }
}
