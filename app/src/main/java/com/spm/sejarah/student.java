package com.spm.sejarah;

public class student {


    private String studIc; //970825-04-1111
    private String studClass; //A,B,C
    private String studPw; //kirana1111
    private String studName; // aiman

    public student() {
    }

    public student(String studIc, String studClass, String studPw, String studName) {
        this.studIc = studIc;
        this.studClass = studClass;
        this.studPw = studPw;
        this.studName = studName;
    }

    public String getStudIc() {
        return studIc;
    }

    public void setStudIc(String studIc) {
        this.studIc = studIc;
    }

    public String getStudClass() {
        return studClass;
    }

    public void setStudClass(String studClass) {
        this.studClass = studClass;
    }

    public String getStudPw() {
        return studPw;
    }

    public void setStudPw(String studPw) {
        this.studPw = studPw;
    }

    public String getStudName() {
        return studName;
    }

    public void setStudName(String studName) {
        this.studName = studName;
    }
}


