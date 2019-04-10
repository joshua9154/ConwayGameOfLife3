package com.company;

import java.util.Random;
import javax.swing.JOptionPane;

class gameOfLife {

    private int[][] grid;
    private int horizontalLength;
    private int verticalLength;
    private int populationControl;



    public void setGrid(int horizontalLength, int verticalLength, int populationControl) {

        this.horizontalLength = horizontalLength;
        this.verticalLength = verticalLength;
        this.populationControl = populationControl;
        grid = new int[horizontalLength][verticalLength];
    }

    public void testGrid(int[][] grid) {
        this.grid = grid;
    }

    /*
          This code creates the first grid by filling
          it with random numbers based on the populationControl number.
           */
    public void createGrid() {
        Random randomNumbers = new Random();

        for (int row = 0; row < horizontalLength; row++) {
            for (int col = 0; col < verticalLength; col++) {
                grid[row][col] = randomNumbers.nextInt(populationControl);
            }
        }
    }

    /*This code prints out the original generation and switched all the 0's to 1
and all the other digits to 0 in order to have a easier way to deal with living and dead cells
* */
    public void announceOriginalGeneration() {
        for (int row = 0; row < horizontalLength; row++) {
            System.out.println();
            for (int col = 0; col < verticalLength; col++) {

                if (grid[row][col] == 0) {
                    System.out.print("o");
                    grid[row][col] = 1;
                } else {
                    System.out.print(".");
                    grid[row][col] = 0;
                }
            }
        }
    }

    public int[][] getGrid() {
        return grid;
    }

    /*
    This code finds out how many neighbors the cell has
    and then determines if it will live to the next round.
     */
    public void newGen(int totalIterations) {
        for (int iteration = 0; iteration < totalIterations; iteration++) {
            int[][] nextGen = new int[horizontalLength][verticalLength];
            for (int row = 0; row < horizontalLength; row++) {
                for (int col = 0; col < verticalLength; col++) {
                    boolean isAlive = isAlive(row, col);
                    int totalNeighborCount = totalNeighborCount(row, col);

                    if (isAlive && totalNeighborCount < 2)
                        nextGen[row][col] = 0;
                    else if (isAlive && totalNeighborCount > 3)
                        nextGen[row][col] = 0;
                    else if (isAlive == false && totalNeighborCount == 3)
                        nextGen[row][col] = 1;
                    else if (isAlive && totalNeighborCount == 2 || isAlive && totalNeighborCount == 3)
                        nextGen[row][col] = 1;
                }
         /*
         This code announces the new generation
          */
            }
            System.out.println();
            System.out.println();
            System.out.println("This is New Generation number " + (iteration + 1));
            for (int row = 0; row < horizontalLength; row++) {
                System.out.println();
                for (int col = 0; col < verticalLength; col++) {
                    if (nextGen[row][col] == 1)
                        System.out.print("o");
                    else
                        System.out.print(".");
                }
                /*
                This code makes the new generation the
                current generation
                 */
            }
            for (int row = 0; row < horizontalLength; row++) {
                for (int col = 0; col < verticalLength; col++) {
                    grid[row][col] = nextGen[row][col];
                }
            }
        }
        /*
        This code figures out if the current cell
        is alive or not.
         */
    }

    public boolean isAlive(int row, int col) {
        boolean isAlive = false;
        if (grid[row][col] == 1)
            isAlive = true;
        return isAlive;

    }

    /*
    This program figures out the total amount of live neighbors
    using Math.max and min to not go out of bounds.
     */
    public int totalNeighborCount(int row, int col) {
        int totalNeighborCount = 0;
        for (int x = Math.max(0, row - 1); x <= Math.min(horizontalLength - 1, row + 1); x++)
            for (int y = Math.max(0, col - 1); y <= Math.min(verticalLength - 1, col + 1); y++) {

                if (row == x && col == y)
                    continue;

                if (grid[x][y] == 1)
                    totalNeighborCount++;

            }
        return totalNeighborCount;
    }
}

public class Main {

    /*
    Programmer Joshua Steinerman
     */

    public static void main(String[] args) {
        int horizontalLength = 20;
        int verticalLength = 100;
        int populationControl = 10;
        int totalIterations = 100;

        JOptionPane.showMessageDialog(null, "The Game of Life is ready to begin, are you?");
        System.out.println("This is the original Generation");

        gameOfLife box = new gameOfLife();
        box.setGrid(horizontalLength, verticalLength, populationControl);
        box.createGrid();
        box.announceOriginalGeneration();
        box.newGen(totalIterations);
    }
}


