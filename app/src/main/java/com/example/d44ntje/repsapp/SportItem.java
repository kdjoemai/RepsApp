package com.example.d44ntje.repsapp;

import java.sql.Time;
import java.util.Calendar;

/**
 * Created by KaMaL on 19-2-2018.
 */

public class SportItem {
    private Long id;
    private String name;
    private int rep1 = 0, rep2 = 0, rep3 = 0;
    private Calendar calendar;
    private int time;

    public void setId(Long id) {
        this.id = id;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    public SportItem() {

    }

    public SportItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRep1() {
        return rep1;
    }

    public void setRep1(int rep1) {
        this.rep1 = rep1;
    }

    public int getRep2() {
        return rep2;
    }

    public void setRep2(int rep2) {
        this.rep2 = rep2;
    }

    public int getRep3() {
        return rep3;
    }

    public void setRep3(int rep3) {
        this.rep3 = rep3;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getTime() {
        return time;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return name;
    }

}