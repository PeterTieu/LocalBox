package com.petertieu.android.localbox;


//SoundManager manages ALL the Sounds in the assets resource folder. It functions to:
    //1: Load all the Sound ASSET files into the SoundPool
    //2: FETCH and RELEASE Sounds to/from the RecyclerView
    //3: PLAY a Sound from the SoundPool

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
    public static String SOUNDS_FOLDER_NAME = "all_sounds/thai/numerics";

    //List of all sounds within the parent directory
    List mSounds = new ArrayList<Sound>();

    //SoundPool for playing the Sound asset files
    SoundPool mSoundPool;





    //SpeedSeekBar variables
    public static final float MIN_PLAYBACK_SPEED = 0.7f;
    public static final float MAX_PLAYBACK_SPEED = 1.4f;

    private float mCurrentSpeedValue = 1;





    //============= Define methods ==========================================================


    //======== 1: LOAD Sounds to the SoundPool ================================

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





    //======== 2: FETCH and RELEASE Sounds to/from the RecyclerView ================================

    //Get Sound ArrayList - called by the Adapter in the RecyclerView (i.e. SoundAdapter in CategoryFragment.java)
    public List<Sound> getSounds(){
        return mSounds;
    }



    //Release all the Sounds from the SoundPool class  - called by CategoryFragment.onDestroy()
    public void releaseSounds(){
        mSoundPool.release();
    }





    //======== 3: PLAY a Sound from the SoundPool ================================

    //Play the Sound - triggered by android:onClick by the VIEW (list_itemSound.xml),
    // which is then called by the VIEW-MODEL (SoundViewModel) when the list-item is pressed
    public void playSound(Sound sound){

        //Get the Sound ID
        Integer soundId = sound.getSoundId();

        //If the Sound ID does NOT exist
        if (soundId == null){
            return;
        }

        //Play the Sound, based on the Sound ID.
        // Let the right and left volumes be 100%, set priority to 1, loop 0 times, and have the rate at normal (1)
        mSoundPool.play(soundId, 1.0f, 1.0f, 1, 0, mCurrentSpeedValue);
    }








    //================================================== Speed SeekBar ===========================================================================


    //======== 4: GET current Playback Speed of the Sound ================================
    public float getCurrentSpeedValue(){
        return mCurrentSpeedValue;
    }




    //======== 4: SET current Playback Speed of the Sound ================================
    public void setCurrentSpeedValue(float currentSpeedValue){

        if (currentSpeedValue > MAX_PLAYBACK_SPEED){
            mCurrentSpeedValue = MAX_PLAYBACK_SPEED;
        }
        else if (currentSpeedValue < MIN_PLAYBACK_SPEED){
            mCurrentSpeedValue = MIN_PLAYBACK_SPEED;
        }
        else{
            mCurrentSpeedValue = currentSpeedValue;
        }
    }





}

