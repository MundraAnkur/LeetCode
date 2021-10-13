package com.problem.coding.medium;

/**
 * @author ankurmundra
 * October 06, 2021
 */
public class LC79_WordSearch {
    private boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        visited = new boolean[m][n];

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (board[i][j] == word.charAt(0) && search(board, i, j, word, 0))
                    return true;
        return false;
    }

    private boolean search(char[][] board, int i, int j, String word, int wordIndex) {
        if (wordIndex == word.length())
            return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || visited[i][j] || board[i][j] != word.charAt(wordIndex))
            return false;

        visited[i][j] = true;
        if (search(board, i + 1, j, word, wordIndex + 1) ||
                search(board, i - 1, j, word, wordIndex + 1) ||
                search(board, i, j + 1, word, wordIndex + 1) ||
                search(board, i, j - 1, word, wordIndex + 1))
            return true;
        visited[i][j] = false;
        return false;
    }
}
