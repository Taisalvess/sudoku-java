package br.com.tais.sudoku.controller;

import javax.swing.JOptionPane;
import br.com.tais.sudoku.model.Sudoku;

public class SudokuController {

    private Sudoku sudoku;

    public SudokuController() {
        sudoku = new Sudoku();
    }

    public Sudoku getSudoku() {
        return sudoku;
    }

    public boolean checkMove(int row, int col, int value) {

        boolean correct = sudoku.isCorrect(row, col, value);

        if (correct) {
            sudoku.getCell(row, col).setValue(value);
        }

        if (sudoku.isComplete()) {
            JOptionPane.showMessageDialog(null, "Parabéns! Você venceu!");
        }

        return correct;
    }
}
