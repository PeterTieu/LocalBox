package com.petertieu.android.localbox;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.annotation.LayoutRes;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;


//ABSTRACT class that is to be subclassed by other activities

//In CONTROLLER layer of the project

public abstract class OneFragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Set the activity content to an explicit view
        //NOTE: getLayoutResId is to be overriden in the subclass to return reference resource files based on the configuration qualifier
        setContentView(getLayoutResourceId());

        //Return the FragmentManager for interacting with fragments associated with this activity
        FragmentManager fragmentManager = getSupportFragmentManager();

        //Find a fragment that was identified by the given ID
        Fragment fragment = fragmentManager.findFragmentById(R.id.fragment_container);

        //If the fragment doesn't exist yet
        if (fragment == null){
            //Create a fragment
            fragment = createFragment();
            //Start a series of edit operations on the Fragments associated with this FragmentManager
            fragmentManager.beginTransaction().add(R.id.fragment_container, fragment).commit();
        }
    }


    //To be overriden in the subclass activity class - to return reference resource files
    @LayoutRes
    protected abstract int getLayoutResourceId();


    //Declare the abstract method that is to be overriden in the subclass activity class
    protected abstract Fragment createFragment();

}
