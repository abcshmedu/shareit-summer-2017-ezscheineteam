package edu.hm.shareit.model;

public class Copy {
    private Medium medium;
    private String owner;

    public Copy(String owner, Medium medium) {
        if (owner == null) {
            throw new IllegalArgumentException("Owner cannot be null!");
        }
        if (medium == null) {
            throw new IllegalArgumentException("Medium cannot be null!");
        }

        this.medium = medium;
        this.owner = owner;
    }

    public Medium getMedium() {
        return medium;
    }

    public String getOwner() {
        return owner;
    }
}
