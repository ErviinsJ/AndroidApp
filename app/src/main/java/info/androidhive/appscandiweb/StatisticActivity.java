package info.androidhive.appscandiweb;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import static android.R.attr.y;
import static android.R.attr.yesNoPreferenceStyle;
import static info.androidhive.appscandiweb.ProfileSettingsActivity.READ_BLOCK_SIZE;
import static info.androidhive.appscandiweb.R.id.PieChart;

public class StatisticActivity extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    public void backB(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


    private float[] yData = {240.0f, 270.0f, 220.0f, 70.0f};
    private String[] xData = {"food and restaurants", "clothing", "entertainment", "saved"};

    String strSpendings = "";
    String monthTxt = "January.txt";
    float earnings = 0.0f;
    float spendings = 0.0f;

    PieChart pieChart;

    public void janB(View view) {
        monthTxt = "January.txt";
        getData();
        addDataSet();
        reset_btn_background_color();
        final Button color_btn = (Button) findViewById(R.id.rd_jan_btn);
        color_btn.setBackgroundColor(Color.parseColor("#6956EC"));
    }
    public void febB(View view) {
        monthTxt = "February.txt";
        getData();
        addDataSet();
        reset_btn_background_color();
        final Button color_btn = (Button) findViewById(R.id.rd_feb_btn);
        color_btn.setBackgroundColor(Color.parseColor("#6956EC"));
    }
    public void marchB(View view) {
        monthTxt = "March.txt";
        getData();
        addDataSet();
        reset_btn_background_color();
        final Button color_btn = (Button) findViewById(R.id.rd_mar_btn);
        color_btn.setBackgroundColor(Color.parseColor("#6956EC"));
    }
    public void aprilB(View view) {
        monthTxt = "April.txt";
        getData();
        addDataSet();
        reset_btn_background_color();
        final Button color_btn = (Button) findViewById(R.id.rd_apr_btn);
        color_btn.setBackgroundColor(Color.parseColor("#6956EC"));
    }
    public void mayB(View view) {
        monthTxt = "May.txt";
        getData();
        addDataSet();
        reset_btn_background_color();
        final Button color_btn = (Button) findViewById(R.id.rd_may_btn);
        color_btn.setBackgroundColor(Color.parseColor("#6956EC"));
    }
    public void juneB(View view) {
        monthTxt = "June.txt";
        getData();
        addDataSet();
        reset_btn_background_color();
        final Button color_btn = (Button) findViewById(R.id.rd_june_btn);
        color_btn.setBackgroundColor(Color.parseColor("#6956EC"));
    }
    public void julyB(View view) {
        monthTxt = "July.txt";
        getData();
        addDataSet();
        reset_btn_background_color();
        final Button color_btn = (Button) findViewById(R.id.rd_july_btn);
        color_btn.setBackgroundColor(Color.parseColor("#6956EC"));
    }
    public void augB(View view) {
        monthTxt = "August.txt";
        getData();
        addDataSet();
        reset_btn_background_color();
        final Button color_btn = (Button) findViewById(R.id.rd_aug_btn);
        color_btn.setBackgroundColor(Color.parseColor("#6956EC"));
    }
    public void septB(View view) {
        monthTxt = "September.txt";
        getData();
        addDataSet();
        reset_btn_background_color();
        final Button color_btn = (Button) findViewById(R.id.rd_sep_btn);
        color_btn.setBackgroundColor(Color.parseColor("#6956EC"));
    }
    public void octB(View view) {
        monthTxt = "October.txt";
        getData();
        addDataSet();
        reset_btn_background_color();
        final Button color_btn = (Button) findViewById(R.id.rd_oct_btn);
        color_btn.setBackgroundColor(Color.parseColor("#6956EC"));
    }
    public void novB(View view) {
        monthTxt = "November.txt";
        getData();
        addDataSet();
        reset_btn_background_color();
        final Button color_btn = (Button) findViewById(R.id.rd_nov_btn);
        color_btn.setBackgroundColor(Color.parseColor("#6956EC"));
    }
    public void decB(View view) {
        monthTxt = "December.txt";
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

        pieChart = (PieChart) findViewById(PieChart);

        getData();



        pieChart.setRotationEnabled(true);

        //pieChart.setUsePercentValues(true);
        pieChart.setHoleColor(getResources().getColor(R.color.main_dark));
        //pieChart.setCenterTextColor(Color.BLACK);

        pieChart.setHoleRadius(60f);
        pieChart.getDescription().setEnabled(false);
        pieChart.setTransparentCircleAlpha(0);
        pieChart.getLegend().setEnabled(false);
        pieChart.setDrawEntryLabels(false);


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

                String places = xData[pos1];
                final TextView amountSpent = (TextView) findViewById(R.id.amount_spent_text);
                amountSpent.setText(spent);
                final TextView whereSpent = (TextView) findViewById(R.id.description_text);
                whereSpent.setText(places);
            }


            @Override

            public void onNothingSelected() {

            }
        });

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }
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
            e.printStackTrace();
        }

    }

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

    private void addDataSet() {


        int found = 0;
        int j = 0;
        int lastSemicol = 0;
            for (char ch: strSpendings.toCharArray()) {
                if (ch == ';')  {
                    found++;
                    switch(found) {
                        case 1:

                            yData[0] = Float.parseFloat(strSpendings.substring(0, j));
                            lastSemicol = j;
                            break;
                        case 2:

                            yData[1] = Float.parseFloat(strSpendings.substring(lastSemicol+1, j));
                            lastSemicol = j;
                            break;
                        case 3:

                            yData[2] = Float.parseFloat(strSpendings.substring(lastSemicol+1, j));
                            lastSemicol = j;

                            break;
                        case 4:
                            yData[3]= Float.parseFloat(strSpendings.substring(lastSemicol+1, j))
                                    - yData[0] - yData[1] - yData[2];
                            earnings = Float.parseFloat(strSpendings.substring(lastSemicol+1, j));
                            if(yData[3] <0 ){yData[3] = 0;}
                            break;
                    }

                }
                j++;
            }


        float snumb = (yData[3] % 1) * 100;
        TextView bTextView = (TextView)findViewById(R.id.stat_dolars);
        bTextView.setText(String.valueOf((int)yData[3]));
        TextView mTextView = (TextView)findViewById(R.id.stat_cents);
        mTextView.setText(String.valueOf((int)snumb));


        float posCents = (earnings % 1) * 100;
        TextView posDolTextView = (TextView)findViewById(R.id.positive_dolars);
        posDolTextView.setText(String.valueOf((int)earnings));
        TextView posCentTextView = (TextView)findViewById(R.id.positive_cents);
        posCentTextView.setText(String.valueOf((int)posCents));

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


        //create the data set
        PieDataSet pieDataSet = new PieDataSet(yEntrys, "amount spent");
        pieDataSet.setSliceSpace(2);
        pieDataSet.setValueTextSize(0);

        pieChart.animateY(1000);

        //add colors to dataset

        ArrayList<Integer> colors = new ArrayList<>();

        colors.add(Color.parseColor("#16A085"));
        colors.add(Color.parseColor("#FACE15"));
        colors.add(Color.parseColor("#8D4DE8"));
        colors.add(Color.parseColor("#0E0F1A"));

        pieDataSet.setColors(colors);

        //create pie data object
        PieData pieData = new PieData(pieDataSet);
        pieChart.setData(pieData);
        pieChart.invalidate();
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Statistic Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
