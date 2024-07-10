package io.github.srujangajul.drm.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Board {
    private int[][] squares = new int[3][3];

    public boolean move(int x, int y, int value) {
        if (x > 2 || x < 0 || y > 2 || y < 0) {
            return false;
        } else if (squares[x][y] != 0) {
            return false;
        }
        squares[x][y] = value;
        return true;
    }

    public int playerWon(int x, int y, int value) {
        if (
                checkIfAllValuesEqual(squares[x][0], squares[x][1], squares[x][2]) ||
                checkIfAllValuesEqual(squares[0][y], squares[1][y], squares[2][y])
        ) {
            return value;
        }

        if (
                (x == y || x + y == 2) &&
                (
                        checkIfAllValuesEqual(squares[0][0], squares[1][1], squares[2][2]) ||
                        checkIfAllValuesEqual(squares[0][2], squares[1][1], squares[2][0])
                )
        ) {
            return value;
        }

        return 0;
    }

    private boolean checkIfAllValuesEqual(int a, int b, int c) {
        return a == b && b == c;
    }
}
