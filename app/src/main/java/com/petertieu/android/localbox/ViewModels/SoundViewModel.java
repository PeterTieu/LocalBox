package com.petertieu.android.localbox.ViewModels;

import android.content.Context;
import android.databinding.BaseObservable;
import android.graphics.drawable.StateListDrawable;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.petertieu.android.localbox.ActivitiesAndFragments.CategoryFragment;
import com.petertieu.android.localbox.Models.Sound;
import com.petertieu.android.localbox.Models.SoundManager;
import com.petertieu.android.localbox.R;


//SoundViewModel is a VIEW-MODEL
    //It links the VIEW (list_item_sound.xml) with the MODEL (Sound, SoundManager).
    //Its function is to:
        //1: Set what happens when a list item (i.e. Sound) is clicked on...
            //REGARDING the playing of the Sound ...AND... the parentLinearLayout of list_item_sound.xml
        //2: Set what happens when a list item (i.e. Sound) is clicked on...
            //REGARDING the list item itself

//In the VIEW-MODEL layer of the project

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

    //==================== DATA-BINDING the layout (VIEW) to the SoundViewModel (VIEW-MODEL) =============================================================================================

    //Build constructor - called by mListItemSoundBinding.setSoundViewModel(..) in CategoryFragment
    public SoundViewModel(SoundManager soundManger, Context context){

        //Assign the SoundManager instance reference variable to the local variable
        mSoundManager = soundManger;

        //Assign the Context instance variable to the local variable
        mContext = context;
    }



    //Set the Sound to the associated list item - called by SoundHolder.bind(Sound) in CategoryFragment
    public void setSound(Sound sound){

        //Get the Sound
        mSound = sound;

        //FEEDBACK:
        // VIEW-MODEL (SoundViewModel) informs the LAYOUT (listItemSoundBinding) that
        // The Sound inside SoundHolder.bind(Sound) has been updated
        // OTHERWISE (without the code below (notifyChange()), the names of the grids will be random and all over the place!
        notifyChange();
    }





    //==================== LINKING the layout (VIEW) to the SoundViewModel (VIEW-MODEL) =============================================================================================

    //Get the name of the Sound in English - called by "android:text="@{SoundViewModel.getSoundName}" in list_item_sound.xml
    public String getSoundName() {

        //Get the name of the Soud in English
        return mSound.getSoundNameEnglish();

    }




    //1: Set what happens when a list item (i.e. Sound) is clicked on...
    // ...REGARDING the playing of the Sound ...AND... the parentLinearLayout of list_item_sound.xml
    // called by "android:onClick="@{(view) -> SoundViewModel.onButtonClicked()}" in list_item_sound.xml
    public void onButtonClicked(){

        //Play the sound
            //In this case: VIEW (list_item_sound.xml) -> sends data to (asks to play Sound) to -> MODEL (SoundManager)
        mSoundManager.playSound(mSound);



        //======= REMOVE the PRE-TAP View on screen (NOTE: Only either one of the PRE-TAP View ...OR... POST-TAP View could appear on screen at a time!) ================

        //Obtain the linear layout of the "parent" element, which contains the preTapView and the postTapView
        LinearLayout parentLinearLayout = (LinearLayout) CategoryFragment.fragmentLocalboxBinding.parentLinearLayout;

        //Obtain the preTapView layout - a layout that shows a text "Tap the Speech Bubbles" and a picture next to it
        LinearLayout preTapView = (LinearLayout) CategoryFragment.fragmentLocalboxBinding.preTapView;

        //Remove the preTapView layout
        parentLinearLayout.removeView(preTapView);




        //======= ADD the POST-TAP View on screen (NOTE: Only either one of the PRE-TAP View ...OR... POST-TAP View could appear on screen at a time!) ================

        //Obtain the postTapView LinearLayout element - a layout that shows the English Text, Language Text and Pronunciation Text
        LinearLayout postTapView = (LinearLayout) CategoryFragment.fragmentLocalboxBinding.postTapView;

        //If the POST-TAP View does NOT exist, then add it to the layout
        if (CategoryFragment.fragmentLocalboxBinding.getRoot().findViewById(R.id.postTapView) == null) {
            //Add the English Text to the parentLinearLayout View
            parentLinearLayout.addView(postTapView, parentLinearLayout.getChildCount() - 3);
        }


        //Obtain the English Text TextView element
        TextView englishText = CategoryFragment.fragmentLocalboxBinding.getRoot().findViewById(R.id.english_text);
        //Set the name of the Sound in English to the View
        englishText.setText(mSound.getSoundNameEnglish());


        //Obtain the languageText TextView element
        TextView languageText = CategoryFragment.fragmentLocalboxBinding.getRoot().findViewById(R.id.language_text);
        //Set the name of the Sound in the Language to the View
        languageText.setText(mSound.getSoundNameLanguage());


        //If the Pronunciation Text of the Sound EXISTS
        // NOTE: This check is necessary, as the Pronunciation Text does NOT exist for languages these languages: German, Spanish, Vietnamese etc.
        if (!mSound.getSoundPronounciation().equals(" ")) {

            //Obtain the Pronunciation Text TextView element
            TextView pronounciationText = CategoryFragment.fragmentLocalboxBinding.getRoot().findViewById(R.id.pronounciation_text);
            //Set the Pronunciation of the Language to the View
            pronounciationText.setText(mSound.getSoundPronounciation());
        }



        //======= CONFIGURE the size of the English Text and Language Text ================

        //Account for the length of the English Text. Adjust the font size of the English Text accordingly
        if(englishText.length() >= 5 && englishText.length() < 10){
            CategoryFragment.fragmentLocalboxBinding.englishText.setTextSize(35f);
        }
        else if (englishText.length() >= 10 && englishText.length() < 15){
            CategoryFragment.fragmentLocalboxBinding.englishText.setTextSize(27f);
        }
        else if(englishText.length() >= 15 && englishText.length() < 20){
            CategoryFragment.fragmentLocalboxBinding.englishText.setTextSize(25f);
        }
        else if (englishText.length() >= 20 && englishText.length() < 30 && CategoryFragment.sLanguageChosen.equals("russian") || CategoryFragment.sLanguageChosen.equals("vietnamese")){
            CategoryFragment.fragmentLocalboxBinding.englishText.setTextSize(12f);
        }
        else if(englishText.length() >= 20 && englishText.length() < 30){
            CategoryFragment.fragmentLocalboxBinding.englishText.setTextSize(18f);
        }
        else if (englishText.length() >= 30 && englishText.length() < 35 && CategoryFragment.sLanguageChosen.equals("russian") || CategoryFragment.sLanguageChosen.equals("vietnamese")){
            CategoryFragment.fragmentLocalboxBinding.englishText.setTextSize(12f);
        }
        else if(englishText.length() >= 30 && englishText.length() < 35){
            CategoryFragment.fragmentLocalboxBinding.englishText.setTextSize(16f);
        }
        else if (englishText.length() >= 35 && englishText.length() <45 && CategoryFragment.sLanguageChosen.equals("russian") || CategoryFragment.sLanguageChosen.equals("vietnamese")){
            CategoryFragment.fragmentLocalboxBinding.englishText.setTextSize(10f);
        }
        else if(englishText.length() >= 35 && englishText.length() < 45){
            CategoryFragment.fragmentLocalboxBinding.englishText.setTextSize(14f);
        }
        else if (englishText.length() >= 45 && CategoryFragment.sLanguageChosen.equals("russian") || CategoryFragment.sLanguageChosen.equals("vietnamese")){
            CategoryFragment.fragmentLocalboxBinding.englishText.setTextSize(8f);
        }
        else if (englishText.length() >= 45){
            CategoryFragment.fragmentLocalboxBinding.englishText.setTextSize(14f);
        }
        else{
            CategoryFragment.fragmentLocalboxBinding.englishText.setTextSize(50f);
        }


        //Account for the length of the Language Text. Adjust the font size of the Language Text accordingly
        if (languageText.length() >= 5 && languageText.length() < 10){
            CategoryFragment.fragmentLocalboxBinding.languageText.setTextSize(35f);
        }
        else if (languageText.length() >= 10 && languageText.length() < 15){
            CategoryFragment.fragmentLocalboxBinding.languageText.setTextSize(20f);
        }
        else if (languageText.length() >= 15){
            CategoryFragment.fragmentLocalboxBinding.languageText.setTextSize(20f);
        }
        else{
            CategoryFragment.fragmentLocalboxBinding.languageText.setTextSize(50f);
        }

    }





    //2: Set what happens when a list item (i.e. Sound) is clicked on...
    // ...REGARDING the list item
    // called by android:background="@{SoundViewModel.makeSelector()}"in list_item_sound.xml
    public StateListDrawable makeSelector(){

        //Create StateListDrawable object
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.setExitFadeDuration(300); //Set duration of the fade of the UNPRESSED state (aka the duration of appearance of the PRESSED state)
        stateListDrawable.setAlpha(150); //Set the transparancy (out of 255) of the PRESSED state


        //Create State-List Drawable for: ARABIC
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


        //Create State-List Drawable for: CHINESE
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


        //Create State-List Drawable for: FRENCH
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


        //Create State-List Drawable for: GERMAN
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


        //Create State-List Drawable for: HINDI
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


        //Create State-List Drawable for: ITALIAN
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


        //Create State-List Drawable for: JAPANESE
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


        //Create State-List Drawable for: KOREAN
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


        //Create State-List Drawable for: RUSSIAN
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


        //Create State-List Drawable for: SPANISH
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


        //Create State-List Drawable for: THAI
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


        //Create State-List Drawable for: VIETNAMESE
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


        //Return the StateListDrawable object
        return stateListDrawable;
    }

}