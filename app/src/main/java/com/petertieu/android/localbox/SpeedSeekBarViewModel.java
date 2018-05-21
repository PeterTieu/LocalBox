package com.petertieu.android.localbox;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.widget.SeekBar;
import android.widget.TextView;


//SpeedSeekBarViewModel is a VIEW-MODEL
    //It links the VIEW (fragment_local_box.xml) with the MODEL (SoundManager).
    //Its function is to:
        //1: Send data from the MODEL (SoundManager) to the VIEW (fragment_local_box.xml)...
            // ...to display the RAW Speed value on the TextView
        //2: Send data from the VIEW (fragment_local_box.xml) to the MODEL (SoundManager)...
            // ...to set the RAW Speed to the MODEL so that it could regulate the Sound playback speed

//In the VIEW-MODEL layer of the project

//NOTE: SpeedSeekBarViewModel extends BaseObservable class so that we could get access to the method: notifyChange()
public class SpeedSeekBarViewModel extends BaseObservable{

    //============= Declare instance variables ==============================================

    //Model reference variable
    private SoundManager mSoundManager;

    //RAW Speed variables (in float form, e.g. 0.6f, 1.4f)
    private float mMinSpeedValue;
    private float mMaxSpeedValue;
    private float mRangeSpeedValue;

    //PERCENTAGE Speed variables (as a percentage of the SeekBar)
    private int mMinSpeedPercentage;
    private int mMaxSpeedPercentage;
    private int mRangeSpeedPercentage;
    private int mCurrentSpeedPercentage;





    //============= Declare methods =========================================================

    //==================== DATA-BINDING the layout (VIEW) to the SpeedkSeekerViewModel (VIEW-MODEL) ==========================================================================================

    //Build constructor - called by fragmentLocalboxBinding.setSpeedSeekBarViewModel(..) in CategoryFragment
    public SpeedSeekBarViewModel(SoundManager soundManager, SeekBar seekBar){

        //Assign the SoundManager instance reference variable to the local variable
        mSoundManager = soundManager;

        //Configure the RAW Speed variables
        mMinSpeedValue = SoundManager.MIN_PLAYBACK_SPEED; //Get the minimum RAW speed (0.6f)
        mMaxSpeedValue = SoundManager.MAX_PLAYBACK_SPEED; //Get the maixumum RAW speed (1.4f)
        mRangeSpeedValue = mMaxSpeedValue - mMinSpeedValue; //Get the range of the RAW speed (0.8f)

        //Configure the PERCENTAGE Speed variables
        mMinSpeedPercentage = 0; //Set the minimum PERCENTAGE speed to 0
        mMaxSpeedPercentage = seekBar.getMax(); //Get the maximum PERCENTAGE speed (100 (int))
        mRangeSpeedPercentage = mMaxSpeedPercentage - mMinSpeedPercentage; //Get the range of the PERCENTAGE speed (0 (int))
    }



    //==================== LINKING the layout (VIEW) to the SpeedSeekBarViewModel (VIEW-MODEL) =============================================================================================

    //Get the current RAW Speed - called by "android:text" of the TextView element of fragment_local_box.xml
    //In this case: MODEL (SoundManager) -> sends data (RAW Speed) to -> VIEW (fragment_local_box.xml)
    @Bindable
    public float getCurrentSpeedValue(){
        return mSoundManager.getCurrentSpeedValue();
    }



    //Get the current PERCENTAGE Speed - called by "android:progress" of the SeekBar element of fragment_local_box.xml
    //In this case: VIEW (fragment_local_box.xml) -> sends data (PERCENTAGE Speed) to -> MODEL (SoundManager)
    public int getCurrentSpeedPercentage(){

        //Get the current PERCENTAGE Speed
        mCurrentSpeedPercentage = Math.round( (mSoundManager.getCurrentSpeedValue() - mMinSpeedValue)/mRangeSpeedValue * mRangeSpeedPercentage + mMinSpeedPercentage);

        //Set the boundaries for th PERCENTAGE Speed
        if (mCurrentSpeedPercentage < mMinSpeedPercentage){
            return mMinSpeedPercentage;
        }
        else if (mCurrentSpeedPercentage > mMaxSpeedPercentage){
            return mMaxSpeedPercentage;
        }
        else {
            return mCurrentSpeedPercentage;
        }
    }



    //Set the PERCENTAGE Speed upon changes to the SeekBar - called by "android:onProgressChanged" of the SeekBar element of fragment_local_box.xml
    //In this case: VIEW (fragment_local_box.xml) -> sends data (PERCENTAGE Speed) to -> MODEL (SoundManager)
    public void setSpeedValue(SeekBar seekBar, int currentProgress, boolean fromUser){

        //Get the current RAW Speed
        float currentSpeedValue = ( (float)currentProgress - mMinSpeedPercentage)/mRangeSpeedPercentage * mRangeSpeedValue + mMinSpeedValue;

        //Set the current RAW Speed
        mSoundManager.setCurrentSpeedValue(currentSpeedValue);

        //FEEDBACK:
        // VIEW-MODEL (SpeedSeekBarViewModel) informs the VIEW (fragment_local_box.xml) that the RAW speed has been changed
        notifyChange();


        //============ Set the Speed Description of the current speed (e.g. "Normal Speed", "Very Fast Speed", etc.) ====================================================
        TextView speedDescription = CategoryFragment.fragmentLocalboxBinding.speedSeekBarText.getRootView().findViewById(R.id.speed_seek_bar_text);

        if (currentSpeedValue == SoundManager.MIN_PLAYBACK_SPEED){
            speedDescription.setText(R.string.slowest_speed);
        }
        else if (currentSpeedValue < 0.8 && currentSpeedValue > SoundManager.MIN_PLAYBACK_SPEED) {
            speedDescription.setText("Very Slow Speed");
        }
        else if (currentSpeedValue < 0.95 && currentSpeedValue > 0.8) {
            speedDescription.setText(R.string.slow_speed);
        }
        else if (currentSpeedValue >= 0.95 && currentSpeedValue <= 1.05){
            speedDescription.setText(R.string.normal_speed);
        }
        else if (currentSpeedValue > 1.05 && currentSpeedValue < 1.2){
            speedDescription.setText(R.string.fast_speed);
        }
        else if (currentSpeedValue > 1.2 && currentSpeedValue < SoundManager.MAX_PLAYBACK_SPEED){
            speedDescription.setText("Very Fast Speed");
        }
        else if (currentSpeedValue == SoundManager.MAX_PLAYBACK_SPEED){
            speedDescription.setText(R.string.fastest_speed);
        }
    }

}
