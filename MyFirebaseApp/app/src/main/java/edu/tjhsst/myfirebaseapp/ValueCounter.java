package edu.tjhsst.myfirebaseapp;

/**
 * Created by varunmosur on 10/25/17.
 */

class ValueCounter {

    private int value;
    private String name;

    public ValueCounter(){
    }

    public ValueCounter(String s){
        name = s;
        value = 0;
    }
    public void increment(){
        value++;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
