/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.project.master;
import static org.junit.Assert.*;
import org.junit.Test;


/**
 *
 * @author tlesi
 */
public class TaskTest {
    
     @Test
    public void testCheckTaskDescriptionSuccess() {
        Task task = new Task("Login Feature", 0, "Create Login to authenticate users", "Robyn Harrison", 8, "To Do");
        assertTrue(task.checkTaskDescription());
    }

    @Test
    public void testCheckTaskDescriptionFailure() {
        Task task = new Task("Login Feature", 0, "This description is way too long and should fail validation", "Robyn Harrison", 8, "To Do");
        assertFalse(task.checkTaskDescription());
    }

    @Test
    public void testCreateTaskID() {
        Task task = new Task("Login Feature", 0, "Create Login to authenticate users", "Robyn Harrison", 8, "To Do");
        assertEquals("LO:0:SON", task.createTaskID());
    }
}