package edu.uoc.pac4;

public abstract class Saurischian extends Dinosaur {

    public Saurischian(String name, int height, double weight, int numLegs, Gender gender, int speed, Position position) throws DinosaurException {
        super(name, height, weight, numLegs, gender, speed, position);
    }
    public String roar() {
        return  "Mic mic!!!";
    }
}
