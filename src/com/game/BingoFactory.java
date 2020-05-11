package com.game;

import com.board.Board;
import com.board.factory.BingoBoardFactory;
import com.input.Input;
import com.input.Terminal;
import com.matcher.BingoAllBoardMatch;
import com.matcher.BingoLinearMatch;
import com.matcher.BingoMatcher;
import com.matcher.Matcher;
import com.poll.BingoPool;
import com.poll.ValuesPool;
import com.token.Cardinal;

public class BingoFactory {
    protected int maxNumber;
    protected boolean fullBoard;

    public BingoFactory(int maxNumber, boolean fullBoard) {
        this.maxNumber = maxNumber;
        this.fullBoard = fullBoard;
    }

    public ValuesPool<String> createValuesPool() {
        return new BingoPool(maxNumber);
    }

    public Board createBoard() {
        return (new BingoBoardFactory()).generateNewBoard();
    }

    public Matcher<Cardinal> createMatcher() {
        if(fullBoard)
            return new BingoMatcher(new BingoAllBoardMatch(null));
        return new BingoMatcher(new BingoLinearMatch(null));
    }

    public Input createInput() {
        return new Terminal();
    }
}
