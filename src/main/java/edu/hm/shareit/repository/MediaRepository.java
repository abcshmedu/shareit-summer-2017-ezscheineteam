package edu.hm.shareit.repository;

import edu.hm.shareit.model.Medium;

import java.util.List;

public interface MediaRepository {
    List<Medium> findAllMedia();
}
