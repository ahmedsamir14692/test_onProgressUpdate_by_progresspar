package com.example.ahmed.syntask1;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ProgressBar progressBar;
    ArrayAdapter<String> arrayAdapter;
    String array[]={

        "ahmed","ahmed",
                "ahmed","ahmed", "ahmed","ahmed", "ahmed","ahmed", "ahmed","ahmed", "ahmed","ahmed",
                "ahmed","ahmed", "ahmed","ahmed", "ahmed","ahmed", "ahmed","ahmed", "ahmed","ahmed",
                "ahmed","ahmed",  "ahmed","ahmed","ahmed","ahmed","ahmed","ahmed","ahmed","ahmed",
                "ahmed","ahmed","ahmed","ahmed","ahmed","ahmed","ahmed","ahmed","ahmed","ahmed",

                "ahmed","ahmed", "ahmed","ahmed", "ahmed","ahmed", "ahmed","ahmed", "ahmed","ahmed",
                "ahmed","ahmed", "ahmed","ahmed", "ahmed","ahmed", "ahmed","ahmed", "ahmed","ahmed",
                "ahmed","ahmed",  "ahmed","ahmed","ahmed","ahmed","ahmed","ahmed","ahmed","ahmed",
                "ahmed","ahmed","ahmed","ahmed","ahmed","ahmed","ahmed","ahmed","ahmed","ahmed","ahmed","ahmed",
                "ahmed","ahmed", "ahmed","ahmed", "ahmed","ahmed", "ahmed","ahmed", "ahmed","ahmed",
                "ahmed","ahmed", "ahmed","ahmed", "ahmed","ahmed", "ahmed","ahmed", "ahmed","ahmed",
                "ahmed","ahmed",  "ahmed","ahmed","ahmed","ahmed","ahmed","ahmed","ahmed","ahmed",
                "ahmed","ahmed","ahmed","ahmed","ahmed","ahmed","ahmed","ahmed","ahmed","ahmed"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        listView= (ListView) findViewById(R.id.listView);
        arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,new ArrayList<String>());
        progressBar= (ProgressBar) findViewById(R.id.progressBar);
        listView.setAdapter(arrayAdapter);
        new tryy().execute();



    }

    class tryy extends AsyncTask<Void,String,Void>{
int count =0;
        @Override
        protected void onPreExecute() {
           progressBar.setVisibility(View.INVISIBLE);
        }

        @Override
        protected Void doInBackground(Void... params) {

            for ( String item:array){
                count++;

                publishProgress(item);


                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


                return null;
        }

        @Override
        protected void onProgressUpdate(String... values) {
           progressBar.setVisibility(View.VISIBLE);
            progressBar.setMax(array.length);

           arrayAdapter.add(values[0]);
           progressBar.setProgress(count);
        }

        @Override
        protected void onPostExecute(Void aVoid) {
           progressBar.setVisibility(View.INVISIBLE);
        }
    }
}
