package com.example.english.greenglish.dto;

import java.util.List;

public class VocabularyDTO {
    private String id;
    private String word;
    private String grammarType;
    private Boolean isMastered;
    private List<MeaningDTO> meaningDTOs;
    private List<SentenceDTO> sentenceDTOs;
    private VocabularyDTO similarVocab;
    private VocabularyDTO oppositeVocab;
    private String createdDate;
    private String updatedDate;

    public VocabularyDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getGrammarType() {
        return grammarType;
    }

    public void setGrammarType(String grammarType) {
        this.grammarType = grammarType;
    }

    public Boolean getMastered() {
        return isMastered;
    }

    public void setMastered(Boolean mastered) {
        isMastered = mastered;
    }

    public List<MeaningDTO> getMeaningDTOs() {
        return meaningDTOs;
    }

    public void setMeaningDTOs(List<MeaningDTO> meaningDTOs) {
        this.meaningDTOs = meaningDTOs;
    }

    public List<SentenceDTO> getSentenceDTOs() {
        return sentenceDTOs;
    }

    public void setSentenceDTOs(List<SentenceDTO> sentenceDTOs) {
        this.sentenceDTOs = sentenceDTOs;
    }

    public VocabularyDTO getSimilarVocab() {
        return similarVocab;
    }

    public void setSimilarVocab(VocabularyDTO similarVocab) {
        this.similarVocab = similarVocab;
    }

    public VocabularyDTO getOppositeVocab() {
        return oppositeVocab;
    }

    public void setOppositeVocab(VocabularyDTO oppositeVocab) {
        this.oppositeVocab = oppositeVocab;
    }

    public String getCreatedDate() { return createdDate; }

    public void setCreatedDate(String createdDate) { this.createdDate = createdDate; }

    public String getUpdatedDate() { return updatedDate; }

    public void setUpdatedDate(String updatedDate) { this.updatedDate = updatedDate; }
}
