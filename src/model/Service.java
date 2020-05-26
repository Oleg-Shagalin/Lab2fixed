package oop.model;

import org.intellij.lang.annotations.MagicConstant;

public class Service {

    @MagicConstant(stringValues = {NAME}, intValues = {COST})
    private String name;
    private double cost;
    private final String NAME = "интернет 100мб\\сек";
    private final int COST = 300;

    public Service() {
        name = NAME;
        cost = COST;
    }

    public Service(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

}
