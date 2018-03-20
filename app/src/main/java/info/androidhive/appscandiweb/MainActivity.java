package info.androidhive.appscandiweb;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.concurrent.TimeUnit;

import static android.R.attr.button;
import static android.os.Build.VERSION_CODES.N;

public class MainActivity extends AppCompatActivity {


//    Bottom menu buttons
    public void statistB(View view)  {

        Intent intent = new Intent(this, StatisticActivity.class);
        startActivity(intent);
        final ImageButton button = (ImageButton) findViewById(R.id.stat_btn);
        button.setBackgroundColor(Color.parseColor("#6956EC"));
    }

    public void usrB(View view) {

        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
        final ImageButton button = (ImageButton) findViewById(R.id.usr_btn);
        button.setBackgroundColor(Color.parseColor("#6956EC"));
    }
    public void bellB(View view) {

        Intent intent = new Intent(this, NotificationActivity.class);
        startActivity(intent);
        final ImageButton button = (ImageButton) findViewById(R.id.bell_btn);
        button.setBackgroundColor(Color.parseColor("#6956EC"));
    }
    public void collB(View view) {

        Intent intent = new Intent(this, DataActivity.class);
        startActivity(intent);
        final ImageButton button = (ImageButton) findViewById(R.id.coll_btn);
        button.setBackgroundColor(Color.parseColor("#6956EC"));
    }
    public void homeB(View view) {

        Intent intent = new Intent(this, NotificationActivity.class);
        startActivity(intent);
        final ImageButton button = (ImageButton) findViewById(R.id.home_btn);
        button.setBackgroundColor(Color.parseColor("#6956EC"));
    }
    public void backB(View view) {
        return;
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

//    Resets button colors
    @Override
    protected void onResume() {
        super.onResume();

        final ImageButton stat_button = (ImageButton) findViewById(R.id.stat_btn);
        stat_button.setBackgroundColor(Color.parseColor("#1a1b25"));

        final ImageButton usr_button = (ImageButton) findViewById(R.id.usr_btn);
        usr_button.setBackgroundColor(Color.parseColor("#1a1b25"));

        final ImageButton bell_button = (ImageButton) findViewById(R.id.bell_btn);
        bell_button.setBackgroundColor(Color.parseColor("#1a1b25"));

        final ImageButton coll_button = (ImageButton) findViewById(R.id.coll_btn);
        coll_button.setBackgroundColor(Color.parseColor("#1a1b25"));

        final ImageButton home_button = (ImageButton) findViewById(R.id.home_btn);
        home_button.setBackgroundColor(Color.parseColor("#1a1b25"));


    }


}


