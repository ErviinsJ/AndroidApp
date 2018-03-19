package info.androidhive.appscandiweb;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import static android.os.Build.VERSION_CODES.M;
import static android.provider.Telephony.Mms.Part.FILENAME;
import static info.androidhive.appscandiweb.ProfileSettingsActivity.READ_BLOCK_SIZE;

public class ProfileActivity extends AppCompatActivity {



    public void backB(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void settB(View view) {
        Intent intent = new Intent(this, ProfileSettingsActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        try {
            FileInputStream fileIn=openFileInput("name.txt");
            InputStreamReader InputRead= new InputStreamReader(fileIn);

            char[] inputBuffer= new char[READ_BLOCK_SIZE];
            String s="";
            int charRead;

            while ((charRead=InputRead.read(inputBuffer))>0) {
                // char to string conversion
                String readstring=String.copyValueOf(inputBuffer,0,charRead);
                s +=readstring;
            }
            TextView mTextView = (TextView)findViewById(R.id.name);
            mTextView.setText(s);
            InputRead.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            FileInputStream fileIn=openFileInput("surname.txt");
            InputStreamReader InputRead= new InputStreamReader(fileIn);

            char[] inputBuffer= new char[READ_BLOCK_SIZE];
            String s="";
            int charRead;

            while ((charRead=InputRead.read(inputBuffer))>0) {
                // char to string conversion
                String readstring=String.copyValueOf(inputBuffer,0,charRead);
                s +=readstring;
            }
            TextView myAwesomeTextView = (TextView)findViewById(R.id.surname);
            myAwesomeTextView.setText(s);
            InputRead.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
