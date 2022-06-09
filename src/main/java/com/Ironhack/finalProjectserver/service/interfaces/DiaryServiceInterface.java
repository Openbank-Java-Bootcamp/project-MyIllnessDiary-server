package com.Ironhack.finalProjectserver.service.interfaces;

import com.Ironhack.finalProjectserver.model.Diary;

public interface DiaryServiceInterface {
    Diary findById(Long id);
    void saveDiary(Diary diary);
    void update(Long id, Diary diary);
    void deleteDiary(Long id);
}
