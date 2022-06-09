package com.Ironhack.finalProjectserver.service.impl;

import com.Ironhack.finalProjectserver.DTO.DiaryLogDTO;
import com.Ironhack.finalProjectserver.model.DiaryLog;
import com.Ironhack.finalProjectserver.repository.DiaryLogRepository;
import com.Ironhack.finalProjectserver.repository.DiaryRepository;
import com.Ironhack.finalProjectserver.service.interfaces.DiaryLogServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
