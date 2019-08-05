package com.example.english.greenglish.service.impl;

import com.example.english.greenglish.dto.MeaningDTO;
import com.example.english.greenglish.dto.SentenceDTO;
import com.example.english.greenglish.dto.VocabularyDTO;
import com.example.english.greenglish.model.Vocabulary;
import com.example.english.greenglish.repository.VocabularyRepository;
import com.example.english.greenglish.service.MeaningService;
import com.example.english.greenglish.service.SentenceService;
import com.example.english.greenglish.service.VocabService;
import com.example.english.greenglish.service.mapper.VocabMapperService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VocabServiceImpl implements VocabService {

    private final VocabularyRepository vocabularyRepository;

    private final VocabMapperService vocabMapperService;

    private final SentenceService sentenceService;

    private final MeaningService meaningService;

    public VocabServiceImpl(final VocabularyRepository vocabularyRepository, final VocabMapperService vocabMapperService, final SentenceService sentenceService, final MeaningService meaningService) {
        this.vocabularyRepository = vocabularyRepository;
        this.vocabMapperService = vocabMapperService;
        this.sentenceService = sentenceService;
        this.meaningService = meaningService;
    }


    @Override
    public VocabularyDTO add(VocabularyDTO vocabularyDTO) {
        Vocabulary vocabulary = vocabMapperService.vocabularyDTOToVocabulary(vocabularyDTO);
        Vocabulary savedVocabulary = vocabularyRepository.save(vocabulary);
        List<MeaningDTO> meaningDTOList = meaningService.addMeaning(vocabularyDTO.getMeaningDTOs(), savedVocabulary.getId());
        List<SentenceDTO> sentenceDTOList = sentenceService.addSentence(vocabularyDTO.getSentenceDTOs(), savedVocabulary.getId());
        VocabularyDTO toVocabularyDTO = vocabMapperService.vocabularyToVocabularyDTO(savedVocabulary);
        toVocabularyDTO.setMeaningDTOs(meaningDTOList);
        toVocabularyDTO.setSentenceDTOs(sentenceDTOList);
        return toVocabularyDTO;
    }

    @Override
    public List<VocabularyDTO> getAll(Pageable pageable, String initialLetter, String searchParam) {
        List<Vocabulary> vocabularyList = vocabularyRepository.findAll(pageable, initialLetter, searchParam);
        return vocabMapperService.vocabularyListToVocabularyDTOs(vocabularyList);
    }

    @Override
    public List<VocabularyDTO> getByInitialLetter(String initialLetter) {
        List<Vocabulary> vocabularies = vocabularyRepository.findByWordStartingWith(initialLetter);
        return vocabMapperService.vocabularyListToVocabularyDTOs(vocabularies);
    }

    @Override
    public VocabularyDTO update(Long vocabId, VocabularyDTO vocabularyDTO) {
        Vocabulary updatedVocabulary = vocabMapperService.vocabularyDTOToVocabulary(vocabularyDTO);
        updatedVocabulary.setUpdatedDate(LocalDateTime.now());
        Vocabulary save = vocabularyRepository.save(updatedVocabulary);
        return vocabMapperService.vocabularyToVocabularyDTO(save);
    }
}
