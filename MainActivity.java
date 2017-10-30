package com.game.knight.guessmylogo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableRow;

import java.util.Random;

@SuppressWarnings("deprecation")
public class MainActivity extends AppCompatActivity {

    // buttons of keyboard
    Button btns[] = new Button[18];
    //  alphabet chars to add random chars to 18 buttons in  keyboard
    String[] alphabet = {
            "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p",
            "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

    // user submit answer
    public char[] answer_submit;
    // correct answer
    String[] correct_answer = {"adidas", "ajax", "amazon", "apple", "arsenal",
            "assassincreed", "bitcoin", "blogger", "bluetooth", "bvb", "chelsea",
            "dropbox", "ebay", "facebook", "flickr", "google", "joomla", "javascript",
            "jquery", "juventus", "lacoste", "levis", "linkedin", "linux", "liverpool",
            "louis vuitton", "lululemon", "myspace", "microsoft", "mcdonalds", "motorola",
            "milan", "mancity", "nike", "nodejs", "paypal", "pepsi", "pinterest", "pokemon",
            "prestashop", "python", "rails", "real madrid", "ruby", "reddit", "shopify", "skype",
            "snapchat", "soundcloud", "sqlite", "superman", "tmobile", "twitter", "tripadvisor",
            "ubuntu", "unity", "vimeo", "vine", "vodafone", "vkontakte", "walmart", "wordpress",
            "wwe", "webmoney", "whatsapp", "yahoo"};

    // image list to display in the imagelogo from drawable folder

    int[] image_list = {R.drawable.adidas, R.drawable.ajax,
            R.drawable.amazon, R.drawable.apple, R.drawable.arsenal,
            R.drawable.assassincreed, R.drawable.bitcoin, R.drawable.blogger,
            R.drawable.bluetooth, R.drawable.bvb, R.drawable.chelsea, R.drawable.dropbox,
            R.drawable.ebay, R.drawable.facebook, R.drawable.flickr, R.drawable.google,
            R.drawable.joomla, R.drawable.javascript, R.drawable.jquery, R.drawable.juventus,
            R.drawable.lacoste, R.drawable.levis, R.drawable.linkedin, R.drawable.linux,
            R.drawable.liverpool, R.drawable.louisvuitton, R.drawable.lululemon, R.drawable.myspace,
            R.drawable.microsoft, R.drawable.mcdonalds, R.drawable.motorola, R.drawable.milan,
            R.drawable.mancity, R.drawable.nike, R.drawable.nodejs, R.drawable.paypal, R.drawable.pepsi,
            R.drawable.pinterest, R.drawable.pokemon, R.drawable.presta, R.drawable.python, R.drawable.rails,
            R.drawable.real, R.drawable.ruby, R.drawable.reddit, R.drawable.shopify, R.drawable.skype,
            R.drawable.snap, R.drawable.soundcloud, R.drawable.sqlite, R.drawable.superman, R.drawable.tmobile,
            R.drawable.twitter, R.drawable.tripadvisor, R.drawable.ubuntu, R.drawable.unity, R.drawable.vimeo,
            R.drawable.vine, R.drawable.vodafone, R.drawable.vkontakte, R.drawable.walmart, R.drawable.wordpress,
            R.drawable.wwe, R.drawable.webmoney, R.drawable.whatsapp, R.drawable.yahoo,

    };
    // share button
    private Button shareGame;
    int i = 0;
        String answer="";
    public ImageView imgViewQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // imageView to display logo
        imgViewQuestion = (ImageView) findViewById(R.id.imgLogo);

     // to increment the images every time the user user submit a correct answer
        if (answer == correct_answer[i]) {
            imgViewQuestion.setImageResource(image_list[i++]);
        }

         // set random chars to the 18 buttons

        for (int i = 0; i < btns.length; i++) {

            for (int j = 0; j < 6; j++) {
                Random r = new Random();
                String str = alphabet[r.nextInt(alphabet.length)];
                btns[i].setText(str);

            }
        }

        String message = "ANSWER";
        int size = message.length();
        TableRow tableRow = (TableRow) findViewById(R.id.answerLayout);
        if (size != 0) {
            for (int i = 0; i < size; i++) {
                final Button btn = new Button(this);
                TableRow.LayoutParams tl = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                 TableRow.LayoutParams.WRAP_CONTENT);
                btn.setBackgroundColor(Color.GRAY);
                btn.setText("H");
                tl.setMargins(10, 10, 0, 0);
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        btn.setText(" ");
                    }
                });

                tableRow.addView(btn);

                tableRow.removeAllViews();
                    }

                }

           /* shareGame = (Button) findViewById(R.id.shareGame);
        shareGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentShare = new Intent(Intent.ACTION_SEND);
                intentShare.setType("text/plain");
                intentShare.putExtra(Intent.EXTRA_SUBJECT, "New Amazing Trivia Game ! Try it out now !");
                intentShare.putExtra(Intent.EXTRA_TEXT, "https://play.google.com/" + "store/apps/details?id=com.vyara.greatleaders");
                startActivity(Intent.createChooser(intentShare, "Share Via"));
                }
             });
             */
    }
}