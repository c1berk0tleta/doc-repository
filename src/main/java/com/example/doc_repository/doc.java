package com.example.doc_repository;

import java.sql.Blob;

public class doc {
    int doc_ID;
    int docRealty_ID;
    Blob doc_file;

    public int getDoc_ID() {
        return doc_ID;
    }

    public void setDoc_ID(int doc_ID) {
        this.doc_ID = doc_ID;
    }

    public int getDocRealty_ID() {
        return docRealty_ID;
    }

    public void setDocRealty_ID(int docRealty_ID) {
        this.docRealty_ID = docRealty_ID;
    }

    public Blob getDoc_file() {
        return doc_file;
    }

    public void setDoc_file(Blob doc_file) {
        this.doc_file = doc_file;
    }

    public doc (int doc_ID, int docRealty_ID, Blob doc_file) {
        this.doc_ID = doc_ID;
        this.docRealty_ID = docRealty_ID;
        this.doc_file = doc_file;
    }
}
