/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sudokuverifier;

/**
 *
 * @author Ayman
 */
public class ThreeThreadVerifier implements Verifier {

    private int[][] board;
    private VerificationResult result;

    public ThreeThreadVerifier(int[][] board) {
        this.board = board;
        this.result = new VerificationResult();
    }

    @Override
    public VerificationResult verify() {

        Thread tRows = new Thread(() -> {
            for (int r = 0; r < 9; r++)
                new RowChecker(r, board, result).run();
        });

        Thread tCols = new Thread(() -> {
            for (int c = 0; c < 9; c++)
                new ColumnChecker(c, board, result).run();
        });

        Thread tBoxes = new Thread(() -> {
            for (int b = 0; b < 9; b++)
                new BoxChecker(b, board, result).run();
        });

        tRows.start(); tCols.start(); tBoxes.start();

        try {
            tRows.join();
            tCols.join();
            tBoxes.join();
        } catch (InterruptedException e) {}

        return result;
    }
}
