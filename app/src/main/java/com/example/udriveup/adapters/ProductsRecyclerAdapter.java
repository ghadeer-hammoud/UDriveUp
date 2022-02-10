package com.example.udriveup.adapters;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.udriveup.R;
import com.example.udriveup.models.Product;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProductsRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{


    private Context context;
    private List<Product> products;

    public ProductsRecyclerAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_list_product, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((ProductViewHolder) holder).bind(products.get(position));
    }

    @Override
    public int getItemCount() {
        return products == null ? 0 : products.size();
    }

    public void setProducts(List<Product> products){
        this.products = products;
        notifyDataSetChanged();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder{

        ImageView ivImage;
        TextView tvProductService, tvProductTitle, tvPrice, tvOldPrice, tvDiscount, tvDistance;
        RatingBar ratingBar;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);

            ivImage = itemView.findViewById(R.id.ivImage);
            tvProductService = itemView.findViewById(R.id.tvProductService);
            tvProductTitle = itemView.findViewById(R.id.tvProductTitle);
            tvPrice = itemView.findViewById(R.id.tvPrice);
            tvOldPrice = itemView.findViewById(R.id.tvOldPrice);
            tvDiscount = itemView.findViewById(R.id.tvDiscount);
            tvDistance = itemView.findViewById(R.id.tvDistance);
            ratingBar = itemView.findViewById(R.id.ratingBar);

        }

        public void bind(Product product){

            tvProductService.setText(product.getProductService());
            tvProductTitle.setText(product.getProductTitle());
            tvDiscount.setText(String.valueOf(product.getDiscount()) + "% Off");
            tvDistance.setText(String.valueOf(product.getDistance()) + " Km");
            ratingBar.setRating(product.getRating());

            if (product.getDiscount() > 0){
                tvOldPrice.setVisibility(View.VISIBLE);
                tvOldPrice.setText(String.valueOf(product.getPrice()) + "/-");
                tvOldPrice.setPaintFlags(tvOldPrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                double newPrice = product.getPrice() - (product.getPrice() * product.getDiscount() / 100);
                tvPrice.setText(String.valueOf(newPrice) + "/-");
            }
            else{
                tvOldPrice.setVisibility(View.GONE);
                tvPrice.setText(String.valueOf(product.getPrice()) + "/-");
            }
            Glide.with(context)
                    .load(product.getImageUrl())
                    .centerCrop()
                    .into(ivImage);


        }

    }

}