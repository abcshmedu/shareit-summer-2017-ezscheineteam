package edu.hm.shareit.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * Base class of all Users.
 */
public class User {

    private String name;
    
    /**
     * Creates a new User.
     * @param name - the name of the User.
     */
    public User(@JsonProperty("name") String name) {       
        this.name = Objects.requireNonNull(name);
    }

    /**
     * Gets the name of this user.
     * 
     * @return The name of this user.
     */
    public String getName() {
        return name;
    }
}
