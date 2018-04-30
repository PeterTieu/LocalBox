package com.petertieu.android.localbox.dialogfragment;

import android.app.Dialog;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.text.Html;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.petertieu.android.localbox.R;

public class AboutDialogFragment extends DialogFragment{


    public static AboutDialogFragment newInstance(){
        return new AboutDialogFragment();
    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){

        TextView dialogTitle = new TextView(getActivity());
        dialogTitle.setText("What is LocalBox?");
        dialogTitle.setTextSize(22);
        dialogTitle.setGravity(Gravity.CENTER);
        dialogTitle.setTypeface(null, Typeface.BOLD);
        dialogTitle.setTextColor(getResources().getColor(R.color.colorAccent));
        dialogTitle.setBackgroundColor(getResources().getColor(R.color.colorDarkBackground));


        View view = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_about, null);


        AlertDialog alertDialog = new AlertDialog
                .Builder(getActivity())
                .setView(view)
                .setCustomTitle(dialogTitle)
                .setMessage(Html.fromHtml(
                            "<br>" + "</br>" + //New Line
                                "LocalBox is your key to some of the world's most widely spoken languages!" + " " +
                                "Break language barriers and communicate with speakers of any of the 12 supported languages using some of the most commonly spoken everyday words and phrases!" +
                                "<br>" + "</br>" + //New Line
                                "<br>" + "</br>" + //New Line
                                "<b>" + "Great for " + "</b>" +
                                "English speaking tourists or learners of the 12 supported languages." +
                                "<br>" + "</br>" + // New Line
                                "<br>" + "</br>" + //New Line
                                "<b>" + "Features " + "</b>" +
                                "words and phrases that come equipped with sounded pronounciation, translated text and text description of how to pronounce them!" +
                                "<br>" + "</br>" + //New Line
                                "<br>" + "</br>" + //New Line
                                "<b>" + "Also includes " + "</b>" +
                                "modifiable playback speed to suit the pace you want to hear the pronounciation!" +
                                "<br>" + "</br>" + //New Line
                                "<br>" + "</br>" + //New Line
                                "<br>" + "</br>" + //New Line
                                "<div style=\"text-align:center\">" + "Created by TieuTech" + "</div>"))
                .show();



        alertDialog.getWindow().setLayout(850,1150);


        return alertDialog;


    }


}
