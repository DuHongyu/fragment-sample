package com.example.fragmenttest.utils;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.fragmenttest.R;

/**
 * @author Administrator
 */
public class ReplaceFragmentUtils {

    private static final ReplaceFragmentUtils INSTANCE = new ReplaceFragmentUtils();

    private ReplaceFragmentUtils() {

    }

    public static ReplaceFragmentUtils getInstance() {
        return INSTANCE;
    }

    public void replaceFragment(AppCompatActivity appCompatActivity, Fragment fragment) {
        FragmentManager fragmentManager = appCompatActivity.getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fg_left, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
