package com.example.udriveup.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.udriveup.R;
import com.example.udriveup.models.Category;
import com.example.udriveup.models.SubCategory;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SubCategoriesRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context context;
    private List<SubCategory> subCategories;

    public SubCategoriesRecyclerAdapter(Context context) {
      this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_list_sub_category, parent, false);
        return new SubCategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((SubCategoryViewHolder) holder).bind(subCategories.get(position));
    }

    @Override
    public int getItemCount() {
        return subCategories == null ? 0 : subCategories.size();
    }

    public void setSubCategories(List<SubCategory> subCategories){
        this.subCategories = subCategories;
        notifyDataSetChanged();
    }

    public class SubCategoryViewHolder extends RecyclerView.ViewHolder{

        ImageView ivImage;
        TextView tvTitle;

        public SubCategoryViewHolder(@NonNull View itemView) {
            super(itemView);

            ivImage = itemView.findViewById(R.id.ivImage);
            tvTitle = itemView.findViewById(R.id.tvTitle);

        }

        public void bind(SubCategory subCategory){

            tvTitle.setText(subCategory.getTitle());
          /*  glideInstance
                    .load(category.getIconUrl())
                    .into(ivImage);*/


        }

    }

}