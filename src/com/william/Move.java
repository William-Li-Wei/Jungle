package com.william;

/**
 * Die Klasse Move repraesentiert einen einzelnen Zug.
 *
 * Es gibt zwei Konstruktoren. Einer bekommt
 * Ausgangsfeld und Zielfeld uebergeben, der andere
 * bekommt nur den eingegebenen Zug in der Form
 * <Ausgangsfeld><Zielfeld> als String uebergeben,
 * also z. B. "a7c5" fuer den Zug von "a7" nach "c5".
 */
public class Move {

    private String from;
    private String to;
    private String via;
    private String move;

    public Move(String from, String to, String via) {
        this.from = from;
        this.to = to;
        this.via = via;
        this.move = "from " + from + " to " + to + " via " + via;
    }

    public Move(String from, String to){
        this.from = from;
        this.to = to;
        this.move = "from " + from + " to " + to;
    }

    public Move(String move){
        this.move = move;
    }

    @Override
    public String toString(){
        //TODO
        // Rueckgabe exakt in der Form <Ausgangsfeld><Zielfeld> als String,
        // also z. B. "b2b3" fuer den Zug eines Tiers von "b2" nach "b3".
        return move == "" ? "from " + from + " to " + to : move;
    }

    public boolean equals(Object other) {
        //TODO
        return false;
    }


    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
}
