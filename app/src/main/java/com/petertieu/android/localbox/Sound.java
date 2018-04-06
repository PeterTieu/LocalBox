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

    //Sound name - English translation
    private String mSoundNameEnglish;

    //Sound name - Native language translation
    private String mSoundNameLanguage;

    private String mSoundPronounciation;




    //============= Define methods ==========================================================

    //Build constructor - takes the filepath of the sound and obtains the name of the sound
    public Sound(String soundFilePath){

        //Stash the filepath of the sound to the instance variable
        mSoundFilePath = soundFilePath;

        //Obtain the components of the sound's filepath (e.g. "..app/java/assets/mi_nombre_es.mp3")
        String[] componentsOfSoundFilePath = soundFilePath.split("/");

        //Obtain the FILENAME of the sound (i.e. the last component of the sound filepath, e.g. "mi_nombre_es.mp3");
        String soundFilename = componentsOfSoundFilePath[componentsOfSoundFilePath.length - 1];

        //Remove the ".mp3" component from the Sound filename
        String soundFilenameWithoutFiletype = soundFilename.replace(".mp3", "");


        String[] componentsOfSoundFileName = soundFilenameWithoutFiletype.split("_");

        mSoundNameEnglish = componentsOfSoundFileName[1];

        mSoundNameLanguage = componentsOfSoundFileName[2];

        if (componentsOfSoundFileName[3] != null) {
            mSoundPronounciation = componentsOfSoundFileName[3];
        }



        Log.i(TAG, "Sound filename English: " + mSoundNameEnglish);
        Log.i(TAG, "Sound filename Language: " + mSoundNameLanguage);

        if (mSoundPronounciation != null) {
            Log.i(TAG, "Sound phonetics: " + mSoundPronounciation);
        }




        //Get the RAW name of the Sound. Remove the following components: ".mp3", numeric, and the underscore ("_") between the numeric and the name
        mSoundName = soundFilename.replace(".mp3", "").replaceAll("\\d", "").replace("_", "");





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

    //Get the name of the Sound
    public String getSoundName(){
        return mSoundName;
    }


//    //Get the title of the Sound
//    public String getTitle(){
//        return mSoundTitle;
//    }


    public String getSoundNameEnglish(){
        return mSoundNameEnglish;
    }


    public String getSoundNameLanguage(){
        return mSoundNameLanguage;
    }


    public String getSoundPronounciation(){
        return mSoundPronounciation;
    }










}
