package com.petertieu.android.localbox;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.widget.SeekBar;
import android.widget.TextView;

public class SpeedSeekBarViewModel extends BaseObservable{

    private SoundManager mSoundManager;




    private float mMinSpeedValue;
    private float mMaxSpeedValue;
    private float mRangeSpeedValue;




    private int mMinSpeedPercentage;
    private int mMaxSpeedPercentage;
    private int mRangeSpeedPercentage;
    private int mCurrentSpeedPercentage;



    public SpeedSeekBarViewModel(SoundManager soundManager, SeekBar seekBar){

        mSoundManager = soundManager;

        mMinSpeedPercentage = 0;
        mMaxSpeedPercentage = seekBar.getMax(); //returns: 100 (int)
        mRangeSpeedPercentage = mMaxSpeedPercentage - mMinSpeedPercentage;

        mMinSpeedValue = SoundManager.MIN_PLAYBACK_SPEED;
        mMaxSpeedValue = SoundManager.MAX_PLAYBACK_SPEED;
        mRangeSpeedValue = mMaxSpeedValue - mMinSpeedValue;

    }




    @Bindable
    public float getCurrentSpeedValue(){
        return mSoundManager.getCurrentSpeedValue();
    }





    public int getCurrentSpeedPercentage(){
        mCurrentSpeedPercentage = Math.round( (mSoundManager.getCurrentSpeedValue() - mMinSpeedValue)/mRangeSpeedValue * mRangeSpeedPercentage + mMinSpeedPercentage);


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




    public void setSpeedValue(SeekBar seekBar, int currentProgress, boolean fromUser){

        float currentSpeedValue = ( (float)currentProgress - mMinSpeedPercentage)/mRangeSpeedPercentage * mRangeSpeedValue + mMinSpeedValue;

        mSoundManager.setCurrentSpeedValue(currentSpeedValue);


        notifyChange();



//        TextView speedDescription = CategoryFragment.fragmentLocalboxBinding.speedSeekBarText.getRootView().findViewById(R.id.speed_seek_bar_text);
//        speedDescription.setText("Normal speed");



    }








}
