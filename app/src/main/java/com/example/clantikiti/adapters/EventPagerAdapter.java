package com.example.clantikiti.adapters;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.clantikiti.UI.EventDetailFragment;
import com.example.clantikiti.models.Events;

import java.util.List;

public class EventPagerAdapter extends FragmentStatePagerAdapter /*FragmentStateAdapter*/ {

    private List<Events> mProperties;

    public EventPagerAdapter(@NonNull FragmentManager fm, int behavior, List<Events> properties) {
        super(fm, behavior);
        mProperties = properties;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return EventDetailFragment.newInstance(mProperties.get(position));
    }

    @Override
    public int getCount() {
        //return mProperties == null ? 0 : mProperties.size();
        Log.d("properties", mProperties.get(0).getName());
        return mProperties.size();
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return mProperties.get(position).getName();
    }
}
