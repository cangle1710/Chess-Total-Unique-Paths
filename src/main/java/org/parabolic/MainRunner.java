package org.parabolic;

import org.parabolic.chess.KnightMoves;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainRunner {
    private static final String FILE_NAME = "input.txt";

    public static String[][] readFileToArray(String fileName) throws IOException {
        List<String[]> rows = new ArrayList<>();

        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream(fileName);

        try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                rows.add(row);
            }
        }

        // Convert the list of rows to a 2D array
        String[][] grid = new String[rows.size()][];
        for (int i = 0; i < rows.size(); i++) {
            grid[i] = rows.get(i);
        }

        return grid;
    }

    public static void main(String[] args) {

        try {
            String[][] grid = readFileToArray(FILE_NAME);
            // print out grid for display purposes
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    System.out.print(grid[i][j] + " ");
                }
                System.out.println();
            }

            KnightMoves knightMoves = new KnightMoves(grid);
            long result = knightMoves.solve();
            System.out.println("Total unique paths using knight moves: " + result);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}