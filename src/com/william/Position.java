package com.william;

/**
 * Die Klasse Position repraesentiert eine Spielsituation.
 *
 */
public class Position {

    /**
     * Die Tiere werden intern in einem Array gespeichert.
     * nrAnimals gibt an, wie viele Tiere auf dem Brett sind.
     * Diese sind in myAnimals an den Positionen 0 bis nrAnimals-1 enthalten.
     *
     * Es ist empfohlen, aber nicht vorgeschrieben, diese Attribute zu verwenden.
     *
     * Falls die beiden Attribute NICHT verwendet werden, muss die Ausgabe
     * der Spielposition unten entsprechend auf die verwendete Datenstruktur
     * angepasst werden. Die toString-Methode darf dabei nicht veraendert werden,
     * muss jedoch die selbe Rueckgabe liefern. D.h. es ist dann notwendig,
     * die Hilfsmethode boardRepresentation auf die verwendete Datenstruktur anzupassen.
     */
    private Animal[] myAnimals;
    private int nrAnimals;

    /**
     * Spieler, der als naechstes ziehen darf ('M' oder 'W').
     * Wird jedes Mal aktualisiert, wenn eine Seite ihre Zuege ausfuehrt.
     */
    private char next = 'W';


    public Position() {
        // woman
        Horse wh1 = new Horse(true, "c1");
        Horse wh2 = new Horse(true, "f1");
        Leopard wl1 = new Leopard(true, "d1");
        Leopard wl2 = new Leopard(true, "e1");

        // man
        Horse h1 = new Horse(false, "c8");
        Horse h2 = new Horse(false, "f8");
        Leopard l1 = new Leopard(false, "d8");
        Leopard l2 = new Leopard(false, "e8");


        myAnimals = new Animal[8];

        myAnimals[0] = wh1;
        myAnimals[1] = wh2;
        myAnimals[2] = wl1;
        myAnimals[3] = wl2;

        myAnimals[4] = h1;
        myAnimals[5] = h2;
        myAnimals[6] = l1;
        myAnimals[7] = l2;
    }


    /**
     * Stellt die Anfangsposition des Spiels her.
     * Der Parameter gibt an, welche Seite beginnt ('M' oder 'W').
     */
    public void reset(char movesNext) {
        for(Animal animal : myAnimals) {
            animal.resetSquare();
        }
    }


    /**
     * Fuehrt die uebergebenen Zuege fuer einen der Spieler aus.
     * Die Reihenfolge soll keinen Unterschied machen.
     * Diese Methode geht davon aus, dass dies bereits ueberprueft wurde.
     *
     * Der Zustand des Spiels wird entsprechend angepasst, d. h. ein Spiel
     * kann von der Anfangsposition aus allein mittels Aufrufen dieser Methode
     * gespielt werden. Insbesondere wechselt durch den Aufruf das Zugrecht,
     * da M und W abwechselnd ziehen.
     *
     * @param moves Array mit den Zuegen, die ausgefuehrt werden sollen.
     *
     */
    public void applyMoves(Move[] moves){
        for(Move move : moves) {
            Animal animal = getAnimalBySquare(move.getFrom());
            animal.square = move.getTo();
        }

        // if any opponent animals killed


        // next = "M"
        if(next == 'W') {
            next = 'M';
        } else {
            // for each animal, call sunset
        }

        System.out.print(this);


    }


    /**
     * Ermittelt, ob/wer gewonnen hat.
     *
     * @return 'W' falls W gewonnen hat,
     *         'M' falls M gewonnen hat,
     *         'N' falls das Spiel unentschieden zu Ende ist,
     *         'X' falls das Spiel noch nicht zu Ende ist.
     *
     */
    public char theWinner() {
        //TODO
        return 'X';
    }





    // Ausgabe der Spielposition

    private static final int[] I = {8,7,6,5,4,3,2,1};
    private static final String[] J = {"a","b","c","d","e","f","g","h"};
    private static int toIndex(String s){return (s.charAt(0)-'a');}

    // Erzeugt eine 2D-Repraesentation der Spielposition.
    // Darf ggf. auf neue Datenstruktur angepasst werden (s.o.)
    // Die Rueckgabe ist ein zweidimensionales Array, welches
    // jedem Feld das darauf befindliche Tier (oder null) zuordnet.
    // Dabei laeuft der erste Index von der 'a'-Linie zur 'h'-Linie,
    // der zweite von der 1. zur 8. Reihe. D.h. wenn z.B. bei a[3][7]
    // ein Tier ist, ist das zugehörige Feld "d8" (vierter Buchstabe,
    // achte Zahl).
    public Animal[][] boardRepresentation(){
        Animal[][] a = new Animal[8][8];
        for (int i : I) {
            for (String j : J) {
                for (int k = 0; k < myAnimals.length; k++) {
                    if (null == myAnimals[k]) {break;}
                    if (myAnimals[k].square.equals(j+i)) {
                        a[toIndex(j)][i-1] = myAnimals[k];
                    }
                }
            }
        }
        return a;
    }


    @Override
    public String toString(){
        String str = "   a b c d e f g h\n";
        Animal[][] ani = boardRepresentation();
        for (int i : I) {
            str += (i+" ");
            for (String j : J) {
                if (null == ani[toIndex(j)][i-1]) {
                    str += (i+toIndex(j))%2==1 ? Globals.ts_empty_square_dark : Globals.ts_empty_square_light;
                } else {
                    str += ani[toIndex(j)][i-1].toString();
                }
            }
            str += " " + i + "\n";
        }
        str += "  a b c d e f g h\nIt is " + next + "'s turn.\n";
        return str;
    }


    public int getAnimalIndexBySquare(String square) {
        int idx = 0;
        for(Animal animal : this.myAnimals) {
            if(!square.equals(animal.square)) {
                idx ++;
            } else {
                break;
            }
        }
        return idx;
    }

    public Animal getAnimalBySquare(String square) {
        // loop through the array myAnimals to find the one
        return myAnimals[getAnimalIndexBySquare(square)];
    }

    public void removeDeadAnimals() {
        // loop to find dead animals, and remove them from myAnimals;

        //
    }





    public Animal[] getMyAnimals() {
        return myAnimals;
    }

    public void setMyAnimals(Animal[] myAnimals) {
        this.myAnimals = myAnimals;
    }

    public int getNrAnimals() {
        return nrAnimals;
    }

    public void setNrAnimals(int nrAnimals) {
        this.nrAnimals = nrAnimals;
    }

    public char getNext() {
        return next;
    }

    public void setNext(char next) {
        this.next = next;
    }
}
