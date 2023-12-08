package com.example.doc_repository;

import java.sql.Blob;

public class info {
    int info_id;
    int realty_id;
    String address;
    int status_id;
    Blob photo;

    public int getInfo_id() {
        return info_id;
    }

    public void setInfo_id(int info_id) {
        this.info_id = info_id;
    }

    public int getRealty_id() {
        return realty_id;
    }

    public void setRealty_id(int realty_id) {
        this.realty_id = realty_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getStatus_id() {
        return status_id;
    }

    public void setStatus_id(int status_id) {
        this.status_id = status_id;
    }

    public void setPhoto(Blob photo) {
        this.photo = photo;
    }

    public Blob getPhoto() {
        return photo;
    }

    public info (int info_id, int realty_id, String address, int status_id) {
        this.info_id = info_id;
        this.realty_id = realty_id;
        this.address = address;
        this.status_id = status_id;
    }
}
