package com.example.root.phone_book;

/**
 * Created by root on 1/1/17.
 */

public class PBFunctions {
    private int id;
    private String name,contact_number,contact_type,note;

    public PBFunctions(String n, String c_number, String c_type, String note){
        name = n;
        contact_number = c_number;
        contact_type = c_type;
        note = c_type;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return  id;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setContact_number(String contact_number){
        this.contact_number = contact_number;
    }

    public String getContact_number(){
        return contact_number;
    }

    public void setContact_type(String contact_type){
        this.contact_type = contact_type;
    }

    public String getContact_type(){
        return contact_type;
    }

    public void setNote(String note){
        this.note = note;
    }

    public String getNote(){
        return note;
    }

}
