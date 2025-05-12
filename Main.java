import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        char[][] chr = new char[3][3];
        for (int row = 0; row < chr.length; row++) {
            for (int col = 0; col < chr[row].length; col++) {
                chr[row][col] = ' ';
            }
        }
        char player = 'X';
        boolean gameOver = false;
        Scanner sc = new Scanner(System.in);
        while (!gameOver) {
            printBoard(chr);
            System.out.print("Player " + player + ", Enter: "); 
            int row = sc.nextInt();
            int col = sc.nextInt();
            if(chr[row][col] == ' ') {
                chr[row][col] = player;
                gameOver = haveWon(chr, player);
                    if(gameOver) {
                        System.out.println("Player " + player + " has won!");
                    } else {
                        player = (player == 'X') ? 'O' : 'X';
                    }
            } else {
                System.out.println("Invalid move! Try again.");
            }
        } 
        printBoard(chr);
    }
    public static boolean haveWon(char[][] board, char player) {
        for (int row = 0; row < board.length; row++) {
            if (board[row][0] == player && board[row][1] == player && board[row][2] == player) {
                return true;
            }
        }

        for(int col = 0; col < board.length; col++) {
            if (board[0][col] == player && board[1][col] == player && board[2][col] == player) {
                return true;
            }
        }

        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }

        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }
        return false;
    }

    public static void printBoard(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                System.out.print(board[row][col] + " | ");
            }
            System.out.println();
        }
    }
}
