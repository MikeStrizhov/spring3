package com.mgs.beans;

/**
 * Created by Michael Strizhov on 01.02.2018.
 */
public class Client {
    private String id;
    private String fullName;

    public Client(String id, String fullName){
        super();
        this.id = id;
        this.fullName = fullName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
