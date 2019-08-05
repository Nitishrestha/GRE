package com.example.english.greenglish.service.mapper;

import com.example.english.greenglish.dto.MeaningDTO;
import com.example.english.greenglish.model.Meaning;
import com.example.english.greenglish.model.Vocabulary;
import com.example.english.greenglish.utils.DateTimeUtil;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MeaningMapperService {

    public Meaning meaningDTOToMeaning(MeaningDTO meaningDTO, Vocabulary vocabulary) {
        if (meaningDTO == null) return null;
        if (meaningDTO.getId() == null) {
            meaningDTO.setId("0");
        }
        Meaning meaning = new Meaning();
        meaning.setId(Long.valueOf(meaningDTO.getId()));
        meaning.setWordMeaning(meaningDTO.getWordMeaning());
        meaning.setVocabulary(vocabulary);
        meaning.setCreatedDate(DateTimeUtil.convertStringToLocalDateTime(meaningDTO.getCreatedDate()));
        meaning.setUpdatedDate(DateTimeUtil.convertStringToLocalDateTime(meaningDTO.getUpdatedDate()));
        return meaning;
    }

    public List<Meaning> meaningListDTOsToMeaningList(List<MeaningDTO> meaningDTOs, Vocabulary vocabulary) {
        if (meaningDTOs == null) return Collections.emptyList();
        return meaningDTOs.stream().map(meaningDTO ->
                meaningDTOToMeaning(meaningDTO, vocabulary)).collect(Collectors.toList());
    }

    public MeaningDTO meaningToMeaningDTO(Meaning meaning) {
        if (meaning == null) return null;
        MeaningDTO meaningDTO = new MeaningDTO();
        meaningDTO.setId(String.valueOf(meaning.getId()));
        meaningDTO.setWordMeaning(meaning.getWordMeaning());
        meaningDTO.setVocabularyId(meaning.getVocabulary().getId());
        meaningDTO.setCreatedDate(DateTimeUtil.convertLocalDateTimeToString(meaning.getCreatedDate()));
        meaningDTO.setUpdatedDate(DateTimeUtil.convertLocalDateTimeToString(meaning.getUpdatedDate()));
        return meaningDTO;
    }

    public List<MeaningDTO> meaningsToMeaningDTOs(List<Meaning> meanings) {
        if (meanings == null) return Collections.emptyList();
        return meanings.stream().map(this::meaningToMeaningDTO).collect(Collectors.toList());
    }
}
