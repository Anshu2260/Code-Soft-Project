package ttictacToe;

import java.util.Scanner;

public class TIcTacToe {
    static final char HUMAN = 'X';
    static final char AI = 'O';
    static final char EMPTY = '_';

    static char[][] board = {
            { EMPTY, EMPTY, EMPTY },
            { EMPTY, EMPTY, EMPTY },
            { EMPTY, EMPTY, EMPTY }
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        printBoard();

        while (true) {
            humanMove(scanner);
            printBoard();
            if (isGameOver()) break;

            System.out.println("AI is making a move 0...");
            Move bestMove = findBestMove();
            board[bestMove.row][bestMove.col] = AI;
            printBoard();
            if (isGameOver()) break;
        }

        scanner.close();
    }

    static void printBoard() {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("---------");
    }

    static void humanMove(Scanner scanner) {
        int row, col;
        while (true) {
            System.out.print("Enter your move X (row and column: 0 1 2): ");
            row = scanner.nextInt();
            col = scanner.nextInt();
            if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == EMPTY) {
                board[row][col] = HUMAN;
                break;
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }
    }

    static boolean isGameOver() {
        int score = evaluate();
        if (score == 10) {
            System.out.println("AI wins!");
            return true;
        } else if (score == -10) {
            System.out.println("You win!");
            return true;
        } else if (!isMovesLeft()) {
            System.out.println("It's a draw!");
            return true;
        }
        return false;
    }

    static boolean isMovesLeft() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (board[i][j] == EMPTY)
                    return true;
        return false;
    }

    static int evaluate() {
        for (int row = 0; row < 3; row++) {
            if (board[row][0] == board[row][1] &&
                    board[row][1] == board[row][2]) {
                if (board[row][0] == AI)
                    return 10;
                else if (board[row][0] == HUMAN)
                    return -10;
            }
        }

        for (int col = 0; col < 3; col++) {
            if (board[0][col] == board[1][col] &&
                    board[1][col] == board[2][col]) {
                if (board[0][col] == AI)
                    return 10;
                else if (board[0][col] == HUMAN)
                    return -10;
            }
        }

        if (board[0][0] == board[1][1] &&
                board[1][1] == board[2][2]) {
            if (board[0][0] == AI)
                return 10;
            else if (board[0][0] == HUMAN)
                return -10;
        }

        if (board[0][2] == board[1][1] &&
                board[1][1] == board[2][0]) {
            if (board[0][2] == AI)
                return 10;
            else if (board[0][2] == HUMAN)
                return -10;
        }

        return 0;
    }

    static int minimax(int depth, boolean isMax) {
        int score = evaluate();

        if (score == 10 || score == -10)
            return score;

        if (!isMovesLeft())
            return 0;

        if (isMax) {
            int best = Integer.MIN_VALUE;
            for (int i = 0; i < 3; i++)
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == EMPTY) {
                        board[i][j] = AI;
                        best = Math.max(best, minimax(depth + 1, false));
                        board[i][j] = EMPTY;
                    }
                }
            return best;
        } else {
            int best = Integer.MAX_VALUE;
            for (int i = 0; i < 3; i++)
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == EMPTY) {
                        board[i][j] = HUMAN;
                        best = Math.min(best, minimax(depth + 1, true));
                        board[i][j] = EMPTY;
                    }
                }
            return best;
        }
    }

    static Move findBestMove() {
        int bestVal = Integer.MIN_VALUE;
        Move bestMove = new Move(-1, -1);

        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == EMPTY) {
                    board[i][j] = AI;
                    int moveVal = minimax(0, false);
                    board[i][j] = EMPTY;

                    if (moveVal > bestVal) {
                        bestMove.row = i;
                        bestMove.col = j;
                        bestVal = moveVal;
                    }
                }
            }
        return bestMove;
    }

    static class Move {
        int row, col;

        Move(int r, int c) {
            row = r;
            col = c;
        }
    }
}
