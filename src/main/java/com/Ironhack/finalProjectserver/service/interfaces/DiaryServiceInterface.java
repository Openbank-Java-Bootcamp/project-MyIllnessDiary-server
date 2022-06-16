package com.Ironhack.finalProjectserver.service.interfaces;

import com.Ironhack.finalProjectserver.DTO.DiaryDTO;
import com.Ironhack.finalProjectserver.model.Diary;
import org.springframework.security.core.Authentication;

public interface DiaryServiceInterface {
    Diary findById(Long id);
    void saveDiary(Diary diary, Authentication authentication);
    //void saveDiaryUser(DiaryDTO diaryDTO);
    void update(Long id, Diary diary);
    void deleteDiary(Long id);
}
