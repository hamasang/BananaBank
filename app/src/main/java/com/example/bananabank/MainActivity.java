package com.example.bananabank;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.bananabank.model.BankInfoModel;
import com.example.bananabank.ui.MainViewModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    // 메인 화면 viewmodel
    private MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.

        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);

        NavigationUI.setupWithNavController(navView, navController);

        setStatus();
    }


    public void setStatus() {
        LayoutInflater inflater = (LayoutInflater) getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.custom_alert_layout, null);
        EditText view_wallet = (EditText) view.findViewById(R.id.editTextNumberDecimal);
        EditText view_safe = (EditText) view.findViewById(R.id.editTextNumberDecimal2);
        DecimalFormat nf = new DecimalFormat("###,###");
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setView(view);
        builder.setPositiveButton("네", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                final BankInfoModel bankInfoModel = new BankInfoModel();
                bankInfoModel.setHomeBank(nf.format(Long.parseLong(view_wallet.getEditableText().toString()))  + " 원");
                bankInfoModel.setSafeBank(nf.format(Long.parseLong(view_safe.getEditableText().toString())) + " 원");
                mainViewModel.setBankInfoModel(bankInfoModel);

                dialog.dismiss();
            }
        });
        builder.setNegativeButton("아니오", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();


    }

}