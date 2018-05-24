package com.petertieu.android.localbox.ActivitiesAndFragments;

import android.support.v4.app.Fragment;

import com.petertieu.android.localbox.R;


//Activity hosting LanguageChooserFragment

//In CONTROLLER layer of the project

public class LanguageChooserActivity extends OneFragmentActivity{

    //============= Define methods ==========================================================
    //Get resource ID of the layout
    @Override
    protected int getLayoutResourceId(){
        return R.layout.activity_masterfragment;
    }

    //Create the fragment for the activity
    @Override
    protected Fragment createFragment(){
        return new LanguageChooserFragment();
    }

}
