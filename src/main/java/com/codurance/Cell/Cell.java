package com.codurance.Cell;

public class Cell {

    private String value;

    public Cell() {
        this.value = "-";
    }

    public void setValue(String newValue) {
        value = newValue;
    }

    public String getValue() {
        return value;
    }
}
