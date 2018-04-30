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

public class LanguageInfoDialogFragment extends DialogFragment{


    private static final String ARG_LANGUAGE_CHOSEN = "languageChosen";

    private String mCustomTitleText;
    private int mCustomTitleTextColor;
    private int mCustomTitleBackgroundColor;
    private CharSequence mMessage;


    public static LanguageInfoDialogFragment newInstance(String languageChosen){

        Bundle argumentBundle = new Bundle();

        argumentBundle.putString(ARG_LANGUAGE_CHOSEN, languageChosen);

        LanguageInfoDialogFragment languageInfoDialogFragment = new LanguageInfoDialogFragment();

        languageInfoDialogFragment.setArguments(argumentBundle);

        return languageInfoDialogFragment;
    }




    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){

        String languageChosen = (String) getArguments().getString(ARG_LANGUAGE_CHOSEN);






        switch(languageChosen){

            case "arabic":

                mCustomTitleText = "Arabic Language";
                mCustomTitleTextColor = getResources().getColor(R.color.white);
                mCustomTitleBackgroundColor = getResources().getColor(R.color.green_arabic_flag);


                mMessage = Html.fromHtml(
                        "<br>" + "</br>" + //New Line
                                "Arabic is the 5th most commonly spoken language, with 300 million people speakers around the world. " +
                                "It is the official language of the Middle Eastern countries as well as in the horn and the north of Africa." +
                                "<br>" + "</br>" + //New Line
                                "<br>" + "</br>" + //New Line
                                "Arabic belongs to the Semitic language family which includes Aramaic and Hebrew. " +
                                "The Arabic alphabet consists of 28 letters. It is a language written from right to left. " +
                                "Dots play an important role in differentiating one letter to another, so their placement is crucial." +
                                "<br>" + "</br>" + // New Line
                                "<br>" + "</br>" + //New Line
                                "Arabic is one of the oldest spoken languages, and has passed through a plethora of history and civilisation. " +
                                "Its origin dates back to the Arabian Peninsual 16 centuries ago."
                );
                break;




            case "chinese":

                mCustomTitleText = "Chinese Language";
                mCustomTitleTextColor = getResources().getColor(R.color.yellow_chinese_flag);
                mCustomTitleBackgroundColor = getResources().getColor(R.color.red_chinese_flag);

                mMessage = Html.fromHtml(
                        "<br>" + "</br>" + //New Line
                                "More than 1.3 billion people speak Chinese, with the majority of the Chinese speaking population concentrated " +
                                "in China, Indonesia, Malaysia, and Singapore." +
                                "<br>" + "</br>" + //New Line
                                "<br>" + "</br>" + //New Line
                                "The written Chinese language characters are not just pictographs (which make up less than 5%), " +
                                "they are also highly stylised and carry considerable abstract meaning. " +
                                "The total number of characters is not exactly known, however, 50,000+ is a good approximation." +
                                "<br>" + "</br>" + // New Line
                                "<br>" + "</br>" + //New Line
                                "A character could stand alone as a word. A combination of characters could also come together to form a word. " +
                                "This adds to the diversity of words that the characters could form. " +
                                "<br>" + "</br>" + // New Line
                                "<br>" + "</br>" + //New Line
                                "For a Chinese speaker, knowledge of about 3,000 Chinese characters is good enough for everyday use!"
                );
                break;


            case "french":

                mCustomTitleText = "French Language";
                mCustomTitleTextColor = getResources().getColor(R.color.white);
                mCustomTitleBackgroundColor = getResources().getColor(R.color.blue_french_flag);

                mMessage = Html.fromHtml(
                        "<br>" + "</br>" + //New Line
                                "French is one of the world's major languages. It is the official language of 22 countries and is the co-official language of several others, " +
                                "with almost 300 million people speaking French as their native language or second language." +
                                "<br>" + "</br>" + //New Line
                                "<br>" + "</br>" + //New Line
                                "Modern French belongs to the group of so-called  \"Romance\" languages, which includes Italian, Spanish and Portuguese. Decended from Latin, " +
                                "these languages are said to represent living shaows of the acient Roman empire. " +
                                "The oldest known document written in the form of French dates back to the 9th century." +
                                "<br>" + "</br>" + // New Line
                                "<br>" + "</br>" + //New Line
                                "French is a moderately inflected or \"synthetic\" language, meaning the grammatical function of words is often indicated by suffixes and markers. " +
                                "The grammar (syntax), punctuation (or inflexion of the voice) and the form of words (morphology) are key factors in determining meaning. "
                );
                break;



            case "german":

                mCustomTitleText = "German Language";
                mCustomTitleTextColor = getResources().getColor(R.color.yellow_german_flag);
                mCustomTitleBackgroundColor = getResources().getColor(R.color.black);

                mMessage = Html.fromHtml(
                        "<br>" + "</br>" + //New Line
                                "German is the 6th most spoken language in the world, being the native language of more than 90 million speakers. " +
                                "It is the official language of Germany and Austria and is one of the three offcial languages of Switzerland." +
                                "<br>" + "</br>" + // New Line
                                "<br>" + "</br>" + //New Line
                                "Modern German belongs to the \"proto-Germanic\" group of languages " +
                                "which began around 100BC upon first contact with the Romans. The German language became distinct after the 6th century."+
                                "<br>" + "</br>" + //New Line
                                "<br>" + "</br>" + //New Line
                                "German is generally considered to be a difficult language to learn by English speakers. It is an inflected language, constituting of four cases for " +
                                "nouns, pronouns, adjectives, and three grammatical genders." +
                                "The pronounciation of words give every muscle in the mouth a good workout! " +
                                "However, English and German share some similarities that make it easier for English speakers to learn."
                );
                break;


            case "hindi":

                mCustomTitleText = "Hindi Language";
                mCustomTitleTextColor = getResources().getColor(R.color.orange_hindi_flag);
                mCustomTitleBackgroundColor = getResources().getColor(R.color.green_hindi_flag);

                mMessage = Html.fromHtml(
                        "<br>" + "</br>" + //New Line
                                "Hindi, amongst the many languages in India, is the official language of the country, with English as the other official language. " +
                                "It is used by the largest number of people in India as a first language. " +
                                "It is the first language of 425 million people, and the second language of 120 million people." + " " +
                                "<br>" + "</br>" + //New Line
                                "<br>" + "</br>" + //New Line
                                "Hindi in its present form, emerged through different stages since the 7th century, over which time it was known by other names. " +
                                "Modern Hindi and its literary tradition evolved towards the end of the 18th century." +
                                "<br>" + "</br>" + // New Line
                                "<br>" + "</br>" + //New Line
                                "The Hindi language is based on the Devanagari alphabet. In Hindi, it is common to find long words created by combining several other words. " +
                                "Hindi and English have many words that have been borrowed from each other."
                );
                break;


            case "italian":

                mCustomTitleText = "Italian Language";
                mCustomTitleTextColor = getResources().getColor(R.color.white);
                mCustomTitleBackgroundColor = getResources().getColor(R.color.green_italian_flag);

                mMessage = Html.fromHtml(
                        "<br>" + "</br>" + //New Line
                                "Italian is the official language of Italy and San Marino. It is one of the two offical languages of the Vatican " +
                                "and one of the three offical languages of Switzerland. Currently, it is spoken by over 70 million people worldwide." +
                                "<br>" + "</br>" + //New Line
                                "<br>" + "</br>" + //New Line
                                "Italian belongs to a group of Romance languages, and developed from Vulgar Latin, the colloquial language of the late Roman empire. " +
                                "The earliest known Italian texts date back to the 8th century, with distinct Italian from Vulgar Latin emerging in the 10th century. " +
                                "Standard Italian began developing in the 13th and 14th centuries as a literary dialect, and has always been heavily influenced by Latin." +
                                "<br>" + "</br>" + // New Line
                                "<br>" + "</br>" + //New Line
                                "Pronounciation in Italian is clear, with every vowel distinctly enunciated. Nouns can be either msculine or feminine. " +
                                "Vocabulary is similar to other languages of Latin origin, namely Spanish, French and Portuguese."
                );
                break;




            case "japanese":

                mCustomTitleText = "Japanese Language";
                mCustomTitleTextColor = getResources().getColor(R.color.red_japanese_flag);
                mCustomTitleBackgroundColor = getResources().getColor(R.color.white);

                mMessage = Html.fromHtml(
                        "<br>" + "</br>" + //New Line
                                "Japanese is the official language of Japan, which has a population of 125 million. There are also around 3 million speakers of Japanese " +
                                "origin, many of whom live in the United States, Cananda and Australia." +
                                "<br>" + "</br>" + //New Line
                                "<br>" + "</br>" + //New Line
                                "The exact origin of Japanese is not accurately known, however, evidence has been offered for a number of sources: " +
                                "Ural-Atlaic, Polynesian, and Chinese among others. It is believe that a proto-Japanese language has existed from at least the 3rd century." +
                                "<br>" + "</br>" + // New Line
                                "<br>" + "</br>" + //New Line
                                "Like English, Japanese has no gender distinctions. Unlike English, however, Japanese " +
                                "does not use articles extensively and there is no way of showing whether a word is singular of plural." +
                                "There are no pronunciations or tones to remember, and each syllable is given equal emphasis."
                );
                break;



            case "korean":

                mCustomTitleText = "Korean Language";
                mCustomTitleTextColor = getResources().getColor(R.color.black);
                mCustomTitleBackgroundColor = getResources().getColor(R.color.white);

                mMessage = Html.fromHtml(
                        "<br>" + "</br>" + //New Line
                                "Korean is the official and national language of South Korea and North Korea. " +
                                "It is spoken by over 80 million people around the world. " +
                                "<br>" + "</br>" + //New Line
                                "<br>" + "</br>" + //New Line
                                "Korean is considered to be one of the world's oldest living languages. " +
                                "Beginning in the 5th century, the Korean language was originally written in Hanja, which were borrowed Chinese characters " +
                                "spoken with unique pronunciation. This continued until the 15th century when the revolutionary Korean language alphabet was devised."+
                                "<br>" + "</br>" + // New Line
                                "<br>" + "</br>" + // New Line
                                "The modern name for the Korean alphabet is Hangul, which contains 24 letters, combined together into syllable blocks. " +
                                "Korean senstences and grammar share many similarities to those of Japanese, though the words and pronunciations are quite disctict from one another."
                );
                break;



            case "russian":

                mCustomTitleText = "Russian Language";
                mCustomTitleTextColor = getResources().getColor(R.color.blue_russian_flag);
                mCustomTitleBackgroundColor = getResources().getColor(R.color.white);

                mMessage = Html.fromHtml(
                        "<br>" + "</br>" + //New Line
                                "Russian is the official language in the Russian Federation, and is spoken by over 170 million people in the world. " +
                                "Russian is also spoken in Ukraine, Belarus, Kazakhstan and other republics of the former USSR." +
                                "<br>" + "</br>" + //New Line
                                "<br>" + "</br>" + //New Line
                                "It is believed that the Russian language originated from the Eastern Slavic languages of the 10th century, along with" +
                                "Ukraine, and Belorussian, meaning that it belongs to the wider Indo-European language family." +
                                "<br>" + "</br>" + // New Line
                                "<br>" + "</br>" + //New Line
                                "Pronunciation and grammar in Russian are drastically distinct from that of English, however, about 10% of Russian words " +
                                "are internationalisms and bear a resemblance to English words." +
                                "On top of that, plenty of Russian words have been loaned from Italian, French, or German, which may seem archaic, " +
                        "as they have made their way into the Russian language in the 18th and 19ht centuries."
                );
                break;


            case "spanish":

                mCustomTitleText = "Spanish Language";
                mCustomTitleTextColor = getResources().getColor(R.color.red_spanish_flag);
                mCustomTitleBackgroundColor = getResources().getColor(R.color.yellow_spanish_flag);

                mMessage = Html.fromHtml(
                        "<br>" + "</br>" + //New Line
                                "Spanish is the native language of over 330 million people in the world. It is the official language of Spain, " +
                                "and is also spoken across Central and South American countries which were former Spanish colonies." +
                                "<br>" + "</br>" + //New Line
                                "<br>" + "</br>" + //New Line
                                "Spanish is a Romance language of Western Europe, which evolved out of Late Vulgar Latin, with minor Germanic and major Arabic influence. " +
                                "Spanish began in the Southwest region of Europe known as the Iberian Peninsula. The creation of a standardized Spanish language " +
                                "began towards the end of the 13th century." +
                                "<br>" + "</br>" + // New Line
                                "<br>" + "</br>" + //New Line
                                "Spanish is generally thought of as an one of the easier languages to learn by English speakers, as words are pronounced the way they are written. " +
                                "Because English and Spanish share many words of Latin origin, more than 3,000 words would be recognisable to an English speaker"
                );
                break;


            case "thai":

                mCustomTitleText = "Thai Language";
                mCustomTitleTextColor = getResources().getColor(R.color.blue_thai_flag);
                mCustomTitleBackgroundColor = getResources().getColor(R.color.red_thai_flag);

                mMessage = Html.fromHtml(
                        "<br>" + "</br>" + //New Line
                                "Thai is spoken exclusively in Thailand, by approximately 60 million people. " +
                                "The dialect spoken in the Central Region is regarded as Standard Thai. " +
                                "<br>" + "</br>" + //New Line
                                "<br>" + "</br>" + //New Line
                                "The Thai language is classified as a member of the Tai language group within the Tai-Kadai language family, " +
                                "which originated in what is now southern China. " +
                                "The Thai language and culture have an intricate history stretching back thousands of years. " +
                                "<br>" + "</br>" + // New Line
                                "<br>" + "</br>" + //New Line
                                "The Thai language consists of 42 consonant signs, as well as vowel and tone markers, " +
                                "and is written in the alphabet based on the Khmer alphabet. Thai is a tonal language, " +
                                "so the learner has to get used to recognising the pitch of a word. There are five tones; mid tone, low tone, high tone, " +
                                "falling tone, and rising tone."
                );
                break;


            case "vietnamese":

                mCustomTitleText = "Vietnamese Language";
                mCustomTitleTextColor = getResources().getColor(R.color.yellow_vietnamese_flag);
                mCustomTitleBackgroundColor = getResources().getColor(R.color.red_vietnamese_flag);

                mMessage = Html.fromHtml(
                        "<br>" + "</br>" + //New Line
                                "Vietnamese is the official language of Vietnam, spoken by over 70 million people. " +
                                "<br>" + "</br>" + //New Line
                                "<br>" + "</br>" + //New Line
                                "It is believed that Vietnamese originated in the Red River Delta region in what is now northern Vietnam. " +
                                "Early Vietnamese was primarily influenced by Chinese due to its political predominance. " +
                                "Chinese characters and writing systems were applied up until the " +
                                "French invaded Vietnam in the late 19th century, replacing Chinese as the official language, and romanized Vietnamese text." +
                                "<br>" + "</br>" + // New Line
                                "<br>" + "</br>" + //New Line
                                "About 60 percent of modern Vietnamese words are of Chinese origin. Many basic words were adpoted from Mon-Khmer languages. " +
                                "Meanwhile, tonality originated from Tai." +
                                "In Vietnamese, each syllable has one of six tones, which could completely alters the meaning of the word."
                );
                break;
        }







        TextView customTitle = new TextView(getActivity());
        customTitle.setText(mCustomTitleText);
        customTitle.setTextSize(22);
        customTitle.setGravity(Gravity.CENTER);
        customTitle.setTypeface(null, Typeface.BOLD);
        customTitle.setTextColor(mCustomTitleTextColor);
        customTitle.setBackgroundColor(mCustomTitleBackgroundColor);


        View view = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_about, null);




        AlertDialog alertDialog = new AlertDialog
                .Builder(getActivity())
                .setView(view)
                .setCustomTitle(customTitle)
                .setMessage(mMessage)
                .show();



        alertDialog.getWindow().setLayout(850,1200);


        return alertDialog;


    }


}