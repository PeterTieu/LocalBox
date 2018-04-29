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
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.petertieu.android.localbox.databinding.FragmentLocalBoxBinding;
import com.petertieu.android.localbox.databinding.ListItemSoundBinding;
import com.petertieu.android.localbox.dialogfragment.CategoryInfoDialogFragment;


import java.util.List;



public class CategoryFragment extends Fragment {

    //============= Declare instance variables ==============================================

    private final String TAG = "CategoryFragment";
    public static String mLanguageChosen;
    public static String mCategoryChosen;


    private SoundManager mSoundManager;

    private final String IDENTIFIER_DIALOG_FRAGMENT_CATEGORY_INFO = "DialogFragmentCategoryInfo";



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



            case ("arabic"):
                switch(mCategoryChosen){

                    case("numerics"):
                        SoundManager.SOUNDS_FOLDER_NAME = "all_sounds/arabic/numerics";
                        break;

                    case("statements"):
                        SoundManager.SOUNDS_FOLDER_NAME = "all_sounds/arabic/statements";
                        break;

                    case("questions"):
                        SoundManager.SOUNDS_FOLDER_NAME = "all_sounds/arabic/questions";
                        break;


                    case("adjectives"):
                        SoundManager.SOUNDS_FOLDER_NAME = "all_sounds/arabic/adjectives";
                        break;

                    case("nouns"):
                        SoundManager.SOUNDS_FOLDER_NAME = "all_sounds/arabic/nouns";
                        break;

                    default:
                        SoundManager.SOUNDS_FOLDER_NAME = "";
                        break;
                }

                break;


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



            case("french"):
                switch(mCategoryChosen){

                    case("numerics"):
                        SoundManager.SOUNDS_FOLDER_NAME = "all_sounds/french/numerics";
                        break;


                    case("statements"):
                        SoundManager.SOUNDS_FOLDER_NAME = "all_sounds/french/statements";
                        break;

                    case("questions"):
                        SoundManager.SOUNDS_FOLDER_NAME = "all_sounds/french/questions";
                        break;


                    case("adjectives"):
                        SoundManager.SOUNDS_FOLDER_NAME = "all_sounds/french/adjectives";
                        break;

                    case("nouns"):
                        SoundManager.SOUNDS_FOLDER_NAME = "all_sounds/french/nouns";
                        break;

                    default:
                        SoundManager.SOUNDS_FOLDER_NAME = "";
                        break;
                }

                break;




            case("german"):
                switch(mCategoryChosen){

                    case("numerics"):
                        SoundManager.SOUNDS_FOLDER_NAME = "all_sounds/german/numerics";
                        break;


                    case("statements"):
                        SoundManager.SOUNDS_FOLDER_NAME = "all_sounds/german/statements";
                        break;

                    case("questions"):
                        SoundManager.SOUNDS_FOLDER_NAME = "all_sounds/german/questions";
                        break;


                    case("adjectives"):
                        SoundManager.SOUNDS_FOLDER_NAME = "all_sounds/german/adjectives";
                        break;

                    case("nouns"):
                        SoundManager.SOUNDS_FOLDER_NAME = "all_sounds/german/nouns";
                        break;

                    default:
                        SoundManager.SOUNDS_FOLDER_NAME = "";
                        break;
                }

                break;



            case ("hindi"):
                switch(mCategoryChosen){

                    case("numerics"):
                        SoundManager.SOUNDS_FOLDER_NAME = "all_sounds/hindi/numerics";
                        break;

                    case("statements"):
                        SoundManager.SOUNDS_FOLDER_NAME = "all_sounds/hindi/statements";
                        break;

                    case("questions"):
                        SoundManager.SOUNDS_FOLDER_NAME = "all_sounds/hindi/questions";
                        break;


                    case("adjectives"):
                        SoundManager.SOUNDS_FOLDER_NAME = "all_sounds/hindi/adjectives";
                        break;

                    case("nouns"):
                        SoundManager.SOUNDS_FOLDER_NAME = "all_sounds/hindi/nouns";
                        break;

                    default:
                        SoundManager.SOUNDS_FOLDER_NAME = "";
                        break;
                }

                break;






            case ("italian"):
                switch(mCategoryChosen){

                    case("numerics"):
                        SoundManager.SOUNDS_FOLDER_NAME = "all_sounds/italian/numerics";
                        break;

                    case("statements"):
                        SoundManager.SOUNDS_FOLDER_NAME = "all_sounds/italian/statements";
                        break;

                    case("questions"):
                        SoundManager.SOUNDS_FOLDER_NAME = "all_sounds/italian/questions";
                        break;


                    case("adjectives"):
                        SoundManager.SOUNDS_FOLDER_NAME = "all_sounds/italian/adjectives";
                        break;

                    case("nouns"):
                        SoundManager.SOUNDS_FOLDER_NAME = "all_sounds/italian/nouns";
                        break;

                    default:
                        SoundManager.SOUNDS_FOLDER_NAME = "";
                        break;
                }

                break;




            case ("japanese"):
                switch(mCategoryChosen){

                    case("numerics"):
                        SoundManager.SOUNDS_FOLDER_NAME = "all_sounds/japanese/numerics";
                        break;

                    case("statements"):
                        SoundManager.SOUNDS_FOLDER_NAME = "all_sounds/japanese/statements";
                        break;

                    case("questions"):
                        SoundManager.SOUNDS_FOLDER_NAME = "all_sounds/japanese/questions";
                        break;


                    case("adjectives"):
                        SoundManager.SOUNDS_FOLDER_NAME = "all_sounds/japanese/adjectives";
                        break;

                    case("nouns"):
                        SoundManager.SOUNDS_FOLDER_NAME = "all_sounds/japanese/nouns";
                        break;

                    default:
                        SoundManager.SOUNDS_FOLDER_NAME = "";
                        break;
                }

                break;





            case ("korean"):
                switch(mCategoryChosen){

                    case("numerics"):
                        SoundManager.SOUNDS_FOLDER_NAME = "all_sounds/korean/numerics";
                        break;

                    case("statements"):
                        SoundManager.SOUNDS_FOLDER_NAME = "all_sounds/korean/statements";
                        break;

                    case("questions"):
                        SoundManager.SOUNDS_FOLDER_NAME = "all_sounds/korean/questions";
                        break;


                    case("adjectives"):
                        SoundManager.SOUNDS_FOLDER_NAME = "all_sounds/korean/adjectives";
                        break;

                    case("nouns"):
                        SoundManager.SOUNDS_FOLDER_NAME = "all_sounds/korean/nouns";
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




            case("russian"):
                switch(mCategoryChosen){

                    case("numerics"):
                        SoundManager.SOUNDS_FOLDER_NAME = "all_sounds/russian/numerics";
                        break;


                    case("statements"):
                        SoundManager.SOUNDS_FOLDER_NAME = "all_sounds/russian/statements";
                        break;

                    case("questions"):
                        SoundManager.SOUNDS_FOLDER_NAME = "all_sounds/russian/questions";
                        break;


                    case("adjectives"):
                        SoundManager.SOUNDS_FOLDER_NAME = "all_sounds/russian/adjectives";
                        break;

                    case("nouns"):
                        SoundManager.SOUNDS_FOLDER_NAME = "all_sounds/russian/nouns";
                        break;

                    default:
                        SoundManager.SOUNDS_FOLDER_NAME = "";
                        break;
                }

                break;





            case("spanish"):
                switch(mCategoryChosen){

                    case("numerics"):
                        SoundManager.SOUNDS_FOLDER_NAME = "all_sounds/spanish/numerics";
                        break;


                    case("statements"):
                        SoundManager.SOUNDS_FOLDER_NAME = "all_sounds/spanish/statements";
                        break;

                    case("questions"):
                        SoundManager.SOUNDS_FOLDER_NAME = "all_sounds/spanish/questions";
                        break;


                    case("adjectives"):
                        SoundManager.SOUNDS_FOLDER_NAME = "all_sounds/spanish/adjectives";
                        break;

                    case("nouns"):
                        SoundManager.SOUNDS_FOLDER_NAME = "all_sounds/spanish/nouns";
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



        setHasOptionsMenu(true);


        setRetainInstance(true);

    }




    Button mButton;


    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle savedIstanceState){

//        FragmentLocalBoxBinding fragmentLocalboxBinding;

        fragmentLocalboxBinding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_local_box, viewGroup, false);



        //REMOVE the CAPTIONS View so that ONLY the PRE-TAP View appear on the screen (NOTE: Only one of the PRE-TAP View or CAPTIONS View could appear on screen at a time!)
        LinearLayout parentLinearLayout = (LinearLayout) fragmentLocalboxBinding.parentLinearLayout;
        LinearLayout captionsLinearLayout = (LinearLayout) fragmentLocalboxBinding.postTapView;
        parentLinearLayout.removeView(captionsLinearLayout);






        fragmentLocalboxBinding.recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));


        fragmentLocalboxBinding.recyclerView.setAdapter(new SoundAdapter(mSoundManager.getSounds()));





        fragmentLocalboxBinding.setSpeedSeekBarViewModel(new SpeedSeekBarViewModel(mSoundManager, fragmentLocalboxBinding.speedSeekBar));



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




    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater){
        super.onCreateOptionsMenu(menu, menuInflater);

        Log.i(TAG, "onCreateOptionsMenu(..) called");

        menuInflater.inflate(R.menu.fragment_category, menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem){
        Log.i(TAG, "onOptionsItemSelected(..) caleld");

        switch (menuItem.getItemId()){
            case (R.id.category_info_dialog):
                categoryInfoDialogFragment(mCategoryChosen);
                break;
        }

        return super.onOptionsItemSelected(menuItem);
    }


    private void categoryInfoDialogFragment(String categoryChosen){
        FragmentManager fragmentManager = getFragmentManager();


        CategoryInfoDialogFragment categoryInfoDialogFragment = new CategoryInfoDialogFragment.newInstance(categoryChosen);

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
