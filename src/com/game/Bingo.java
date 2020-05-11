package com.game;

import com.board.Board;
import com.dev.BingoBoardPrinter;
import com.dev.BingoPoolPrinter;
import com.input.Input;
import com.matcher.Matcher;
import com.poll.ValuesPool;
import com.token.Cardinal;

public class Bingo extends Game {
    protected BingoFactory factory;
    protected Matcher<Cardinal> matcher;
    protected Board board;
    protected ValuesPool<String> pool;
    protected Input input;

    @Override
    public void init() {
        exit = false;
        factory = new BingoFactory(75, false);
        matcher = factory.createMatcher();
        board = factory.createBoard();
        pool = factory.createValuesPool();
        input = factory.createInput();
    }

    @Override
    public void update() {
        String action = input.getInput();
        switch (action) {
            case "printBoard":
                BingoBoardPrinter.print(board.getTile("0","reference"), false);
                break;
            case "printValues":
                BingoPoolPrinter.print(pool);
                break;
            case "play":
                String newValue = pool.getNewValue();
                board.updateTileProperty(newValue, "value", "isMatched", "true");
                exit = matcher.checkMatch(board.getTile("0", "reference"));
                if(exit){
                    BingoBoardPrinter.print(board.getTile("0","reference"), false);
                    BingoPoolPrinter.print(pool);
                }
                break;
            case "debug":
                BingoBoardPrinter.print(board.getTile("0","reference"), false);
                BingoPoolPrinter.print(pool);

                break;
            case "endGame":
                exit = true;
                break;
            default:
                break;
        }
    }

    @Override
    public void render() {

    }

    @Override
    public void dispose() {

    }


}
