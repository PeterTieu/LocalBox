package com.petertieu.android.localbox;

import android.support.v4.app.Fragment;


//Activity hosting LanguageChooserFragment
public class LanguageChooserActivity extends OneFragmentActivity{

    //============= Declare instance variables ==============================================
    private static final String TAG = "LanguageChooserActivity";


    //============= Define methods ==========================================================
    @Override
    protected Fragment createFragment(){
        return new LanguageChooserFragment();
    }

    @Override
    protected int getLayoutResourceId(){
        return R.layout.activity_masterfragment;
    }





}
