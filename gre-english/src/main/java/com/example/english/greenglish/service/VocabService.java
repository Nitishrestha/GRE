package com.example.english.greenglish.service;

import com.example.english.greenglish.dto.VocabularyDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface VocabService {

    VocabularyDTO add(VocabularyDTO vocabularyDTO);

    List<VocabularyDTO> getAll(Pageable pageable, String initialLetter, String searchParam);

    List<VocabularyDTO> getByInitialLetter(String initialLetter);

    VocabularyDTO update(Long vocabId, VocabularyDTO vocabularyDTO);
}
