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
import android.widget.ImageButton;

import java.util.Objects;

public class RepairingActivity extends AppCompatActivity {

    Toolbar toolbar;
    String[] ProductCategory = {"Category 1", "Category 2", "Category 3", "Category 4", "Category 5"};

    AutoCompleteTextView RepairingProductCategoryAutoCompleteTV;

    ArrayAdapter<String> adapterProductCategory;
    Button RepairingConfirmButton;
    Button RepairingConfirmFinalButton;
    ImageButton ConfirmContactRepairingCloseIV;
    ImageButton ConfirmRepairingCloseIV;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repairing);

        /* --------------DialogBox--------------- */
        Dialog dialog = new Dialog(this);
        Dialog dialog1 = new Dialog(this);
        dialog.setContentView(R.layout.confirm_contact_repairing_dialog_box_layout);
        dialog1.setContentView(R.layout.confirm_repairing_dailog_box_layout);

        /* --------------Hooks--------------- */

        toolbar = findViewById(R.id.RepairingScreenToolbar);
        RepairingProductCategoryAutoCompleteTV = findViewById(R.id.Repairing_Product_Category_Auto_Complete_TV);
        RepairingConfirmButton = dialog.findViewById(R.id.Repairing_Confirm_Button);
        ConfirmContactRepairingCloseIV = dialog.findViewById(R.id.Confirm_Contact_Repairing_Close_IV);
        RepairingConfirmFinalButton = dialog1.findViewById(R.id.Repairing_Confirm_Final_Button);
        ConfirmRepairingCloseIV = dialog1.findViewById(R.id.Confirm_Repairing_Close_IV);
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

        /* --------------Handle onClicks on  DialogBox Close Button------------------- */

        ConfirmContactRepairingCloseIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(RepairingActivity.this, RepairingActivity.class));
            }
        });

        /* --------------Handle onClicks on  DialogBox1------------------- */

        RepairingConfirmFinalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RepairingActivity.this, MainActivity.class));
            }
        });

        /* --------------Handle onClicks on  DialogBox1 Close Button------------------- */

        ConfirmRepairingCloseIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(RepairingActivity.this, RepairingActivity.class));
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}