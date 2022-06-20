package com.example.recyleview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>{

    public List<Category> mListCategoryList;

    public void setData(List<Category> list){
        this.mListCategoryList = list;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_categories, parent, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        Category category = mListCategoryList.get(position);
        if(category == null){
            return;
        }
        holder.imgCategory.setImageResource(category.getImage());
        holder.productCategory.setText(category.getName());

    }

    @Override
    public int getItemCount() {
        return mListCategoryList.size();
    }



    public class CategoryViewHolder extends RecyclerView.ViewHolder {

       private ImageView imgCategory;
       private TextView productCategory;

       public CategoryViewHolder(@NonNull View itemView) {
           super(itemView);
           imgCategory = itemView.findViewById(R.id.img_catagory);
           productCategory = itemView.findViewById(R.id.product_category);
       }

   }
}
