package edu.hm.shareit.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 *
 */
public class Medium {
    private String title;

    public Medium(String title) {
        if (title == null) {
            throw new IllegalArgumentException("Title for medium cannot be null!");
        }
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Medium medium = (Medium) o;

        return title != null ? title.equals(medium.title) : medium.title == null;
    }

    @Override
    public int hashCode() {
        return title != null ? title.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Medium{" + "title='" + title + '\'' + '}';
    }
}
