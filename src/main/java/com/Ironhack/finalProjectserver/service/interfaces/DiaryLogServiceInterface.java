package com.Ironhack.finalProjectserver.service.interfaces;

import com.Ironhack.finalProjectserver.DTO.DiaryLogDTO;
import com.Ironhack.finalProjectserver.model.Diary;
import com.Ironhack.finalProjectserver.model.DiaryLog;

public interface DiaryLogServiceInterface {
    void saveDiaryLog(DiaryLogDTO diaryLogDTO);

    DiaryLog findById(Long id);

    void updateDiaryLog(Long id, DiaryLogDTO diaryLogDTO);
    void deleteDiaryLog(Long id);
}
