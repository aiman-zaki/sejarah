package com.spm.sejarah;

public class teacher {

    private String teachIc; //970825-04-1111
    private String teachPw; //kirana1111
    private String teachName; // aiman

    public teacher() {
    }

    public teacher(String teachIc, String teachPw, String teachName) {
        this.teachIc = teachIc;
        this.teachPw = teachPw;
        this.teachName = teachName;
    }

    public String getTeachIc() {
        return teachIc;
    }

    public void setTeachIc(String teachIc) {
        this.teachIc = teachIc;
    }

    public String getTeachPw() {
        return teachPw;
    }

    public void setTeachPw(String teachPw) {
        this.teachPw = teachPw;
    }

    public String getTeachName() {
        return teachName;
    }

    public void setTeachName(String teachName) {
        this.teachName = teachName;
    }
}

