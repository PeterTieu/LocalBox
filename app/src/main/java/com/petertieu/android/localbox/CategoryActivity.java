package com.petertieu.android.localbox;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

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
//
//        getSupportActionBar().setTitle(languageChosenCapitalised + " " + categoryChosenCapitalised);









        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);




        LayoutInflater layoutInflator = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = layoutInflator.inflate(R.layout.action_bar_category_activity, null);
        TextView textView = (TextView) v.findViewById(R.id.text_view);

        textView.setText(languageChosenCapitalised + " " + categoryChosenCapitalised);







        ImageView flagActionBarImageView = (ImageView) v.findViewById(R.id.flag_action_bar);

        int flagActionBarResourceId = 0;


        //TODO: Make a method out of this////////////////////////////////////////////////////////////////////////////////////
        switch (mLanguageChosen){
            case ("arabic"):
                flagActionBarResourceId = R.drawable.arabic_flag;
                break;

            case ("chinese"):
                flagActionBarResourceId = R.drawable.chinese_flag;
                break;


            case ("french"):
                flagActionBarResourceId = R.drawable.french_flag;
                break;


            case ("german"):
                flagActionBarResourceId = R.drawable.german_flag;
                break;

            case ("hindi"):
                flagActionBarResourceId = R.drawable.hindi_flag;
                break;

            case ("italian"):
                flagActionBarResourceId = R.drawable.italian_flag;
                break;

            case ("japanese"):
                flagActionBarResourceId = R.drawable.japanese_flag;
                break;

            case ("korean"):
                flagActionBarResourceId = R.drawable.korean_flag;
                break;

            case ("russian"):
                flagActionBarResourceId = R.drawable.russian_flag;
                break;

            case ("spanish"):
                flagActionBarResourceId = R.drawable.spanish_flag;
                break;

            case ("thai"):
                flagActionBarResourceId = R.drawable.thai_flag;
                break;

            case ("vietnamese"):
                flagActionBarResourceId = R.drawable.vietnamese_flag;
                break;
        }


        flagActionBarImageView.setImageDrawable(getResources().getDrawable(flagActionBarResourceId));









        actionBar.setCustomView(v);


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
