package com.petertieu.android.localbox;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;


//Activity hosting LanguageChooserFragment
public class CategoryChooserActivity extends OneFragmentActivity{

    //============= Declare instance variables ==============================================
    private static final String TAG = "CategoryChooserActivity";

    private String mLanguageChosen;

    private final static String EXTRA_FROM_LANGUAGE_CHOOSER_FRAGMENT_LANGUAGE_CHOSEN = "Language";
    public final static String KEY_FOR_LANGUAGE_CHOSEN = "Lang";


    //============= Define methods ==========================================================



    public static Intent newIntent(Context context, String language){

        Log.i(TAG, "newIntent(..) called");

        Intent intent = new Intent(context, CategoryChooserActivity.class);

        intent.putExtra(EXTRA_FROM_LANGUAGE_CHOOSER_FRAGMENT_LANGUAGE_CHOSEN, language);

        return intent;

    }







    @Override
    public void onCreate(Bundle bundle){

        Log.i(TAG, "onCreate(..) called");

        mLanguageChosen = (String) getIntent().getStringExtra(EXTRA_FROM_LANGUAGE_CHOOSER_FRAGMENT_LANGUAGE_CHOSEN);






//        SharedPreferences sharedPreferences = getSharedPreferences("LocalBox", Context.MODE_PRIVATE);
//
//
//        sharedPreferences.edit().putString("language", mLanguageChosen);
//
//
//        mLanguageChosen = sharedPreferences.getString("LanguageChosen", null);















        super.onCreate(bundle);



        if (mLanguageChosen != null) {
            Log.i(TAG, mLanguageChosen);
        }


        //Captalise the first letter of the language chosen (e.g. "chinese" to "Chinese", "thai" to "Thai", etc.)
        String languageChosenCapitalised = mLanguageChosen.substring(0,1).toUpperCase() + mLanguageChosen.substring(1);

        // Display the capitalised lanuage String in the action bar
        getSupportActionBar().setTitle(languageChosenCapitalised);




    }





    @Override
    protected Fragment createFragment(){

        Log.i(TAG, "createFragment() called: " + "LanguageChosen is " + mLanguageChosen);

        Bundle argumentBundle = new Bundle();
        argumentBundle.putString(KEY_FOR_LANGUAGE_CHOSEN, mLanguageChosen);



        CategoryChooserFragment categoryChooserFragment = new CategoryChooserFragment();

        categoryChooserFragment.setArguments(argumentBundle);

        return categoryChooserFragment;
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
