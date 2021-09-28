package com.example.clantikiti.UI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.clantikiti.Constants;
import com.example.clantikiti.R;
import com.example.clantikiti.adapters.EventListAdapter;
import com.example.clantikiti.models.Events;
import com.example.clantikiti.network.API;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class event_location extends AppCompatActivity {
    @BindView(R.id.recyclerView2) RecyclerView mRecyclerView2;
    @BindView(R.id.errorTextView2) TextView mErrorTextView2;
    @BindView(R.id.progressBar2) ProgressBar mProgressBar2;

    private EventListAdapter mAdapter;
    public List<Events> restaurants;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_location);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String location = intent.getStringExtra("location");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        API api = retrofit.create(API.class);

        Call<List<Events>> call = api.getEvents();

        call.enqueue(new Callback<List<Events>>() {
            @Override
            public void onResponse(Call<List<Events>> call, Response<List<Events>> response) {
                hideProgressBar();

                if (response.isSuccessful()) {
                    restaurants = response.body();
                    mAdapter = new EventListAdapter(event_location.this, restaurants);
                    mRecyclerView2.setAdapter(mAdapter);
                    RecyclerView.LayoutManager layoutManager =
                            new LinearLayoutManager(event_location.this);
                    mRecyclerView2.setLayoutManager(layoutManager);
                    mRecyclerView2.setHasFixedSize(true);

                    showRestaurants();

                } else {
                    //Log.d(TAG, "onResponse: "+ restaurants);
                    showUnsuccessfulMessage();
                }
            }

            @Override
            public void onFailure(Call<List<Events>> call, Throwable t) {
                Toast.makeText(event_location.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                hideProgressBar();
                //Log.d(TAG, "onFailure: ", t);
                showFailureMessage();

            }
        });
    }
    private void showFailureMessage() {
        mErrorTextView2.setText("Something went wrong. Please check your Internet connection and try again later");
        mErrorTextView2.setVisibility(View.VISIBLE);
    }

    private void showUnsuccessfulMessage() {
        mErrorTextView2.setText("Something went wrong. Please try again later");
        mErrorTextView2.setVisibility(View.VISIBLE);
    }

    private void showRestaurants() {
        mRecyclerView2.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar() {
        mProgressBar2.setVisibility(View.GONE);
    }
}