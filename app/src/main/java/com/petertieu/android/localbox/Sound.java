package com.petertieu.android.localbox;


//Sound obtains the FILENAME of a single Sound asset file, and gets/sets its ID
    //NOTE: Each Sound originates from an ASSET file

//In MODEL layer of the project

public class Sound {

    //============= Declare instance variables ==============================================
    //The filepath of the Sound asset file
    private String mSoundFilePath;

    //Name of the Sound asset file (i.e. after the directory components have been stripped)
    private String mSoundName;

    //ID of the of the Sound asset file - of type Integer, as it does not carry a primative value
    private Integer mSoundId;



    //============= Define methods ==========================================================

    //Build constructor - takes the filepath of the sound and obtains the name of the sound
    public Sound(String soundFilePath){

        //Stash the filepath of the sound to the instance variable
        mSoundFilePath = soundFilePath;

        //Obtain the components of the sound's filepath (e.g. "..app/java/assets/mi_nombre_es.mp3")
        String[] componentsOfSoundFilePath = soundFilePath.split("/");

        //Obtain the FILENAME of the sound (i.e. the last component of the sound filepath, e.g. "mi_nombre_es.mp3");
        String soundFilename = componentsOfSoundFilePath[componentsOfSoundFilePath.length - 1];

        //Get the RAW name of the Sound. Replace the ".mp3" part of the Sound's name to a blank.
        mSoundName = soundFilename.replace(".mp3", "");
    }



    //Get filepath of the Sound
    public String getSoundFilePath(){
        return mSoundFilePath;
    }



    //Get the name of the Sound
    public String getSoundName(){
        return mSoundName;
    }



    //Get the ID of the Sound
    public Integer getSoundId(){
        return mSoundId;
    }



    //Set the ID of the Sound
    public void setSoundId(Integer soundId){
        mSoundId = soundId;
    }
}
