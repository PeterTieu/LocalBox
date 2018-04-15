package com.petertieu.android.localbox;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mehdi.sakout.fancybuttons.FancyButton;


//
public class LanguageChooserFragment extends Fragment{

    //============= Declare instance variables ==============================================
    private final String TAG = "LanguageChooserFragment";

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


    //============= Define methods ==========================================================

    //Override onAttach(..) fragment lifecycle callback method
    @Override
    public void onAttach(Context context){
        super.onAttach(context);

        Log.i(TAG, "onAttach(..) called");
    }


    //Override onCreate(..) fragment lifecycle callback method
    @Override
    public void onCreate(Bundle onSaveInstanceState){
        super.onCreate(onSaveInstanceState);

        Log.i(TAG, "onCreate(..) called");
    }





    //Override onStart() fragment lifecycle callback method
    @Override
    public void onStart(){
        super.onStart();

        Log.i(TAG, "onStart() called");
    }


    //Override onResume() fragment lifecycle callback method
    @Override
    public void onResume(){
        super.onResume();

        Log.i(TAG, "onResume() called");
    }



    //Overrinmn de onCreateView(..) fragment lifecycle callback method
    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle savedInstanceState){
        super.onCreateView(layoutInflater, viewGroup, savedInstanceState);

        //Log lifecycle callback
        Log.i(TAG, "onCreateView(..) called");


        View view = layoutInflater.inflate(R.layout.fragment_language_chooser, viewGroup, false);

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









        mArabicButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intraLanguageActivityIntent = CategoryChooserActivity.newIntent(getActivity(), "arabic");

                startActivity(intraLanguageActivityIntent);

            }
        });


        mChineseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intraLanguageActivityIntent = CategoryChooserActivity.newIntent(getActivity(), "chinese");

                startActivity(intraLanguageActivityIntent);

            }
        });






        mFrenchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intraActivityIntent = CategoryChooserActivity.newIntent(getActivity(), "french");

                startActivity(intraActivityIntent);
            }
        });




        mGermanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intraLanguageActivityIntent = CategoryChooserActivity.newIntent(getActivity(), "german");

                startActivity(intraLanguageActivityIntent);

            }
        });



        mHindiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intraLanguageActivityIntent = CategoryChooserActivity.newIntent(getActivity(), "hindi");

                startActivity(intraLanguageActivityIntent);

            }
        });


        mItalian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intraLanguageActivityIntent = CategoryChooserActivity.newIntent(getActivity(), "italian");

                startActivity(intraLanguageActivityIntent);
            }
        });



        mJapanese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intraLanguageActivityIntent = CategoryChooserActivity.newIntent(getActivity(), "japanese");

                startActivity(intraLanguageActivityIntent);
            }
        });


        mKorean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intraLanguageActivityIntent = CategoryChooserActivity.newIntent(getActivity(), "korean");

                startActivity(intraLanguageActivityIntent);
            }
        });




        mRussianButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intraLanguageActivityIntent = CategoryChooserActivity.newIntent(getActivity(), "russian");

                startActivity(intraLanguageActivityIntent);

            }
        });




        mSpanishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intraLanguageActivityIntent = CategoryChooserActivity.newIntent(getActivity(), "spanish");

                startActivity(intraLanguageActivityIntent);

            }
        });



        mThaiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intraLanguageActivityIntent = CategoryChooserActivity.newIntent(getActivity(), "thai");

                startActivity(intraLanguageActivityIntent);

            }
        });




        mVietnameseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intraLanguageActivityIntent = CategoryChooserActivity.newIntent(getActivity(), "vietnamese");

                startActivity(intraLanguageActivityIntent);

            }
        });






        return view;
    }


    //Override onPause() fragment lifecycle callback method
    @Override
    public void onPause(){
        super.onPause();
        Log.i(TAG, "onPause() called");
    }





    //Override onStop() fragment lifecycle callback method
    @Override
    public void onStop(){
        super.onStop();
        Log.i(TAG, "onStop() called");
    }





    @Override
    public void onDestroyView(){
        super.onDestroyView();
        Log.i(TAG, "onDestroyView() called");
    }





    //Override onDestroy() fragment lifecycle callback method
    @Override
    public void onDestroy(){
        super.onDestroy();
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
