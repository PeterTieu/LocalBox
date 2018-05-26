package com.petertieu.android.localbox.AlertDialogs;

import android.app.Dialog;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.text.Html;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.petertieu.android.localbox.R;

//Class that sets the AlertDialog for CategoryFragment

//In CONTROLLER layer of the project

public class CategoryInfoDialogFragment extends DialogFragment{

    //============= Declare instance variables ==============================================
    //Key for for Language chosen
    private static final String ARG_LANGUAGE_CHOSEN = "languageChosen";

    //Key for Category chosen
    private static final String ARG_CATEGORY_CHOSEN = "categoryChosen";

    //Lnguage and Category chosen
    private String mLanguageChosen;
    private String mCategoryChosen;

    //Custom title variables
    private String mCustomTitleText;
    private int mCustomTitleTextColor;
    private int mCustomTitleBackgroundColor;

    //Message variable
    private CharSequence mMessage;



    //============= Define methods ==========================================================

    //Encapsulator method - called by CategoryFragment
    public static CategoryInfoDialogFragment newInstance(String languageChosen, String categoryChosen){

        //Create argument-bundle
        Bundle argumentBundle = new Bundle();

        //Put the Language chosen to the argument-bundle
        argumentBundle.putString(ARG_LANGUAGE_CHOSEN, languageChosen);

        //Put the Category chosen to the argument-bundle
        argumentBundle.putString(ARG_CATEGORY_CHOSEN, categoryChosen);

        //Create the CategoryInfoDialogFragment
        CategoryInfoDialogFragment categoryInfoDialogFragment = new CategoryInfoDialogFragment();

        //Set the argument-bundle to the CategoryInfoDialogFragment object
        categoryInfoDialogFragment.setArguments(argumentBundle);

        //Return the CategoryInfoDialogFragment
        return categoryInfoDialogFragment;
    }




    //Override onCreateDialog(..) method
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        //Obtain the Language chosen from the argument-bundle
        mLanguageChosen = getArguments().getString(ARG_LANGUAGE_CHOSEN);

        //Obtain the Category chosen from the argument-bundle
        mCategoryChosen = getArguments().getString(ARG_CATEGORY_CHOSEN);

        //Scan through the different Language chosen values and set the COLORS of the TITLE and BACKGROUND of the AlertDialog accordingly
        switch (mLanguageChosen){

            case ("arabic"):
                mCustomTitleTextColor = getResources().getColor(R.color.white);
                mCustomTitleBackgroundColor = getResources().getColor(R.color.green_arabic_flag);
                break;

            case("chinese"):
                mCustomTitleTextColor = getResources().getColor(R.color.yellow_chinese_flag);
                mCustomTitleBackgroundColor = getResources().getColor(R.color.red_chinese_flag);
                break;

            case("french"):
                mCustomTitleTextColor = getResources().getColor(R.color.white);
                mCustomTitleBackgroundColor = getResources().getColor(R.color.blue_french_flag);
                break;

            case("german"):
                mCustomTitleTextColor = getResources().getColor(R.color.yellow_german_flag);
                mCustomTitleBackgroundColor = getResources().getColor(R.color.black);
                break;

            case("hindi"):
                mCustomTitleTextColor = getResources().getColor(R.color.orange_hindi_flag);
                mCustomTitleBackgroundColor = getResources().getColor(R.color.green_hindi_flag);
                break;

            case("italian"):
                mCustomTitleTextColor = getResources().getColor(R.color.white);
                mCustomTitleBackgroundColor = getResources().getColor(R.color.green_italian_flag);
                break;

            case("japanese"):
                mCustomTitleTextColor = getResources().getColor(R.color.red_japanese_flag);
                mCustomTitleBackgroundColor = getResources().getColor(R.color.white);
                break;

            case("korean"):
                mCustomTitleTextColor = getResources().getColor(R.color.black);
                mCustomTitleBackgroundColor = getResources().getColor(R.color.white);
                break;

            case("russian"):
                mCustomTitleTextColor = getResources().getColor(R.color.blue_russian_flag);
                mCustomTitleBackgroundColor = getResources().getColor(R.color.white);
                break;

            case("spanish"):
                mCustomTitleTextColor = getResources().getColor(R.color.red_spanish_flag);
                mCustomTitleBackgroundColor = getResources().getColor(R.color.yellow_spanish_flag);
                break;

            case("thai"):
                mCustomTitleTextColor = getResources().getColor(R.color.blue_thai_flag);
                mCustomTitleBackgroundColor = getResources().getColor(R.color.red_thai_flag);
                break;

            case("vietnamese"):
                mCustomTitleTextColor = getResources().getColor(R.color.yellow_vietnamese_flag);
                mCustomTitleBackgroundColor = getResources().getColor(R.color.red_vietnamese_flag);
                break;
        }


        //Scan through the different Category chosen values and set the TEXT of the TITLE and MESSAGE of the AlertDialog accordingly
        switch (mCategoryChosen){

            case ("numerics"):
                mCustomTitleText = "Numerics";
                mMessage = Html.fromHtml(
                        "<br>" + "</br>" + //New Line
                                "Words for numbers and time."
                );
                break;


            case ("statements"):
                mCustomTitleText = "Statements";
                mMessage = Html.fromHtml(
                        "<br>" + "</br>" + //New Line
                                "Common sentences and expressions."
                );
                break;


            case ("questions"):
                mCustomTitleText = "Questions";
                mMessage = Html.fromHtml(
                        "<br>" + "</br>" + //New Line
                                "Questions to ask for help or directions."
                );
                break;


            case ("adjectives"):
                mCustomTitleText = "Adjectives";
                mMessage = Html.fromHtml(
                        "<br>" + "</br>" + //New Line
                                "Common words to describe nouns or objects."
                );
                break;


            case ("nouns"):
                mCustomTitleText = "Nouns";
                mMessage = Html.fromHtml(
                        "<br>" + "</br>" + //New Line
                                "Common words to identify objects, places or things"
                );
                break;
        }


        //Set custom title based on the variables configured for the chosen Language and Category
        TextView customTitle = new TextView(getActivity());
        customTitle.setText(mCustomTitleText);
        customTitle.setTextSize(22);
        customTitle.setGravity(Gravity.CENTER);
        customTitle.setTypeface(null, Typeface.BOLD);
        customTitle.setTextColor(mCustomTitleTextColor);
        customTitle.setBackgroundColor(mCustomTitleBackgroundColor);


        //Obtain View of the menu layout file
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_category_info, null);


        //Create AlertDialog, based on the layout and custom title and message
        AlertDialog alertDialog = new AlertDialog
                .Builder(getActivity())
                .setView(view)
                .setCustomTitle(customTitle)
                .setMessage(mMessage)
                .show();


        //Set the size of the AlertDialog
        alertDialog.getWindow().setLayout(850, 450);


        //Return the AlertDialog
        return alertDialog;
    }

}
