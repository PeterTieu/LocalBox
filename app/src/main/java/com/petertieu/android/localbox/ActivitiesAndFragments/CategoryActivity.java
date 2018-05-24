package com.petertieu.android.localbox.ActivitiesAndFragments;

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

import com.petertieu.android.localbox.R;

//Activity hosting the CategoryFragment (i.e. the fragment that contains the Sound asset files of a Category of a Language)

//In CONTROLLER layer of the app

public class CategoryActivity extends OneFragmentActivity{


    //============= Declare instance variables ==============================================

    //Tag for Logcat
    private static final String TAG = "CategoryActivity";

    //Keys for the Extra passed to the intent to begin this qactivity
    private static final String EXTRA_LANGUAGE_CHOSEN= "ExtraLanguageChosen"; //Key for Language chosen
    private static final String EXTRA_CATEGORY_CHOSEN = "ExtraCategoryChosen"; //Key for Category chosen

    //Language and Category chosen
    private String mLanguageChosen;
    private String mCategoryChosen;

    //Keys for the Language and Category passed to CategoryFragment
    public static final String KEY_LANGUAGE_CHOSEN = "KeyLanguageChosen";
    public static final String KEY_CATEGORY_CHOSEN = "KeyCategoryChosen";




    //============= Define methods ==========================================================

    ////Static method to begin the CategoryActivity (called in CategoryChooserFragment)
    public static Intent newIntent(Context context, String language, String category){

        //Log to Logcat
        Log.i(TAG, "newIntent(..) called");

        //Create Intent for CategoryActivity
        Intent intent = new Intent(context, CategoryActivity.class);

        //Add Extras that describe the Language and Category chosen
        intent.putExtra(EXTRA_LANGUAGE_CHOSEN, language);
        intent.putExtra(EXTRA_CATEGORY_CHOSEN, category);

        //REturn the Intent
        return intent;
    }




    //Override onCreate(..) activity lifecycle callback method
    @Override
    public void onCreate(Bundle bundle){

        //Log to Logcat
        Log.i(TAG, "onCreate(..) called");

        //Get the Language and Category chosen passed from the CategoryChooserFragment
        mLanguageChosen = (String) getIntent().getStringExtra(EXTRA_LANGUAGE_CHOSEN);
        mCategoryChosen = (String) getIntent().getStringExtra(EXTRA_CATEGORY_CHOSEN);

        super.onCreate(bundle);

        //Log Language and Category chosen in Logcat (for debugging)
        Log.i(TAG, "Language chosen: " + mLanguageChosen + "... " + "Category chosen: " + mCategoryChosen);




        //===================== Configure the ActionBar ===========================

        //Create ActionBar object
        ActionBar actionBar = getSupportActionBar();

        //Set the display to be customisable
        actionBar.setDisplayShowCustomEnabled(true);

        //Create LayoutInflater object to inflate the ActionBar
        LayoutInflater layoutInflator = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //Obtain the View from layout of the ActionBar
        View v = layoutInflator.inflate(R.layout.action_bar_category_activity, null);

        //Obtain the TextView View from the layout resource file of the ActionBar
        TextView textView = (TextView) v.findViewById(R.id.text_view);



            //===================== Set up the of the Language and Category chosen - for the ActionBar ======================

        //Get the Strings of the Language and Category chosen, but capitalise the first letter of each
        String languageChosenCapitalised = mLanguageChosen.substring(0,1).toUpperCase() + mLanguageChosen.substring(1);
        String categoryChosenCapitalised = mCategoryChosen.substring(0,1).toUpperCase() + mCategoryChosen.substring(1);

        //Set the text of the ActionBar to include the Language and Category chosen
        textView.setText(languageChosenCapitalised + " " + categoryChosenCapitalised);



            //===================== Set up the flag of the Language chosen - for the ActionBar ======================

        //Obtain the ImageView View from the laout resource file of the ActionBar
        ImageView flagActionBarImageView = (ImageView) v.findViewById(R.id.flag_action_bar);

        //Intialise the resource ID (int) of the flag's ImageView
        int flagActionBarResourceId = 0;


        //Scan through the different values of the Language chosen, and obtain the resource ID of the their corresponding flag drawable
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

        //Set the drawable of the ImageView View to the image of the flag of the Language chosen
        flagActionBarImageView.setImageDrawable(getResources().getDrawable(flagActionBarResourceId));


        //Set the custom view to the ActionBar
        actionBar.setCustomView(v);
    }





    //Override createFragment() method inherited from OneFragmentActivity - in order to be created the CategoryChooserFragment
    @Override
    protected Fragment createFragment(){

        //Create an argunent bundle object
        Bundle argumentBundle = new Bundle();

        //Add the String of the Language and Category dhosen to the Fragment
        argumentBundle.putString(KEY_LANGUAGE_CHOSEN, mLanguageChosen);
        argumentBundle.putString(KEY_CATEGORY_CHOSEN, mCategoryChosen);

        //Create the category fragment
        CategoryFragment categoryFragment = new CategoryFragment();

        //Set the argument-bundle to the fragment
        categoryFragment.setArguments(argumentBundle);

        //Return the fragment
        return categoryFragment;
    }




    //Overrie getLayoutResourceId() inherited from OneFragmentActivity
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