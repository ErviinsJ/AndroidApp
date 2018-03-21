package info.androidhive.appscandiweb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class ProfileSettingsActivity extends AppCompatActivity {

    public void backB(View view) {
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
    }

    EditText textName;
    EditText textLastName;

    static final int READ_BLOCK_SIZE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_settings);

        textName =(EditText)findViewById(R.id.edit_first_name);
        textLastName =(EditText)findViewById(R.id.edit_last_name);
    }
//    write text to file
    public void NameBtn(View v) {
        try {
            FileOutputStream fileout=openFileOutput("name.txt", MODE_PRIVATE);
            OutputStreamWriter outputWriter=new OutputStreamWriter(fileout);
            outputWriter.write(textName.getText().toString());
            outputWriter.close();

            Toast.makeText(getBaseContext(), "First name updated successfully!",
                    Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            e.printStackTrace();
        }
        textName.setText("");
    }

//    Read text from file
    public void SurnameBtn(View v) {
        try {
            FileOutputStream fileout=openFileOutput("surname.txt", MODE_PRIVATE);
            OutputStreamWriter outputWriter=new OutputStreamWriter(fileout);
            outputWriter.write(textLastName.getText().toString());
            outputWriter.close();

            Toast.makeText(getBaseContext(), "Last name updated successfully!",
                    Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            e.printStackTrace();
        }
        textLastName.setText("");
    }
    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
