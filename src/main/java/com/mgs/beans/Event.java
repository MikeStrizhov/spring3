package com.mgs.beans;

import java.text.DateFormat;
import java.util.Date;

/**
 * Created by Michael Strizhov on 01.02.2018.
 */
public class Event {
    private int id;
    private String msg;
    private Date date;
    private DateFormat df;

    public Event(Date date, DateFormat df){
        this.date = date;
        this.df = df;
    }
    @Override
    public String toString(){
        String result = "Id=" + Integer.toString(getId()) + " msg=" + getMsg() + " date=" + df.format(date);
        return result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
