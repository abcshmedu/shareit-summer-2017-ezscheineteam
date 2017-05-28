package edu.hm.shareit.model;

import java.util.Date;


/**
 * Represents a token generated for an user.
 */
public final class Token {

    private Date createdOn;
    private Date validUntil;
    private User user;
    private boolean active;

    /**
     * Default empty constructor hidden.
     */
    private Token() {
    }


    /**
     * Gets the date when this token was generated.
     * 
     * @return Date when this token was generated.
     */
    public Date getCreatedOn() {
        return createdOn;
    }

    /**
     * Gets the date till when this token is valid.
     * 
     * @return Date when this token invalidates.
     */
    public Date getValidUntil() {
        return validUntil;
    }

    /**
     * Get the user that the token was generated for.
     * 
     * @return The user referenced by this token.
     */
    public User getUser() {
        return user;
    }

    /**
     * Get if this token is active.
     * 
     * @return true if this token is active, else false.
     */
    public boolean isActive() {
        return active;
    }

}
