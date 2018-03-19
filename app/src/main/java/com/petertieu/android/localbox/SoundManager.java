package com.petertieu.android.localbox;


//SoundManager loads all the Sound ASSET files into the calling category fragment class
    //i.e. NumbericsCategoryFragment, StatementsCategoryFragment, QuestionsCategoryFragment, AdjectivesCategoryFragment, NoundsCategoryFragment

//In MODEL layer of the project

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SoundManager {

    //============= Declare instance variables ==============================================
    //Log to Logcat
    private final String TAG = "SoundManager";

    //AssetManager for accessing assets
    AssetManager mAssetManager;

    //Maximum number of sounds that could be played at a time
    private int MAX_SOUNDS_PLAYED_TOGETHER = 5;

    //Parent directory name of the folder where the Sound asset files are saved in
    private final String SOUNDS_FOLDER_NAME = "all_sounds";

    //List of all sounds within the parent directory
    List mSounds = new ArrayList<Sound>();

    //SoundPool for playing the Sound asset files
    SoundPool mSoundPool;




    //============= Define methods ==========================================================

    //Build constructor
    public SoundManager(Context context){
        mAssetManager = context.getAssets();

        //Create a SoundPool object, defining: max number of sounds played together, audio stream type, and the sample-rate converter quality (default 0)
        mSoundPool = new SoundPool(MAX_SOUNDS_PLAYED_TOGETHER, AudioManager.STREAM_MUSIC, 0);

        //Load all the sounds to the SoundPool
        loadSounds();
    }




    //Helper method - loads all the sounds to the SoundPool
    private void loadSounds(){

        //String array to store sound names
        String[] soundNames;

        //Try a 'risky' task - mAssetManager.list(String) could throw an IOException if no asset files are found in the directory
        try{
            //Get the filenames of all the Sound asset files in the parent directory (e.g. "hello", "yes")
            soundNames = mAssetManager.list(SOUNDS_FOLDER_NAME);
        }
        catch(IOException ioException){

            //Log to Logcat
            Log.e(TAG, "Unable to list the assets", ioException);

            return;
        }

        //Cycle through all the Sound asset filenames in the directory folder
        for (String fileName : soundNames){

            //Try risky task - load(Sound) could throw an IOException
            try{

                //Get the filepath of the asset
                String filePath = SOUNDS_FOLDER_NAME + "/" + fileName;

                //Get the sound name from the filepath
                Sound sound = new Sound(filePath);

                //Load the Sound
                load(sound);

                //Add the sound to the Sound ArrayList
                mSounds.add(sound);
            }

            catch(IOException ioException){

                //Log to Logcat
                Log.e(TAG, "Unable to load any Sounds" + fileName, ioException);
            }
        }
    }




    //Helper method - sets the soundId of the
    private void load(Sound sound) throws IOException{

        //Create AssetFileDescriptor to be fed into SoundPool.load(..). An AssetFileDescriptor represents an open file to be read
        AssetFileDescriptor assetFileDescriptor = mAssetManager.openFd(sound.getSoundFilePath());

        //Load the Sound into the SoundPool, and get the Sound ID
        int soundId = mSoundPool.load(assetFileDescriptor, 1);

        //Set the Sound ID to the Sound
        sound.setSoundId(soundId);

    }

}

