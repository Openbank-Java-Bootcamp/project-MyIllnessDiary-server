package com.Ironhack.finalProjectserver.service.impl;

import com.Ironhack.finalProjectserver.DTO.DiaryLogDTO;
import com.Ironhack.finalProjectserver.model.Diary;
import com.Ironhack.finalProjectserver.model.DiaryLog;
import com.Ironhack.finalProjectserver.repository.DiaryLogRepository;
import com.Ironhack.finalProjectserver.repository.DiaryRepository;
import com.Ironhack.finalProjectserver.service.interfaces.DiaryLogServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class DiaryLogService implements DiaryLogServiceInterface {
    @Autowired
    private DiaryRepository diaryRepository;

    @Autowired
    private DiaryLogRepository diaryLogRepository;

    public void saveDiaryLog(DiaryLogDTO diaryLogDTO){
        DiaryLog newDiaryLog = new DiaryLog();
        newDiaryLog.setCrisisNumber(diaryLogDTO.getCrisisNumber());
        newDiaryLog.setCrisisType(diaryLogDTO.getCrisisType());
        newDiaryLog.setDuration(diaryLogDTO.getDuration());
        newDiaryLog.setMood(diaryLogDTO.getMood());
        newDiaryLog.setDiary(diaryRepository.findById(diaryLogDTO.getDiaryId()).get());
        diaryLogRepository.save(newDiaryLog);
    }


    

    public DiaryLog findById(Long id) {
        return diaryLogRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "DiaryLog not found"));
    }

    public void updateDiaryLog(Long id, DiaryLogDTO diaryLogDTO) {
        Optional<DiaryLog> diaryLog = diaryLogRepository.findById(id);
        if (diaryLog.isPresent()) {
            try {
                diaryLog.get().setCrisisNumber(diaryLogDTO.getCrisisNumber());
                diaryLog.get().setCrisisType(diaryLogDTO.getCrisisType());
                diaryLog.get().setDuration(diaryLogDTO.getDuration());
                diaryLog.get().setMood(diaryLogDTO.getMood());
                diaryLogRepository.save(diaryLog.get());
            } catch (Exception e) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "DiaryLog not valid.");
            }
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The DiaryLogId doesn't exist.");
        }
    }

    public void deleteDiaryLog(Long id) {
        DiaryLog diaryLogFromDB = diaryLogRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "DiaryLog not found"));
        diaryLogRepository.deleteById(id);
    }
}
