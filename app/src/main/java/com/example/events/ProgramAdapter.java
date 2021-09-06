package com.example.events;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

public class ProgramAdapter extends ArrayAdapter<String> {
    Context context;

    String[] events;
    String[] details;
    public ProgramAdapter(Context context, String[] events, String[] details) {
        super(context, R.layout.singlt_item,R.id.textView1,events);
        this.context = context;

        this.events = events;
        this.details = details;
    }

    @Override
    public View getView(int position, View convertView,ViewGroup parent) {

        View singleItem = convertView;
        ProgramViewHolder  holder = null;
        if (singleItem == null){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            singleItem = layoutInflater.inflate(R.layout.singlt_item,parent,false);
            holder = new ProgramViewHolder(singleItem);
            singleItem.setTag(holder);
        }
        else {
            holder = (ProgramViewHolder) singleItem.getTag();
        }

        holder.events.setText(events[position]);
        holder.details.setText(details[position]);
        singleItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), events[position], Toast.LENGTH_SHORT);
            }
        });
        return singleItem;
    }
}
