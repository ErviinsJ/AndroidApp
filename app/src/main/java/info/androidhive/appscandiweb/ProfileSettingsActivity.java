package info.androidhive.appscandiweb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import static android.os.Build.VERSION_CODES.M;

public class ProfileSettingsActivity extends AppCompatActivity {

    public void backB(View view) {
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
    }

    EditText textmsg1;
    EditText textmsg2;

    static final int READ_BLOCK_SIZE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_settings);

        textmsg1=(EditText)findViewById(R.id.edit_first_name);
        textmsg2=(EditText)findViewById(R.id.edit_last_name);
    }
    // write text to file
    public void NameBtn(View v) {
        // add-write text into file
        try {
            FileOutputStream fileout=openFileOutput("name.txt", MODE_PRIVATE);
            OutputStreamWriter outputWriter=new OutputStreamWriter(fileout);
            outputWriter.write(textmsg1.getText().toString());
            outputWriter.close();

            //display file saved message
            Toast.makeText(getBaseContext(), "First name updated successfully!",
                    Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Read text from file
    public void SurnameBtn(View v) {
        //reading text from file
        try {
            FileOutputStream fileout=openFileOutput("surname.txt", MODE_PRIVATE);
            OutputStreamWriter outputWriter=new OutputStreamWriter(fileout);
            outputWriter.write(textmsg2.getText().toString());
            outputWriter.close();

            //display file saved message
            Toast.makeText(getBaseContext(), "Last name updated successfully!",
                    Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
