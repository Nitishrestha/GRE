package com.example.english.greenglish.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Vocabulary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "word")
    private String word;
    @Column(name = "grammar_type")
    private String grammarType;
    @Column(name = "is_mastered")
    private Boolean isMastered;
    @Column(name = "created_date")
    @CreationTimestamp
    private LocalDateTime createdDate;
    @Column(name = "updated_date")
    private LocalDateTime updatedDate;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "similar_vocab",
            joinColumns = @JoinColumn(name = "first_vocab_id"),
            inverseJoinColumns = @JoinColumn(name = "second_vocab_id"))
    private Vocabulary similarVocabularies;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "opposite_vocab",
            joinColumns = @JoinColumn(name = "first_vocab_id"),
            inverseJoinColumns = @JoinColumn(name = "second_vocab_id"))
    private Vocabulary oppositeVocabularies;
    @OneToMany(mappedBy = "vocabulary")
    private List<Meaning> meanings;
    @OneToMany(mappedBy = "vocabulary")
    private List<Sentence> sentences;

    public Vocabulary() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public void setSimilarVocabularies(Vocabulary similarVocabularies) {
        this.similarVocabularies = similarVocabularies;
    }

    public Vocabulary getOppositeVocabularies() {
        return oppositeVocabularies;
    }

    public void setOppositeVocabularies(Vocabulary oppositeVocabularies) {
        this.oppositeVocabularies = oppositeVocabularies;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Vocabulary getSimilarVocabularies() {
        return similarVocabularies;
    }

    public List<Meaning> getMeanings() { return meanings; }

    public void setMeanings(List<Meaning> meanings) {
        this.meanings = meanings;
    }

    public List<Sentence> getSentences() {
        return sentences;
    }

    public void setSentences(List<Sentence> sentences) {
        this.sentences = sentences;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
