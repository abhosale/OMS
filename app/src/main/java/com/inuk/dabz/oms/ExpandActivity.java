package com.inuk.dabz.oms;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExpandActivity extends AppCompatActivity {

    private ExpandableListView  expandListView;
    private List<String> parentHeaderInformation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expand);


        parentHeaderInformation = new ArrayList<String>();
        parentHeaderInformation.add("Cars");
        parentHeaderInformation.add("Houses");
        parentHeaderInformation.add("Football Clubs");
        HashMap<String, List<String>> allChildItems = returnGroupedChildItems();
        expandListView = (ExpandableListView)findViewById(R.id.expandableListView);
        ExpandListViewAdapter expandableListViewAdapter = new ExpandListViewAdapter(getApplicationContext(), parentHeaderInformation, allChildItems);
        expandListView.setAdapter(expandableListViewAdapter);

    }

    private HashMap<String, List<String>> returnGroupedChildItems(){
        HashMap<String, List<String>> childContent = new HashMap<String, List<String>>();
        List<String> cars = new ArrayList<String>();
        cars.add("Volvo");
        cars.add("BMW");
        cars.add("Toyota");
        cars.add("Nissan");
        List<String> houses = new ArrayList<String>();
        houses.add("Duplex");
        houses.add("Twin Duplex");
        houses.add("Bungalow");
        houses.add("Two Storey");
        List<String> footballClubs = new ArrayList<String>();
        footballClubs.add("Liverpool");
        footballClubs.add("Arsenal");
        footballClubs.add("Stoke City");
        footballClubs.add("West Ham");
        childContent.put(parentHeaderInformation.get(0), cars);
        childContent.put(parentHeaderInformation.get(1), cars);
        childContent.put(parentHeaderInformation.get(2), cars);
        return childContent;

    }

}
