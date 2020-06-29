package com.paul.leetcode;

import java.util.Objects;

public class Tictactoe {

    public static String tictactoe_1(String[] board) {
        if (Objects.isNull(board)|| !Objects.equals(board.length, board[0].length())) {
            return "ERROR";
        }

        int length = board.length;

        int sumRow = 0, sumColumn = 0, sumX1 = 0, sumX2 = 0;
        boolean waitPending = false;

        for (int i = 0; i < length; ++i) {
            sumRow = 0;
            sumColumn = 0;

            sumX1 += board[i].charAt(i);
            sumX2 += board[i].charAt(length - i - 1);

            for (int j = 0; j < length; ++j) {
                sumRow += board[i].charAt(j);
                sumColumn += board[j].charAt(i);

                if (board[i].charAt(j) == ' ') {
                    waitPending = true;
                }
            }

            if (Objects.equals(sumRow, 'X' * length) || Objects.equals(sumColumn, 'X' *length)) {
                return "X";
            }

            if (Objects.equals(sumRow, 'O' * length) || Objects.equals(sumColumn, 'O' *length)) {
                return "O";
            }
        }

        if (Objects.equals(sumX1, 'X' * length) || Objects.equals(sumX2, 'X' *length)) {
            return "X";
        }

        if (Objects.equals(sumX1, 'O' * length) || Objects.equals(sumX2, 'O' *length)) {
            return "O";
        }


        return waitPending ? "Pending" : "Draw";
    }

    public static String tictactoe(String[] board) {
        if (Objects.isNull(board)|| !Objects.equals(board.length, board[0].length())) {
            return "ERROR";
        }

        int length = board.length;

        boolean waitPending = false;

        for (int i = 0; i < length; ++i) {
            for (int j = 0; j < length; ++j) {

                if (board[i].charAt(j) == ' ') {
                    waitPending = true;
                    continue;
                }

                if (hasWon(board, i, j)) {
                    return "" + board[i].charAt(j);
                }
            }
        }

        return waitPending ? "Pending" : "Draw";
    }

    private static boolean hasWon(String[] board, int i, int j) {
        // row check
        if (Objects.equals(j, 0) && (rowCheck(board[i]))) {
            return true;
        }

        // column check
        if (Objects.equals(i, 0) && columnCheck(board, j)) {
            return true;
        }

        // X1 check
        if (Objects.equals(i, 0) && Objects.equals(j, 0) && X1Check(board)) {
            return true;
        }

        // X2 check
        if (Objects.equals(i, 0) && Objects.equals(j, board[0].length() - 1) && X2Check(board)) {
            return true;
        }

        return false;
    }

    private static boolean X2Check(String[] board) {
        int length = board.length;

        for (int i = 1; i < board.length; ++i) {
            if (!Objects.equals(board[i].charAt(length - i - 1), board[i - 1].charAt(length - i))) {
                return false;
            }
        }

        return true;
    }


    private static boolean X1Check(String[] board) {
        for (int i = 1; i < board.length; ++ i) {
            if (!Objects.equals(board[i].charAt(i), board[i - 1].charAt(i - 1))) {
                return false;
            }
        }

        return true;
    }

    private static boolean columnCheck(String[] board, int j) {
        for (int i = 1; i < board.length; ++i) {
            if (!Objects.equals(board[i].charAt(j), board[i - 1].charAt(j))) {
                return false;
            }
        }

        return true;
    }

    private static boolean rowCheck(String s) {
        for (int i = 1; i < s.length(); ++i) {
            if (!Objects.equals(s.charAt(i), s.charAt(i - 1))) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String[] strings = {"O X"," XO","X O"};
        System.out.println(tictactoe_1(strings));
    }
}
