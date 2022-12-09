package edu.uoc.pac4;

public enum FoodType {
    MEAT(100),
    FISH(85),
    VEGETABLE(50),
    WATER(10);

    private int energy;
    FoodType (int energy){
        setEnergy(energy);
    }
    private void setEnergy(int energy){
        this.energy = energy;
    }
    public int getEnergy() {
        return energy;
    }
}
