package com.example.doc_repository;

public class realty {
    int realty_id;
    String realty_name;
    String type;

    public int getRealty_id() {
        return realty_id;
    }

    public void setRealty_id(int realty_id) {
        this.realty_id = realty_id;
    }

    public String getRealty_name() {
        return realty_name;
    }

    public void setRealty_name(String realty_name) {
        this.realty_name = realty_name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public realty(int realty_id, String realty_name, String type) {
        this.realty_id = realty_id;
        this.realty_name = realty_name;
        this.type = type;
    }
}
