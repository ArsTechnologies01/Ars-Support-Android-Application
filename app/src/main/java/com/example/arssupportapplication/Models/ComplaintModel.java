package com.example.arssupportapplication.Models;

public class ComplaintModel {
    private String ComplaintIdTV,ComplaintStatusTV,ComplaintDetailsTV;

    public ComplaintModel(String complaintIdTV, String complaintStatusTV, String complaintDetailsTV) {
        ComplaintIdTV = complaintIdTV;
        ComplaintStatusTV = complaintStatusTV;
        ComplaintDetailsTV = complaintDetailsTV;
    }

    public String getComplaintIdTV() {
        return ComplaintIdTV;
    }

    public void setComplaintIdTV(String complaintIdTV) {
        ComplaintIdTV = complaintIdTV;
    }

    public String getComplaintStatusTV() {
        return ComplaintStatusTV;
    }

    public void setComplaintStatusTV(String complaintStatusTV) {
        ComplaintStatusTV = complaintStatusTV;
    }

    public String getComplaintDetailsTV() {
        return ComplaintDetailsTV;
    }

    public void setComplaintDetailsTV(String complaintDetailsTV) {
        ComplaintDetailsTV = complaintDetailsTV;
    }
}
