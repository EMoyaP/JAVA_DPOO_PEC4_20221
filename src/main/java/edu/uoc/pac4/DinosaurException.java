package edu.uoc.pac4;

public class DinosaurException extends Exception {
    public static final String MSG_ERR_NAME_LENGTH = "[ERROR] Dinosaur's name cannot be shorter than 5 characters";
    public static final String MSG_ERR_NAME_FORMAT = "[ERROR] Dinosaur's name does not have the correct format";
    public static final String MSG_ERR_HEIGHT = "[ERROR] Dinosaur's height must be greater than 0";
    public static final String MSG_ERR_WEIGHT = "[ERROR] Dinosaur's weight must be greater than 0";
    public static final String MSG_ERR_NUM_LEGS = "[ERROR] Dinosaur's number of legs must be zero or a positive number";

    public static final String MSG_ERR_EATING = "[ERROR] This food is not good for this kind of dinosaur";
    public static final String MSG_ERR_ATTACKING_NOT_CLOSE = "[ERROR] The target is not close to the dinosaur";
    public static final String MSG_ERR_ATTACKING_SAME_CLASS = "[ERROR] A dinosaur doesn't attack a dinosaur from the same class";
    public static final String MSG_ERR_ATTACKING_NO_STAMINA = "[ERROR] This dinosaur doesn't have enough stamina to attack";

    public DinosaurException() {
        super();
    }
    public DinosaurException(String message) {
        super(message);
    }

}
