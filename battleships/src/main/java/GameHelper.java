

import java.io.*;
import java.util.*;

public class GameHelper {
    private static final String alphabet = "abcdefghij";
    private int boardLength = 10;
    private int boardSize = 100;
    private int [] board = new int[boardSize];
    private int shipsCount = 0;

    public String getEntryData(String message) {
        String entryData = null;
        System.out.print(message + "  ");
        try {
            BufferedReader is = new BufferedReader(
                    new InputStreamReader(System.in));
            entryData = is.readLine();
            if (entryData.length() == 0 )  return null;
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }
        return entryData.toLowerCase();
    }

    public ArrayList placeShip (int shipSize) {
        ArrayList<String> occupiedFields = new ArrayList<String>();
        String [] coordinates = new String [shipSize];
        String help = null;
        int [] currentCoordinates = new int[shipSize];
        int triesCount = 0;
        boolean isSuccessful = false;
        int placement = 0;

        shipsCount++;
        int incr = 1;
        if ((shipsCount % 2) == 1) {
            incr = boardLength;
        }

        while (!isSuccessful & triesCount++ < 200 ) {
            placement = (int) (Math.random() * boardSize);
            System.out.print(" sprawdź " + placement);
            int x = 0;
            isSuccessful = true;
            while (isSuccessful && x < shipSize) {
                if (board[placement] == 0) {
                    currentCoordinates[x++] = placement;
                    placement += incr;
                    if (placement >= boardSize){
                        isSuccessful = false;
                    }
                    if (x>0 & (placement % boardLength == 0)) {
                        isSuccessful = false;
                    }
                } else {
                    System.out.print(" już zajęte " + placement);
                    isSuccessful = false;
                }
            }
        }

        int x = 0;
        int line = 0;
        int column = 0;
        while (x < shipSize) {
            board[currentCoordinates[x]] = 1;
            line = (int) (currentCoordinates[x] / boardLength);
            column = currentCoordinates[x] % boardLength;
            help = String.valueOf(alphabet.charAt(column));

            occupiedFields.add(help.concat(Integer.toString(line)));
            x++;
            System.out.print(" współrzędne "+x+" = "+occupiedFields.get(x-1));
        }
        System.out.println("\n");

        return occupiedFields;
    }
}