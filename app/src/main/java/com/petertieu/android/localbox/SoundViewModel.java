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
        //2: Answers to the android:onClick attribute from the layout (VIEW) and call the playSound(Sound) method from the SoundManager class (MODEL)


//NOTE: Extends BaseObservable class so that we could get access to the method: notifyChange()
public class SoundViewModel extends BaseObservable{

    //============= Declare instance variables ==============================================

    private final String TAG = "SoundViewModel";


    private Sound mSound;
    private SoundManager mSoundManager;


    //============= Declare methods =========================================================



    //Build constructor
    public SoundViewModel(SoundManager soundManger, Context context){
        mSoundManager = soundManger;
        mContext = context;
    }


    //Set the Sound to the associated list item - called by SoundHolder.bind(Sound)
    public void setSound(Sound sound){

        mSound = sound;

        //FEEDBACK:
        // VIEW-MODEL (SoundViewModel) informs the LAYOUT (listItemSoundBinding) that
        // The Sound inside SoundHolder.bind(Sound) has been updated
        // OTHERWISE (without the code below (notifyChange()), the names of the grids will be random and all over the place!
        notifyChange();
    }







    //Get the name of the Sound - called by "android:text="@{SoundViewModel.getSoundName}" in list_item_sound.xml
    public String getSoundName() {



        return mSound.getSoundNameEnglish();

    }







    //Set what happens when the list item is clicked - called by "android:onClick="@{(view) -> SoundViewModel.onButtonClicked()}" in list_item_sound.xml
    public void onButtonClicked(){



        //Play the sound
        mSoundManager.playSound(mSound);


        //REMOVE the PRE-TAP View on screen, and ADD the CAPTIONS View (NOTE: Only one of the PRE-TAP View or CAPTIONS View could appear on screen at a time!)
        LinearLayout parentLinearLayout = (LinearLayout) CategoryFragment.fragmentLocalboxBinding.parentLinearLayout;
        LinearLayout preTapView = (LinearLayout) CategoryFragment.fragmentLocalboxBinding.preTapView;
        parentLinearLayout.removeView(preTapView);


        LinearLayout captionsLinearLayout = (LinearLayout) CategoryFragment.fragmentLocalboxBinding.postTapView;

        //If the CAPTIONS View does not exist, then add it to the layout
        if (CategoryFragment.fragmentLocalboxBinding.getRoot().findViewById(R.id.postTapView) == null) {
            parentLinearLayout.addView(captionsLinearLayout, parentLinearLayout.getChildCount() - 3);
        }







        TextView englishText = CategoryFragment.fragmentLocalboxBinding.getRoot().findViewById(R.id.english_text);
        englishText.setText(mSound.getSoundNameEnglish());




        TextView languageText = CategoryFragment.fragmentLocalboxBinding.getRoot().findViewById(R.id.language_text);
        languageText.setText(mSound.getSoundNameLanguage());



        if (mSound.getSoundPronounciation() != null) {
            TextView pronounciationText = CategoryFragment.fragmentLocalboxBinding.getRoot().findViewById(R.id.pronounciation_text);
            pronounciationText.setText(mSound.getSoundPronounciation());
        }



//        for (int i = 0; i<CategoryFragment.soundHolders.size()-1; i++){
//            if (mSound.equals(CategoryFragment.soundHolders.get(i))){
//                CategoryFragment.soundHolders.get(i).setTextToLanguage();
//            }
//        }




        //Account for the length of the English Text. Adjust the fond size of the English Text accordingly
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





    public Context mContext;




    public StateListDrawable makeSelector(){

        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.setExitFadeDuration(300);
        stateListDrawable.setAlpha(150);








        //TODO: MAKE METHODS OUT OF THE BELOW
        if (CategoryFragment.mLanguageChosen.equals("arabic")) {

            if (CategoryFragment.mCategoryChosen.equals("numerics")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_arabic_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_numerics));
            }

            if (CategoryFragment.mCategoryChosen.equals("statements")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_arabic_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_statements));
            }

            if (CategoryFragment.mCategoryChosen.equals("questions")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_arabic_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_questions));
            }

            if (CategoryFragment.mCategoryChosen.equals("adjectives")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_arabic_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_adjectives));
            }

            if (CategoryFragment.mCategoryChosen.equals("nouns")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_arabic_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_nouns));
            }
        }



        if (CategoryFragment.mLanguageChosen.equals("chinese")) {

            if (CategoryFragment.mCategoryChosen.equals("numerics")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_chinese_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_numerics));
            }

            if (CategoryFragment.mCategoryChosen.equals("statements")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_chinese_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_statements));
            }

            if (CategoryFragment.mCategoryChosen.equals("questions")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_chinese_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_questions));
            }

            if (CategoryFragment.mCategoryChosen.equals("adjectives")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_chinese_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_adjectives));
            }

            if (CategoryFragment.mCategoryChosen.equals("nouns")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_chinese_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_nouns));
            }
        }




        if (CategoryFragment.mLanguageChosen.equals("french")) {

            if (CategoryFragment.mCategoryChosen.equals("numerics")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_french_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_numerics));
            }

            if (CategoryFragment.mCategoryChosen.equals("statements")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_french_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_statements));
            }

            if (CategoryFragment.mCategoryChosen.equals("questions")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_french_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_questions));
            }

            if (CategoryFragment.mCategoryChosen.equals("adjectives")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_french_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_adjectives));
            }

            if (CategoryFragment.mCategoryChosen.equals("nouns")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_french_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_nouns));
            }
        }



        if (CategoryFragment.mLanguageChosen.equals("german")) {

            if (CategoryFragment.mCategoryChosen.equals("numerics")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_german_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_numerics));
            }

            if (CategoryFragment.mCategoryChosen.equals("statements")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_german_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_statements));
            }

            if (CategoryFragment.mCategoryChosen.equals("questions")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_german_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_questions));
            }

            if (CategoryFragment.mCategoryChosen.equals("adjectives")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_german_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_adjectives));
            }

            if (CategoryFragment.mCategoryChosen.equals("nouns")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_german_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_nouns));
            }
        }





        if (CategoryFragment.mLanguageChosen.equals("hindi")) {

            if (CategoryFragment.mCategoryChosen.equals("numerics")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_hindi_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_numerics));
            }

            if (CategoryFragment.mCategoryChosen.equals("statements")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_hindi_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_statements));
            }

            if (CategoryFragment.mCategoryChosen.equals("questions")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_hindi_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_questions));
            }

            if (CategoryFragment.mCategoryChosen.equals("adjectives")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_hindi_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_adjectives));
            }

            if (CategoryFragment.mCategoryChosen.equals("nouns")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_hindi_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_nouns));
            }
        }





        if (CategoryFragment.mLanguageChosen.equals("italian")) {

            if (CategoryFragment.mCategoryChosen.equals("numerics")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_italian_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_numerics));
            }

            if (CategoryFragment.mCategoryChosen.equals("statements")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_italian_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_statements));
            }

            if (CategoryFragment.mCategoryChosen.equals("questions")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_italian_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_questions));
            }

            if (CategoryFragment.mCategoryChosen.equals("adjectives")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_italian_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_adjectives));
            }

            if (CategoryFragment.mCategoryChosen.equals("nouns")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_italian_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_nouns));
            }
        }




        if (CategoryFragment.mLanguageChosen.equals("japanese")) {

            if (CategoryFragment.mCategoryChosen.equals("numerics")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_japanese_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_numerics));
            }

            if (CategoryFragment.mCategoryChosen.equals("statements")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_japanese_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_statements));
            }

            if (CategoryFragment.mCategoryChosen.equals("questions")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_japanese_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_questions));
            }

            if (CategoryFragment.mCategoryChosen.equals("adjectives")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_japanese_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_adjectives));
            }

            if (CategoryFragment.mCategoryChosen.equals("nouns")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_japanese_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_nouns));
            }
        }




        if (CategoryFragment.mLanguageChosen.equals("korean")) {

            if (CategoryFragment.mCategoryChosen.equals("numerics")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_korean_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_numerics));
            }

            if (CategoryFragment.mCategoryChosen.equals("statements")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_korean_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_statements));
            }

            if (CategoryFragment.mCategoryChosen.equals("questions")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_korean_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_questions));
            }

            if (CategoryFragment.mCategoryChosen.equals("adjectives")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_korean_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_adjectives));
            }

            if (CategoryFragment.mCategoryChosen.equals("nouns")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_korean_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_nouns));
            }
        }






        if (CategoryFragment.mLanguageChosen.equals("russian")) {

            if (CategoryFragment.mCategoryChosen.equals("numerics")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_russian_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_numerics));
            }

            if (CategoryFragment.mCategoryChosen.equals("statements")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_russian_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_statements));
            }

            if (CategoryFragment.mCategoryChosen.equals("questions")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_russian_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_questions));
            }

            if (CategoryFragment.mCategoryChosen.equals("adjectives")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_russian_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_adjectives));
            }

            if (CategoryFragment.mCategoryChosen.equals("nouns")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_russian_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_nouns));
            }
        }




        if (CategoryFragment.mLanguageChosen.equals("spanish")) {

            if (CategoryFragment.mCategoryChosen.equals("numerics")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_spanish_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_numerics));
            }

            if (CategoryFragment.mCategoryChosen.equals("statements")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_spanish_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_statements));
            }

            if (CategoryFragment.mCategoryChosen.equals("questions")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_spanish_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_questions));
            }

            if (CategoryFragment.mCategoryChosen.equals("adjectives")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_spanish_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_adjectives));
            }

            if (CategoryFragment.mCategoryChosen.equals("nouns")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_spanish_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_nouns));
            }
        }




        if (CategoryFragment.mLanguageChosen.equals("thai")) {

            if (CategoryFragment.mCategoryChosen.equals("numerics")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_thai_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_numerics));
            }

            if (CategoryFragment.mCategoryChosen.equals("statements")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_thai_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_statements));
            }

            if (CategoryFragment.mCategoryChosen.equals("questions")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_thai_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_questions));
            }

            if (CategoryFragment.mCategoryChosen.equals("adjectives")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_thai_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_adjectives));
            }

            if (CategoryFragment.mCategoryChosen.equals("nouns")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_thai_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_nouns));
            }
        }




        if (CategoryFragment.mLanguageChosen.equals("vietnamese")) {

            if (CategoryFragment.mCategoryChosen.equals("numerics")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_vietnamese_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_numerics));
            }

            if (CategoryFragment.mCategoryChosen.equals("statements")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_vietnamese_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_statements));
            }

            if (CategoryFragment.mCategoryChosen.equals("questions")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_vietnamese_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_questions));
            }

            if (CategoryFragment.mCategoryChosen.equals("adjectives")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_vietnamese_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_adjectives));
            }

            if (CategoryFragment.mCategoryChosen.equals("nouns")) {
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mContext.getResources().getDrawable(R.drawable.speech_bubble_vietnamese_flag));
                stateListDrawable.addState(new int[]{}, mContext.getResources().getDrawable(R.drawable.speech_bubble_nouns));
            }
        }














        return stateListDrawable;
    }







}


