package com.example.english.greenglish.controller;

import com.example.english.greenglish.dto.MeaningDTO;
import com.example.english.greenglish.service.MeaningService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.english.greenglish.utils.ApiConstant.*;

@RestController
@RequestMapping(API_VER + MEANING_PATH)
public class MeaningController {

    private final MeaningService meaningService;

    public MeaningController(MeaningService meaningService) {
        this.meaningService = meaningService;
    }

    @PostMapping
    public ResponseEntity<List<MeaningDTO>> add(@RequestBody List<MeaningDTO> meaningDTOs, @RequestParam Long vocabId){
        List<MeaningDTO> meaningDTOList = meaningService.addMeaning(meaningDTOs, vocabId);
        return new ResponseEntity<>(meaningDTOList, HttpStatus.OK);
    }

    @PutMapping(ID_PATH)
    public ResponseEntity<MeaningDTO> update(@PathVariable Long id, @RequestBody MeaningDTO meaningDTO){
        MeaningDTO newMeaningDTO = meaningService.update(id, meaningDTO);
        return new ResponseEntity<>(newMeaningDTO, HttpStatus.OK);
    }
}
