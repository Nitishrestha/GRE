package com.example.english.greenglish.service.impl;

import com.example.english.greenglish.dto.SentenceDTO;
import com.example.english.greenglish.model.Sentence;
import com.example.english.greenglish.repository.SentenceRepository;
import com.example.english.greenglish.repository.VocabularyRepository;
import com.example.english.greenglish.service.SentenceService;
import com.example.english.greenglish.service.mapper.SentenceMapperService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SentenceServiceImpl implements SentenceService {

    private final SentenceRepository sentenceRepository;

    private final SentenceMapperService sentenceMapperService;

    private final VocabularyRepository vocabularyRepository;

    public SentenceServiceImpl(final SentenceRepository sentenceRepository, final SentenceMapperService sentenceMapperService, final VocabularyRepository vocabularyRepository) {
        this.sentenceRepository = sentenceRepository;
        this.sentenceMapperService = sentenceMapperService;
        this.vocabularyRepository = vocabularyRepository;
    }

    @Override
    public List<SentenceDTO> addSentence(List<SentenceDTO> sentenceDTOs, Long vocabId) {
        if (sentenceDTOs == null) return Collections.emptyList();
        List<Sentence> sentences = sentenceMapperService.sentenceDTOListTOSentenceList(sentenceDTOs, vocabularyRepository.findById(vocabId).get());
        List<Sentence> sentenceList = sentenceRepository.saveAll(sentences);
        return sentenceMapperService.sentencesToSentenceDTOs(sentenceList);
    }
}