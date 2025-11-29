/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sudokuverifier;

import java.util.Arrays;

/**
 *
 * @author Ayman
 */
public class DuplicateReport {

    private String regionType;   // ROW, COL, BOX
    private int regionIndex;     // 1–9
    private int duplicateValue;  // duplicated number
    private int[] duplicatePositions; // positions where this duplicate occurs

    public DuplicateReport(String regionType, int regionIndex, int duplicateValue, int[] duplicatePositions) {
        this.regionType = regionType;
        this.regionIndex = regionIndex;
        this.duplicateValue = duplicateValue;
        this.duplicatePositions = duplicatePositions;
    }

    @Override
    public String toString() {
        return String.format(
            "%s %d, #%d, %s",
            regionType,
            regionIndex,
            duplicateValue,
            Arrays.toString(duplicatePositions)
        );
    }
}