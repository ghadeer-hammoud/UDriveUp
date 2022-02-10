package com.example.udriveup.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.udriveup.R;
import com.example.udriveup.models.Story;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import de.hdodenhof.circleimageview.CircleImageView;

public class StoriesRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{


    private Context context;
    private List<Story> stories;

    public StoriesRecyclerAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_list_story, parent, false);
        return new StoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((StoryViewHolder) holder).bind(stories.get(position));
    }

    @Override
    public int getItemCount() {
        return stories == null ? 0 : stories.size();
    }

    public void setStories(List<Story> stories){
        this.stories = stories;
        notifyDataSetChanged();
    }

    public class StoryViewHolder extends RecyclerView.ViewHolder{

        CircleImageView ivImage;
        TextView tvUsername;

        public StoryViewHolder(@NonNull View itemView) {
            super(itemView);

            ivImage = itemView.findViewById(R.id.ivImage);
            tvUsername = itemView.findViewById(R.id.tvUsername);

        }

        public void bind(Story story){

            tvUsername.setText(story.getUsername());
            Glide.with(context)
                    .load(story.getImageUrl())
                    .centerCrop()
                    .into(ivImage);

        }

    }

}