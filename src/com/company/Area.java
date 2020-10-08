package com.company;

public class Area {


    public enum Measure {
        m,
        ga,
        ar,
        de
    }

    ;
    private double value;
    private Measure type;

    public Area(double value, Measure type) {
        this.value = value;
        this.type = type;
    }

    @Override
    public String toString() {
        String typeAsString = "";
        switch (this.type) {
            case m:
                typeAsString = "кв.м";
                break;
            case ga:
                typeAsString = "га";
                break;
            case ar:
                typeAsString = "сотка";
                break;
            case de:
                typeAsString = "десятина";
                break;
        }
        return String.format("%s %s", this.value, typeAsString);
    }

    public Area add(double number) {
        Area newArea = new Area(this.value + number, this.type);
        return newArea;
    }

    public Area subtraction(double number) {
        Area newArea = new Area(this.value - number, this.type);
        return newArea;
    }

    public Area multiply(double number) {
        Area newArea = new Area(this.value * number, this.type);
        return newArea;
    }

    public Area to(Measure newType) {
        double newValue = this.value;
        if (this.type == Measure.m) {
            switch (newType) {
                case m:
                    newValue = this.value;
                    break;
                case ga:
                    newValue = this.value / 10000;
                    break;
                case ar:
                    newValue = this.value / 100;
                    break;
                case de:
                    newValue = this.value / 11111;
                    break;
            }
        } else if (newType == Measure.m) {
            switch (this.type) {
                case ga:
                    newValue = this.value * 10000;
                    break;
                case ar:
                    newValue = this.value * 100;
                    break;
                case de:
                    newValue = this.value * 11111;
                    break;
            }
        } else {
            newValue = this.to(Measure.m).to(newType).value;
        }
        return new Area(newValue, newType);
    }
    public Area add(Area otherArea) {
        Area otherAreaConverted = otherArea.to(this.type);
        return this.add(otherAreaConverted.value);
    }

    public Area subtraction(Area otherArea) {
        Area otherAreaConverted = otherArea.to(this.type);
        return this.subtraction(otherAreaConverted.value);
    }
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Area)) {
            return false;
        }
        Area objArea = (Area) obj;
        return objArea.to(this.type).value == this.value;
    }
}

