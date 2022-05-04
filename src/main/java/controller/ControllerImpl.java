package controller;

import model.BoardImpl;

public class ControllerImpl {

    private BoardImpl board;
    public ControllerImpl(BoardImpl boardimpl){
        board = boardimpl;
    }

    public BoardImpl getBoard() {
        return board;
    }
}
