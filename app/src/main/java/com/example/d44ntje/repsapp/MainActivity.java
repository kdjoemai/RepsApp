package com.example.d44ntje.repsapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.d44ntje.repsapp.DB.DatabaseSource;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import android.widget.ArrayAdapter;


public class MainActivity extends AppCompatActivity {

    private static List<SportItem> mItems = new ArrayList<>();
//    private static Iterator<SportItem> iterator;
//    private ArrayAdapter<SportItem> adapter;
    private Spinner s;
    private Button plus, add, save, showList;
    private TextView editExercisName, editTextREP1, editTextREP2, editTextREP3, editTextTime;
    private int cels = 0;
    private boolean handledClick = false;

    private DatabaseSource datasource;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        add = (Button) findViewById(R.id.buttonAdd);
        plus = (Button) findViewById(R.id.buttonPlus);
        save = (Button) findViewById(R.id.buttonSave);
        showList = (Button) findViewById(R.id.buttonShowList);

        editExercisName = (TextView) findViewById(R.id.editExercis);
        editTextREP1 = (TextView) findViewById(R.id.editTextREP1);
        editTextREP2 = (TextView) findViewById(R.id.editTextREP2);
        editTextREP3 = (TextView) findViewById(R.id.editTextREP3);
        editTextTime = (TextView) findViewById(R.id.editTextTime);


//        updateUI();

        datasource = new DatabaseSource(this);
        datasource.open();
//        if (mItems.size() == 0) {
//            createData();
//            mItems = datasource.findAll();
////
//        }

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!(editExercisName.getText().toString().length() == 0)) {
                    mItems.add(new SportItem(editExercisName.getText().toString()));
                    editExercisName.setText("");
                } else {
                    Toast.makeText(MainActivity.this,
                            "Write and exersice name or sellect an exersice", Toast.LENGTH_SHORT).show();
                }
            }
        });

//        mItems = datasource.findAll();

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!handledClick) {

                    if (cels == 0) {
                        editTextREP2.setVisibility(View.VISIBLE);
                        cels++;
                    } else if (cels == 1) {
                        editTextREP3.setVisibility(View.VISIBLE);
                        cels++;
                    } else if (cels >= 2) {
                        cels = 0;
                        editTextREP2.setVisibility(View.INVISIBLE);
                        editTextREP3.setVisibility(View.INVISIBLE);
                    }


                }
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!(editExercisName.getText().toString().length() == 0) || !(editTextTime.getText().toString().length() == 0)) {
                    //if name != null && exercisVal != null

                      /*
        * Tour tour = new Tour();
		tour.setTitle("Salton Sea");
		tour.setDescription("A tour to Salton Sea");
		tour.setPrice(600);
		tour.setImage("salton_sea");
		tour = datasource.create(tour);
		Log.i(LOGTAG, "Tour created with id " + tour.getId());

        * */
                    SportItem sportItem = new SportItem();
                    sportItem.setName(editExercisName.getText().toString());

                    if (!(editTextREP1.getText().toString().length() == 0)) {
                        Toast.makeText(MainActivity.this,
                                editExercisName.getText().toString(), Toast.LENGTH_SHORT).show();

                        sportItem.setRep1(editTextREP1.getText().charAt(0));
                    }

                    if ((!(editTextTime.getText().toString().length() == 0))) {
                        Toast.makeText(MainActivity.this,
                                "time", Toast.LENGTH_SHORT).show();
                        sportItem.setTime(editTextTime.getText().charAt(0));
                    }

                    datasource.open();
                    datasource.createRep(sportItem);

//                    datasource.addNew(sportItem);
                    Toast.makeText(MainActivity.this,
                            "edded", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(MainActivity.this,
                            "Enter reps or time", Toast.LENGTH_SHORT).show();
                }
            }
        });

        showList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this, ShowListActivity.class);
                startActivity(i);



//                ArrayAdapter<SportItem> adapter = new ArrayAdapter<SportItem>(MainActivity.this,
//                        android.R.layout.simple_list_item_1, mItems);
//                setListAdapter(adapter);
//                display("all data", datasource.findAll());


            }
        });
    }

    public void display(String title, List<SportItem> message) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message.toString());
        builder.show();
    }

    private void createData() {

//        SportItem sportItem = new SportItem("hva");
//        sportItem = datasource.createRep(sportItem);
//        Log.i("MAIN", "id: " + sportItem.getId());
//
//        sportItem = new SportItem("Wecity");
//        sportItem = datasource.create(sportItem);
//        Log.i("MAIN", "id: " + sportItem.getId());
    }

//    private void updateUI() {
//
//        // If the list adapter is null, a new one will be instantiated and set on our list view.
//
//        if (adapter == null) {
////            // We can use ‘this’ for the context argument because an Activity is a subclass of the Context class.
////            // The ‘android.R.layout.simple_list_item_1’ argument refers to the simple_list_item_1 layout of the Android layout directory.
////            mAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mItems);
////            mListView.setAdapter(mAdapter);
//
//            Spinner s = (Spinner) findViewById(R.id.spinner1);
//
//
//            ArrayAdapter<SportItem> adapter = new ArrayAdapter<SportItem>(this,
//                    android.R.layout.simple_dropdown_item_1line, mItems);
////            mItems.add(mItems.);
//
////            mItems.add(new SportItem("that"));
////            mItems.add(new SportItem("thow"));
//
//            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//
//            s.setAdapter(adapter);
//
//
//        } else {
//
//            // When the adapter is not null, it has to know what to do when our dataset changes, when a change happens we need to call this method on the adapter so that it will update internally.
//
//            adapter.notifyDataSetChanged();
//        }
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
