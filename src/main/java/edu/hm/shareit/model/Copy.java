package edu.hm.shareit.model;

public class Copy {
    private Medium medium;
    private String owner;

    public Copy(String owner, Medium medium) {
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
