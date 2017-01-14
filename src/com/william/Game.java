package com.william;

/**
 * Die Klasse Game fuehrt die Benutzerinteraktion durch.
 *
 */

public class Game {

    private Position pos;


    /**
     * Startet ein neues Spiel.
     * Der Benutzer wird ueber das Spielgeschehen informiert.
     *
     * Dazu gehoert auch die Information, wie lange die
     * einzelnen Raubtiere noch ohne Essen auskommen koennen.
     * Diese Information soll auf Anfrage oder immer angezeigt werden.
     *
     * Es soll ausserdem eine Moeglichkeit geben, sich alle Zuege
     * anzeigen zu lassen, die in der Spielsituation moeglich sind.
     *
     * Bei fehlerhaften Eingaben wird die Eingabe natuerlich wiederholt.
     *
     * Der Parameter spezifiziert, wer das Spiel beginnen darf.
     */
    public void startGame(boolean ladiesFirst){
        pos = new Position();
        pos.reset(ladiesFirst ? 'W' : 'M');

        System.out.println(pos);


        // get user input for selecting an animal
        String animalSquare = IO.readString("Please choose an animal to move by specifying it's coordinate (e.g. e4): ");
        Animal selectedAnimal = pos.getAnimalBySquare(animalSquare);
        if(selectedAnimal != null) {
            Move[] moves = selectedAnimal.possibleMoves();
            System.out.println("Possible Moves are as followed: ");
            for(Move move : moves) {
                System.out.println(move);
            }

            String selectedMove = IO.readString("Please decide your move by specifying the destination coordinate (e.g. e4): ");
            Move nextMove = new Move(selectedAnimal.square, selectedMove);
            Move[] newMoves = new Move[1];
            newMoves[0] = nextMove;
            pos.applyMoves(newMoves);
        } else {
            System.out.println("no animal found");
        }


//        while(pos.theWinner() == 'X') {
//            String animalName = IO.readString("Please choose an animal to move");
//
//            // check if the selected animal is valid
//            switch(animalName) {
//                case "H":
//                    pos.getAnimalByChar(animalName, pos.getNext() == 'W');
//                    break;
//            }
//        }
    }
}
