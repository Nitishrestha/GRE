package com.example.english.greenglish.service.mapper;

import com.example.english.greenglish.dto.SentenceDTO;
import com.example.english.greenglish.model.Sentence;
import com.example.english.greenglish.model.Vocabulary;
import com.example.english.greenglish.utils.DateTimeUtil;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SentenceMapperService {

    private Sentence sentenceDTOToSentence(SentenceDTO sentenceDTO, Vocabulary vocabulary) {
        if (sentenceDTO == null) return null;
        if (sentenceDTO.getId() == null) {
            sentenceDTO.setId("0");
        }
        Sentence sentence = new Sentence();
        sentence.setId(Long.valueOf(sentenceDTO.getId()));
        sentence.setSentence(sentenceDTO.getSentence());
        sentence.setVocabulary(vocabulary);
        sentence.setCreatedDate(DateTimeUtil.convertStringToLocalDateTime(sentenceDTO.getCreatedDate()));
        sentence.setUpdatedDate(DateTimeUtil.convertStringToLocalDateTime(sentenceDTO.getUpdatedDate()));
        return sentence;
    }

    private SentenceDTO sentenceToSentenceDTO(Sentence sentence) {
        if (sentence == null) return null;
        SentenceDTO sentenceDTO = new SentenceDTO();
        sentenceDTO.setId(String.valueOf(sentence.getId()));
        sentenceDTO.setVocabularyId(sentence.getVocabulary().getId());
        sentenceDTO.setSentence(sentence.getSentence());
        sentenceDTO.setCreatedDate(DateTimeUtil.convertLocalDateTimeToString(sentence.getCreatedDate()));
        sentenceDTO.setUpdatedDate(DateTimeUtil.convertLocalDateTimeToString(sentence.getUpdatedDate()));
        return sentenceDTO;
    }

    public List<Sentence> sentenceDTOListTOSentenceList(List<SentenceDTO> sentenceDTOs, Vocabulary vocabulary) {
        if (sentenceDTOs == null) return Collections.emptyList();
        return sentenceDTOs.stream().map(sentenceDTO -> sentenceDTOToSentence(sentenceDTO, vocabulary)).collect(Collectors.toList());
    }

    public List<SentenceDTO> sentencesToSentenceDTOs(List<Sentence> sentences) {
        if (sentences == null) return Collections.emptyList();
        return sentences.stream().map(this::sentenceToSentenceDTO).collect(Collectors.toList());
    }
}
