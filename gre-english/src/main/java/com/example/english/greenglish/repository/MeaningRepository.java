package com.example.english.greenglish.repository;

import com.example.english.greenglish.model.Meaning;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeaningRepository extends JpaRepository<Meaning, Long> {
}
