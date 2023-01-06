package com.example.arssupportapplication.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.arssupportapplication.Models.ComplaintModel;
import com.example.arssupportapplication.R;

import java.util.ArrayList;

public class ComplaintAdapter extends RecyclerView.Adapter<ComplaintAdapter.ComplaintViewHolder> {

    ArrayList<ComplaintModel> list;
    Context context;

    public ComplaintAdapter(ArrayList<ComplaintModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ComplaintViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.complaintcustomlayout, parent, false);
        return new ComplaintViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ComplaintViewHolder holder, int position) {
        ComplaintModel model = list.get(position);
        holder.complaintId.setText(model.getComplaintIdTV());
        holder.complaintStatus.setText(model.getComplaintStatusTV());
        holder.complaintDetails.setText(model.getComplaintDetailsTV());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ComplaintViewHolder extends RecyclerView.ViewHolder {
        TextView complaintId, complaintDetails, complaintStatus;
        public ComplaintViewHolder(@NonNull View itemView) {

            super(itemView);
            complaintId = itemView.findViewById(R.id.complaintsIdTextview);
            complaintDetails = itemView.findViewById(R.id.complaintDetails);
            complaintStatus = itemView.findViewById(R.id.complaintStatus);
        }
    }
}
