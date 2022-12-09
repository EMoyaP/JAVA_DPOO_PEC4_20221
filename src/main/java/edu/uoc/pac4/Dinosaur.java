package edu.uoc.pac4;


public abstract class Dinosaur implements Comparable <Dinosaur> {
    private String name;
    private int height;
    private double weight;
    private int numLegs;
    private boolean dead;
    private int speed;
    private double stamina;
    public static final int MIN_NAME_LENGTH = 5;
    public static final int AVERAGE_AGE = 30;
    private Gender gender;
    private Position position;

    public Dinosaur(String name, int height, double weight, int numLegs, Gender gender, int speed, Position position) throws DinosaurException {
        setName(name);
        setHeight(height);
        setWeight(weight);
        setNumLegs(numLegs);
        setGender(gender);
        setSpeed(speed);
        setPosition(position);
        this.dead = false;
        this.stamina = 0;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) throws DinosaurException {
        if (name.length() < MIN_NAME_LENGTH)
            throw new DinosaurException(DinosaurException.MSG_ERR_NAME_LENGTH);
        if (name.contains("-") || name.contains("/"))
            throw new DinosaurException(DinosaurException.MSG_ERR_NAME_FORMAT);
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) throws DinosaurException {
        if (height <= 0)
            throw new DinosaurException(DinosaurException.MSG_ERR_HEIGHT);
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) throws DinosaurException {
        if (weight <= 0)
            throw new DinosaurException(DinosaurException.MSG_ERR_WEIGHT);
        this.weight = weight;
    }

    public int getNumLegs() {
        return numLegs;
    }

    public void setNumLegs(int numLegs) throws DinosaurException {
        if (numLegs < 0)
            throw new DinosaurException(DinosaurException.MSG_ERR_NUM_LEGS);
        this.numLegs = numLegs;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        if (speed < 1)
            this.speed = 1;
        else
            this.speed = speed;
    }

    public double getStamina() {
        return stamina;
    }

    protected void incStamina(double stamina) {
        this.stamina += stamina;
        if (this.stamina > 100)
            this.stamina = 100;
        else if (this.stamina < 0)
            this.stamina = 0;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public boolean isDead() {
        return dead;
    }

    public void kill() {
        this.dead = true;
    }

    public double getLifeExpectancy() {
        double lifeExpectancy = AVERAGE_AGE - ((weight / Math.pow(height / 100, 2) * 0.2));
        if (lifeExpectancy <= 0)
            lifeExpectancy = AVERAGE_AGE;
        return Math.round(lifeExpectancy * 100.0) / 100.0;
    }

    @Override
    public boolean equals(Object obj) {
        super.equals(obj);
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Dinosaur other = (Dinosaur) obj;
        if (name == other.name
                && height == other.height
                && weight == other.weight
                && position.equals(other.position)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "\tName: " + name + System.lineSeparator()
                + "\tHeight: " + height + " cm." + System.lineSeparator()
                + "\tWeight: " + weight + " kg." + System.lineSeparator()
                + "\t#Legs: " + numLegs + System.lineSeparator()
                + "\tPosition: " + position + System.lineSeparator()
                + "\tLife expectancy: " + getLifeExpectancy() + " years";
    }

    @Override
    public int compareTo(Dinosaur dinosaur) {
        if (dinosaur == null)
            throw new NullPointerException();

        if (this.weight > dinosaur.weight) {
            return -1;
        } else if (this.weight < dinosaur.weight) {
            return 1;
        } else if (this.height > dinosaur.height) {
            return -1;
        } else if (this.height < dinosaur.height) {
            return 1;
        }
        return 0;
    }

    public String sleep() {
        return "Zzzz...";
    }

    public void walk(Position target) {
        if (target.isCloseTo(position, speed)) {
            position = target;
        } else {
            int orientationX = position.getXOrientation(target);
            int orientationY = position.getYOrientation(target);

            if (orientationX == 1)
                position.setX(position.getX() + speed);
            else if (orientationX == -1)
                position.setX(position.getX() - speed);

            if (orientationY == 1)
                position.setY(position.getY() + speed);
            else if (orientationY == -1)
                position.setY(position.getY() - speed);
        }
    }

    public abstract String roar();


}
