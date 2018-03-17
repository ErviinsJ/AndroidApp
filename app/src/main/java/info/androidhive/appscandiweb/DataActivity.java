package info.androidhive.appscandiweb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class DataActivity extends AppCompatActivity {


    public void backB(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    EditText textmsgInc;
    EditText textmsgFood;
    EditText textmsgCloth;
    EditText textmsgEnt;
    String str = "";
    String monthTxt = "January.txt";




    static final int READ_BLOCK_SIZE = 100;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        textmsgInc=(EditText)findViewById(R.id.edit_income);
        textmsgFood=(EditText)findViewById(R.id.edit_food);
        textmsgCloth=(EditText)findViewById(R.id.edit_clothing);
        textmsgEnt=(EditText)findViewById(R.id.edit_entertainment);
    }
    // write text to file
    public void changeBtn(View v) {
        // add-write text into file
        str =  textmsgFood.getText().toString() + ";" + textmsgCloth.getText().toString() + ";"
                +textmsgEnt.getText().toString() + ";" + textmsgInc.getText().toString() + ";" ;
        try {
            FileOutputStream fileout=openFileOutput(monthTxt, MODE_PRIVATE);
            OutputStreamWriter outputWriter=new OutputStreamWriter(fileout);
            outputWriter.write(str);
            outputWriter.close();

            //display file saved message
            Toast.makeText(getBaseContext(), "File saved successfully!",
                    Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
