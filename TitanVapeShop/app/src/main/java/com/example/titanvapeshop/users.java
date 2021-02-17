package com.example.titanvapeshop;

import java.util.ArrayList;
import java.util.List;

public class users {
    public static List<Integer> id = new ArrayList<Integer>();
    public static List<String> name = new ArrayList<String>();
    public static List<String> address = new ArrayList<String>();
    public static List<String> email = new ArrayList<String>();
    public static List<String> password = new ArrayList<String>();

    public users(int id,String name,String address,String email,String password){
        this.id.add(id);
        this.name.add(name);
        this.address.add(address);
        this.email.add(email);
        this.password.add(password);
    }
}
