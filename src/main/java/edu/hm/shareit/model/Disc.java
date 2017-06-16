package edu.hm.shareit.model;

/**
 * The disc class.
 */
public class Disc extends Medium {
    private String barcode;
    private String director;
    private int fsk = -1;

    /**
     * Creates a new Disc.
     */
    public Disc() {
        super("");
    }

    /**
     * Sets a new barcode.
     * @param barcode the new barcode
     */
    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    /**
     * Sets a new director for the disc.
     * @param director the new director
     */
    public void setDirector(String director) {
        this.director = director;
    }

    /**
     * Sets a new fsk value.
     * @param fsk the new fsk value.
     */
    public void setFsk(int fsk) {
        this.fsk = fsk;
    }

    /**
     * Creates a new disc.
     * @param title - the title of the disc.
     * @param barcode - the barcode of the disc.
     * @param fsk - the fsk of the disc.
     * @param director - the director of the disc.
     */
    public Disc(String title, String barcode, int fsk, String director) {
        super(title);
        this.barcode = barcode;
        this.fsk = fsk;
        this.director = director;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }

        Disc disc = (Disc) o;

        if (fsk != disc.fsk) {
            return false;
        }
        if (barcode != null ? !barcode.equals(disc.barcode) : disc.barcode != null) {
            return false;
        }
        return director != null ? director.equals(disc.director) : disc.director == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (barcode != null ? barcode.hashCode() : 0);
        result = 31 * result + (director != null ? director.hashCode() : 0);
        result = 31 * result + fsk;
        return result;
    }

    /**
     * Returns the barcode of the disc.
     * @return the barcode of the disc.
     */
    public String getBarcode() {
        return barcode;
    }

    /**
     * Returns the director of the disc.
     * @return the director of the disc.
     */
    public String getDirector() {
        return director;
    }

    @Override
    public String toString() {
        return "Disc{"
                + "barcode='" + barcode + '\''
                + ", director='" + director + '\''
                + ", fsk=" + fsk
                + '}';
    }

    /**
     * Returns the fsk of the disc.
     * @return the fsk of the disc.
     */
    public int getFsk() {
        return fsk;
    }
}
