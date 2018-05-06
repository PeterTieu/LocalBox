package com.petertieu.android.localbox;


//Sound obtains the FILENAME of a single Sound asset file, and gets/sets its ID
    //NOTE: Each Sound originates from an ASSET file

//In MODEL layer of the project

import android.media.MediaMetadataRetriever;
import android.util.Log;

import java.io.IOException;

public class Sound {

    //============= Declare instance variables ==============================================

    private final String TAG = "Sound";

    //The filepath of the Sound asset file
    private String mSoundFilePath;

    //ID of the of the Sound asset file - of type Integer, as it does not carry a primative value
    private Integer mSoundId;

    //Name of the Sound asset file (i.e. after the directory components have been stripped)
    private String mSoundName;

    //Sound name - English translation (e.g. "How are you？")
    private String mSoundNameEnglish;

    //Sound name - Language translation (e.g. "好吗？")
    private String mSoundNameLanguage;

    //Sound name - Native language Pronunciation (e.g. "Nǐ hǎo ma？")
    private String mSoundPronounciation;




    //============= Define methods ==========================================================

    //Build constructor - takes the filepath of the sound and obtains the name of the sound
    public Sound(String soundFilePath){

        //Stash the filepath of the sound to the instance variable
        mSoundFilePath = soundFilePath;

        //Obtain the components of the sound's filepath (e.g. "..app/java/assets/01_How are you？_好吗？_Nǐ hǎo ma？.mp3")
        String[] componentsOfSoundFilePath = soundFilePath.split("/");

        //Obtain the FILENAME of the sound (i.e. the last component of the sound filepath (e.g. "01_How are you？_好吗？_Nǐ hǎo ma？.mp3");
        String soundFilename = componentsOfSoundFilePath[componentsOfSoundFilePath.length - 1];

        //Remove the ".mp3" component from the Sound filename (e.g. "01_How are you？_好吗？_Nǐ hǎo ma？")
        String soundFilenameWithoutFiletype = soundFilename.replace(".mp3", "");

        //Split the components of the Sound filename by "_" and place them in the componentsOfSoundFilename String
        String[] componentsOfSoundFileName = soundFilenameWithoutFiletype.split("_");


        //Obtain English translation of the Sound (e.g. "How are you?")
        mSoundNameEnglish = componentsOfSoundFileName[1];

        //Obtain Language translation of the Sound (e.g. "好吗？")
        mSoundNameLanguage = componentsOfSoundFileName[2];

        //Check if the Language Pronunciation of the Sound (e.g. "Nǐ hǎo ma？") exists. Some languages need them (e.g. Chinese, Thai), whereas others don't (e.g. Italian, French)
        if (componentsOfSoundFileName[3] != null) {
            //Obtain language pronounciation of the Sound (e.g. "Nǐ hǎo ma？")
            mSoundPronounciation = componentsOfSoundFileName[3];
        }


        //Log the English and language translations
        Log.i(TAG, "Sound filename English: " + mSoundNameEnglish);
        Log.i(TAG, "Sound filename Language: " + mSoundNameLanguage);

        //Log the Language Pronounciations if it exists
        if (mSoundPronounciation != null) {
            Log.i(TAG, "Sound phonetics: " + mSoundPronounciation);
        }

    }




    //Get filepath of the Sound
    public String getSoundFilePath(){
        return mSoundFilePath;
    }




    //Get the ID of the Sound
    public Integer getSoundId(){
        return mSoundId;
    }




    //Set the ID of the Sound
    public void setSoundId(Integer soundId){
        mSoundId = soundId;
    }




    //Get the English translation of the Sound
    public String getSoundNameEnglish(){
        return mSoundNameEnglish;
    }




    //Get the Language translation of the Sound
    public String getSoundNameLanguage(){
        return mSoundNameLanguage;
    }




    //Get the pronounciation of the Sound
    public String getSoundPronounciation(){
        return mSoundPronounciation;
    }

}
