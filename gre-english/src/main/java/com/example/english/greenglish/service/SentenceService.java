package com.example.english.greenglish.service;

import com.example.english.greenglish.dto.SentenceDTO;

import java.util.List;

public interface SentenceService {

    List<SentenceDTO> addSentence(List<SentenceDTO> sentenceDTOs, Long vocabId);
}
