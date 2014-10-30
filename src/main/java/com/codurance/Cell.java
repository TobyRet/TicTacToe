package com.codurance;

public class Cell {

    private String value;

    public Cell() {
        this.value = "-";
    }
    public String getValue() {
        return value;
    };

    public void setValue (String value) {
        if(value.equals("-") || value.equals("X") || value.equals("O")) {
            this.value = value;
        } else {
            throw new RuntimeException("Invalid input set for cell");
        }
    }
}
