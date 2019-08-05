package com.example.english.greenglish.dto;

public class SentenceDTO {
    private String id;
    private String sentence;
    private Long vocabularyId;
    private String createdDate;
    private String updatedDate;

    public SentenceDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public Long getVocabularyId() { return vocabularyId; }

    public void setVocabularyId(Long vocabularyId) { this.vocabularyId = vocabularyId; }

    public String getCreatedDate() { return createdDate; }

    public void setCreatedDate(String createdDate) { this.createdDate = createdDate; }

    public String getUpdatedDate() { return updatedDate; }

    public void setUpdatedDate(String updatedDate) { this.updatedDate = updatedDate; }
}
