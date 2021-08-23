package com.arnoldvaz27.mxplayerdetailoptionui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private AlertDialog fullDetailOption;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    private void AlertDialog() {
        if (fullDetailOption == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            View view = LayoutInflater.from(this).inflate(
                    R.layout.alertdialog, findViewById(R.id.layoutMoreDetailOptions)
            );

            builder.setView(view);
            builder.setCancelable(false);
            fullDetailOption = builder.create();
            if (fullDetailOption.getWindow() != null) {
                fullDetailOption.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            }

            TextView cancel;

            cancel = view.findViewById(R.id.Cancel);

            cancel.setOnClickListener(v -> fullDetailOption.cancel());
        }
        fullDetailOption.show();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        getMenuInflater().inflate(R.menu.main_menu, menu);


        return true;
    }


    @SuppressLint("SetTextI18n")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);

        if (item.getItemId() == R.id.dashboard) {
            AlertDialog();
        }
        return true;
    }

}