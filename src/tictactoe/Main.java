package tictactoe;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Field holder = new Field();
        boolean over = false;
        // Creating initial char array
        char[][] ticTac = holder.setField(' ');
        // Printing 2d array
        holder.printField(ticTac);

        while (over == false) {
            holder.setCoords(ticTac);

            if(holder.isOver() == true)
                over = true;
            }


    }
}


class Field {
    private char[][] field = new char[3][3];
    boolean playerX = true;

    public boolean isOver() {
        return over;
    }

    public void setOver(boolean over) {
        this.over = over;
    }

    boolean over = false;

    public boolean isPlayerX() {
        return playerX;
    }

    public void setPlayerX(boolean playerX) {
        this.playerX = playerX;
    }

    public boolean isPlayerO() {
        return playerO;
    }

    public void setPlayerO(boolean playerO) {
        this.playerO = playerO;
    }

    boolean playerO = false;

    // Creating initial field
    char[][] setField(char input) {
        int charCounter = 0;
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                field[x][y] = input;
                // changing character '_' to whitespace
                if (field[x][y] == '_') {
                    field[x][y] = ' ';
                }
            }
        }
        return field;
    }


    // Printing array
    void printField(char[][] field) {
        System.out.println("---------");
        for (int x = 0; x < 3; x++) {
            System.out.print("| ");
            for (int y = 0; y < 3; y++) {
                System.out.print(field[x][y] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    // Getting coordinates and testing conditions
    void setCoords(char[][] field) {
        boolean success = false;
        while (!success) {
            System.out.print("Enter the coordinates: ");
            try {
                int x = Main.sc.nextInt();
                int y = Main.sc.nextInt();
                int realX = 3 - y;
                int realY = Math.abs(1 - x);

                if (x >= 1 && x <= 3 && y >= 1 && y <= 3 && field[realX][realY] == ' ') {
                    field = setField(field, realX, realY);
                    printField(field);
                    over = checkStat(field);
                    success = true;
                } else if (field[realX][realY] != ' ') {
                    System.out.println("This cell is occupied! Choose another one!");
                    continue;
                } else {
                    System.out.println("Coordinates should be from 1 to 3!");
                    continue;
                }
            } catch (Exception e) {
                System.out.println("You should enter numbers!");
                String catchError = Main.sc.nextLine();
            }
        }
    }

    // Assign 'X' (with coordinates) to array
    char[][] setField(char[][] field, int xC, int yC) {
        if (isPlayerX()) {
            field[xC][yC] = 'X';
            setPlayerX(false);
            setPlayerO(true);
        } else if (isPlayerO()) {
            field[xC][yC] = 'O';
            setPlayerX(true);
            setPlayerO(false);
        }

        return field;
    }


    boolean checkStat(char[][] field) {
        for (int i = 0; i < 3; i++) {
            if (field[i][0] == field[i][1] && field[i][0] == field[i][2] && field[i][0] != ' ' && field[i][1] != ' ' && field[i][2] != ' ') {
                System.out.println(field[i][0] + " wins");
                return true;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (field[0][i] == field[1][i] && field[0][i] == field[2][i] && field[0][i] != ' ' && field[1][i] != ' ' && field[2][i] != ' ') {
                System.out.println(field[0][i] + " wins");
                return true;
            }
        }
        if(field[0][2] == field[1][1] && field[1][1] == field[2][0] && field[0][2] != ' '&& field[1][1] != ' ' && field[2][0] != ' '){
            System.out.println(field[1][1] + " wins");
            return true;
        }
        if(field[0][0] == field[1][1] && field[1][1] == field[2][2] && field[0][0] != ' '&& field[1][1] != ' ' && field[2][2] != ' '){
            System.out.println(field[1][1] + " wins");
            return true;
        }
        


            return false;
    }

}