package com.example.newsapi_recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CategoryRVAdapter extends RecyclerView.Adapter<CategoryRVAdapter.Viewholder> {
    private final ArrayList<CategoryRVModel> categoryRVModels;
    private final CategoryClickInterface categoryClickInterface;

    public CategoryRVAdapter(ArrayList<CategoryRVModel> categoryRVModels, CategoryClickInterface categoryClickInterface) {
        this.categoryRVModels = categoryRVModels;
        this.categoryClickInterface = categoryClickInterface;
    }

    @NonNull
    @Override
    public CategoryRVAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.categories_rv_item,parent,false);
        return new CategoryRVAdapter.Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryRVAdapter.Viewholder holder,int position) {
        CategoryRVModel categoryRVModel = categoryRVModels.get(position);
        holder.categoryTV.setText(categoryRVModel.getCategory());
        Picasso.get().load(categoryRVModel.getCategoryImageUrl()).into(holder.categoryIV);
        holder.itemView.setOnClickListener(view -> categoryClickInterface.onCategoryClick(position));
    }

    @Override
    public int getItemCount() {
        return categoryRVModels.size();
    }

    public interface CategoryClickInterface{
        void onCategoryClick(int position);

    }

    public static class Viewholder  extends RecyclerView.ViewHolder{
        private final TextView categoryTV;
        private final ImageView categoryIV;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            categoryTV = itemView.findViewById(R.id.idTV_Category);
            categoryIV = itemView.findViewById(R.id.idIV_category);
        }
    }
}
