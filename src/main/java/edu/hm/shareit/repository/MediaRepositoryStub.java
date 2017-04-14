package edu.hm.shareit.repository;

import edu.hm.shareit.model.Book;
import edu.hm.shareit.model.Disc;
import edu.hm.shareit.model.Medium;

import java.util.ArrayList;
import java.util.List;

public class MediaRepositoryStub implements MediaRepository {
    @Override
    public List<Medium> findAllMedia() {
        List<Medium> media = new ArrayList<>();

        Book b = new Book("Die Eule mit der Beule", "Susanne Weber", "978-3789167065");
        Disc d = new Disc("Never Gonna Give You Up", "123-124132", 80, "Rick Astley");

        media.add(b);
        media.add(d);

        return media;
    }
}
