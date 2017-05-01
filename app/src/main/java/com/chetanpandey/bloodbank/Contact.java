package com.chetanpandey.bloodbank;

/**
 * Created by Chetan Pandey on 28-04-2017.
 */

public class Contact {

    //private variables
    int _id;
    String _name;
    String bgrp;
    String Add;

    public String getAdd() {
        return Add;
    }

    public void setAdd(String add) {
        Add = add;
    }



    public String getGen() {
        return gen;
    }

    public void setGen(String gen) {
        this.gen = gen;
    }

    String gen;

    public String getBgrp() {
        return bgrp;
    }

    public void setBgrp(String bgrp) {
        this.bgrp = bgrp;
    }

    public String getDistt() {
        return distt;
    }

    public void setDistt(String distt) {
        this.distt = distt;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    String distt;
    String state;
    String _phone_number;

    // Empty constructor
    public Contact(){

    }
    // constructor
    public Contact(int id, String name, String _phone_number, String bgrp, String distt, String state,String gen,String add){
        this._id = id;
        this._name = name;
        this._phone_number = _phone_number;
        this.bgrp = bgrp;
        this.distt = distt;
        this.state = state;
        this.gen= gen;
        this.Add = add;
    }
    // getting ID
    public int getID(){
        return this._id;
    }

    // setting id
    public void setID(int id){
        this._id = id;
    }

    // getting name
    public String getName(){
        return this._name;
    }

    // setting name
    public void setName(String name){
        this._name = name;
    }

    // getting phone number
    public String getPhoneNumber(){
        return this._phone_number;
    }

    // setting phone number
    public void setPhoneNumber(String phone_number){
        this._phone_number = phone_number;
    }
}