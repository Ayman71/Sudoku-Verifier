/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sudokuverifier;

/**
 *
 * @author Ayman
 */

public class VerifierFactory {

    public static Verifier createVerifier(int mode, int[][] board) {

        switch (mode) {
            case 0:  return new SequentialVerifier(board);
            case 3:  return new ThreeThreadVerifier(board);
            case 27: return new TwentySevenThreadVerifier(board);
        }

        throw new IllegalArgumentException("Mode must be 0, 3, or 27");
    }
}