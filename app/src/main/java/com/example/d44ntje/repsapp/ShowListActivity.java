package com.example.d44ntje.repsapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.example.d44ntje.repsapp.Adapter.ItemsAdapter;
import com.example.d44ntje.repsapp.DB.DatabaseSource;

import java.util.List;

public class ShowListActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private List<SportItem> mItemslist;
    private DatabaseSource datasource;

//    private ApiInterface apiService;
//    private TextView textView;
//    private List<SensorDataObject> dataItemList;
//    private RecyclerAdapter adapter;
//    private RecyclerAdapter mItemAdapter;

//    static final String SENSOR_API = "showListAdapter";
//    int i = 1;


    private ItemsAdapter itemAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));



        displayDataitems(datasource.getallReps());

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }


    private void displayDataitems(List<SportItem> list) {

        if (list != null) {

            itemAdapter = new ItemsAdapter(list, this);
            recyclerView.setAdapter(itemAdapter);
        } else {

            Toast.makeText(this, "list empty", Toast.LENGTH_SHORT).show();
        }
    }
}
