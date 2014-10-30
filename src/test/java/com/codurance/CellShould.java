package com.codurance;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CellShould {

    private Cell cell;

    @Before
    public void initialise() {
        cell = new Cell();
    }

    @Test public void
    should_be_empty_when_initialised() {
        assertThat(cell.getValue(), is("-"));
    }

    @Test public void
    set_value_to_X_or_O() {
        cell.setValue("X");
        assertThat(cell.getValue(),is("X"));

        cell.setValue("O");
        assertThat(cell.getValue(),is("O"));
    }

    @Test(expected = RuntimeException.class) public void
    throw_exception_if_invalid_value_set_for_cell() {
        cell.setValue("T");
    }
}
