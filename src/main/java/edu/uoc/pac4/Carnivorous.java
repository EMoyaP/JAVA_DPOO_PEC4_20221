package edu.uoc.pac4;

public interface Carnivorous extends Eater {
    void attack(Dinosaur target) throws DinosaurException;

    @Override
    default void eat(Food food) throws DinosaurException {
        if (food.getType() != FoodType.VEGETABLE)
            System.out.print("Yum, yum");
        else
            throw new DinosaurException(DinosaurException.MSG_ERR_EATING);
    }
}

