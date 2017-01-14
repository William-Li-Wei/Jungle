package com.william;

import java.util.ArrayList;
import java.util.List;

public class Leopard extends Predator {

    // Ein Leopard kann nur 5 Tage bzw. Spielrunden ohne Essen auskommen.
    // Die Deklaration darf entfernt (und der Wert z. B. direkt im Code
    // verwendet) werden.
    private static int maxWithoutFood = 5;
    private int withoutFood = 0;


    /**
     * Dem Konstruktor wird das Geschlecht des Tiers uebergeben.
     *
     */
    public Leopard(boolean female) {
        super(female);
    }

    public Leopard(boolean female, String square) {
        super(female, square);
    }

    public Move[] possibleMoves() {
        List<Move> moves = new ArrayList();
        List<String> strMoves = new ArrayList();

        // 4 direct neighbours
        // a = 97, h = 104
        strMoves.add(this.getX() > 97 ? String.valueOf((char) (this.getX() - 1)) + String.valueOf(this.getY()) : "stay");    // left neighbour
        strMoves.add(this.getX() < 104 ? String.valueOf((char) (this.getX() + 1)) + String.valueOf(this.getY()) : "stay");   // right neighbour
        strMoves.add(this.getY() < 8 ? String.valueOf(this.getX()) + String.valueOf(this.getY() + 1) : "stay");     // top neighbour
        strMoves.add(this.getY() > 1 ? String.valueOf(this.getX()) + String.valueOf(this.getY() - 1) : "stay");     // down neighbour


        for(String strMove : strMoves) {
            if(strMove != "stay") {
                moves.add(new Move(this.square, strMove));
            }
        }


        // not moved
        moves.add(new Move(this.square, this.square));

        return moves.toArray(new Move[moves.size()]);
    }

    public void sunset() {
        withoutFood ++;
        if(withoutFood == 5) {
            this.alive = false;
        }
    }


    @Override
    public String toString(){
        return this.female
          ? (Globals.darkSquare(this.square) ? Globals.ts_female_leopard_dark : Globals.ts_female_leopard_light)
          : (Globals.darkSquare(this.square) ? Globals.ts_male_leopard_dark : Globals.ts_male_leopard_light);
    }

}
