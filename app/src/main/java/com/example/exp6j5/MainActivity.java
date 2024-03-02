package com.example.exp6j5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentResultListener;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    SportsFragment sf;
    FragmentManager fmgr;
    FragmentTransaction ft;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fmgr  = getSupportFragmentManager();
        ft = fmgr.beginTransaction();
        sf = new SportsFragment();
        ft.add(R.id.linearLayout,sf);
        ft.commit();
        fmgr.setFragmentResultListener("rk", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                int option=result.getInt("si");
                ft = fmgr.beginTransaction();
                switch(option){
                    case 0:ft.replace(R.id.linearLayout2,new BadmintonFragment());
                        break;
                    case 1:ft.replace(R.id.linearLayout2,new Cricket());
                        break;
                    case 2:ft.replace(R.id.linearLayout2,new BasketballFragment());
                        break;
                    case 3:ft.replace(R.id.linearLayout2,new VolleyballFragment());
                        break;
                    default:ft.replace(R.id.linearLayout2,new HockeyFragment());
                }
                ft.commit();

            }
        });
    }
}