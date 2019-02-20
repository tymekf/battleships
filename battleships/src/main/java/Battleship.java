import java.util.ArrayList;

public class Battleship {

    private String shipName;
    private ArrayList<String> shipPlacement;
    private int iloscTrafien = 0;

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public void setShipPlacement(ArrayList<String> place ) {
        shipPlacement = place;
    }

    public String checkMove (String move) {

        String result = "haha, pudło!";
        int index = shipPlacement.indexOf(move);

        if (index >= 0) {
            shipPlacement.remove(move);

            if (shipPlacement.isEmpty()) {
                result = "trafiony i zatopiony :|";
            } else {
                result = "trafiony, o ty gnoju";
            }

        }
        return result;
    }

}
