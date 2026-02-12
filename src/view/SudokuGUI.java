package br.com.tais.sudoku.view;

import br.com.tais.sudoku.controller.SudokuController;
import br.com.tais.sudoku.model.Cell;

import javax.swing.*;
import java.awt.*;

public class SudokuGUI extends JFrame {

    private SudokuController controller;

    public SudokuGUI() {

        controller = new SudokuController();

        setTitle("Sudoku - Tais Edition 🧩");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(9, 9));

        initializeBoard();

        setVisible(true);
    }

    private JTextField[][] fields = new JTextField[9][9];


    private void initializeBoard() {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                Cell cell = controller.getSudoku().getCell(i, j);

                JTextField textField = new JTextField();
                textField.setHorizontalAlignment(JTextField.CENTER);
                textField.setFont(new Font("Arial", Font.BOLD, 20));

                if (cell.getValue() != 0) {
                    textField.setText(String.valueOf(cell.getValue()));
                    textField.setEditable(false);
                    textField.setBackground(Color.LIGHT_GRAY);
                } else {

                    int row = i;
                    int col = j;

                    textField.addActionListener(e -> {
                        try {
                            int value = Integer.parseInt(textField.getText());

                            if (controller.checkMove(row, col, value)) {
                                textField.setBackground(Color.WHITE);
                            } else {
                                textField.setBackground(Color.PINK);
                            }

                        } catch (NumberFormatException ex) {
                            textField.setText("");
                        }
                    });
                }

                fields[i][j] = textField;
                add(textField);
            }
        }
    }

}
