package com.petertieu.android.localbox;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;

/**
 * Created by Peter Tieu on 19/03/2018.
 */

public class CategoryActivity extends OneFragmentActivity{

    //============= Declare instance variables ==============================================
    private static final String TAG = "CategoryActivity";

    private static final String EXTRA_LANGUAGE_CHOSEN= "ExtraLanguageChosen";
    private static final String EXTRA_CATEGORY_CHOSEN = "ExtraCategoryChosen";

    private String mLanguageChosen;
    private String mCategoryChosen;


    public static final String KEY_LANGUAGE_CHOSEN = "KeyLanguageChosen";
    public static final String KEY_CATEGORY_CHOSEN = "KeyCategoryChosen";


    //============= Define methods ==========================================================
    public static Intent newIntent(Context context, String language, String category){

        Log.i(TAG, "newIntent(..) called");

        Intent intent = new Intent(context, CategoryActivity.class);

        intent.putExtra(EXTRA_LANGUAGE_CHOSEN, language);
        intent.putExtra(EXTRA_CATEGORY_CHOSEN, category);

        return intent;
    }




    @Override
    public void onCreate(Bundle bundle){

        Log.i(TAG, "onCreate(..) called");


        mLanguageChosen = (String) getIntent().getStringExtra(EXTRA_LANGUAGE_CHOSEN);
        mCategoryChosen = (String) getIntent().getStringExtra(EXTRA_CATEGORY_CHOSEN);

        super.onCreate(bundle);


        Log.i(TAG, "Language Chosen: " + mLanguageChosen + "... " + "Category Chosen: " + mCategoryChosen);


        String languageChosenCapitalised = mLanguageChosen.substring(0,1).toUpperCase() + mLanguageChosen.substring(1);

        String categoryChosenCapitalised = mCategoryChosen.substring(0,1).toUpperCase() + mCategoryChosen.substring(1);

        getSupportActionBar().setTitle(languageChosenCapitalised + " " + categoryChosenCapitalised);


    }








    @Override
    protected Fragment createFragment(){

        Bundle argumentBundle = new Bundle();

        argumentBundle.putString(KEY_LANGUAGE_CHOSEN, mLanguageChosen);
        argumentBundle.putString(KEY_CATEGORY_CHOSEN, mCategoryChosen);


        CategoryFragment categoryFragment = new CategoryFragment();
        categoryFragment.setArguments(argumentBundle);
        return categoryFragment;


    }



    @Override
    protected int getLayoutResourceId(){
        return R.layout.activity_masterfragment;
    }







    //Override onStart() Activity lifecycle callback method
    @Override
    public void onStart(){
        super.onStart();

        Log.i(TAG, "onStart() called");
    }


    //Override onResume() Activity lifecycle callback method
    @Override
    public void onResume(){
        super.onResume();

        Log.i(TAG, "onResume() called");
    }



    //Override onPause() Activity lifecycle callback method
    @Override
    public void onPause(){
        super.onPause();

        Log.i(TAG, "onPause() called");
    }




    //Override onStop() Activity lifecycle callback method
    @Override
    public void onStop(){
        super.onStop();

        Log.i(TAG, "onStop() called");
    }




    //Override onDestroy() Activity lifecycle callback method
    @Override
    public void onDestroy(){
        super.onDestroy();

        Log.i(TAG, "onDestroy() called");
    }



}
