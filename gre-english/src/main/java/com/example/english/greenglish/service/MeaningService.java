package com.example.english.greenglish.service;

import com.example.english.greenglish.dto.MeaningDTO;

import java.util.List;

public interface MeaningService {

    List<MeaningDTO> addMeaning(List<MeaningDTO> meaningDTO, Long vocabId);

    MeaningDTO update(Long id, MeaningDTO meaningDTO);
}
