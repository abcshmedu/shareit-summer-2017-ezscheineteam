package edu.hm.shareit.model;

public class Disc extends Medium {
    private String barcode;
    private String director;
    private int fsk;

    public Disc(String title, String barcode, int fsk, String director) {
        super(title);
        this.barcode = barcode;
        this.fsk = fsk;
        this.director = director;
    }

    public Disc() {
        this("", "", 0, "");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Disc disc = (Disc) o;

        if (fsk != disc.fsk) return false;
        if (barcode != null ? !barcode.equals(disc.barcode) : disc.barcode != null) return false;
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

    public String getBarcode() {
        return barcode;
    }

    public String getDirector() {
        return director;
    }

    @Override
    public String toString() {
        return "Disc{" +
                "barcode='" + barcode + '\'' +
                ", director='" + director + '\'' +
                ", fsk=" + fsk +
                '}';
    }

    public int getFsk() {
        return fsk;
    }
}
