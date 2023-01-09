package com.example.arssupportapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.arssupportapplication.Adapters.ComplaintAdapter;
import com.example.arssupportapplication.Models.ComplaintModel;

import java.util.ArrayList;
import java.util.Objects;

public class ComplaintActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaint);

        /* --------------Hooks--------------- */
        recyclerView = findViewById(R.id.complaintRecyclerView);
        toolbar = findViewById(R.id.complaintScreenToolbar);

        /* --------------Toolbar--------------- */

        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ArrayList<ComplaintModel> list = new ArrayList<>();
        list.add(new ComplaintModel("Complaint Id #101", "Response Pending", "Details"));
        list.add(new ComplaintModel("Complaint Id #101", "Response Pending", "Details"));
        list.add(new ComplaintModel("Complaint Id #101", "Response Pending", "Details"));
        list.add(new ComplaintModel("Complaint Id #101", "Response Pending", "Details"));
        list.add(new ComplaintModel("Complaint Id #101", "Response Pending", "Details"));
        list.add(new ComplaintModel("Complaint Id #101", "Response Pending", "Details"));
        list.add(new ComplaintModel("Complaint Id #101", "Response Pending", "Details"));
        list.add(new ComplaintModel("Complaint Id #101", "Response Pending", "Details"));
        list.add(new ComplaintModel("Complaint Id #101", "Response Pending", "Details"));
        list.add(new ComplaintModel("Complaint Id #101", "Response Pending", "Details"));
        list.add(new ComplaintModel("Complaint Id #101", "Response Pending", "Details"));

        ComplaintAdapter adapter = new ComplaintAdapter(list, this);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        /* --------------Handle onClicks on Add New Complaint Button------------------- */

        findViewById(R.id.lodgeComplaintButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ComplaintActivity.this, NewComplaintActivity.class));
                finish();
            }
        });

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}