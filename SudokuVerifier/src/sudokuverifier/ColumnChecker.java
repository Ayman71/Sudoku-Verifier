/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sudokuverifier;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ayman
 */
public class ColumnChecker extends Worker {

    public ColumnChecker(int index, int[][] board, VerificationResult result) {
        super(index, board, result);
    }

    @Override
    public void run() {
        List<Integer>[] positions = new List[10];

        for (int i = 0; i < 10; i++)
            positions[i] = new ArrayList<>();

        for (int row = 0; row < 9; row++) {
            int value = board[row][index];
            positions[value].add(row + 1);
        }

        for (int value = 1; value <= 9; value++) {
            if (positions[value].size() > 1) {
                int[] posArray = positions[value].stream().mapToInt(Integer::intValue).toArray();
                result.addDuplicate(
                    new DuplicateReport("COL", index + 1, value, posArray)
                );
            }
        }
    }
}
