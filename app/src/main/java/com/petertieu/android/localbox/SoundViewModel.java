package com.petertieu.android.localbox;

import android.databinding.BaseObservable;


//SoundViewModel is the VIEW-MODEL of the project.
    //It links the VIEW (list_item_sound.xml) with the MODEL (Sound, SoundManager).
    //Its function is to:
        //1: Get the title of the Sound asset from the Sound class (MODEL) and DISPLAY it onto the layout (VIEW)
        //2: Answers to the android:onClick attribute from the layout (VIEW) and call the playSound(Sound) method from the SoundManager class (MODEL)


//NOTE: Extends BaseObservable class so that we could get access to the method: notifyChange()
public class SoundViewModel extends BaseObservable{

    //============= Declare instance variables ==============================================
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
    public String getSoundName(){
        return mSound.getSoundName();
    }


    //Set what happens when the list item is clicked - called by "android:onClick="@{(view) -> SoundViewModel.onButtonClicked()}" in list_item_sound.xml
    public void onButtonClicked(){
        //Play the sound
        mSoundManager.playSound(mSound);
    }

}


