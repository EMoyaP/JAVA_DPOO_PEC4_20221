package edu.uoc.pac4;

public class Theropoda extends Saurischian implements Carnivorous{
    private final static int SPEED = 5;
    private final static int STAMINA_ATTACK = 5;

    public Theropoda(String name, int height, double weight, Gender gender, Position position) throws DinosaurException {
        super(name, height, weight, 2, gender, SPEED, position);
    }

    @Override
    public void attack(Dinosaur target) throws DinosaurException {
        if (target.getClass().equals(this.getClass()))
            throw new DinosaurException(DinosaurException.MSG_ERR_ATTACKING_SAME_CLASS);

        if (!target.getPosition().isCloseTo(this.getPosition(), SPEED))
            throw new DinosaurException(DinosaurException.MSG_ERR_ATTACKING_NOT_CLOSE);

        if (this.getStamina() < STAMINA_ATTACK)
            throw new DinosaurException(DinosaurException.MSG_ERR_ATTACKING_NO_STAMINA);

        this.incStamina(-STAMINA_ATTACK * Math.max(1, target.getWeight() / this.getWeight()));
        target.kill();

    }

    @Override
    public String roar() {
        return super.roar() + " Grrr!!!";
    }

    @Override
    public void eat(Food food) throws DinosaurException {
        Carnivorous.super.eat(food);
        this.incStamina(food.getEnergy());
    }

    @Override
    public String toString() {
        return "I'm a Theropoda:" + System.lineSeparator() + super.toString();
    }
}
