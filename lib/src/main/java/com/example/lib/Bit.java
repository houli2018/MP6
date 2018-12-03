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

        this.Yvalue++;
        if (Yvalue < 0 || Yvalue >= 11) {
            return false;

        }
        return true;
    }
    public Bit copy() {
        Bit toReturn = new Bit();
        toReturn.Xvalue = this.Xvalue;
        toReturn.Yvalue = this.Yvalue;
        return toReturn;
    }
    public boolean moveRight() {

        this.Xvalue++;
        if (Xvalue < 0 || Xvalue >= 8) {
            return false;

        }
        return true;
    }
    public boolean moveLeft() {

        this.Xvalue--;
        if (Xvalue < 0 || Xvalue >= 8) {
            return false;

        }
        return true;
    }
}
