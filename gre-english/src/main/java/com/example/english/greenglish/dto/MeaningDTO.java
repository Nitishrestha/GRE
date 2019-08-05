package com.example.english.greenglish.dto;

public class MeaningDTO {
    private String id;
    private String wordMeaning;
    private Long vocabularyId;
    private String createdDate;
    private String updatedDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWordMeaning() { return wordMeaning; }

    public void setWordMeaning(String wordMeaning) { this.wordMeaning = wordMeaning; }

    public Long getVocabularyId() { return vocabularyId; }

    public void setVocabularyId(Long vocabularyId) { this.vocabularyId = vocabularyId; }

    public String getCreatedDate() { return createdDate; }

    public void setCreatedDate(String createdDate) { this.createdDate = createdDate; }

    public String getUpdatedDate() { return updatedDate; }

    public void setUpdatedDate(String updatedDate) { this.updatedDate = updatedDate; }
}
