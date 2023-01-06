package com.example.arssupportapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import java.util.Objects;

public class RepairingActivity extends AppCompatActivity {

    Toolbar toolbar;
    String[] ProductCategory = {"Category 1", "Category 2", "Category 3", "Category 4", "Category 5"};

    AutoCompleteTextView RepairingProductCategoryAutoCompleteTV;

    ArrayAdapter<String> adapterProductCategory;
    Button RepairingConfirmButton;
    Button RepairingConfirmFinalButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repairing);

        /* --------------DialogBox--------------- */
        Dialog dialog = new Dialog(this);
        Dialog dialog1 = new Dialog(this);
        dialog.setContentView(R.layout.confirm_repairing_dialog_box_layout);
        dialog1.setContentView(R.layout.confirm_dailog_box_layout);

        /* --------------Hooks--------------- */

        toolbar = findViewById(R.id.RepairingScreenToolbar);
        RepairingProductCategoryAutoCompleteTV = findViewById(R.id.Repairing_Product_Category_Auto_Complete_TV);
        RepairingConfirmButton = dialog.findViewById(R.id.Repairing_Confirm_Button);
        RepairingConfirmFinalButton = dialog1.findViewById(R.id.Repairing_Confirm_Final_Button);

        /* --------------Toolbar--------------- */
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        /* --------------Repairing_Product_Category--------------- */
        adapterProductCategory = new ArrayAdapter<String>(this, R.layout.dropdown, ProductCategory);
        RepairingProductCategoryAutoCompleteTV.setAdapter(adapterProductCategory);



        /* --------------Handle onClicks on  Button------------------- */

        findViewById(R.id.Click_To_Proceed_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show();
            }
        });
        /* --------------Handle onClicks on  DialogBox------------------- */

        RepairingConfirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog1.show();
            }
        });
        /* --------------Handle onClicks on  DialogBox1------------------- */
        RepairingConfirmFinalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RepairingActivity.this, MainActivity.class));
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}