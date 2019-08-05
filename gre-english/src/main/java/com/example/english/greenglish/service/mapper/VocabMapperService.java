package com.example.english.greenglish.service.mapper;

import com.example.english.greenglish.dto.VocabularyDTO;
import com.example.english.greenglish.model.Vocabulary;
import com.example.english.greenglish.utils.DateTimeUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VocabMapperService {

    public VocabularyDTO vocabularyToVocabularyDTO(Vocabulary vocabulary) {
        VocabularyDTO vocabularyDTO = new VocabularyDTO();
        vocabularyDTO.setId(String.valueOf(vocabulary.getId()));
        vocabularyDTO.setWord(vocabulary.getWord());
        vocabularyDTO.setGrammarType(vocabulary.getGrammarType());
        vocabularyDTO.setMastered(vocabulary.getMastered());
        vocabularyDTO.setCreatedDate(DateTimeUtil.convertLocalDateTimeToString(vocabulary.getCreatedDate()));
        vocabularyDTO.setUpdatedDate(DateTimeUtil.convertLocalDateTimeToString(vocabulary.getUpdatedDate()));
        return vocabularyDTO;
    }

    public Vocabulary vocabularyDTOToVocabulary(VocabularyDTO vocabularyDTO) {
        if(vocabularyDTO.getId() == null){
            vocabularyDTO.setId("0");
        }
        Vocabulary vocabulary = new Vocabulary();
        vocabulary.setId(Long.valueOf(vocabularyDTO.getId()));
        vocabulary.setGrammarType(vocabularyDTO.getGrammarType());
        vocabulary.setWord(vocabularyDTO.getWord());
        vocabulary.setMastered(vocabularyDTO.getMastered());
        vocabulary.setCreatedDate(DateTimeUtil.convertStringToLocalDateTime(vocabularyDTO.getCreatedDate()));
        vocabulary.setUpdatedDate(DateTimeUtil.convertStringToLocalDateTime(vocabularyDTO.getUpdatedDate()));
        return vocabulary;
    }

    public List<VocabularyDTO> vocabularyListToVocabularyDTOs(List<Vocabulary> vocabularies) {
        return vocabularies.stream().map(this::vocabularyToVocabularyDTO).collect(Collectors.toList());
    }
}
