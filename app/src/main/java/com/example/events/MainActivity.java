package com.example.events;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView (R.id.viewAllButton) Button mViewAllevents;
    @BindView (R.id.searchItemEditText) EditText mItemToSearch;
    @BindView (R.id.searchButton) Button mSearchItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mViewAllevents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            //Toast.makeText(MainActivity.this, "Hello World!", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(MainActivity.this, ViewAllActivity.class);
            startActivity(intent);
            }
        });

        mSearchItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String area = mItemToSearch.getText().toString();
                if (area.equals("")) {
                    Toast.makeText(MainActivity.this, "Please Enter desired location... ", Toast.LENGTH_SHORT).show();
                    return;
                }
                else{
                    Toast.makeText(MainActivity.this, "Searching for upcoming events... ", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, eventsActivity.class);
                    intent.putExtra("area", area);
                    startActivity(intent);
                }
            }
        });
    }
}