package info.androidhive.appscandiweb;

import android.app.Activity;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import static android.os.Build.VERSION_CODES.N;

public class MainActivity extends AppCompatActivity {


    public void statistB(View view) {

        Intent intent = new Intent(this, StatisticActivity.class);
        startActivity(intent);
    }
    public void usrB(View view) {

        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);

    }
    public void bellB(View view) {

        Intent intent = new Intent(this, NotificationActivity.class);
        startActivity(intent);
    }
    public void collB(View view) {

        Intent intent = new Intent(this, DataActivity.class);
        startActivity(intent);
    }
    public void homeB(View view) {

        Intent intent = new Intent(this, NotificationActivity.class);
        startActivity(intent);
    }
    public void backB(View view) {
        return;
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





    }
}


