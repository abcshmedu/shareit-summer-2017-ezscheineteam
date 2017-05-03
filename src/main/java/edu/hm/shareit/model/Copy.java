package edu.hm.shareit.model;

/**
 * The copy class.
 */
public class Copy {
    private Medium medium;
    private String owner;

    /**
     * Copies a Medium.
     * @param owner - the orginial owner of the medium.
     * @param medium - the medium to be copied.
     */
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

    /**
     * Returns the medium.
     * @return the medium.
     */
    public Medium getMedium() {
        return medium;
    }

    /**
     * Returns the Owner of the medium.
     * @return the owner of the medium.
     */
    public String getOwner() {
        return owner;
    }
}
