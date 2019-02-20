import java.util.ArrayList;

public class BasicBattleshipsGame {

    private int movesCount = 0;
    private GameHelper pomocnik = new GameHelper();
    private ArrayList<Battleship> shipsList = new ArrayList();

    private void prepareGame() {
        Battleship firstShip = new Battleship();
        firstShip.setShipName("'Queen Anne's Revenge'");
        shipsList.add(firstShip);
        Battleship secondShip = new Battleship();
        secondShip.setShipName("'The Golden Hind'");
        shipsList.add(secondShip);
        Battleship thirdShip = new Battleship();
        thirdShip.setShipName("'Royal Fortune'");
        shipsList.add(thirdShip);
        Battleship fourthShip = new Battleship();
        fourthShip.setShipName("'The Rising Sun'");
        shipsList.add(fourthShip);
        Battleship fifthShip = new Battleship();
        fifthShip.setShipName("'Andromache'");
        shipsList.add(fifthShip);

        System.out.println("zniszcz wszystkie pięć statków, a twoje będzie wygranko");
        System.out.println("spróbuj to zrobić w jak najmniejszej ilości ruchów ");
        System.out.println("zakres planszy to A0-J9, powodzonka, byku");

        for (Battleship placedBattleship : shipsList) {
            ArrayList<String> newPlacement = pomocnik.placeShip(3);
            placedBattleship.setShipPlacement(newPlacement);
        }

    }

    private void beginGame() {
        while (!shipsList.isEmpty()) {
            String playerMove = pomocnik.getEntryData("strzelaj:");
            checkPlayerMove(playerMove);
        }
        endGame();
    }

    void checkPlayerMove(String move) {
        movesCount++;
        String result = "hahah, pudło!";

        for (Battleship shipToCheck: shipsList) {
            result = shipToCheck.checkMove(move);
            if (result.equals("trafiony")) {
                System.out.println(shipToCheck.getShipName() + " " + result);
                break;
            }
            if (result.equals("trafiony i zatopiony :|")) {
                System.out.println(shipToCheck.getShipName() + " " + result + ", pozostałe statki: " + (shipsList.size()-1));
                shipsList.remove(shipToCheck);
                break;
            }
        }
        if (result.equals("hahah, pudło!")) {
            System.out.println(result);

        }

    }

    void endGame() {
        System.out.println("gra zakończona :| ");
        if (movesCount < 40) {
            System.out.println("dobra robota, wygrałeś w: " + movesCount + " ruchach");
        } else {
            System.out.println(movesCount + " ruchów? trochę dużo, nie uważasz?");
        }
    }

    public static void main(String[] args) {
        BasicBattleshipsGame gra = new BasicBattleshipsGame();
        gra.prepareGame();
        gra.beginGame();
    }


}
