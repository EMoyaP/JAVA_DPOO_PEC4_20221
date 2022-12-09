package edu.uoc.pac4;

public interface Herbivorous extends Eater {

    Position find(Food[] foods);
    @Override
    default void eat(Food food) throws DinosaurException {
        if (food.getType() == FoodType.VEGETABLE || food.getType() == FoodType.WATER) {
            System.out.print("Mmmm");
        } else {
            throw new DinosaurException(DinosaurException.MSG_ERR_EATING);
        }
    }

}
