package com.Ironhack.finalProjectserver.controller;

import com.Ironhack.finalProjectserver.DTO.DiaryLogDTO;
import com.Ironhack.finalProjectserver.model.Diary;
import com.Ironhack.finalProjectserver.repository.DiaryRepository;
import com.Ironhack.finalProjectserver.service.impl.DiaryLogService;
import com.Ironhack.finalProjectserver.service.impl.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DiaryLogController {
    @Autowired
    private DiaryLogService diaryLogService;

    @PostMapping("/diarylogs")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveDiaryLog(@RequestBody DiaryLogDTO diaryLogDTO){
        diaryLogService.saveDiaryLog(diaryLogDTO);
    }
}
