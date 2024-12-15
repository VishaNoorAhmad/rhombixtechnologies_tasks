package com.example.ecom.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.ecom.Adapter.PopularAdapter;
import com.example.ecom.Domain.PopularDomain;
import com.example.ecom.R;
import com.example.ecom.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        statusBarColor();
        initRecycleView();
        bottomNavigation();
    }

    private void bottomNavigation() {
        binding.cartbtn.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, CartActivity.class)));

       
    }

    private void statusBarColor() {
        Window window=MainActivity.this.getWindow();
        window.setStatusBarColor(ContextCompat.getColor(MainActivity.this, R.color.red));
    }

    private void initRecycleView() {
        ArrayList<PopularDomain> items=new ArrayList<>();
        items.add(new PopularDomain("Iphone","item_3",10,4.9,500,"This timeless black iphone is\n"+
                "a wardrobe essential, offering\n"
                +"a versatile and stylish look\n "
                +"for any occasion. Made from\n "
                +"premium-quality, breathable fabric, \n"
                +"it ensures all-day comfort and \n"
                +"durability. Its sleek design\n"
                +"features a tailored fit, crew \n"
                +"neckline, and double-stitched\n"
                +"seams for added strength.\n "));
        items.add(new PopularDomain("Frock","item_15",15,3.2,30,"Stay connected and active \n with this sleek smart watch. \nIt features fitness tracking, \nheart rate monitoring, and \n smartphone notifications, all \nin a stylish, water-resistant \ndesign with a vibrant \ntouchscreen. Perfect for your\n daily life and workouts!"));
        items.add(new PopularDomain("Lipstick","item_8",4,4.2,10,"Experience power and style\n with this sleek smartphone.\n Featuring a stunning display,\n high-performance processor, and\n advanced camera system, it’s \nperfect for multitasking, capturing \nmemories, and staying connected.\n Designed for your modern lifestyle!"));
        items.add(new PopularDomain("Perfume","item_6",10,4.5,100,"This timeless black t-shirt is\n"+
                "a wardrobe essential, offering\n"
                +"a versatile and stylish look\n "
                +"for any occasion. Made from\n "
                +"premium-quality, breathable fabric, \n"
                +"it ensures all-day comfort and \n"
                +"durability. Its sleek design\n"
                +"features a tailored fit, crew \n"
                +"neckline, and double-stitched\n"
                +"seams for added strength.\n "));
        items.add(new PopularDomain("Perfume","item_9",15,3,110,"Stay connected and active \n with this sleek smart watch. \nIt features fitness tracking, \nheart rate monitoring, and \n smartphone notifications, all \nin a stylish, water-resistant \ndesign with a vibrant \ntouchscreen. Perfect for your\n daily life and workouts!"));
        items.add(new PopularDomain("Nail Paint","item_13",4,4.2,50,"Experience power and style\n with this sleek smartphone.\n Featuring a stunning display,\n high-performance processor, and\n advanced camera system, it’s \nperfect for multitasking, capturing \nmemories, and staying connected.\n Designed for your modern lifestyle!"));

        binding.PopularView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        binding.PopularView.setAdapter(new PopularAdapter(items));
    }
}

