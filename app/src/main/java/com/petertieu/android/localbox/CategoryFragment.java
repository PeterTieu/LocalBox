package com.petertieu.android.localbox;


import android.databinding.DataBindingUtil;
import android.media.MediaMetadataRetriever;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


import com.petertieu.android.localbox.databinding.FragmentLocalBoxBinding;
import com.petertieu.android.localbox.databinding.ListItemSoundBinding;


import java.util.ArrayList;
import java.util.List;



public class CategoryFragment extends Fragment {

    //============= Declare instance variables ==============================================

    private final String TAG = "CategoryFragment";
    public static String mLanguageChosen;
    public static String mCategoryChosen;


    private SoundManager mSoundManager;



    //============= Declare methods =========================================================

    //Override onCreate(..) fragment lifecycle callback method
    @Override
    public void onCreate(Bundle onSaveInstanceState){
        super.onCreate(onSaveInstanceState);

        //Log to Logcat
        Log.i(TAG, "onCreate(..) called");


        //Get the l
        if (getArguments() != null){

            mLanguageChosen = getArguments().getString(CategoryActivity.KEY_LANGUAGE_CHOSEN);

            mCategoryChosen = getArguments().getString(CategoryActivity.KEY_CATEGORY_CHOSEN);

            Log.i(TAG, "Language chosen: " + mLanguageChosen + "... " + "Category chosen: " + mCategoryChosen);
        }







        //TODO: Put all of the below in a method!
        switch (mLanguageChosen){

            case ("chinese"):
                switch(mCategoryChosen){

                    case("numerics"):
                        SoundManager.SOUNDS_FOLDER_NAME = "all_sounds/chinese/numerics";
                        break;

                    case("statements"):
                        SoundManager.SOUNDS_FOLDER_NAME = "all_sounds/chinese/statements";
                        break;

                    case("questions"):
                        SoundManager.SOUNDS_FOLDER_NAME = "all_sounds/chinese/questions";
                        break;


                    case("adjectives"):
                        SoundManager.SOUNDS_FOLDER_NAME = "all_sounds/chinese/adjectives";
                        break;

                    case("nouns"):
                        SoundManager.SOUNDS_FOLDER_NAME = "all_sounds/chinese/nouns";
                        break;

                    default:
                        SoundManager.SOUNDS_FOLDER_NAME = "";
                        break;
                }

                break;





            case("vietnamese"):
                switch(mCategoryChosen){

                    case("numerics"):
                        SoundManager.SOUNDS_FOLDER_NAME = "all_sounds/vietnamese/numerics";
                        break;


                    case("statements"):
                        SoundManager.SOUNDS_FOLDER_NAME = "all_sounds/vietnamese/statements";
                        break;

                    case("questions"):
                        SoundManager.SOUNDS_FOLDER_NAME = "all_sounds/vietnamese/questions";
                        break;


                    case("adjectives"):
                        SoundManager.SOUNDS_FOLDER_NAME = "all_sounds/vietnamese/adjectives";
                        break;

                    case("nouns"):
                        SoundManager.SOUNDS_FOLDER_NAME = "all_sounds/vietnamese/nouns";
                        break;

                    default:
                        SoundManager.SOUNDS_FOLDER_NAME = "";
                        break;
                }

                break;








            case("thai"):
                switch(mCategoryChosen){

                    case("numerics"):
                        SoundManager.SOUNDS_FOLDER_NAME = "all_sounds/thai/numerics";
                        break;


                    case("statements"):
                        SoundManager.SOUNDS_FOLDER_NAME = "all_sounds/thai/statements";
                        break;

                    case("questions"):
                        SoundManager.SOUNDS_FOLDER_NAME = "all_sounds/thai/questions";
                        break;


                    case("adjectives"):
                        SoundManager.SOUNDS_FOLDER_NAME = "all_sounds/thai/adjectives";
                        break;

                    case("nouns"):
                        SoundManager.SOUNDS_FOLDER_NAME = "all_sounds/thai/nouns";
                        break;

                    default:
                        SoundManager.SOUNDS_FOLDER_NAME = "";
                        break;
                }

                break;











            default:
                SoundManager.SOUNDS_FOLDER_NAME = "";
                break;



        }



        mSoundManager = new SoundManager(getActivity());



        setRetainInstance(true);

    }




    Button mButton;


    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle savedIstanceState){

//        FragmentLocalBoxBinding fragmentLocalboxBinding;

        fragmentLocalboxBinding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_local_box, viewGroup, false);

        fragmentLocalboxBinding.recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));


        fragmentLocalboxBinding.recyclerView.setAdapter(new SoundAdapter(mSoundManager.getSounds()));




        //Equivalent to returning "view" - returns the outermost View in the layout file associated with the Binding
        return fragmentLocalboxBinding.getRoot();




    }


    public static FragmentLocalBoxBinding fragmentLocalboxBinding;








    private class SoundAdapter extends RecyclerView.Adapter<SoundHolder>{
        private List<Sound> mSounds;



        public SoundAdapter(List<Sound> sounds){
            mSounds = sounds;
        }


        @Override
        public int getItemCount(){
            return mSounds.size();
        }




        @Override
        public SoundHolder onCreateViewHolder(ViewGroup viewGroup, int viewType){

            //Refer to the LayoutInflater object created in CategoryFragment.onCreate(..)
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());



            ListItemSoundBinding listItemSoundBinding;


            listItemSoundBinding = DataBindingUtil.inflate(layoutInflater, R.layout.list_item_sound, viewGroup, false);


            return new SoundHolder(listItemSoundBinding);

        }





        @Override
        public void onBindViewHolder(SoundHolder soundHolder, int position){
            Sound sound = mSounds.get(position);

            soundHolder.bind(sound);





        }




    }



















//    public static ListItemSoundBinding mListItemSoundBinding;


    public class SoundHolder extends RecyclerView.ViewHolder{


        public ListItemSoundBinding mListItemSoundBinding;


        private SoundHolder(ListItemSoundBinding listItemSoundBinding){

            super(listItemSoundBinding.getRoot());


            mListItemSoundBinding = listItemSoundBinding;


            //Set the variable of the list_item_sound to be the ViewModel (SoundViewModel)
            mListItemSoundBinding.setSoundViewModel(new SoundViewModel(mSoundManager, listItemSoundBinding.getRoot().getContext()));





        }






        public void bind(final Sound sound){



            mListItemSoundBinding.getSoundViewModel().setSound(sound);


            //Can be omitted: "Evaluates the pending bindings, updating any Views that have expressions bound to modified variables"
            mListItemSoundBinding.executePendingBindings();





//            mSound = sound;


        }






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
