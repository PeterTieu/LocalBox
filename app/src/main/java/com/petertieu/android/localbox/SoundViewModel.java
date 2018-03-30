package com.petertieu.android.localbox;

import android.content.Context;
import android.content.res.Resources;
import android.databinding.BaseObservable;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.StateListDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
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
    public SoundViewModel(SoundManager soundManger){
        mSoundManager = soundManger;
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


        
        TextView englishText = CategoryFragment.fragmentLocalboxBinding.getRoot().findViewById(R.id.english_text);
        englishText.setText(mSound.getSoundNameEnglish());




        TextView languageText = CategoryFragment.fragmentLocalboxBinding.getRoot().findViewById(R.id.language_text);
        languageText.setText(mSound.getSoundNameLanguage());


        TextView pronounciationText = CategoryFragment.fragmentLocalboxBinding.getRoot().findViewById(R.id.pronounciation_text);
        pronounciationText.setText(mSound.getSoundPronounciation());



//        for (int i = 0; i<CategoryFragment.soundHolders.size()-1; i++){
//            if (mSound.equals(CategoryFragment.soundHolders.get(i))){
//                CategoryFragment.soundHolders.get(i).setTextToLanguage();
//            }
//        }


    }







    public StateListDrawable makeSelector(){
        StateListDrawable res = new StateListDrawable();
        res.setExitFadeDuration(300);
        res.setAlpha(100);

        if (CategoryFragment.mLanguageChosen.equals("chinese") && CategoryFragment.mCategoryChosen.equals("numerics")) {
            res.addState(new int[]{android.R.attr.state_pressed}, new ColorDrawable(Color.RED));
            res.addState(new int[]{}, new ColorDrawable(Color.YELLOW));
        }
        if (CategoryFragment.mLanguageChosen.equals("thai") && CategoryFragment.mCategoryChosen.equals("numerics")) {
            res.addState(new int[]{android.R.attr.state_pressed}, new ColorDrawable(Color.BLUE));
            res.addState(new int[]{}, new ColorDrawable(Color.RED));
        }


        return res;
    }

}


