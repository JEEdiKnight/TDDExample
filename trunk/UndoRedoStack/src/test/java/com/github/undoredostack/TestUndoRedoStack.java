package com.github.undoredostack;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TestUndoRedoStack {

    static final String COMMAND_1 = "command1";
    static final String COMMAND_2 = "command2";
    private UndoRedoStack stack;

    @Before
    public void setUp() {
        stack = new UndoRedoStack();
    }

    @Test(expected = NoCommandToUndoException.class)
    public void undoWithOutPreviousCommandsThrowException() {
        //Act
        stack.undo();
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

    @Test
    public void undoTwoCommandUseReturnSecondCommand() {
        //Arrange
        stack.command(COMMAND_1);
        stack.command(COMMAND_2);
        //Act
        String actualResult = stack.undo();
        //Assert
        assertEquals(COMMAND_2, actualResult);
    }

    @Test
    public void twoCommandsTwoUndoLastUndoReturnsFirstCommand() {
        //Arrange
        stack.command(COMMAND_1);
        stack.command(COMMAND_2);
        //Act
        stack.undo();
        String actualResult = stack.undo();
        //Assert
        assertEquals(COMMAND_1, actualResult);
    }

    @Test(expected = NoCommandToRedoException.class)
    public void redoWithNoPreviousUndoThrowException() {
        //Act
        stack.redo();
    }

    @Test
    public void redoLastCommandUndone() {
        stack.command(COMMAND_1);
        stack.undo();
        String actualResult = stack.redo();
        assertEquals(COMMAND_1, actualResult);
    }
    @Test
    public void twoUndoOneRedoShouldReturnSecondCommandUndone() {
        stack.command(COMMAND_1);
        stack.command(COMMAND_2);
        stack.undo();//undo COMMAND_2
        stack.undo();//undo COMMAND_1
        String actualResult = stack.redo();
        assertEquals(COMMAND_1, actualResult);
    }

    @Test
    public void twoUndoTwoRedoShouldReturnFirstCommandUndone() {
        stack.command(COMMAND_1);
        stack.command(COMMAND_2);
        stack.undo();//undo COMMAND_2
        stack.undo();//undo COMMAND_1
        stack.redo();
        String actualResult = stack.redo();
        assertEquals(COMMAND_2, actualResult);
    }
    
    @Test
    public void canUndoCommandShouldReturnFalseWhenNoCommands() {
        boolean actualResult = stack.canUndoCommand();
        assertFalse(actualResult);
    }

    @Test
    public void canUndoCommandShouldReturnTrueWhenCommandsBeenUsed() {
        stack.command(COMMAND_1);
        boolean actualResult = stack.canUndoCommand();
        assertTrue(actualResult);
    }
}
