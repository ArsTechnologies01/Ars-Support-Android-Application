package com.example.arssupportapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.arssupportapplication.Adapters.ProductAdapter;
import com.example.arssupportapplication.Models.ProductModel;

import java.util.ArrayList;
import java.util.Objects;

public class ProductsActivity extends AppCompatActivity {

    Toolbar toolbar;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

        /* --------------Hooks--------------- */

        toolbar = findViewById(R.id.productsScreenToolbar);
        recyclerView = findViewById(R.id.productScreenRecyclerView);

        /* --------------Toolbar--------------- */
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        /* --------------Recycler View-------------*/
        ArrayList<ProductModel> list = new ArrayList<>();
        list.add(new ProductModel("Printer Name", R.drawable.fop_image1));
        list.add(new ProductModel("Printer Name", R.drawable.fop_image1));
        list.add(new ProductModel("Printer Name", R.drawable.fop_image1));
        list.add(new ProductModel("Printer Name", R.drawable.fop_image1));
        list.add(new ProductModel("Printer Name", R.drawable.fop_image1));
        list.add(new ProductModel("Printer Name", R.drawable.fop_image1));
        list.add(new ProductModel("Printer Name", R.drawable.fop_image1));
        list.add(new ProductModel("Printer Name", R.drawable.fop_image1));
        list.add(new ProductModel("Printer Name", R.drawable.fop_image1));
        list.add(new ProductModel("Printer Name", R.drawable.fop_image1));
        list.add(new ProductModel("Printer Name", R.drawable.fop_image1));
        list.add(new ProductModel("Printer Name", R.drawable.fop_image1));
        list.add(new ProductModel("Printer Name", R.drawable.fop_image1));
        ProductAdapter adapter = new ProductAdapter(list, this);

        recyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}