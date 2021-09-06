package com.example.events;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ProgramViewHolder {


    TextView events;
    TextView details;

    ProgramViewHolder(View view){
        events= view.findViewById(R.id.textView1);
        details = view.findViewById(R.id.textView2);
    }
}
