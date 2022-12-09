package edu.uoc.pac4;

public class Ornithischian extends Dinosaur implements Herbivorous {
    private final static int SPEED = 1;
    private final static int STAMINA_FIND = 5;

    public Ornithischian(String name, int height, double weight, Gender gender, Position position) throws DinosaurException {
        super(name, height, weight, 4,gender,SPEED,position);

    }
    @Override
    public String roar(){
        return "Orrr!!!";
    }

    @Override
    public Position find(Food[] foods) {
        if (this.getStamina() < STAMINA_FIND) return null;
        this.incStamina(-STAMINA_FIND);
        Position foodPosition = null;
        int minDistance = Integer.MAX_VALUE;
        for (Food food : foods) {
            if (food != null) {
                int distance = Math.abs(this.getPosition().getX() - food.getPosition().getX()) + Math.abs(this.getPosition().getY() - food.getPosition().getY());
                if (distance < minDistance) {
                    minDistance = distance;
                    foodPosition = food.getPosition();
                }
            }
        }
        return foodPosition;
    }

    @Override
    public void eat(Food food) throws DinosaurException {
        Herbivorous.super.eat(food);
        this.incStamina(food.getEnergy());
    }

    @Override
    public String toString() {
        return "I'm an Ornithischian:" + System.lineSeparator() + super.toString();
    }
}
