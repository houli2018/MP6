package com.example.lib;

public class Bit {
    public int Xvalue;
    public int Yvalue;
    public int getXvalue() {
        return this.Xvalue;
    }
    public int getYvalue() {
        return this.Yvalue;
    }
    public void setXvalue(int setXvalue) {
        this.Xvalue = setXvalue;
    }
    public void setYvalue(int setYvalue) {
        this.Yvalue = setYvalue;
    }
    public boolean moveDown() {
        if (Yvalue++ > 10) {
            return false;

        }
        this.Yvalue++;
        return true;
    }
    public boolean moveRight() {
        if (Xvalue++ > 7) {
            return false;

        }
        this.Xvalue++;
        return true;
    }
    public boolean moveLeft() {
        if (Xvalue-- < 0) {
            return false;

        }
        this.Xvalue--;
        return true;
    }
}
