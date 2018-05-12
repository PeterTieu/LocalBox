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
import android.widget.ImageView;
import com.petertieu.android.localbox.dialogfragment.LanguageInfoDialogFragment;
import mehdi.sakout.fancybuttons.FancyButton;


//Fragment of a language that displays the categories (e.g. "Numerics", "Statement", "Question", "Adjectives", "Nouns")

//In CONTROLLER layer of the project
public class CategoryChooserFragment extends Fragment{

    //============= Declare instance variables ==============================================
    private final String TAG = "CategoryChooserFragment";

    //Language chosen (LanguageChooserFragment -> CategoryChooserActivity -> CategoryChooserFragment)
    private String mLanguageChosen;

    //View of the flag of the language
    private ImageView mFlag;

    //Buttons of the categories
    private FancyButton mNumerics;
    private FancyButton mStatements;
    private FancyButton mQuestions;
    private FancyButton mAdjectives;
    private FancyButton mNouns;

    //Identifier for LanguageInfoDialogFragment (DialogFragment for the Info of the language chosen)
    private static final String IDENTIFIER_DIALOG_FRAGMENT_LANGUAGE_INFO = "DialogFragmentLanguageInfo";



    //============= Define methods ==========================================================

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


        //If arguments passed to CategoryChooserFragment from CategoryChooserActivity exists
        if (getArguments() != null){

            //Log to Logcat
            Log.i(TAG, "Language chosen: " + mLanguageChosen);

            //Get the String for the language chosen
            mLanguageChosen = getArguments().getString(CategoryChooserActivity.KEY_FOR_LANGUAGE_CHOSEN);
        }


        //Declare that this fragment participates in populating menus
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




    //Overrinmn de onCreateView(..) fragment lifecycle callback method
    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle savedInstanceState){
        super.onCreateView(layoutInflater, viewGroup, savedInstanceState);

        //Log lifecycle callback
        Log.i(TAG, "onCreateView(..) called");

        //Obtain View from the layout of the CategoryChooserFragment
        View view = layoutInflater.inflate(R.layout.fragment_category_chooser, viewGroup, false);

        //Obtain the ImageView of the flag from the layout resource file
        mFlag = (ImageView) view.findViewById(R.id.flag_action_bar);


        //Scan through all the possible languages chosen. Assign the
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



        //Assign mNumerics reference variable to the associated FancyButton object
        mNumerics = (FancyButton) view.findViewById(R.id.numerics);

        //Set listener for mNumerics FancyButton
        mNumerics.setOnClickListener(new View.OnClickListener() {

            //Override onClick(..) method
            @Override
            public void onClick(View view) {

                //Log to Logcat
                Log.i(TAG, "Numerics pressed");

                //Create Intent for CategoryActivity, passing the language chosen (e.g. "arabic", "chinese", "french", etc.) and the category chosen ("numerics")
                Intent catetegoryActivityIntent = new CategoryActivity().newIntent(getActivity(), mLanguageChosen, "numerics");

                //Start the Intent to begin CategoryActivity
                startActivity(catetegoryActivityIntent);
            }
        });


        //Assign mStatements reference variable to the associated FancyButton object
        mStatements = (FancyButton) view.findViewById(R.id.statements);

        //Set listener for mStatements FancyButton
        mStatements.setOnClickListener(new View.OnClickListener() {

            //Override onClick(..) method
            @Override
            public void onClick(View view) {

                //Log to Logcat
                Log.i(TAG, "Statements pressed");

                //Create Intent for CategoryActivity, passing the language chosen (e.g. "arabic", "chinese", "french", etc.) and the category chosen ("statements")
                Intent catetegoryActivityIntent = new CategoryActivity().newIntent(getActivity(), mLanguageChosen, "statements");

                //Start the Intent to begin CategoryActivity
                startActivity(catetegoryActivityIntent);

            }
        });


        //Assign mQuestions reference variable to the associated FancyButton object
        mQuestions = (FancyButton) view.findViewById(R.id.questions);

        //Set listener for mQuestions FancyButton
        mQuestions.setOnClickListener(new View.OnClickListener() {

            //Override onClick(..) method
            @Override
            public void onClick(View view) {

                //Log to Logcat
                Log.i(TAG, "Questions pressed");

                //Create Intent for CategoryActivity, passing the language chosen (e.g. "arabic", "chinese", "french", etc.) and the category chosen ("questions")
                Intent catetegoryActivityIntent = new CategoryActivity().newIntent(getActivity(), mLanguageChosen, "questions");

                //Start the Intent to begin CategoryActivity
                startActivity(catetegoryActivityIntent);

            }
        });


        //Assign mAdjectives reference variable to the associated FancyButton object
        mAdjectives = (FancyButton) view.findViewById(R.id.adjectives);

        //Set listener for mAdjectives FancyButton
        mAdjectives.setOnClickListener(new View.OnClickListener() {

            //Override onClick(..) method
            @Override
            public void onClick(View view) {

                //Log to Logcat
                Log.i(TAG, "adjectives pressed");

                //Create Intent for CategoryActivity, passing the language chosen (e.g. "arabic", "chinese", "french", etc.) and the category chosen ("adjectives")
                Intent catetegoryActivityIntent = new CategoryActivity().newIntent(getActivity(), mLanguageChosen, "adjectives");

                //Start the Intent to begin CategoryActivity
                startActivity(catetegoryActivityIntent);

            }
        });


        //Assign mNouns reference variable to the associated FancyButton object
        mNouns = (FancyButton) view.findViewById(R.id.nouns);

        //Set listener for mNouns FancyButton
        mNouns.setOnClickListener(new View.OnClickListener() {

            //Override onClick(..) method
            @Override
            public void onClick(View view) {

                //Log to Logcat
                Log.i(TAG, "nouns pressed");

                //Create Intent for CategoryActivity, passing the language chosen (e.g. "arabic", "chinese", "french", etc.) and the category chosen ("nouns")
                Intent catetegoryActivityIntent = new CategoryActivity().newIntent(getActivity(), mLanguageChosen, "nouns");

                //Start the Intent to begin CategoryActivity
                startActivity(catetegoryActivityIntent);
            }
        });


        //Return the View
        return view;
    }




    //Override onOptionsItemSelected(..) fragment lifecycle callback method
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater){
        super.onCreateOptionsMenu(menu, menuInflater);

        //Log to Logcat
        Log.i(TAG, "onCreateOptionsMenu(..) called");

        //Inflate the menu layout of the fragment
        menuInflater.inflate(R.menu.fragment_category_chooser, menu);
    }




    //Override onOptionsItemSelected(..) 'listener' method
    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem){

        //Log to Logcat
        Log.i(TAG, "onOptionsItemSelected(..) called");

        //Implement listener for the menu items in the menu layout
        switch(menuItem.getItemId()){

            case (R.id.language_info_dialog):

                //Create the "language information" menu item
                languageInfoDialogFragment(mLanguageChosen);
                break;
        }

        return super.onOptionsItemSelected(menuItem);
    }




    //Helper method - Create the "about" menu item
    private void languageInfoDialogFragment(String languageChosen){

        //Create FragmentManager instance
        FragmentManager fragmentManager = getFragmentManager();

        //Create the LanguageInfoDialogFragment instance
        LanguageInfoDialogFragment languageInfoDialogFragment = LanguageInfoDialogFragment.newInstance(languageChosen);

        //Show the LanguageInfoDialogFragment fragment
        languageInfoDialogFragment.show(fragmentManager, IDENTIFIER_DIALOG_FRAGMENT_LANGUAGE_INFO);
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
