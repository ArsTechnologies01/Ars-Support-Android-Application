package com.example.arssupportapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.Objects;

public class NewComplaintActivity extends AppCompatActivity {


    String[] Groups = {"Group 1", "Group 2", "Group 3", "Group 4", "Group 5"};
    String[] CategoryS = {"Category 1", "Category 2", "Category 3", "Category 4", "Category 5"};
    String[] Products = {"Product 1", "Product 2", "Product 3", "Product 4", "Product 5"};


    AutoCompleteTextView GroupAutoCompleteTV;
    AutoCompleteTextView SubCategoryAutoCompleteTV;
    AutoCompleteTextView ProductAutoCompleteTV;

    ArrayAdapter<String> adapterGroup;
    ArrayAdapter<String> adapterCategory;
    ArrayAdapter<String> adapterProduct;

    Toolbar toolbar;

    Button ComplaintConfirmFinalButton;
    ImageButton ConfirmComplaintCloseIV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_complaint);

        /* --------------DialogBox--------------- */

        Dialog ComplaintDialog = new Dialog(this);
        ComplaintDialog.setContentView(R.layout.confirm_complaint_dialogbox_layout);

        /* --------------Hooks--------------- */
        toolbar = findViewById(R.id.NewComplaintScreenToolbar);
        GroupAutoCompleteTV = findViewById(R.id.Group_Auto_Complete_TV);
        SubCategoryAutoCompleteTV = findViewById(R.id.Sub_Category_Auto_Complete_TV);
        ProductAutoCompleteTV = findViewById(R.id.Product_Auto_Complete_TV);
        ComplaintConfirmFinalButton = ComplaintDialog.findViewById(R.id.Complaint_Confirm_Final_Button);
        ConfirmComplaintCloseIV = ComplaintDialog.findViewById(R.id.Confirm_Complaint_Close_IV);

        /* --------------Toolbar--------------- */
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        /* --------------Group--------------- */
        adapterGroup = new ArrayAdapter<String>(this, R.layout.dropdown, Groups);
        GroupAutoCompleteTV.setAdapter(adapterGroup);

        /* --------------Category--------------- */
        adapterCategory = new ArrayAdapter<String>(this, R.layout.dropdown, CategoryS);
        SubCategoryAutoCompleteTV.setAdapter(adapterCategory);
        /* --------------Product--------------- */
        adapterProduct = new ArrayAdapter<String>(this, R.layout.dropdown, Products);
        ProductAutoCompleteTV.setAdapter(adapterProduct);

        /* --------------Handle onClicks on  Button------------------- */

        findViewById(R.id.AddNewComplaintButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ComplaintDialog.show();
            }
        });


        /* --------------Handle onClicks on  dialogBox------------------- */

        ComplaintConfirmFinalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(NewComplaintActivity.this, ComplaintActivity.class));
            }
        });

        /* --------------Handle onClicks on  dialogBox Close Button------------------- */

        ConfirmComplaintCloseIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(NewComplaintActivity.this, NewComplaintActivity.class));
            }
        });


    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}