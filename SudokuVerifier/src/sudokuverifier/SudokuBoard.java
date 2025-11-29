/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sudokuverifier;

/**
 *
 * @author Ayman
 */
import java.io.BufferedReader;
import java.io.FileReader;

public class SudokuBoard {

    private int[][] grid;

    public SudokuBoard(int[][] grid) {
        this.grid = grid;
    }

    public static SudokuBoard fromCsv(String path) {
        int[][] board = new int[9][9];

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            int r = 0;

            while ((line = br.readLine()) != null && r < 9) {
                String[] parts = line.split(",");
                for (int c = 0; c < 9; c++) {
                    board[r][c] = Integer.parseInt(parts[c].trim());
                }
                r++;
            }
        } catch (Exception e) {
            System.err.println("Error reading CSV: " + e.getMessage());
        }

        return new SudokuBoard(board);
    }

    public int[][] getGrid() {
        return grid;
    }
}