package info.androidhive.appscandiweb;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
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
    String monthName = "January";
    String monthTxt = "January.txt";


//    Month selection buttons
    public void janB(View view) {

        monthTxt = "January.txt";
        monthName = "January";
        final TextView main_text = (TextView) findViewById(R.id.current_month);
        main_text.setText(monthName);
        reset_btn_background_color();
        final Button color_btn = (Button) findViewById(R.id.rd_jan_btn);
        color_btn.setBackgroundColor(Color.parseColor("#6956EC"));
    }
    public void febB(View view) {

        monthTxt = "February.txt";
        monthName = "February";
        final TextView main_text = (TextView) findViewById(R.id.current_month);
        main_text.setText(monthName);
        reset_btn_background_color();
        final Button color_btn = (Button) findViewById(R.id.rd_feb_btn);
        color_btn.setBackgroundColor(Color.parseColor("#6956EC"));
    }
    public void marchB(View view) {
        monthTxt = "March.txt";
        monthName = "March";
        final TextView main_text = (TextView) findViewById(R.id.current_month);
        main_text.setText(monthName);
        reset_btn_background_color();
        final Button color_btn = (Button) findViewById(R.id.rd_mar_btn);
        color_btn.setBackgroundColor(Color.parseColor("#6956EC"));
    }
    public void aprilB(View view) {
        monthTxt = "April.txt";
        monthName = "April";
        final TextView main_text = (TextView) findViewById(R.id.current_month);
        main_text.setText(monthName);
        reset_btn_background_color();
        final Button color_btn = (Button) findViewById(R.id.rd_apr_btn);
        color_btn.setBackgroundColor(Color.parseColor("#6956EC"));
    }
    public void mayB(View view) {
        monthTxt = "May.txt";
        monthName = "May";
        final TextView main_text = (TextView) findViewById(R.id.current_month);
        main_text.setText(monthName);
        reset_btn_background_color();
        final Button color_btn = (Button) findViewById(R.id.rd_may_btn);
        color_btn.setBackgroundColor(Color.parseColor("#6956EC"));
    }
    public void juneB(View view) {

        monthTxt = "June.txt";
        monthName = "June";
        final TextView main_text = (TextView) findViewById(R.id.current_month);
        main_text.setText(monthName);
        reset_btn_background_color();
        final Button color_btn = (Button) findViewById(R.id.rd_june_btn);
        color_btn.setBackgroundColor(Color.parseColor("#6956EC"));
    }

    public void julyB(View view) {

        monthTxt = "July.txt";
        monthName = "July";
        final TextView main_text = (TextView) findViewById(R.id.current_month);
        main_text.setText(monthName);
        reset_btn_background_color();
        final Button color_btn = (Button) findViewById(R.id.rd_july_btn);
        color_btn.setBackgroundColor(Color.parseColor("#6956EC"));
    }
    public void augB(View view) {

        monthTxt = "August.txt";
        monthName = "August";
        final TextView main_text = (TextView) findViewById(R.id.current_month);
        main_text.setText(monthName);
        reset_btn_background_color();
        final Button color_btn = (Button) findViewById(R.id.rd_aug_btn);
        color_btn.setBackgroundColor(Color.parseColor("#6956EC"));
    }
    public void septB(View view) {

        monthTxt = "September.txt";
        monthName = "September";
        final TextView main_text = (TextView) findViewById(R.id.current_month);
        main_text.setText(monthName);
        reset_btn_background_color();
        final Button color_btn = (Button) findViewById(R.id.rd_sep_btn);
        color_btn.setBackgroundColor(Color.parseColor("#6956EC"));
    }
    public void octB(View view) {

        monthTxt = "October.txt";
        monthName = "October";
        final TextView main_text = (TextView) findViewById(R.id.current_month);
        main_text.setText(monthName);
        reset_btn_background_color();
        final Button color_btn = (Button) findViewById(R.id.rd_oct_btn);
        color_btn.setBackgroundColor(Color.parseColor("#6956EC"));
    }
    public void novB(View view) {

        monthTxt = "November.txt";
        monthName = "November";
        final TextView main_text = (TextView) findViewById(R.id.current_month);
        main_text.setText(monthName);
        reset_btn_background_color();
        final Button color_btn = (Button) findViewById(R.id.rd_nov_btn);
        color_btn.setBackgroundColor(Color.parseColor("#6956EC"));
    }
    public void decB(View view) {

        monthTxt = "December.txt";
        monthName = "December";
        final TextView main_text = (TextView) findViewById(R.id.current_month);
        main_text.setText(monthName);
        reset_btn_background_color();
        final Button color_btn = (Button) findViewById(R.id.rd_dec_btn);
        color_btn.setBackgroundColor(Color.parseColor("#6956EC"));
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        textmsgInc=(EditText)findViewById(R.id.edit_income);
        textmsgFood=(EditText)findViewById(R.id.edit_food);
        textmsgCloth=(EditText)findViewById(R.id.edit_clothing);
        textmsgEnt=(EditText)findViewById(R.id.edit_entertainment);

        final Button color_btn = (Button) findViewById(R.id.rd_jan_btn);
        color_btn.setBackgroundColor(Color.parseColor("#6956EC"));
    }
//    write text to file
    public void changeBtn(View v) {
        str =  textmsgFood.getText().toString() + ";" + textmsgCloth.getText().toString() + ";"
                +textmsgEnt.getText().toString() + ";" + textmsgInc.getText().toString() + ";" ;


        try {
            FileOutputStream fileout=openFileOutput(monthTxt, MODE_PRIVATE);
            OutputStreamWriter outputWriter=new OutputStreamWriter(fileout);
            outputWriter.write(str);
            outputWriter.close();

            Toast.makeText(getBaseContext(),  monthName + " data updated successfully!",
                    Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            e.printStackTrace();
        }
        textmsgInc.setText("");
        textmsgFood.setText("");
        textmsgCloth.setText("");
        textmsgEnt.setText("");
    }

    public void deleteBtn(View view) {
        try {
            deleteFile(monthTxt);
            Toast.makeText(getBaseContext(), monthName + " data deleted successfully!",
                    Toast.LENGTH_SHORT).show();

        } catch (Exception e){
            e.printStackTrace();
        }
    }

//    Resets background color to all buttons
    private void reset_btn_background_color(){
        final Button jan_btn = (Button) findViewById(R.id.rd_jan_btn);
        jan_btn.setBackgroundColor(Color.parseColor("#0E0F1A"));
        final Button feb_btn = (Button) findViewById(R.id.rd_feb_btn);
        feb_btn.setBackgroundColor(Color.parseColor("#0E0F1A"));
        final Button march_btn = (Button) findViewById(R.id.rd_mar_btn);
        march_btn.setBackgroundColor(Color.parseColor("#0E0F1A"));
        final Button april_btn = (Button) findViewById(R.id.rd_apr_btn);
        april_btn.setBackgroundColor(Color.parseColor("#0E0F1A"));
        final Button may_btn = (Button) findViewById(R.id.rd_may_btn);
        may_btn.setBackgroundColor(Color.parseColor("#0E0F1A"));
        final Button june_btn = (Button) findViewById(R.id.rd_june_btn);
        june_btn.setBackgroundColor(Color.parseColor("#0E0F1A"));
        final Button july_btn = (Button) findViewById(R.id.rd_july_btn);
        july_btn.setBackgroundColor(Color.parseColor("#0E0F1A"));
        final Button aug_btn = (Button) findViewById(R.id.rd_aug_btn);
        aug_btn.setBackgroundColor(Color.parseColor("#0E0F1A"));
        final Button sep_btn = (Button) findViewById(R.id.rd_sep_btn);
        sep_btn.setBackgroundColor(Color.parseColor("#0E0F1A"));
        final Button oct_btn = (Button) findViewById(R.id.rd_oct_btn);
        oct_btn.setBackgroundColor(Color.parseColor("#0E0F1A"));
        final Button nov_btn = (Button) findViewById(R.id.rd_nov_btn);
        nov_btn.setBackgroundColor(Color.parseColor("#0E0F1A"));
        final Button dec_btn = (Button) findViewById(R.id.rd_dec_btn);
        dec_btn.setBackgroundColor(Color.parseColor("#0E0F1A"));

    }



}
