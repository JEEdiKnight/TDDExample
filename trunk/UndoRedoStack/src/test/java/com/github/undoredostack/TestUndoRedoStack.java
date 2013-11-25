package com.github.undoredostack;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TestUndoRedoStack {

    static final String COMMAND_1 = "command1";
    private UndoRedoStack stack;

    @Before
    public void setUp() {
        stack = new UndoRedoStack();
    }

    @Test
    public void undoReturnLastCommand() {
        //Arrange
        stack.command(COMMAND_1);
        //Act
        String actualResult = stack.undo();
        //Assert
        assertEquals(COMMAND_1, actualResult);
    }
}
