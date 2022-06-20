package com.example.recyleview;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ConcatAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class ShowActivity extends Dropdown {

    private RecyclerView rcvProduct;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showlayout);

        rcvProduct = findViewById(R.id.rcv_data);
        FloatingActionButton fab = findViewById(R.id.fab);
        FloatingActionButton web = findViewById(R.id.web);
        FloatingActionButton mess = findViewById(R.id.mess);
        FloatingActionButton cam = findViewById(R.id.capture);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri number = Uri.parse("tel:123456789");
                Intent callIntent = new Intent(Intent.ACTION_DIAL, number);
                startActivity(callIntent);
            }
        });

        web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri webpage = Uri.parse("https://www.facebook.com/profile.php?id=100078035351805");
                Intent callIntent = new Intent(Intent.ACTION_VIEW, webpage);
                startActivity(callIntent);
            }
        });

        mess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_SENDTO);
                callIntent.setData(Uri.parse("smsto:"));
                callIntent.putExtra("sms_body", "hello");
                startActivity(callIntent);
            }
        });

        cam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(callIntent);
            }
        });




        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        rcvProduct.setLayoutManager(linearLayoutManager);

        CategoryAdapter categoryAdapter = new CategoryAdapter();
        categoryAdapter.setData(getListCategory());

        ProductAdapter productAdapter = new ProductAdapter();
        productAdapter.setData(getListProduct());

        ConcatAdapter concatAdapter = new ConcatAdapter(categoryAdapter, productAdapter);
        rcvProduct.setAdapter(concatAdapter);
    }




    private List<Category> getListCategory() {
        List<Category> list = new ArrayList<Category>();
        list.add(new Category((R.drawable.bmw), "BMW"));
        list.add(new Category((R.drawable.adui), "Audi"));
        return list;
    }

    private List<Product> getListProduct() {
        List<Product> list = new ArrayList<>();
        list.add(new Product((R.drawable.bmw), "Bmw", 3000));
        list.add(new Product((R.drawable.adui), "Audi",2000));
        list.add(new Product((R.drawable.porsche), "Porsche", 1000));
        list.add(new Product((R.drawable.bmw), "Bmw", 3000));
        list.add(new Product((R.drawable.adui), "Audi",2000));
        list.add(new Product((R.drawable.porsche), "Porsche", 1000));
        return list;
    }

}
