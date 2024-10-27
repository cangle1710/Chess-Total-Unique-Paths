package org.parabolic.chess;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class KnightMoves implements ChessMoves {
    private static final int[][] KNIGHT_MOVES = {
            {2, 1}, {2, -1}, {-2, 1}, {-2, -1},
            {1, 2}, {1, -2}, {-1, 2}, {-1, -2}
    };
    private static final Set<Character> VOWELS = Set.of('A', 'E', 'I', 'O', 'U', 'Y');
    private final String[][] input;
    private final Set<String> uniquePaths;

    public KnightMoves(String[][] input) {
        this.input = input;
        this.uniquePaths = new HashSet<>();
    }

    private void dfs(int x, int y, StringBuilder path, int vowels) {
        // requirement sanity check
        if (vowels > 2 || path.length() > 10) {
            return;
        }

        if (path.length() == 10) {
            uniquePaths.add(path.toString());
        } else {
            // else explore all other knight paths
            for (int[] move : KNIGHT_MOVES) {
                int nextX = x + move[0];
                int nextY = y + move[1];

                if (isValid(nextX, nextY, input)) {
                    // continue the dfs
                    path.append(input[nextX][nextY]);

                    int nextVowelCount = VOWELS.contains(input[nextX][nextY].charAt(0)) ? 1 : 0;
                    dfs(nextX, nextY, path, vowels + nextVowelCount);

                    // backtrack
                    path.deleteCharAt(path.length() - 1);
                }
            }
        }
    }

    private boolean isValid(int x, int y, String[][] input) {
        return x >= 0 && x < input.length && y >= 0 && y < input[x].length && !Objects.equals(input[x][y], "#");
    }

    @Override
    public long solve() {
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length; j++) {
                if (isValid(i, j, input)) {
                    StringBuilder path = new StringBuilder(input[i][j]);
                    int vowelCount = VOWELS.contains(input[i][j].charAt(0)) ? 1 : 0;
                    dfs(i, j, path, vowelCount);
                }
            }
        }

        return uniquePaths.size();
    }
}
