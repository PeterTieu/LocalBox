package com.petertieu.android.localbox.ActivitiesAndFragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.petertieu.android.localbox.AlertDialogs.AboutDialogFragment;
import com.petertieu.android.localbox.R;

import mehdi.sakout.fancybuttons.FancyButton;


//Fragment that displays all the Languages to be chosen

//In CONTROLLER layer of the project

public class LanguageChooserFragment extends Fragment{

    //============= Declare instance variables ================================================================

    //Log for Logcat
    private final String TAG = "LanguageChooserFragment";

    //Views for the buttons of all the Languages
    FancyButton mArabicButton;
    FancyButton mChineseButton;
    FancyButton mFrenchButton;
    FancyButton mGermanButton;
    FancyButton mHindiButton;
    FancyButton mItalian;
    FancyButton mJapanese;
    FancyButton mKorean;
    FancyButton mRussianButton;
    FancyButton mSpanishButton;
    FancyButton mThaiButton;
    FancyButton mVietnameseButton;

    //Identifier for AboutDialogFragment (DialogFragment that is an "About" of the app)
    private static final String IDENTIFIER_DIALOG_FRAGMENT_ABOUT = "DialogFragmentAbout";



    //============= Define methods ============================================================================

    //Override onAttach(..) fragment lifecycle callback method
    @Override
    public void onAttach(Context context){
        super.onAttach(context);

        //Log to Logcat
        Log.i(TAG, "onAttach(..) called");
    }




    //Override onCreate(..) fragment lifecycle callback method
    @Override
    public void onCreate(Bundle onSaveInstanceState){
        super.onCreate(onSaveInstanceState);

        //Log to Logcat
        Log.i(TAG, "onCreate(..) called");

        //Report that this fragment would like to participate in populating menus
        setHasOptionsMenu(true);

        //Reset options menu
        getActivity().invalidateOptionsMenu();
    }




    //Override onStart() fragment lifecycle callback method
    @Override
    public void onStart(){
        super.onStart();

        //Log to Logcat
        Log.i(TAG, "onStart() called");
    }




    //Override onResume() fragment lifecycle callback method
    @Override
    public void onResume(){
        super.onResume();

        //Log to Logcat
        Log.i(TAG, "onResume() called");
    }




    //Override the onCreateView(..) fragment lifecycle callback method
    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle savedInstanceState){
        super.onCreateView(layoutInflater, viewGroup, savedInstanceState);

        //Log in Logcat
        Log.i(TAG, "onCreateView(..) called");

        //Inflate the layout of the LanguageChooserFragment
        View view = layoutInflater.inflate(R.layout.fragment_language_chooser, viewGroup, false);

        //Assign button views of the LanguageChooserFragment layout to the instance variables
        mArabicButton = view.findViewById(R.id.arabic);
        mChineseButton = view.findViewById(R.id.chinese);
        mFrenchButton = view.findViewById(R.id.french);
        mGermanButton = view.findViewById(R.id.german);
        mHindiButton = view.findViewById(R.id.hindi);
        mItalian = view.findViewById(R.id.italian);
        mJapanese = view.findViewById(R.id.japanese);
        mKorean = view.findViewById(R.id.korean);
        mRussianButton = view.findViewById(R.id.russian);
        mSpanishButton = view.findViewById(R.id.spanish);
        mThaiButton = view.findViewById(R.id.thai);
        mVietnameseButton = view.findViewById(R.id.vietnamese);



        //Set listener for the Arabic button
        mArabicButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Open the CategoryChooserActivity, passing the "arabic" String
                Intent categoryChooserActivityIntent = CategoryChooserActivity.newIntent(getActivity(), "arabic");

                //Start CategoryChooserActivity
                startActivity(categoryChooserActivityIntent);
            }
        });


        //Set listener for the Arabic button
        mChineseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Open the CategoryChooserActivity, passing the "arabic" String
                Intent categoryChooserActivityIntent = CategoryChooserActivity.newIntent(getActivity(), "chinese");

                //Start CategoryChooserActivity
                startActivity(categoryChooserActivityIntent);
            }
        });


        //Set listener for the French button
        mFrenchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Open the CategoryChooserActivity, passing the "french" String
                Intent categoryChooserActivityIntent = CategoryChooserActivity.newIntent(getActivity(), "french");

                //Start CategoryChooserActivity
                startActivity(categoryChooserActivityIntent);
            }
        });


        //Set listener for the German button
        mGermanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Open the CategoryChooserActivity, passing the "german" String
                Intent categoryChooserActivityIntent = CategoryChooserActivity.newIntent(getActivity(), "german");

                //Start CategoryChooserActivity
                startActivity(categoryChooserActivityIntent);
            }
        });


        //Set listener for the Hindi button
        mHindiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Open the CategoryChooserActivity, passing the "hindi" String
                Intent categoryChooserActivityIntent = CategoryChooserActivity.newIntent(getActivity(), "hindi");

                //Start CategoryChooserActivity
                startActivity(categoryChooserActivityIntent);
            }
        });


        //Set listener for the Italian button
        mItalian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Open the CategoryChooserActivity, passing the "italian" String
                Intent categoryChooserActivityIntent = CategoryChooserActivity.newIntent(getActivity(), "italian");

                //Start CategoryChooserActivity
                startActivity(categoryChooserActivityIntent);
            }
        });


        //Set listener for the Japanese button
        mJapanese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Open the CategoryChooserActivity, passing the "japanese" String
                Intent categoryChooserActivityIntent = CategoryChooserActivity.newIntent(getActivity(), "japanese");

                //Start CategoryChooserActivity
                startActivity(categoryChooserActivityIntent);
            }
        });


        //Set listener for the Korean button
        mKorean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Open the CategoryChooserActivity, passing the "korean" String
                Intent categoryChooserActivityIntent = CategoryChooserActivity.newIntent(getActivity(), "korean");

                //Start CategoryChooserActivity
                startActivity(categoryChooserActivityIntent);
            }
        });


        //Set listener for the Russian button
        mRussianButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Open the CategoryChooserActivity, passing the "russian" String
                Intent categoryChooserActivityIntent = CategoryChooserActivity.newIntent(getActivity(), "russian");

                //Start CategoryChooserActivity
                startActivity(categoryChooserActivityIntent);
            }
        });


        //Set listener for the Spanish button
        mSpanishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Open the CategoryChooserActivity, passing the "spanish" String
                Intent categoryChooserActivityIntent = CategoryChooserActivity.newIntent(getActivity(), "spanish");

                //Start CategoryChooserActivity
                startActivity(categoryChooserActivityIntent);
            }
        });


        //Set listener for the Thai button
        mThaiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Open the CategoryChooserActivity, passing the "thai" String
                Intent categoryChooserActivityIntent = CategoryChooserActivity.newIntent(getActivity(), "thai");

                //Start CategoryChooserActivity
                startActivity(categoryChooserActivityIntent);
            }
        });


        //Set listener for the Vietnamese button
        mVietnameseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Open the CategoryChooserActivity, passing the "vietnamese" String
                Intent categoryChooserActivityIntent = CategoryChooserActivity.newIntent(getActivity(), "vietnamese");

                //Start CategoryChooserActivity
                startActivity(categoryChooserActivityIntent);
            }
        });

        //Return the view
        return view;
    }




    //Override onCreateOptionsMenu(..) fragment lifecycle callback method
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater){
        super.onCreateOptionsMenu(menu, menuInflater);

        //Log to Logcat
        Log.i(TAG, "onCreateOptionsMenu(..) called");

        //Inflate the menu layout of the fragment
        menuInflater.inflate(R.menu.fragment_language_chooser, menu);
    }




    //Override onOptionsItemSelected(..) fragment lifecycle callback method
    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem){

        //Log to Logcat
        Log.i(TAG, "onOptionsItemSelected(..) called");

        //Implement listener for the menu items in the menu layout
        switch(menuItem.getItemId()){
            case (R.id.about_dialog):

                //Create the "about" menu item
                aboutDialog();

                return true;
        }


        return super.onOptionsItemSelected(menuItem);
    }




    //Helper method - Create the "about" menu item
    private void aboutDialog(){

        //Create FragmentManager instance
        FragmentManager fragmentManager = getFragmentManager();

        //Create the AboutDialogFragment instance
        AboutDialogFragment aboutDialogFragment = AboutDialogFragment.newInstance();

        //Show the AboutDialogFragment fragment
        aboutDialogFragment.show(fragmentManager, IDENTIFIER_DIALOG_FRAGMENT_ABOUT);
    }




    //Override onPause() fragment lifecycle callback method
    @Override
    public void onPause(){
        super.onPause();

        //Log to Logcat
        Log.i(TAG, "onPause() called");
    }




    //Override onStop() fragment lifecycle callback method
    @Override
    public void onStop(){
        super.onStop();

        //Log to Logcat
        Log.i(TAG, "onStop() called");
    }




    //Override onDestroyView() fragment lifecycle callback method
    @Override
    public void onDestroyView(){
        super.onDestroyView();

        //Log to Logcat
        Log.i(TAG, "onDestroyView() called");
    }




    //Override onDestroy() fragment lifecycle callback method
    @Override
    public void onDestroy(){
        super.onDestroy();

        //Log to Logcat
        Log.i(TAG, "onDestroy() called");
    }




    //Override onDetach() fragment lifecycle callback method
    @Override
    public void onDetach(){
        super.onDetach();

        //Log in Logcat
        Log.i(TAG, "onDetach() called");
    }

}
