package edu.uoc.pac4;

import java.util.*;

public class Herd {
    private String name;
    private final int MAX_SIZE;
    private static final int MIN_SIZE = 5;
    private static final String MSG_ERR_NULL = "[ERROR] The Dinosaur object cannot be null";
    private static final String MSG_ERR_DIFFERENT_FAMILY = "[ERROR] Dinosaurs do not belong to the same family!!";

    private final Set<Dinosaur> dinosaurs;

    public Herd(String name, int size) {
        setName(name);
        this.MAX_SIZE = Math.max(MIN_SIZE, size);
        dinosaurs = new HashSet<>(MAX_SIZE);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxSize() {
        return MAX_SIZE;
    }

    public List<Dinosaur> getDinosaurs() {
        return new ArrayList<>(dinosaurs);
    }

    public boolean add(Dinosaur dinosaur) {
        if (dinosaur == null) {
            throw new NullPointerException(MSG_ERR_NULL);
        }

        if (dinosaurs.size() >= getMaxSize()) {
            return false;
        }

        if (!dinosaurs.isEmpty())
            if ((getDinosaurs().get(0) instanceof Saurischian && dinosaur instanceof Ornithischian) ||
                    (getDinosaurs().get(0) instanceof Ornithischian && dinosaur instanceof Saurischian)) {
                throw new IllegalArgumentException(MSG_ERR_DIFFERENT_FAMILY);
            }

        return dinosaurs.add(dinosaur);
    }

    public boolean remove(Dinosaur dinosaur) {
        if (dinosaur == null) {
            throw new NullPointerException(MSG_ERR_NULL);
        }
        if (dinosaurs.size() == 0) {
            return false;
        }
        if (!dinosaurs.contains(dinosaur)) {
            return false;
        }
        dinosaurs.remove(dinosaur);
        return true;
    }

    public void remove() {
        dinosaurs.clear();
    }

    public boolean exists(Dinosaur dinosaur) {
        if (dinosaur == null) {
            throw new NullPointerException(MSG_ERR_NULL);
        }
        return dinosaurs.contains(dinosaur);
    }

    public boolean isEmpty() {
        return dinosaurs != null && dinosaurs.size() == 0;
    }

    public String toString() {
        return "Herd: " + name + " - Max. Size: " + getMaxSize() + " - Current size: " + dinosaurs.size();
    }

    public List<String> getHeaviestDinosaursWithLifeExpectancy(double lifeExpectancy) {
        List<String> list = new ArrayList<>();
        dinosaurs.stream()
                .filter(d -> d.getWeight() > 6000 && d.getLifeExpectancy() > lifeExpectancy)
                .sorted(Comparator.comparing(Dinosaur::getName))
                .forEach(d -> list.add(d.getName()));
        return list;
    }

    public void killAll() {
        dinosaurs.stream().forEach(d -> {
            d.kill();
            d.setPosition(new Position(0, 0));
        });
    }

    public double averageWeight() {
        if (dinosaurs.isEmpty()) {
            return 0;
        }
        double totalWeight = 0;
        for (Dinosaur dinosaur : dinosaurs) {
            totalWeight += dinosaur.getWeight();
        }
        return totalWeight / dinosaurs.size();
    }


}

