package edu.hm.shareit.model;

/**
 * This class represents an user in the system. It stores values identifying a
 * single person.
 */
public final class User {
    private String name;
    private int iD;
    private boolean active;
    private String email;
    private UserGroup group;

    /**
     * Empty user object not allowed, hidden empty default constructor.
     */
    private User() {
    }

    /**
     * Gets the name of this user.
     * 
     * @return The name of this user.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the ID for this user.
     * 
     * @return ID of the user.
     */
    public int getiD() {
        return iD;
    }

    /**
     * Shows if the user is active and can perform actions.
     * 
     * @return True if active, false if not.
     * 
     */
    public boolean isActive() {
        return active;
    }

    /**
     * Shows the stored email address for this user.
     * 
     * @return The stored email address.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Show the group membership for the given user.
     * 
     * @return group name of this user.
     */
    public UserGroup getGroup() {
        return group;
    }

}