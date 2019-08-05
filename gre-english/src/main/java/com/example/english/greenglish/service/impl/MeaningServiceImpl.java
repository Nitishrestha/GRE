package com.example.english.greenglish.service.impl;

import com.example.english.greenglish.dto.MeaningDTO;
import com.example.english.greenglish.model.Meaning;
import com.example.english.greenglish.model.Vocabulary;
import com.example.english.greenglish.repository.MeaningRepository;
import com.example.english.greenglish.repository.VocabularyRepository;
import com.example.english.greenglish.service.MeaningService;
import com.example.english.greenglish.service.mapper.MeaningMapperService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeaningServiceImpl implements MeaningService {

    private final MeaningRepository meaningRepository;

    private final MeaningMapperService meaningMapperService;

    private final VocabularyRepository vocabularyRepository;

    public MeaningServiceImpl(final MeaningRepository meaningRepository, final MeaningMapperService meaningMapperService, final VocabularyRepository vocabularyRepository) {
        this.meaningRepository = meaningRepository;
        this.meaningMapperService = meaningMapperService;
        this.vocabularyRepository = vocabularyRepository;
    }

    @Override
    public List<MeaningDTO> addMeaning(List<MeaningDTO> meaningDTOs, Long vocabId) {
        Vocabulary vocabulary = vocabularyRepository.findById(vocabId).get();
        List<Meaning> meaning = meaningMapperService.meaningListDTOsToMeaningList(meaningDTOs, vocabulary);
        List<Meaning> meanings = meaningRepository.saveAll(meaning);
        return meaningMapperService.meaningsToMeaningDTOs(meanings);
    }

    @Override
    public MeaningDTO update(Long id, MeaningDTO meaningDTO) {
        Meaning updatedMeaning = meaningMapperService.meaningDTOToMeaning(meaningDTO, vocabularyRepository.findById(meaningDTO.getVocabularyId()).get());
        Meaning save = meaningRepository.save(updatedMeaning);
        return meaningMapperService.meaningToMeaningDTO(save);
    }
}
