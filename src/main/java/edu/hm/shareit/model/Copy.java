package edu.hm.shareit.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * The copy class.
 */
public class Copy {
    
    @JsonTypeInfo(
            use = JsonTypeInfo.Id.NAME,
            include = JsonTypeInfo.As.PROPERTY,
            property = "type")
    @JsonSubTypes({
        @Type(value = Book.class, name = "book"),
        @Type(value = Disc.class, name = "disc") })
    private Medium medium;
    private String owner;
    private int quantity;

    /**
     * Constructor for JSON mapping.
     */
    public Copy() { }
    
    /**
     * Copies a Medium.
     * @param owner - the orginial owner of the medium.
     * @param medium - the medium to be copied.
     * @param quantity - quantity of copys.
     */
    public Copy(String owner, Medium medium, int quantity) {
        if (owner == null) {
            throw new IllegalArgumentException("Owner cannot be null!");
        }
        if (medium == null) {
            throw new IllegalArgumentException("Medium cannot be null!");
        }
        if (quantity < 1) {
            throw new IllegalArgumentException("Quantity cannot be less than one!");
        }
        this.medium = medium;
        this.owner = owner;
        this.quantity = quantity;
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
    
    /**
     * Returns the quantity of the copy.
     * @return the quantity of the copy.
     */
    public int getQuantity() {
        return quantity;
    }
}
