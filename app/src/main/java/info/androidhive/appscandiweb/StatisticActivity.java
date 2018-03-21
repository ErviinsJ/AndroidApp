package info.androidhive.appscandiweb;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import static android.R.id.input;
import static info.androidhive.appscandiweb.ProfileSettingsActivity.READ_BLOCK_SIZE;
import static info.androidhive.appscandiweb.R.id.PieChart;

public class StatisticActivity extends AppCompatActivity {


    public void backB(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }


    private float[] yData = {0.0f, 0.0f, 0.0f, 0.0f};
    private String[] xData = {"food and restaurants", "clothing", "entertainment", "saved"};

    String strSpendings = "";
    String monthTxt = "January.txt";
    float earnings = 0.0f;
    float spendings = 0.0f;
    float balance = 0.0f;

    PieChart pieChart;

    public void janB(View view) {
        nothingSelected();
        monthTxt = "January.txt";
        clearData();
        getData();
        addDataSet();
        reset_btn_background_color();
        final Button color_btn = (Button) findViewById(R.id.rd_jan_btn);
        color_btn.setBackgroundColor(Color.parseColor("#6956EC"));
    }
    public void febB(View view) {
        nothingSelected();
        monthTxt = "February.txt";
        clearData();
        getData();
        addDataSet();
        reset_btn_background_color();
        final Button color_btn = (Button) findViewById(R.id.rd_feb_btn);
        color_btn.setBackgroundColor(Color.parseColor("#6956EC"));
    }
    public void marchB(View view) {
        nothingSelected();
        monthTxt = "March.txt";
        clearData();
        getData();
        addDataSet();
        reset_btn_background_color();
        final Button color_btn = (Button) findViewById(R.id.rd_mar_btn);
        color_btn.setBackgroundColor(Color.parseColor("#6956EC"));
    }
    public void aprilB(View view) {
        nothingSelected();
        monthTxt = "April.txt";
        clearData();
        getData();
        addDataSet();
        reset_btn_background_color();
        final Button color_btn = (Button) findViewById(R.id.rd_apr_btn);
        color_btn.setBackgroundColor(Color.parseColor("#6956EC"));

    }
    public void mayB(View view) {
        nothingSelected();
        monthTxt = "May.txt";
        clearData();
        getData();
        addDataSet();
        reset_btn_background_color();
        final Button color_btn = (Button) findViewById(R.id.rd_may_btn);
        color_btn.setBackgroundColor(Color.parseColor("#6956EC"));
    }
    public void juneB(View view) {
        nothingSelected();
        monthTxt = "June.txt";
        clearData();
        getData();
        addDataSet();
        reset_btn_background_color();
        final Button color_btn = (Button) findViewById(R.id.rd_june_btn);
        color_btn.setBackgroundColor(Color.parseColor("#6956EC"));
    }
    public void julyB(View view) {
        nothingSelected();
        monthTxt = "July.txt";
        clearData();
        getData();
        addDataSet();
        reset_btn_background_color();
        final Button color_btn = (Button) findViewById(R.id.rd_july_btn);
        color_btn.setBackgroundColor(Color.parseColor("#6956EC"));
    }
    public void augB(View view) {
        nothingSelected();
        monthTxt = "August.txt";
        clearData();
        getData();
        addDataSet();
        reset_btn_background_color();
        final Button color_btn = (Button) findViewById(R.id.rd_aug_btn);
        color_btn.setBackgroundColor(Color.parseColor("#6956EC"));
    }
    public void septB(View view) {
        nothingSelected();
        monthTxt = "September.txt";
        clearData();
        getData();
        addDataSet();
        reset_btn_background_color();
        final Button color_btn = (Button) findViewById(R.id.rd_sep_btn);
        color_btn.setBackgroundColor(Color.parseColor("#6956EC"));
    }
    public void octB(View view) {
        nothingSelected();
        monthTxt = "October.txt";
        clearData();
        getData();
        addDataSet();
        reset_btn_background_color();
        final Button color_btn = (Button) findViewById(R.id.rd_oct_btn);
        color_btn.setBackgroundColor(Color.parseColor("#6956EC"));

    }
    public void novB(View view) {
        nothingSelected();
        monthTxt = "November.txt";
        clearData();
        getData();
        addDataSet();
        reset_btn_background_color();
        final Button color_btn = (Button) findViewById(R.id.rd_nov_btn);
        color_btn.setBackgroundColor(Color.parseColor("#6956EC"));
    }
    public void decB(View view) {
        nothingSelected();
        monthTxt = "December.txt";
        clearData();
        getData();
        addDataSet();
        reset_btn_background_color();
        final Button color_btn = (Button) findViewById(R.id.rd_dec_btn);
        color_btn.setBackgroundColor(Color.parseColor("#6956EC"));
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistic);

        final Button color_btn = (Button) findViewById(R.id.rd_jan_btn);
        color_btn.setBackgroundColor(Color.parseColor("#6956EC"));

        pieChart = (PieChart) findViewById(PieChart);

        getData();

//      properties of chart
        pieChart.setRotationEnabled(true);
        pieChart.setHoleColor(getResources().getColor(R.color.main_dark));
        pieChart.setHoleRadius(60f);
        pieChart.getDescription().setEnabled(false);
        pieChart.setTransparentCircleAlpha(0);
        pieChart.getLegend().setEnabled(false);
        pieChart.setDrawEntryLabels(false);
        pieChart.animateY(1000);

        addDataSet();


        pieChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {

            @Override
            public void onValueSelected(Entry e, Highlight h) {
                int pos1 = e.toString().indexOf("x: 0.0 y: ");
                String spent = e.toString().substring(pos1 + 10);
                for (int i = 0; i < yData.length; i++) {
                    if (yData[i] == Float.parseFloat(spent)) {
                        pos1 = i;
                        break;
                    }
                }


                final TextView amountSpent = (TextView) findViewById(R.id.amount_spent_text);
                amountSpent.setText(roundString(spent));
                final TextView whereSpent = (TextView) findViewById(R.id.description_text);
                whereSpent.setText(xData[pos1]);

                final ImageView where_img = (ImageView) findViewById(R.id.section_icon);
                switch(pos1) {
                    case 0:

                        where_img.setImageResource(R.drawable.fork);
                        break;
                    case 1:
                        where_img.setImageResource(R.drawable.clothing_pic);
                        break;
                    case 2:
                        where_img.setImageResource(R.drawable.entertainment_pic);
                        break;
                    case 3:
                        where_img.setImageResource(R.drawable.saved_pic);
                        break;
                }
            }


            @Override
            public void onNothingSelected() {

                nothingSelected();
            }
        });

    }

//    Resets description text
    private void nothingSelected(){
        final TextView amountSpent = (TextView) findViewById(R.id.amount_spent_text);
        amountSpent.setText("");
        final TextView whereSpent = (TextView) findViewById(R.id.description_text);
        whereSpent.setText("Tuch pie sections to see details");
        final ImageView where_img = (ImageView) findViewById(R.id.section_icon);
        where_img.setImageResource(R.drawable.trnsparent);
    }

//    Read data from text file
    private void getData(){

        try {
            FileInputStream fileIn=openFileInput(monthTxt);
            InputStreamReader InputRead= new InputStreamReader(fileIn);

            char[] inputBuffer= new char[READ_BLOCK_SIZE];
            String s="";
            int charRead;

            while ((charRead=InputRead.read(inputBuffer))>0) {
                // char to string conversion
                String readstring=String.copyValueOf(inputBuffer,0,charRead);
                s +=readstring;
            }
            strSpendings = s;
            InputRead.close();


        } catch (Exception e) {
            strSpendings = "";
            e.printStackTrace();
        }

    }

    private void clearData(){
        for (int i = 0; i < yData.length; i++) {
            yData[i] = 0.0f;

        }
    }

//    Rounds a string number to two decimal points
    private String roundString(String input){
        float flNumber = Float.parseFloat(input);
        input = String.format("%.2f", flNumber);
        return input;
    }

//    Resets background color to all month buttons
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

//    Adds data from input string to data array
    private void addDataSet() {

        int found = 0;
        int j = 0;
        int lastSemicol = 0;
            for (char ch: strSpendings.toCharArray()) {
                if (ch == ';')  {
                    found++;
                    switch(found) {
                        case 1:
                            yData[0] = Float.parseFloat(roundString(strSpendings.substring(0, j)));
                            lastSemicol = j;
                            break;
                        case 2:

                            yData[1] = Float.parseFloat(roundString(strSpendings.substring(lastSemicol+1, j)));
                            lastSemicol = j;
                            break;
                        case 3:

                            yData[2] = Float.parseFloat(roundString(strSpendings.substring(lastSemicol+1, j)));
                            lastSemicol = j;

                            break;
                        case 4:
                            yData[3]= Float.parseFloat(roundString(strSpendings.substring(lastSemicol+1, j)))
                                    - yData[0] - yData[1] - yData[2];
                            earnings = Float.parseFloat(roundString(strSpendings.substring(lastSemicol+1, j)));
                            balance = yData[3];
                            if(yData[3] <0 ){yData[3] = 0;}
                            break;
                    }
                }
                j++;
            }
        if (found == 0){
            for (int i=0; i<4; i++){
                yData[i]=0.0f;
            }
            earnings = 0.0f;
            balance = 0.0f;
            final TextView whereSpent = (TextView) findViewById(R.id.description_text);
            whereSpent.setText("No data available for this month");
        }

//        sets text to text inside pie chart center
        if (balance >= 0) {
            float cents = (yData[3] % 1) * 100;
            TextView bTextView = (TextView) findViewById(R.id.stat_dolars);
            bTextView.setText("$" + String.valueOf((int) yData[3]));
            TextView mTextView = (TextView) findViewById(R.id.stat_cents);
            mTextView.setText(String.valueOf((int) cents));
        }else if (balance < 0){
            float cents = ((balance*(-1)) % 1) * 100;
            TextView bTextView = (TextView) findViewById(R.id.stat_dolars);
            bTextView.setText("-$" + String.valueOf((int) (balance*(-1))));
            TextView mTextView = (TextView) findViewById(R.id.stat_cents);
            mTextView.setText(String.valueOf((int) cents));

        }


//        sets text to monthly income
        float posCents = (earnings % 1) * 100;
        TextView posDolTextView = (TextView)findViewById(R.id.positive_dolars);
        posDolTextView.setText(String.valueOf((int)earnings));
        TextView posCentTextView = (TextView)findViewById(R.id.positive_cents);
        posCentTextView.setText(String.valueOf((int)posCents));

//        sets text to monthly spendings
        spendings = yData[0] + yData[1] + yData[2];
        float negCents = (spendings % 1) * 100;
        TextView negDolTextView = (TextView)findViewById(R.id.negative_dolars);
        negDolTextView.setText(String.valueOf((int)spendings));
        TextView negCentTextView = (TextView)findViewById(R.id.negative_cents);
        negCentTextView.setText(String.valueOf((int)negCents));


        ArrayList<PieEntry> yEntrys = new ArrayList<>();
        ArrayList<String> xEntrys = new ArrayList<>();


        for (int i = 0; i < yData.length; i++) {
            yEntrys.add(new PieEntry(yData[i], i));
        }


        for (int i = 1; i < xData.length; i++) {
            xEntrys.add(xData[i]);
        }


//        create the data set
        PieDataSet pieDataSet = new PieDataSet(yEntrys, "amount spent");
        pieDataSet.setSliceSpace(2);
        pieDataSet.setValueTextSize(0);



//        add colors to dataset
        ArrayList<Integer> colors = new ArrayList<>();

        colors.add(Color.parseColor("#16A085"));
        colors.add(Color.parseColor("#FACE15"));
        colors.add(Color.parseColor("#8D4DE8"));
        colors.add(Color.parseColor("#0E0F1A"));

        pieDataSet.setColors(colors);

        Color.parseColor("#16A085");

//        create pie data object
        PieData pieData = new PieData(pieDataSet);
        pieChart.setData(pieData);
        pieChart.invalidate();
    }



}
