package com.company;

/*
Programmer Joshua Steinerman
 */
public class gameOfLifeTest {

    @org.junit.Test
    public void setGrid() {
        /*
        First Test
         */
        int horizontalLength = 2, verticalLength = 2, populationControl = 3;
        gameOfLife box = new gameOfLife();
        box.setGrid(horizontalLength, verticalLength, populationControl);
        int[][] actual = box.getGrid();
        int[][] wantedResult = new int[2][2];
        org.junit.Assert.assertArrayEquals(wantedResult, actual);

        /*
        Second Test
         */

        int[][] wrongResult = new int[1][2];
        org.junit.Assert.assertArrayEquals(wrongResult, actual);


    }

    @org.junit.Test
    public void isAlive() {
        /*
        First Test
         */
        int horizontalLength = 2, verticalLength = 2, falsePopulationControl = 0, truePopulationControl = 1;
        gameOfLife box = new gameOfLife();
        box.setGrid(horizontalLength, verticalLength, falsePopulationControl);
        box.createGrid();
        boolean result = box.isAlive(1, 1);
        org.junit.Assert.assertFalse(result);

        /*
        Second Test
         */
        box.setGrid(horizontalLength, verticalLength, truePopulationControl);
        box.createGrid();
        boolean trueResult = box.isAlive(1, 1);
        org.junit.Assert.assertFalse(trueResult);


    }

    @org.junit.Test
    public void createGrid() {
        int horizontalLength = 2, verticalLength = 2, populationControl = 1;
        int[][] expected = {{0, 0}, {0, 0}};
        gameOfLife box = new gameOfLife();
        box.setGrid(horizontalLength, verticalLength, populationControl);
        box.createGrid();
        int[][] actual = box.getGrid();
        org.junit.Assert.assertArrayEquals(expected, actual);

    }

    @org.junit.Test
    public void getGrid() {
        gameOfLife box = new gameOfLife();
        int[][] expected = {{0, 0, 0}, {0, 0, 0}, {0, 1, 0}};
        box.testGrid(expected);
        org.junit.Assert.assertArrayEquals(expected, box.getGrid());
    }


}