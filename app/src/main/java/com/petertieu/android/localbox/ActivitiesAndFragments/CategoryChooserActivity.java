package com.petertieu.android.localbox.ActivitiesAndFragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;

import com.petertieu.android.localbox.R;


//Activity hosting CategoryChooserFragment

//In CONTROLLER layer of the project

public class CategoryChooserActivity extends OneFragmentActivity{

    //============= Declare instance variables ==============================================

    //Tag for Logcat
    private static final String TAG = "CategoryChooserActivity";

    //Language chosen
    private String mLanguageChosen;

    //Key to retrieve the language chosen (passed as an Extra from the LanguageChooserFragment)
    private final static String EXTRA_FROM_LANGUAGE_CHOOSER_FRAGMENT_LANGUAGE_CHOSEN = "Language";

    //Key for passing the language chosen to the CatgoryChooserFragment
    public final static String KEY_FOR_LANGUAGE_CHOSEN = "Lang";



    //============= Define methods ==========================================================

    //Static method to begin the CategoryChooserActivity (called in LanguageChooserFragment)
    public static Intent newIntent(Context context, String language){

        //Log to Logcat
        Log.i(TAG, "newIntent(..) called");

        //Create Intent for CategoryChooserActivity
        Intent intent = new Intent(context, CategoryChooserActivity.class);

        //Add Extra that describes the language chosen in the CategoryChooserActivity (e.g. "arabic", "chinese", "french", etc.)
        intent.putExtra(EXTRA_FROM_LANGUAGE_CHOOSER_FRAGMENT_LANGUAGE_CHOSEN, language);

        //Return the Intent
        return intent;
    }




    //Override onCreate(..) activity lifecycle callback method
    @Override
    public void onCreate(Bundle bundle){

        //Log to Logcat
        Log.i(TAG, "onCreate(..) called");

        //Retrieve Extra from the intent that began this activity
        mLanguageChosen = (String) getIntent().getStringExtra(EXTRA_FROM_LANGUAGE_CHOOSER_FRAGMENT_LANGUAGE_CHOSEN);

        super.onCreate(bundle);

        //If the language chosen exists (i.e. the LanguageChooserFragment has passed a language to CategoryChooserActivity)
        //The cases where a language chosen does not exist would be if the app was closed on CategoryChooserActivity, then resumed
        if (mLanguageChosen != null) {
            Log.i(TAG, mLanguageChosen);
        }


        //======================== Set the action bar's title to the name of the language chosen ========================================================
        //Captalise the first letter of the language chosen (e.g. "chinese" to "Chinese", "thai" to "Thai", etc.)
        String languageChosenCapitalised = mLanguageChosen.substring(0,1).toUpperCase() + mLanguageChosen.substring(1);

        // Display the capitalised lanuage String in the action bar
        getSupportActionBar().setTitle(languageChosenCapitalised);
    }




    //Override createFragment() method inherited from OneFragmentActivity class to create the CategoryChooserFragment
    @Override
    protected Fragment createFragment(){

        //Log to Logcat
        Log.i(TAG, "createFragment() called: " + "LanguageChosen is " + mLanguageChosen);

        //Create argument-bundle to pass data to CategoryChooserFragment
        Bundle argumentBundle = new Bundle();

        //Add String describing language chosen to the argument-bundle
        argumentBundle.putString(KEY_FOR_LANGUAGE_CHOSEN, mLanguageChosen);

        //Create CategoryChooserFragment
        CategoryChooserFragment categoryChooserFragment = new CategoryChooserFragment();

        //Link the argument-bundle to the CategoryChooserFragment object
        categoryChooserFragment.setArguments(argumentBundle);

        //Return the CategoryChooserFragment
        return categoryChooserFragment;
    }




    //Override getLayoutResourceId() method from OneFragmentActivity
    @Override
    protected int getLayoutResourceId(){
        return R.layout.activity_masterfragment;
    }




    //Override onStart() Activity lifecycle callback method
    @Override
    public void onStart(){
        super.onStart();

        //Log to Logcat
        Log.i(TAG, "onStart() called");
    }




    //Override onResume() Activity lifecycle callback method
    @Override
    public void onResume(){
        super.onResume();

        //Log to Logcat
        Log.i(TAG, "onResume() called");
    }



    //Override onPause() Activity lifecycle callback method
    @Override
    public void onPause(){
        super.onPause();

        //Log to Logcat
        Log.i(TAG, "onPause() called");
    }




    //Override onStop() Activity lifecycle callback method
    @Override
    public void onStop(){
        super.onStop();

        //Log to Logcat
        Log.i(TAG, "onStop() called");
    }




    //Override onDestroy() Activity lifecycle callback method
    @Override
    public void onDestroy(){
        super.onDestroy();

        //Log to Logcat
        Log.i(TAG, "onDestroy() called");
    }

}
