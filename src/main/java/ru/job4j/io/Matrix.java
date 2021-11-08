package ru.job4j.io;

import java.io.FileOutputStream;

public class Matrix {

    private static int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                table[i][j] = (i + 1) * (j + 1);
            }
        }
        return table;
    }

    private static void writeMatrixToFile(int[][] table) {
        try (FileOutputStream out = new FileOutputStream("resultMatrix.txt")) {
            for (int i = 0; i < table.length; i++) {
                for (int j = 0; j < table[i].length; j++) {
                    out.write(Integer.toString(table[i][j]).getBytes());
                    out.write(" ".getBytes());
                }
                out.write(System.lineSeparator().getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        int size = 9;
        writeMatrixToFile(multiple(size));
    }
}
