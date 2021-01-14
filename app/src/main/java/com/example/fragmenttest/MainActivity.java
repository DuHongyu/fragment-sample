package com.example.fragmenttest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.fragmenttest.fragmentImp.ICallBack;
import com.example.fragmenttest.utils.ReplaceFragmentUtils;

/**
 * @author Administrator
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnTip = findViewById(R.id.btn_tip);
        btnTip.setOnClickListener(this);

        Button btnTipTwo = findViewById(R.id.btn_tip_two);
        btnTipTwo.setOnClickListener(this);

        Button btnTipThree = findViewById(R.id.btn_tip_three);
        btnTipThree.setOnClickListener(this);

        TextView tvMessage = findViewById(R.id.tv_message);
        tvMessage.setOnClickListener(this);

        LeftFragment leftFragment = new LeftFragment();
        ReplaceFragmentUtils.getInstance().replaceFragment(this, leftFragment);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        int id = v.getId();
        Bundle bundle = new Bundle();
        switch (id) {
            case R.id.btn_tip:
                AnotherLeftFragment anotherLeftFragment = new AnotherLeftFragment();
                ReplaceFragmentUtils.getInstance().replaceFragment(this, anotherLeftFragment);
                break;
            case R.id.btn_tip_two:
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                LeftFragment leftFragment = new LeftFragment();
                bundle.putString("message", "I love Google");
                leftFragment.setArguments(bundle);
                fragmentTransaction.add(R.id.fg_left, leftFragment);
                fragmentTransaction.commit();
                break;
            case R.id.btn_tip_three:
                FragmentManager fragmentManager1 = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction1 = fragmentManager1.beginTransaction();
                LeftFragment fragment = new LeftFragment();
                fragmentTransaction1.add(R.id.fg_left, fragment);
                fragmentTransaction1.commit();
                fragment.sendMessage(new ICallBack() {
                    @Override
                    public void getMessageFromFragment(String string) {
                        String msg = string;
                    }
                });
                break;
            default:
                break;
        }
    }
}