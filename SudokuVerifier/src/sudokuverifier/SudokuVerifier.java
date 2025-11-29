/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sudokuverifier;

/**
 *
 * @author Ayman
 */

public class SudokuVerifier {

    public static void main(String[] args) {

        if (args.length != 2) {
            System.out.println("Usage: java -jar SudokuVerifier.jar <file.csv> <mode>");
            return;
        }

        String path = args[0];
        int mode = Integer.parseInt(args[1]);

        SudokuBoard board = SudokuBoard.fromCsv(path);
        Verifier verifier = VerifierFactory.createVerifier(mode, board.getGrid());

        VerificationResult result = verifier.verify();

        if (result.isValid()) {
            System.out.println("VALID");
        } else {
            System.out.println("INVALID");
            for (DuplicateReport d : result.getDuplicates()) {
                System.out.println(d);
            }
        }
    }
}