package io.github.srujangajul.drm.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Game {
    private int id;
    private User user1;
    private User user2;
    private Board board;
    private Status status;
    private User playerTurn;
    private User winner;
    private int moveCount;




    public Game(User u1, User u2){
        this.user1 = u1;
        this.user2 = u2;
        this.board = new Board();
        this.status = Status.IN_PROGRESS;
        playerTurn = user1;

    }

    public int placeMove(int x, int y){
        int valueOfUser = playerTurn.equals(user1)? 1: 2;
        boolean moveSuccessful = board.move(x,y, valueOfUser);
        if(moveSuccessful){
            moveCount++;
            playerTurn = playerTurn.equals(user1)? user2: user1;
            int playerWon = board.playerWon(x, y, valueOfUser);
            this.status = computeStatus(moveCount, playerWon);
            return playerWon;
        }
        else{
            return 2;
        }
    }
    public Status computeStatus(int moveCount, int won){
        if(moveCount == 9 && won==0){
            return Status.DRAW;
        }
        if(won!=0){
            return Status.COMPLETED;
        }
        return Status.IN_PROGRESS;
    }

    @Getter
    enum Status{
        COMPLETED("Completed"),
        IN_PROGRESS("InProgress"),
        DRAW("Draw");

        private final String status;

        Status(String status){
            this.status = status;
        }
    }
}

