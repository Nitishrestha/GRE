package com.example.english.greenglish.controller;

import com.example.english.greenglish.dto.VocabularyDTO;
import com.example.english.greenglish.service.VocabService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.english.greenglish.utils.ApiConstant.*;

@RestController
@RequestMapping(API_VER + VOCAB_PATH)
public class VocabController {

    private final VocabService vocabService;

    public VocabController(final VocabService vocabService) {
        this.vocabService = vocabService;
    }

    @PostMapping
    public ResponseEntity<VocabularyDTO> add(@RequestBody VocabularyDTO vocabularyDTO) {
        VocabularyDTO newVocabularyDTO = vocabService.add(vocabularyDTO);
        return new ResponseEntity<>(newVocabularyDTO, HttpStatus.OK);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", dataType = "integer", paramType = "query",
                    value = "Results page you want to retrieve (0..N)"),
            @ApiImplicitParam(name = "size", dataType = "integer", paramType = "query",
                    value = "Number of records per page."),
            @ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query",
                    value = "Sorting criteria in the format: property(,asc|desc). " +
                            "Default sort order is descending. " +
                            "Multiple sort criteria are supported.")
    })
    @GetMapping
    public ResponseEntity<List<VocabularyDTO>> getAll(@PageableDefault(sort = "id", direction = Sort.Direction.DESC
            , size = Integer.MAX_VALUE) Pageable pageable, @RequestParam(required = false) String initialLetter, String param) {
        List<VocabularyDTO> vocabularyDTOList = vocabService.getAll(pageable, initialLetter, param);
        return new ResponseEntity<>(vocabularyDTOList, HttpStatus.OK);
    }

    @GetMapping(INITIAL_LETTER_PATH)
    public ResponseEntity<List<VocabularyDTO>> getByInitialLetter(@PathVariable String initialLetter) {
        List<VocabularyDTO> vocabularyDTOs = vocabService.getByInitialLetter(initialLetter);
        return new ResponseEntity<>(vocabularyDTOs, HttpStatus.OK);
    }

    @PutMapping(ID_PATH)
    public ResponseEntity<VocabularyDTO> update(@PathVariable Long id, @RequestBody VocabularyDTO vocabularyDTO){
        VocabularyDTO newVocabularyDTO =vocabService.update(id, vocabularyDTO);
        return new ResponseEntity<>(newVocabularyDTO, HttpStatus.OK);
    }
}
