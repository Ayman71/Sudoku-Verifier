/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sudokuverifier;

/**
 *
 * @author Ayman
 */

public class TwentySevenThreadVerifier implements Verifier {

    private int[][] board;
    private VerificationResult result;

    public TwentySevenThreadVerifier(int[][] board) {
        this.board = board;
        this.result = new VerificationResult();
    }

    @Override
    public VerificationResult verify() {

        Thread[] threads = new Thread[27];
        int i = 0;

        for (int r = 0; r < 9; r++)
            threads[i++] = new Thread(new RowChecker(r, board, result));

        for (int c = 0; c < 9; c++)
            threads[i++] = new Thread(new ColumnChecker(c, board, result));

        for (int b = 0; b < 9; b++)
            threads[i++] = new Thread(new BoxChecker(b, board, result));

        for (Thread t : threads) t.start();

        for (Thread t : threads) {
            try { t.join(); } catch (InterruptedException e) {}
        }

        return result;
    }
}
