package com.petertieu.android.localbox;

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

import com.petertieu.android.localbox.dialogfragment.ArabicInfoDialogFragment;
import com.petertieu.android.localbox.dialogfragment.ChineseInfoDialogFragment;

import mehdi.sakout.fancybuttons.FancyButton;


//
public class CategoryChooserFragment extends Fragment{

    //============= Declare instance variables ==============================================
    private final String TAG = "CategoryChooserFragment";

    private View mFlag;

    private String mLanguageChosen;

    private FancyButton mNumerics;

    private FancyButton mStatements;

    private FancyButton mQuestions;

    private FancyButton mAdjectives;

    private FancyButton mNouns;


    private static final String IDENTIFIER_DIALOG_FRAGMENT_ABOUT = "DialogFragmentAbout";



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


        if (getArguments() != null){


            mLanguageChosen = getArguments().getString(CategoryChooserActivity.KEY_FOR_LANGUAGE_CHOSEN);

            Log.i(TAG, "Language chosen: " + mLanguageChosen);
        }



        //Report that this fragment would like to participate in populating menus
        setHasOptionsMenu(true);

        //Reset options menu
        getActivity().invalidateOptionsMenu();


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


        View view = layoutInflater.inflate(R.layout.fragment_category_chooser, viewGroup, false);

        mFlag = view.findViewById(R.id.flag_action_bar);


        switch (mLanguageChosen){

            case "arabic":
                mFlag.setBackground(getResources().getDrawable(R.drawable.arabic_flag));

                break;

            case "chinese":
                mFlag.setBackground(getResources().getDrawable(R.drawable.chinese_flag));
                break;

            case "french":
                mFlag.setBackground(getResources().getDrawable(R.drawable.french_flag));
                break;

            case "german":
                mFlag.setBackground(getResources().getDrawable(R.drawable.german_flag));
                break;

            case "hindi":
                mFlag.setBackground(getResources().getDrawable(R.drawable.hindi_flag));
                break;


            case "italian":
                mFlag.setBackground(getResources().getDrawable(R.drawable.italian_flag));
                break;


            case "japanese":
                mFlag.setBackground(getResources().getDrawable(R.drawable.japanese_flag));
                break;

            case "korean":
                mFlag.setBackground(getResources().getDrawable(R.drawable.korean_flag));
                break;


            case "russian":
                mFlag.setBackground(getResources().getDrawable(R.drawable.russian_flag));
                break;

            case "spanish":
                mFlag.setBackground(getResources().getDrawable(R.drawable.spanish_flag));
                break;

            case "thai":
                mFlag.setBackground(getResources().getDrawable(R.drawable.thai_flag));
                break;

            case "vietnamese":
                mFlag.setBackground(getResources().getDrawable(R.drawable.vietnamese_flag));
                break;



        }





        mNumerics = (FancyButton) view.findViewById(R.id.numerics);
        mNumerics.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Log.i(TAG, "Numerics pressed");

                Intent catetegoryActivityIntent = new CategoryActivity().newIntent(getActivity(), mLanguageChosen, "numerics");
                startActivity(catetegoryActivityIntent);
            }
        });


        mStatements = (FancyButton) view.findViewById(R.id.statements);
        mStatements.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "Statements pressed");

                Intent catetegoryActivityIntent = new CategoryActivity().newIntent(getActivity(), mLanguageChosen, "statements");
                startActivity(catetegoryActivityIntent);

            }
        });


        mQuestions = (FancyButton) view.findViewById(R.id.questions);
        mQuestions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "Questions pressed");

                Intent catetegoryActivityIntent = new CategoryActivity().newIntent(getActivity(), mLanguageChosen, "questions");
                startActivity(catetegoryActivityIntent);

            }
        });



        mAdjectives = (FancyButton) view.findViewById(R.id.adjectives);
        mAdjectives.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "Adjectives pressed");

                Intent catetegoryActivityIntent = new CategoryActivity().newIntent(getActivity(), mLanguageChosen, "adjectives");
                startActivity(catetegoryActivityIntent);

            }
        });



        mNouns = (FancyButton) view.findViewById(R.id.nouns);
        mNouns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "nouns pressed");

                Intent catetegoryActivityIntent = new CategoryActivity().newIntent(getActivity(), mLanguageChosen, "nouns");
                startActivity(catetegoryActivityIntent);

            }
        });






        return view;
    }




    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater){
        super.onCreateOptionsMenu(menu, menuInflater);

        Log.i(TAG, "onCreateOptionsMenu(..) called");

        switch(mLanguageChosen){

            case "arabic":
                menuInflater.inflate(R.menu.arabic_info, menu);
                break;



            case "chinese":
                menuInflater.inflate(R.menu.chinese_info, menu);
                break;
        }

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem){
        Log.i(TAG, "onOptionsItemSelected(..) called");


        switch(mLanguageChosen){

            case "arabic":
                switch(menuItem.getItemId()){
                    case (R.id.arabic_info):

                        arabicDialog();
                        return true;
                }
                break;


            case "chinese":
                switch(menuItem.getItemId()){
                    case (R.id.chinese_info):

                        chineseDialog();
                        return true;
                }
                break;


        }



        return super.onOptionsItemSelected(menuItem);
    }




    private void arabicDialog(){
        FragmentManager fragmentManager = getFragmentManager();

        ArabicInfoDialogFragment aboutDialogFragment = ArabicInfoDialogFragment.newInstance();

        aboutDialogFragment.show(fragmentManager, IDENTIFIER_DIALOG_FRAGMENT_ABOUT);
    }


    private void chineseDialog(){
        FragmentManager fragmentManager = getFragmentManager();

        ChineseInfoDialogFragment aboutDialogFragment = ChineseInfoDialogFragment.newInstance();

        aboutDialogFragment.show(fragmentManager, IDENTIFIER_DIALOG_FRAGMENT_ABOUT);
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
