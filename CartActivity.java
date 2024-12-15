package com.example.ecom.Activity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.ecom.Adapter.CartAdapter;
import com.example.ecom.R;
import com.example.ecom.databinding.ActivityCartBinding;
import com.example.ecom.helper.ManagmentCart;

public class CartActivity extends AppCompatActivity {
    private ManagmentCart managmentCart;
    ActivityCartBinding binding;
    double tax;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCartBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        managmentCart =new ManagmentCart(this);
        setVariable();
        initList();
        calculatorCart();
        statusBarColor();
    }
    private void statusBarColor() {
        Window window=CartActivity.this.getWindow();
        window.setStatusBarColor(ContextCompat.getColor(CartActivity.this, R.color.red));
    }


    private void initList() {
        if (managmentCart.getListCart().isEmpty()){
            binding.emptytxt.setVisibility(View.VISIBLE);
            binding.scroll.setVisibility(View.GONE);
        }
        else {
            binding.emptytxt.setVisibility(View.GONE);
            binding.scroll.setVisibility(View.VISIBLE);
        }
        binding.cartView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        binding.cartView.setAdapter(new CartAdapter(managmentCart.getListCart(), () -> calculatorCart()));
    }

    private void calculatorCart(){
        double percenttax=0.02;
        double delivery=10;
        tax=Math.round(managmentCart.getTotalFee()*percenttax*100)/100;
        double total = Math.round((managmentCart.getTotalFee()+tax+delivery)*100)/100;
        double itemTotal = Math.round(managmentCart.getTotalFee()*100)/100;
        binding.totalfeetxt.setText("$"+itemTotal);
        binding.taxtxt.setText("$"+tax);
        binding.deliverytxt.setText("$"+delivery);
        binding.totaltxt.setText("$"+total);

    }
    private void setVariable() {
        binding.backbtn.setOnClickListener(v -> finish());
    }
}