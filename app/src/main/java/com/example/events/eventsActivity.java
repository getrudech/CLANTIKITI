package com.example.events;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class eventsActivity extends AppCompatActivity {

    @BindView(R.id.lvProgram1) ListView mlvprograms;
    @BindView(R.id.areaTextView) TextView mAreaTextView;

    private String[] events = new String[] {"Camp Mulala", "Concerts Dindi", "Beatsdrip", "Viking ", "souls and seas", "All about that bass", "Omah ley", "Camp Kikiwaka", "Camp Mulala", "La bata", "Smokehouse ", "tanqueray", "halsey's Bar", "Pop music", "turn up", "Mi casa" };
    private String[] details = new String[] {"sept 10th", "April 9th", "Sept 6th", "January 6th", "Feb 4th", "march 20th", "dec 5th", "aug 4th", "may 5th", "june 3rd", "april 6th", "may 3rd", " feb 4th", "dec 5th", "oct 6th", "frb 14th" };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area);
        ButterKnife.bind(this);
        ProgramAdapter programAdapter = new ProgramAdapter(this, events, details);
        mlvprograms.setAdapter(programAdapter);
        Intent intent = getIntent();
        String area = intent.getStringExtra("area");
        mAreaTextView.setText("Here are all the events near " + area);
    }}