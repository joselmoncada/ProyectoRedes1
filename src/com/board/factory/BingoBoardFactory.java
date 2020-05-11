package com.board.factory;

import com.board.BingoBoard;
import com.board.Board;
import com.dev.BingoBoardPrinter;
import com.tile.BingoTile;
import com.tile.mapper.TileMapper;
import com.tile.property.Value;
import com.tile.property.isMatched;
import com.token.Cardinal;

import java.util.Arrays;
import java.util.Random;
import java.util.TreeMap;

public class BingoBoardFactory implements BoardFactoryInterface {
    private TreeMap<String, BingoTile> indexByReference;
    private TreeMap<String, BingoTile> indexByValue;
    private Integer[] intArray;
    private Random randomGenerator;
    private TreeMap<Integer, TileMapper<Cardinal, BingoTile>> mapperTree;
    private final int cardLen = 25;

    public BingoBoardFactory() {
        indexByReference = new TreeMap<>();
        indexByValue = new TreeMap<>();
        intArray = new Integer[cardLen];
        Arrays.fill(intArray, 0);
        randomGenerator = new Random();
        mapperTree = new TreeMap<>();
    }

    private boolean isPresent(int number) {
        for(int value: intArray)
            if(value == number)
                return true;
        return false;
    }

    private void generateIntegerBoard() {
        for(int i = 0, newInt = 0, bound = 0, arrPos = 0; i < 5; i++, bound += 15){
            do {
                newInt = randomGenerator.nextInt(14) + 1 + bound;
                if(!isPresent(newInt))
                    intArray[arrPos++] = newInt;
            } while(arrPos % 5 != 0);
        }
        intArray[12] = 0;
    }

    private void generateMapperTree() {
        for(int i = 0; i < cardLen; i++)
            mapperTree.put(i, new TileMapper<>(new TreeMap<>()));
    }

    private void generateIndexByReference() {
        for(int i = 0; i < cardLen; i++)
            if(i == 12)
                indexByReference.put(Integer.toString(i), new BingoTile(mapperTree.get(i), new Value(0, new isMatched(true, null))));
            else
                indexByReference.put(Integer.toString(i), new BingoTile(mapperTree.get(i), new Value(intArray[i], new isMatched(false, null))));
    }
    private void setBoardMap () {
        TileMapper<Cardinal, BingoTile> mapper = null;
        for(int i = 0; i < cardLen; i++) {
            mapper = mapperTree.get(i);
            if(i > 4)
                mapper.setAdjacent(Cardinal.LEFT, indexByReference.get(Integer.toString(i - 5)));
            if(i % 5 != 4)
                mapper.setAdjacent(Cardinal.DOWN, indexByReference.get(Integer.toString(i + 1)));
            if(i < 20)
                mapper.setAdjacent(Cardinal.RIGHT, indexByReference.get(Integer.toString(i + 5)));
            if(i % 5 != 0)
                mapper.setAdjacent(Cardinal.UP, indexByReference.get(Integer.toString(i - 1)));
        }
    }
    private void generateIndexByValue() {
        for(int i = 0; i < 25; i++)
            indexByValue.put(indexByReference.get(Integer.toString(i)).getValueOfProperty("value"), indexByReference.get(Integer.toString(i)));
    }

    private void debug(boolean debugAll) {
        // It prints the map like it references from 0 - 25
        System.out.print("Tablero indexByReference: \n ");
        for(int i = 0; i < 25; i++)
            System.out.print( indexByReference.get(Integer.toString(i)).getValueOfProperty("value") + " ");

        System.out.println("\n\nTablero intArray[]: ");
        for(int i = 0; i < 5; i++)
            System.out.format(" [%2d] [%2d] [%2d] [%2d] [%2d] %n", intArray[i], intArray[i + 5], intArray[i + 10], intArray[i + 15], intArray[i + 20]);

        System.out.println(" ");
        // Prints the complete map
        if(debugAll)
            BingoBoardPrinter.print(indexByReference.get("0"), true);
    }

    @Override
    public Board generateNewBoard() {
        generateIntegerBoard();
        generateMapperTree();
        generateIndexByReference();
        setBoardMap();
        generateIndexByValue();
        debug(false);
        return new BingoBoard(indexByValue, indexByReference);
    }
}
