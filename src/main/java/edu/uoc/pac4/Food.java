package edu.uoc.pac4;

public class Food {
    private String name;
    private Position position;
    private FoodType type;

    public Food() {
        this.name = "water";
        this.type = FoodType.WATER;
        this.position = new Position(0, 0);
    }

    public Food(String name, FoodType type, Position position) {
        this.name = name.toLowerCase().trim().replace(" ", "-");
        this.type = type;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition (Position position) {
        this.position = position;
    }

    public int getEnergy() {
        return type.getEnergy();
    }

    public FoodType getType() {
        return this.type;
    }

    @Override
    public String toString() {
        return "(" + type + ") " + name + "=" + getEnergy();
    }
}
