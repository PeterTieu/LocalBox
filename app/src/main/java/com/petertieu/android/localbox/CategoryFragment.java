package com.petertieu.android.localbox;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.petertieu.android.localbox.databinding.FragmentLocalBoxBinding;
import com.petertieu.android.localbox.databinding.ListItemSoundBinding;


import java.util.List;


/**
 * Created by Peter Tieu on 19/03/2018.
 */

public class CategoryFragment extends Fragment {

    //============= Declare instance variables ==============================================
    private final String TAG = "CategoryFragment";
    private String mLanguageChosen;
    private String mCategoryChosen;


    private SoundManager mSoundManager;



    //Override onCreate(..) fragment lifecycle callback method
    @Override
    public void onCreate(Bundle onSaveInstanceState){
        super.onCreate(onSaveInstanceState);

        Log.i(TAG, "onCreate(..) called");


        if (getArguments() != null){


            mLanguageChosen = getArguments().getString(CategoryActivity.KEY_LANGUAGE_CHOSEN);

            mCategoryChosen = getArguments().getString(CategoryActivity.KEY_CATEGORY_CHOSEN);

            Log.i(TAG, "Language chosen: " + mLanguageChosen + "... " + "Category chosen: " + mCategoryChosen);
        }




        mSoundManager = new SoundManager(getActivity());


        setRetainInstance(true);

    }




    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle savedIstanceState){

        FragmentLocalBoxBinding fragmentLocalboxBinding;

        fragmentLocalboxBinding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_local_box, viewGroup, false);

        fragmentLocalboxBinding.recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));


        fragmentLocalboxBinding.recyclerView.setAdapter(new SoundAdapter(mSoundManager.getSounds()));


        return fragmentLocalboxBinding.getRoot();


    }









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
















    private class SoundHolder extends RecyclerView.ViewHolder{


        ListItemSoundBinding mListItemSoundBinding;


        private SoundHolder(ListItemSoundBinding listItemSoundBinding){

            super(listItemSoundBinding.getRoot());

            mListItemSoundBinding = listItemSoundBinding;



            mListItemSoundBinding.setSoundViewModel(new SoundViewModel(mSoundManager));
        }



        public void bind(Sound sound){



            mListItemSoundBinding.getSoundViewModel().setSound(sound);

            mListItemSoundBinding.executePendingBindings();

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
