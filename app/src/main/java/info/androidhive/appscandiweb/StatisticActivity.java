package info.androidhive.appscandiweb;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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

import java.util.ArrayList;

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

    PieChart pieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistic);

        pieChart = (PieChart) findViewById(PieChart);


        //pieChart.setDescription("");

        pieChart.setRotationEnabled(true);

        //pieChart.setUsePercentValues(true);
        pieChart.setHoleColor(getResources().getColor(R.color.main_dark));
        //pieChart.setCenterTextColor(Color.BLACK);

        pieChart.setHoleRadius(60f);
        pieChart.getDescription().setEnabled(false);
        pieChart.setTransparentCircleAlpha(0);
        pieChart.getLegend().setEnabled(false);

        pieChart.setDrawEntryLabels(false);
        //pieChart.setEntryLabelTextSize(20);
        //More options just check out the documentation!


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


    private void addDataSet() {


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
        pieDataSet.setValueTextSize(12);

        pieChart.animateY(1000);

        //add colors to dataset

        ArrayList<Integer> colors = new ArrayList<>();

        colors.add(Color.parseColor("#16A085"));
        colors.add(Color.parseColor("#FACE15"));
        colors.add(Color.parseColor("#8D4DE8"));
        colors.add(Color.GRAY);
        colors.add(Color.MAGENTA);
        colors.add(Color.BLUE);

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
