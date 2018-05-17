package com.petertieu.android.localbox;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import java.util.List;
import static android.content.res.Configuration.ORIENTATION_PORTRAIT;

import com.petertieu.android.localbox.databinding.FragmentLocalBoxBinding;
import com.petertieu.android.localbox.databinding.ListItemSoundBinding;
import com.petertieu.android.localbox.dialogfragment.CategoryInfoDialogFragment;


///Fragment containing the Sounds of the Category of a Language - that is, the furthest fragment reachable in the app

//In CONTROLLER layer of the project

public class CategoryFragment extends Fragment {

    //============= Declare instance variables ==============================================

    //Tag for Logcat
    private final String TAG = "CategoryFragment";

    //Language and Category chosen
    public static String sLanguageChosen;
    public static String sCategoryChosen;

    //SoundManager
    private SoundManager mSoundManager;

    //Data-binding reference variable for fragment_local_box.xml
    public static FragmentLocalBoxBinding fragmentLocalboxBinding;

    //Identifier for "Category Information" DialogFragment
    private static final String IDENTIFIER_DIALOG_FRAGMENT_CATEGORY_INFO = "DialogFragmentCategoryInfo";





    //============= Declare methods =========================================================

    //Override onCreate(..) fragment lifecycle callback method
    @Override
    public void onCreate(Bundle onSaveInstanceState){
        super.onCreate(onSaveInstanceState);

        //Log to Logcat
        Log.i(TAG, "onCreate(..) called");


        //If the arguments passed from CategoryActivity exist
        if (getArguments() != null){

            //Obtain the Language chosen
            sLanguageChosen = getArguments().getString(CategoryActivity.KEY_LANGUAGE_CHOSEN);

            //Obtain the Category chosen
            sCategoryChosen = getArguments().getString(CategoryActivity.KEY_CATEGORY_CHOSEN);

            //Log to Logcat
            Log.i(TAG, "Language chosen: " + sLanguageChosen + "... " + "Category chosen: " + sCategoryChosen);
        }


        //Open the Sound folder that contains the asset files based on: Language chosen AND Category chosen
        openRelevantSoundFolder(sLanguageChosen);


        //Instantiate SoundManager object
        mSoundManager = new SoundManager(getActivity());


        //Report that this fragment would like to participate in populating menus
        setHasOptionsMenu(true);


        //Set the Fragment to not be destroyed upon configuration changes (e.g. when screen rotates, onDestroy() fragment lifecycle callback method is not called)
        setRetainInstance(true);
    }




    //Helper method - Open the Sound folder that contains the asset files based on: Language chosen AND Category chosen
    private void openRelevantSoundFolder(String languageChosen) {

        //'Scan' for the Category chosen, and open the appropriate Sound folder to reveal Sound asset files of the chosen Category of the chosen Language
        switch (sCategoryChosen) {

            case ("numerics"):
                SoundManager.SOUNDS_FOLDER_NAME = "all_sounds/" + languageChosen + "/numerics";
                break;

            case ("statements"):
                SoundManager.SOUNDS_FOLDER_NAME = "all_sounds/" + languageChosen + "/statements";
                break;

            case ("questions"):
                SoundManager.SOUNDS_FOLDER_NAME = "all_sounds/" + languageChosen + "/questions";
                break;


            case ("adjectives"):
                SoundManager.SOUNDS_FOLDER_NAME = "all_sounds/" + languageChosen + "/adjectives";
                break;

            case ("nouns"):
                SoundManager.SOUNDS_FOLDER_NAME = "all_sounds/" + languageChosen + "/nouns";
                break;

            default:
                SoundManager.SOUNDS_FOLDER_NAME = "";
                break;
        }
    }




    //Override onCreateView(..) fragment lifecycle callback method
    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle savedIstanceState){

        //Create the data-binding object, FragmentLocalBoxBinding object, from the fragment_local_box.xml resource file
        fragmentLocalboxBinding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_local_box, viewGroup, false);


        //REMOVE the CAPTIONS View so that ONLY the PRE-TAP View appear on the screen (NOTE: Only either the PRE-TAP View or CAPTIONS View could appear on the screen at a time!)
        LinearLayout parentLinearLayout = (LinearLayout) fragmentLocalboxBinding.parentLinearLayout;
        LinearLayout captionsLinearLayout = (LinearLayout) fragmentLocalboxBinding.postTapView;
        parentLinearLayout.removeView(captionsLinearLayout);



        //Set the number of list items (i.e. Sound asset files) that could appear per ROW based on the orientation (i.e. landscape or portrait) of the screen
        if (getActivity().getResources().getConfiguration().orientation == ORIENTATION_PORTRAIT) {
            fragmentLocalboxBinding.recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3)); //Set 3 Sound asset files to appear per row
        }
        //If the orientation is LANDSCAPE
        else{
            fragmentLocalboxBinding.recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 6)); //Set 6 Sound asset files to appear per row
        }



        //Set the Adapter of the RecyclerView, taking as argument the ArrayList of Sound files
        fragmentLocalboxBinding.recyclerView.setAdapter(new SoundAdapter(mSoundManager.getSounds()));


        //Assign the SpeedSeekBarViewModel variable of the fragment_local_box.xml file to the the VIEW-MODEL for the SpeedSeekBar object (i.e. SeekBarViewModel)
        fragmentLocalboxBinding.setSpeedSeekBarViewModel(new SpeedSeekBarViewModel(mSoundManager, fragmentLocalboxBinding.speedSeekBar));


        //Return the outermost View in the layout file associated with the Binding - equivalent to returning View in non-databinding cases
        return fragmentLocalboxBinding.getRoot();
    }





    //Define anonymous inner class - Adapter inner class of RecyclerView
    private class SoundAdapter extends RecyclerView.Adapter<SoundHolder>{

        //Obtain List of Sound objects from the constructor
        private List<Sound> mSounds;


        //Constructor for the Adapter
        public SoundAdapter(List<Sound> sounds){
            mSounds = sounds;
        }


        //Override getItemCount method to obtain the number of Sound objects in the List
        @Override
        public int getItemCount(){
            return mSounds.size();
        }


        //Override onCreateViewHolder(..) method to create the ViewHolder (i.e. SoundHolder)
        @Override
        public SoundHolder onCreateViewHolder(ViewGroup viewGroup, int viewType){

            //Refer to the LayoutInflater object created in CategoryFragment.onCreate(..)
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());

            //Declare reference variable for data-binding from list_item_sound.xml
            ListItemSoundBinding listItemSoundBinding;

            //Create the data-binding object, ListItemSoundBinding object, from the list_item_sound.xml resource file
            listItemSoundBinding = DataBindingUtil.inflate(layoutInflater, R.layout.list_item_sound, viewGroup, false);

            //Create the ViewHolder, SoundHolder, taking as argument, the inflated reference variable
            return new SoundHolder(listItemSoundBinding);

        }


        //Override onBindViewHolder(..) method to attach the ViewHolder to 'bind' data to the ViewHolder (i.e. SoundHolder)
        //NOTE: A ViewHolder holds the data for a list-item
        @Override
        public void onBindViewHolder(SoundHolder soundHolder, int position){

            //Get the position of a single Sound
            Sound sound = mSounds.get(position);

            //Bind the ViewHolder (SoundHolder) to the data (i.e. Sound)
            soundHolder.bind(sound);
        }

    }





    //Define anonymous inner class - ViewHolder inner class of RecyclerView
    public class SoundHolder extends RecyclerView.ViewHolder{

        //Obtain reference variable for data-binding from list_item_sound.xml - from the constructor
        public ListItemSoundBinding mListItemSoundBinding;


        //Contructor for the ViewHolder
        private SoundHolder(ListItemSoundBinding listItemSoundBinding){

            //Get the inflated listItemSoundBinding object
            super(listItemSoundBinding.getRoot());

            //Obtain the ListItemSoundBinding object from the parameter
            mListItemSoundBinding = listItemSoundBinding;

            //Assign the SoundViewModel variable of the list_item_sound.xml file to the the VIEW-MODEL for the Sound object (i.e. SoundViewModel)
            mListItemSoundBinding.setSoundViewModel(new SoundViewModel(mSoundManager, listItemSoundBinding.getRoot().getContext()));
        }


        //Bind the ViewHolder (SoundHolder) to the data (i.e. Sound)
        public void bind(final Sound sound){

            //Set the Sound to the SoundViewModel
            mListItemSoundBinding.getSoundViewModel().setSound(sound);

            //Can be omitted: "Evaluates the pending bindings, updating any Views that have expressions bound to modified variables"
            mListItemSoundBinding.executePendingBindings();
        }

    }





    //Override onOptionsItemSelected(..) fragment lifecycle callback method
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater){
        super.onCreateOptionsMenu(menu, menuInflater);

        //Log to Logcat
        Log.i(TAG, "onCreateOptionsMenu(..) called");

        //Inflate the menu layout of the fragment
        menuInflater.inflate(R.menu.fragment_category, menu);
    }




    //Override onOptionsItemSelected(..) 'listener' method
    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem){

        //Log to Logcat
        Log.i(TAG, "onOptionsItemSelected(..) caleld");

        //Implement listener for the menu items in the menu layout
        switch (menuItem.getItemId()){

            case (R.id.category_info_dialog):
                //Create the "Category Information" menu item
                categoryInfoDialogFragment(sLanguageChosen, sCategoryChosen);
                break;
        }

        return super.onOptionsItemSelected(menuItem);
    }




    //Helper method - Create the "Category Information" menu item
    private void categoryInfoDialogFragment(String sLanguageChosen, String categoryChosen){

        //Create FragmentManager instance
        FragmentManager fragmentManager = getFragmentManager();

        //Create the CategoryInfoDialogFragment instance, passing as arguments the Language chosen and Category chosen
        CategoryInfoDialogFragment categoryInfoDialogFragment = CategoryInfoDialogFragment.newInstance(sLanguageChosen, categoryChosen);

        //Show the LanguageInfoDialogFragment fragment
        categoryInfoDialogFragment.show(fragmentManager, IDENTIFIER_DIALOG_FRAGMENT_CATEGORY_INFO);
    }




    //Override onPause() fragment lifecycle callback method
    @Override
    public void onPause(){
        super.onPause();
        Log.i(TAG, "onPause() called");
    }




    //Override onStop() fragment lifecycle callback method
    @Override
    public void onStop(){
        super.onStop();
        Log.i(TAG, "onStop() called");
    }




    @Override
    public void onDestroyView(){
        super.onDestroyView();
        Log.i(TAG, "onDestroyView() called");
    }




    //Override onDestroy() fragment lifecycle callback method
    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.i(TAG, "onDestroy() called");

        mSoundManager.releaseSounds();
    }




    //Override onDetach() fragment lifecycle callback method
    @Override
    public void onDetach(){
        super.onDetach();

        //Log in Logcat
        Log.i(TAG, "onDetach() called");
    }

}
