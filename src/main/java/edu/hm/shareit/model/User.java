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
    public User() {
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

    /**
     * Set a new name.
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Set a new ID.
     * @param iD the new id
     */
    public void setiD(int iD) {
        this.iD = iD;
    }

    /**
     * Set if active or not.
     * @param active true, if active else otherwise
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     * Set a new email.
     * @param email the new email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Set a new user group.
     * @param group the new user group.
     */
    public void setGroup(UserGroup group) {
        this.group = group;
    }
}