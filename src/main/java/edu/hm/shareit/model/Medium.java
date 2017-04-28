package edu.hm.shareit.model;

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
