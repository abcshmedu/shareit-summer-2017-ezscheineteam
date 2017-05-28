package edu.hm.shareit.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Base class of all Mediums.
 */
public class Medium {
    private String title;

    /**
     * Creates a new Medium.
     * @param title - the title of the medium.
     */
    public Medium(@JsonProperty("title") String title) {
        if (title == null) {
            throw new IllegalArgumentException("Title for medium cannot be null!");
        }
        this.title = title;
    }

    /**
     * Returns the title of the medium.
     * @return the title of the medium.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Set a new title.
     * @param title the new title to be set.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Medium medium = (Medium) o;

        return title.equals(medium.title);
    }

    @Override
    public int hashCode() {
        return title.hashCode();
    }

    @Override
    public String toString() {
        return "Medium{" + "title='" + title + '\'' + '}';
    }
}
