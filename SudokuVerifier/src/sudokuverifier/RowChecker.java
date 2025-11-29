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
public class RowChecker extends Worker {

    public RowChecker(int index, int[][] board, VerificationResult result) {
        super(index, board, result);
    }

    @Override
    public void run() {
        int[] row = board[index];
        List<Integer>[] positions = new List[10];

        for (int i = 0; i < 10; i++)
            positions[i] = new ArrayList<>();

        // scan row and collect positions
        for (int col = 0; col < 9; col++) {
            int value = row[col];
            positions[value].add(col + 1); // 1-based index
        }

        // after scanning, report duplicates
        for (int value = 1; value <= 9; value++) {
            if (positions[value].size() > 1) {
                int[] posArray = positions[value].stream().mapToInt(Integer::intValue).toArray();
                result.addDuplicate(
                    new DuplicateReport("ROW", index + 1, value, posArray)
                );
            }
        }
    }
}