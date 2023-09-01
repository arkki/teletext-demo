package com.olliniinioja.demo.yle.TeleText.repository;

import com.olliniinioja.demo.yle.TeleText.model.Image;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

public interface ImageRepository extends MongoRepository<Image, String> {

    @Query("{'page': ?0, 'subpage': ?1}")
    Optional<List<Image>> findByPage(int page, int subpage);

    default Optional<Image> findOneByPage(int page, int subpage) {
        return findByPage(page, subpage).flatMap(list -> list.stream().findFirst());
    }

    @Query(value = "{'page': ?0, 'subpage': ?1, 'time': {$lte: ?2}}", sort = "{'time': -1}")
    Optional<List<Image>> findByPageAndTime(int page, int subpage, Instant time);

    default Optional<Image> findOneByPageAndTime(int page, int subpage, Instant time) {
        return findByPageAndTime(page, subpage, time).flatMap(list -> list.stream().findFirst());
    }

}
