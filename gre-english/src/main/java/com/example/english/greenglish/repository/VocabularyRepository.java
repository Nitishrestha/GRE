package com.example.english.greenglish.repository;

import com.example.english.greenglish.model.Vocabulary;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VocabularyRepository extends JpaRepository<Vocabulary, Long> {

    @Query("SELECT v FROM Vocabulary v WHERE " +
            "(:initialLetter is null or v.word like CONCAT('%',:initialLetter)) " +
            "AND (:searchParam is null or v.word like CONCAT('%',:searchParam, '%')) ")
    List<Vocabulary> findAll(@Param("") Pageable pageable, @Param("initialLetter") String initialLetter, @Param("searchParam") String searchParam);

    List<Vocabulary> findByWordStartingWith(String initialLetter);
}
