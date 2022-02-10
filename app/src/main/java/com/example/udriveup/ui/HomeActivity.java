package com.example.udriveup.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.Menu;

import com.example.udriveup.R;
import com.example.udriveup.adapters.CategoriesRecyclerAdapter;
import com.example.udriveup.adapters.ProductsRecyclerAdapter;
import com.example.udriveup.adapters.StoriesRecyclerAdapter;
import com.example.udriveup.adapters.SubCategoriesRecyclerAdapter;
import com.example.udriveup.repository.RemoteDataSource;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class HomeActivity extends AppCompatActivity {

    private Toolbar toolbar;

    private RecyclerView categoriesRecyclerView;
    private RecyclerView productsRecyclerView;
    private RecyclerView storiesRecyclerView;
    private RecyclerView subCategoriesRecyclerView;
    private RecyclerView products2RecyclerView;

    private CategoriesRecyclerAdapter categoriesAdapter;
    private ProductsRecyclerAdapter productsAdapter;
    private StoriesRecyclerAdapter storiesAdapter;
    private SubCategoriesRecyclerAdapter subCategoriesAdapter;
    private ProductsRecyclerAdapter products2Adapter;

    private Context ctx;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ctx = this;

        toolbar = findViewById(R.id.toolbar);
        categoriesRecyclerView = findViewById(R.id.categoriesRecyclerView);
        productsRecyclerView = findViewById(R.id.productsRecyclerView);
        storiesRecyclerView = findViewById(R.id.storiesRecyclerView);
        subCategoriesRecyclerView = findViewById(R.id.subCategoriesRecyclerView);
        products2RecyclerView = findViewById(R.id.products2RecyclerView);
        setSupportActionBar(toolbar);
        init();

    }

    private void init() {

        setupCategoriesRecyclerView();
        setupProductsRecyclerView();
        setupStoriesRecyclerView();
        setupSubCategoriesRecyclerView();
        setupProducts2RecyclerView();

        fillData();
    }

    private void setupCategoriesRecyclerView(){
        categoriesAdapter = new CategoriesRecyclerAdapter(ctx);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ctx, LinearLayoutManager.HORIZONTAL, false);
        categoriesRecyclerView.setAdapter(categoriesAdapter);
        categoriesRecyclerView.setLayoutManager(linearLayoutManager);
    }

    private void setupProductsRecyclerView(){
        productsAdapter = new ProductsRecyclerAdapter(ctx);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(ctx, 3);
        productsRecyclerView.setAdapter(productsAdapter);
        productsRecyclerView.setLayoutManager(gridLayoutManager);
    }

    private void setupStoriesRecyclerView(){
        storiesAdapter = new StoriesRecyclerAdapter(ctx);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ctx, LinearLayoutManager.HORIZONTAL, false);
        storiesRecyclerView.setAdapter(storiesAdapter);
        storiesRecyclerView.setLayoutManager(linearLayoutManager);
    }

    private void setupSubCategoriesRecyclerView(){
        subCategoriesAdapter = new SubCategoriesRecyclerAdapter(ctx);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ctx, LinearLayoutManager.HORIZONTAL, false);
        subCategoriesRecyclerView.setAdapter(subCategoriesAdapter);
        subCategoriesRecyclerView.setLayoutManager(linearLayoutManager);
    }

    private void setupProducts2RecyclerView(){
        products2Adapter = new ProductsRecyclerAdapter(ctx);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ctx, LinearLayoutManager.HORIZONTAL, false);;
        products2RecyclerView.setAdapter(products2Adapter);
        products2RecyclerView.setLayoutManager(linearLayoutManager);
    }

    private void fillData(){

        RemoteDataSource remoteDataSource = RemoteDataSource.getInstance();

        categoriesAdapter.setCategories(remoteDataSource.getCategoriesList());
        productsAdapter.setProducts(remoteDataSource.getProductsList());
        storiesAdapter.setStories(remoteDataSource.getStoriesList());
        subCategoriesAdapter.setSubCategories(remoteDataSource.getSubCategoriesList());
        products2Adapter.setProducts(remoteDataSource.getProductsList());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
