package com.petertieu.android.localbox;

import android.content.Context;
import android.databinding.BaseObservable;
import android.graphics.drawable.StateListDrawable;
import android.widget.LinearLayout;
import android.widget.TextView;


//SoundViewModel is the VIEW-MODEL of the project.
    //It links the VIEW (list_item_sound.xml) with the MODEL (Sound, SoundManager).
    //Its function is to:
        //1: Get the title of the Sound asset from the Sound class (MODEL) and DISPLAY it onto the layout (VIEW)
        //2: Answer to the android:onClick attribute from the layout (VIEW) and call the playSound(Sound) method from the SoundManager class (MODEL)


//NOTE: SoundViewModel extends BaseObservable class so that we could get access to the method: notifyChange()
public class SoundViewModel extends BaseObservable{

    //============= Declare instance variables ==============================================

    //Tag for Logcat
    private final String TAG = "SoundViewModel";

    //Context reference variable
    public Context mContext;

    //Model reference variables
    private Sound mSound;
    private SoundManager mSoundManager;




    //============= Declare methods =========================================================

    //Build constructor - called by mListItemSoundBinding.setSoundViewModel(..) in CategoryFragment
    public SoundViewModel(SoundManager soundManger, Context context){

        //Assign the SoundManager instance reference variable to the local variable
        mSoundManager = soundManger;

        //Assign the Context instance variable to the local variable
        mContext = context;
    }




    //Set the Sound to the associated list item - called by SoundHolder.bind(Sound)
    public void setSound(Sound sound){

        //Get the Sound
        mSound = sound;

        //FEEDBACK:
        // VIEW-MODEL (SoundViewModel) informs the LAYOUT (listItemSoundBinding) that
        // The Sound inside SoundHolder.bind(Sound) has been updated
        // OTHERWISE (without the code below (notifyChange()), the names of the grids will be random and all over the place!
        notifyChange();
    }




    //Get the name of the Sound in English - called by "android:text="@{SoundViewModel.getSoundName}" in list_item_sound.xml
    public String getSoundName() {

        //Get the name of the Soud in English
        return mSound.getSoundNameEnglish();

    }




    //Set what happens when the list item is clicked - called by "android:onClick="@{(view) -> SoundViewModel.onButtonClicked()}" in list_item_sound.xml
    public void onButtonClicked(){

        //Play the sound
        mSoundManager.playSound(mSound);


        //======= REMOVE the PRE-TAP View on screen, and ADD the CAPTIONS View (NOTE: Only one of the PRE-TAP View or CAPTIONS View could appear on screen at a time!) ================

        //Obtain the linear layout of the "parent" element, which contains the preTapView and the postTapView
        LinearLayout parentLinearLayout = (LinearLayout) CategoryFragment.fragmentLocalboxBinding.parentLinearLayout;

        //Obtain the preTapView layout
        LinearLayout preTapView = (LinearLayout) CategoryFragment.fragmentLocalboxBinding.preTapView;

        //Remove the preTapView layout
        parentLinearLayout.removeView(preTapView);

        //Obtain the postTapView LinearLayout element
        LinearLayout captionsLinearLayout = (LinearLayout) CategoryFragment.fragmentLocalboxBinding.postTapView;

        //If the CAPTIONS View does NOT exist, then add it to the layout
        if (CategoryFragment.fragmentLocalboxBinding.getRoot().findViewById(R.id.postTapView) == null) {
            //
            parentLinearLayout.addView(captionsLinearLayout, parentLinearLayout.getChildCount() - 3);
        }


        //Obtain the englishText TextView element
        TextView englishText = CategoryFragment.fragmentLocalboxBinding.getRoot().findViewById(R.id.english_text);
        //Set the name of the Sound in English
        englishText.setText(mSound.getSoundNameEnglish());


        //Obtain the languageText TextView element
        TextView languageText = CategoryFragment.fragmentLocalboxBinding.getRoot().findViewById(R.id.language_text);
        //Set the name of the Sound in the Language
        languageText.setText(mSound.getSoundNameLanguage());


        //If the Pronunciation Text of the Sound EXISTS (e.g. for languages such as German, Spanish, Vietnamese etc.)
        if (mSound.getSoundPronounciation() != null) {

            //Obtain the Pronunciation Text TextView element
            TextView pronounciationText = CategoryFragment.fragmentLocalboxBinding.getRoot().findViewById(R.id.pronounciation_text);

            //Set the TextView element of the Pronunciation Text to the Pronunciation Text of the Sound
            pronounciationText.setText(mSound.getSoundPronounciation());
        }




        //Account for the length of the English Text. Adjust the font size of the English Text accordingly
        if(englishText.length() >= 5 && englishText.length() < 10){
            CategoryFragment.fragmentLocalboxBinding.englishText.setTextSize(40f);
        }
        else if (englishText.length() >= 10 && englishText.length() < 15){
            CategoryFragment.fragmentLocalboxBinding.englishText.setTextSize(27f);
        }
        else if(englishText.length() >= 15 && englishText.length() < 20){
            CategoryFragment.fragmentLocalboxBinding.englishText.setTextSize(25f);
        }
        else if(englishText.length() >= 20 && englishText.length() < 30){
            CategoryFragment.fragmentLocalboxBinding.englishText.setTextSize(20f);
        }
        else if(englishText.length() >= 30){
            CategoryFragment.fragmentLocalboxBinding.englishText.setTextSize(15f);
        }
        else{
            CategoryFragment.fragmentLocalboxBinding.englishText.setTextSize(50f);
        }


        //Account for the length of the Language Text. Adjust the font size of the Language Text accordingly
        if (languageText.length() >= 5 && languageText.length() < 10){
            CategoryFragment.fragmentLocalboxBinding.languageText.setTextSize(40f);
        }
        else if (languageText.length() >= 10 && languageText.length() < 15){
            CategoryFragment.fragmentLocalboxBinding.languageText.setTextSize(20f);
        }
        else if (languageText.length() >= 15){
            CategoryFragment.fragmentLocalboxBinding.languageText.setTextSize(15f);
        }
        else{
            CategoryFragment.fragmentLocalboxBinding.languageText.setTextSize(50f);
        }

    }




    public StateListDrawable makeSelector(){

        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.setExitFadeDuration(300);
        stateListDrawable.setAlpha(150);


        //TODO: MAKE METHODS OUT OF THE BELOW
        if (CategoryFragment.sLanguageChosen.equals("arabic")) {

            if (CategoryFragment.sCategoryChosen.equals("numerics")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_arabic_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_numerics));
            }

            if (CategoryFragment.sCategoryChosen.equals("statements")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_arabic_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_statements));
            }

            if (CategoryFragment.sCategoryChosen.equals("questions")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_arabic_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_questions));
            }

            if (CategoryFragment.sCategoryChosen.equals("adjectives")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_arabic_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_adjectives));
            }

            if (CategoryFragment.sCategoryChosen.equals("nouns")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_arabic_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_nouns));
            }
        }



        if (CategoryFragment.sLanguageChosen.equals("chinese")) {

            if (CategoryFragment.sCategoryChosen.equals("numerics")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_chinese_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_numerics));
            }

            if (CategoryFragment.sCategoryChosen.equals("statements")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_chinese_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_statements));
            }

            if (CategoryFragment.sCategoryChosen.equals("questions")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_chinese_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_questions));
            }

            if (CategoryFragment.sCategoryChosen.equals("adjectives")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_chinese_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_adjectives));
            }

            if (CategoryFragment.sCategoryChosen.equals("nouns")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_chinese_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_nouns));
            }
        }




        if (CategoryFragment.sLanguageChosen.equals("french")) {

            if (CategoryFragment.sCategoryChosen.equals("numerics")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_french_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_numerics));
            }

            if (CategoryFragment.sCategoryChosen.equals("statements")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_french_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_statements));
            }

            if (CategoryFragment.sCategoryChosen.equals("questions")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_french_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_questions));
            }

            if (CategoryFragment.sCategoryChosen.equals("adjectives")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_french_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_adjectives));
            }

            if (CategoryFragment.sCategoryChosen.equals("nouns")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_french_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_nouns));
            }
        }



        if (CategoryFragment.sLanguageChosen.equals("german")) {

            if (CategoryFragment.sCategoryChosen.equals("numerics")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_german_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_numerics));
            }

            if (CategoryFragment.sCategoryChosen.equals("statements")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_german_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_statements));
            }

            if (CategoryFragment.sCategoryChosen.equals("questions")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_german_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_questions));
            }

            if (CategoryFragment.sCategoryChosen.equals("adjectives")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_german_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_adjectives));
            }

            if (CategoryFragment.sCategoryChosen.equals("nouns")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_german_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_nouns));
            }
        }





        if (CategoryFragment.sLanguageChosen.equals("hindi")) {

            if (CategoryFragment.sCategoryChosen.equals("numerics")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_hindi_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_numerics));
            }

            if (CategoryFragment.sCategoryChosen.equals("statements")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_hindi_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_statements));
            }

            if (CategoryFragment.sCategoryChosen.equals("questions")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_hindi_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_questions));
            }

            if (CategoryFragment.sCategoryChosen.equals("adjectives")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_hindi_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_adjectives));
            }

            if (CategoryFragment.sCategoryChosen.equals("nouns")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_hindi_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_nouns));
            }
        }





        if (CategoryFragment.sLanguageChosen.equals("italian")) {

            if (CategoryFragment.sCategoryChosen.equals("numerics")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_italian_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_numerics));
            }

            if (CategoryFragment.sCategoryChosen.equals("statements")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_italian_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_statements));
            }

            if (CategoryFragment.sCategoryChosen.equals("questions")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_italian_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_questions));
            }

            if (CategoryFragment.sCategoryChosen.equals("adjectives")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_italian_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_adjectives));
            }

            if (CategoryFragment.sCategoryChosen.equals("nouns")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_italian_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_nouns));
            }
        }




        if (CategoryFragment.sLanguageChosen.equals("japanese")) {

            if (CategoryFragment.sCategoryChosen.equals("numerics")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_japanese_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_numerics));
            }

            if (CategoryFragment.sCategoryChosen.equals("statements")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_japanese_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_statements));
            }

            if (CategoryFragment.sCategoryChosen.equals("questions")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_japanese_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_questions));
            }

            if (CategoryFragment.sCategoryChosen.equals("adjectives")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_japanese_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_adjectives));
            }

            if (CategoryFragment.sCategoryChosen.equals("nouns")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_japanese_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_nouns));
            }
        }




        if (CategoryFragment.sLanguageChosen.equals("korean")) {

            if (CategoryFragment.sCategoryChosen.equals("numerics")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_korean_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_numerics));
            }

            if (CategoryFragment.sCategoryChosen.equals("statements")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_korean_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_statements));
            }

            if (CategoryFragment.sCategoryChosen.equals("questions")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_korean_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_questions));
            }

            if (CategoryFragment.sCategoryChosen.equals("adjectives")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_korean_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_adjectives));
            }

            if (CategoryFragment.sCategoryChosen.equals("nouns")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_korean_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_nouns));
            }
        }






        if (CategoryFragment.sLanguageChosen.equals("russian")) {

            if (CategoryFragment.sCategoryChosen.equals("numerics")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_russian_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_numerics));
            }

            if (CategoryFragment.sCategoryChosen.equals("statements")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_russian_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_statements));
            }

            if (CategoryFragment.sCategoryChosen.equals("questions")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_russian_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_questions));
            }

            if (CategoryFragment.sCategoryChosen.equals("adjectives")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_russian_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_adjectives));
            }

            if (CategoryFragment.sCategoryChosen.equals("nouns")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_russian_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_nouns));
            }
        }




        if (CategoryFragment.sLanguageChosen.equals("spanish")) {

            if (CategoryFragment.sCategoryChosen.equals("numerics")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_spanish_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_numerics));
            }

            if (CategoryFragment.sCategoryChosen.equals("statements")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_spanish_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_statements));
            }

            if (CategoryFragment.sCategoryChosen.equals("questions")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_spanish_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_questions));
            }

            if (CategoryFragment.sCategoryChosen.equals("adjectives")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_spanish_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_adjectives));
            }

            if (CategoryFragment.sCategoryChosen.equals("nouns")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_spanish_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_nouns));
            }
        }




        if (CategoryFragment.sLanguageChosen.equals("thai")) {

            if (CategoryFragment.sCategoryChosen.equals("numerics")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_thai_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_numerics));
            }

            if (CategoryFragment.sCategoryChosen.equals("statements")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_thai_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_statements));
            }

            if (CategoryFragment.sCategoryChosen.equals("questions")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_thai_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_questions));
            }

            if (CategoryFragment.sCategoryChosen.equals("adjectives")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_thai_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_adjectives));
            }

            if (CategoryFragment.sCategoryChosen.equals("nouns")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_thai_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_nouns));
            }
        }




        if (CategoryFragment.sLanguageChosen.equals("vietnamese")) {

            if (CategoryFragment.sCategoryChosen.equals("numerics")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_vietnamese_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_numerics));
            }

            if (CategoryFragment.sCategoryChosen.equals("statements")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_vietnamese_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_statements));
            }

            if (CategoryFragment.sCategoryChosen.equals("questions")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_vietnamese_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_questions));
            }

            if (CategoryFragment.sCategoryChosen.equals("adjectives")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_vietnamese_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_adjectives));
            }

            if (CategoryFragment.sCategoryChosen.equals("nouns")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_vietnamese_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_nouns));
            }
        }


        return stateListDrawable;
    }

}