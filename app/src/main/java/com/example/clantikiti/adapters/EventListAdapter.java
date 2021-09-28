package com.example.clantikiti.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.clantikiti.R;
import com.example.clantikiti.UI.EventDetailActivity;
import com.example.clantikiti.models.Events;

import org.parceler.Parcels;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EventListAdapter extends RecyclerView.Adapter<EventListAdapter.PropertyVieHolder> {
    private List<Events> mProperties;
    private Context mContext;

    public EventListAdapter(Context mContext, List<Events> mProperties) {
        this.mProperties = mProperties;
        this.mContext = mContext;
    }

    @Override
    public PropertyVieHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_list_item, parent, false);
        PropertyVieHolder viewHolder = new PropertyVieHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(PropertyVieHolder holder, int position) {
        holder.bindProperty(mProperties.get(position));
    }

    @Override
    public int getItemCount() {
        return mProperties.size();
    }



    public class PropertyVieHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.restaurantImageView)
        ImageView mRestaurantImageView;
        @BindView(R.id.restaurantNameTextView) TextView mNameTextView;
        @BindView(R.id.categoryTextView) TextView mCategoryTextView;


        private Context mContext;

        public PropertyVieHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
            itemView.setOnClickListener(this);
        }

        public void bindProperty(Events property) {
            //Picasso.get().load(Events.getPropertyImage()).into(mRestaurantImageView);
            mNameTextView.setText(property.getName());
            mCategoryTextView.setText(property.getDescription());
        }
        @Override
        public void onClick(View v) {
            int itemPosition = getLayoutPosition();
            Intent intent = new Intent(mContext, EventDetailActivity.class);
            intent.putExtra("position", itemPosition);
            intent.putExtra("properties", Parcels.wrap(mProperties));
            mContext.startActivity(intent);
        }
    }
}
