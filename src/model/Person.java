package oop.model;

public class Person {
    private String fName;
    private String sName;

    public Person(String fName, String sNname) {
        this.fName = fName;
        this.sName = sNname;
    }

    public String getFName() {
        return fName;
    }

    public String getSName() {
        return sName;
    }
}
