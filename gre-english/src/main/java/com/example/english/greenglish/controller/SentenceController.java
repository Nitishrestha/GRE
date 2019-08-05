package com.example.english.greenglish.controller;

import com.example.english.greenglish.dto.SentenceDTO;
import com.example.english.greenglish.service.SentenceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.english.greenglish.utils.ApiConstant.*;

@RestController
@RequestMapping(API_VER + SENTENCE_PATH)
public class SentenceController {

    private final SentenceService sentenceService;

    public SentenceController(final SentenceService sentenceService) {
        this.sentenceService = sentenceService;
    }

    @PostMapping
    public ResponseEntity<List<SentenceDTO>> add(@RequestBody List<SentenceDTO> sentenceDTOs, @RequestParam Long vocabId) {
        List<SentenceDTO> sentenceDTOS = sentenceService.addSentence(sentenceDTOs, vocabId);
        return new ResponseEntity<>(sentenceDTOS, HttpStatus.OK);
    }
}
