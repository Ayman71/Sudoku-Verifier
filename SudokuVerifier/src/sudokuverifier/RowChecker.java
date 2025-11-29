/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sudokuverifier;

/**
 *
 * @author Ayman
 */
public class RowChecker extends Worker {

    public RowChecker(int index, int[][] board, VerificationResult result) {
        super(index, board, result);
    }

    @Override
    public void run() {
        boolean[] seen = new boolean[10];

        for (int n : board[index]) {
            if (seen[n]) {
                result.addDuplicate(new DuplicateReport("ROW", index + 1, n));
                return;
            }
            seen[n] = true;
        }
    }
}