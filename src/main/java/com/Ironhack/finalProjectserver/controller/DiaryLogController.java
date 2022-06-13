package com.Ironhack.finalProjectserver.controller;

import com.Ironhack.finalProjectserver.DTO.DiaryLogDTO;
import com.Ironhack.finalProjectserver.model.Diary;
import com.Ironhack.finalProjectserver.model.DiaryLog;
import com.Ironhack.finalProjectserver.repository.DiaryLogRepository;
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
    @Autowired
    private DiaryLogRepository diaryLogRepository;

    @PostMapping("/diarylogs")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveDiaryLog(@RequestBody DiaryLogDTO diaryLogDTO){
        diaryLogService.saveDiaryLog(diaryLogDTO);
    }




    @GetMapping("/diarylogs/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DiaryLog getDiaryLogById(@PathVariable(name = "id") Long diaryLogId) {
        return diaryLogService.findById(diaryLogId);
    }

    @GetMapping("/diarylogs")
    @ResponseStatus(HttpStatus.OK)
    public List<DiaryLog> getDiaryLogs() {
        return diaryLogRepository.findAll();
    }

    @PutMapping("/diarylogs/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateDiaryLog(@PathVariable Long id,@RequestBody @Valid DiaryLogDTO diaryLogDTO){
        diaryLogService.updateDiaryLog(id, diaryLogDTO);
    }

    @DeleteMapping("/diarylogs/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDiaryLog(@PathVariable Long id) {
        diaryLogService.deleteDiaryLog(id);
    }
}
