package edu.uoc.pac4;

public class Sauropodo extends Saurischian implements Herbivorous {
    private final static int SPEED = 3;
    private final static int STAMINA_FIND = 3;

    public Sauropodo(String name, int height, double weight, Gender gender, Position position) throws DinosaurException {
        super(name, height, weight, 4, gender, SPEED, position);
    }

    @Override
    public String roar() {
        return super.roar() + " Brrr!!!";
    }

    @Override
    public Position find(Food[] foods) {
        if (this.getStamina() < STAMINA_FIND) return null;
        this.incStamina(-STAMINA_FIND);

        for (Food food : foods) {
            if (food != null && food.getPosition().isCloseTo(this.getPosition(), SPEED)) {
                return food.getPosition();
            }
        }

        return null;
    }

    @Override
    public void eat(Food food) throws DinosaurException {
        Herbivorous.super.eat(food);
        this.incStamina(food.getEnergy());
    }

    @Override
    public String toString() {
        return "I'm a Sauropodo:" + System.lineSeparator() + super.toString();
    }
}
