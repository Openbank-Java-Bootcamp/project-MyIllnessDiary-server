package com.Ironhack.finalProjectserver.service.impl;

import com.Ironhack.finalProjectserver.DTO.DiaryDTO;
import com.Ironhack.finalProjectserver.DTO.DiaryLogDTO;
import com.Ironhack.finalProjectserver.model.Diary;
import com.Ironhack.finalProjectserver.model.DiaryLog;
import com.Ironhack.finalProjectserver.model.User;
import com.Ironhack.finalProjectserver.repository.DiaryRepository;
import com.Ironhack.finalProjectserver.repository.UserRepository;
import com.Ironhack.finalProjectserver.service.interfaces.DiaryServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class DiaryService implements DiaryServiceInterface {

    @Autowired
    private DiaryRepository diaryRepository;
    @Autowired
    private UserRepository userRepository;

    public Diary findById(Long id) {
        return diaryRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Diary not found"));
    }

    public void saveDiary(Diary diary, Authentication authentication) {
        String email = (String) authentication.getPrincipal();
        User userFromDb = userRepository.findByEmail(email);
        if (diary.getId() != null) {
            Optional<Diary> optionalDiary = diaryRepository.findById(diary.getId());
            if (optionalDiary.isPresent())
                throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Diary with id " + diary.getId() + " already exist");
        }
        diary.setUser(userFromDb);
        diaryRepository.save(diary);
    }
    /*public void saveDiaryUser(DiaryDTO diaryDTO){
        Diary newDiary = new Diary();
        newDiary.setDiaryWeek(diaryDTO.getDiaryWeek());
        newDiary.setUser(userRepository.findById(diaryDTO.getUserId()).get());
        diaryRepository.save(newDiary);
    }*/

    public void update(Long id, Diary diary) {
        Diary diaryFromDB = diaryRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Diary is not found"));
        diary.setId(diaryFromDB.getId());
        diaryRepository.save(diary);
    }

    public void deleteDiary(Long id) {
        Diary diaryFromDB = diaryRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Diary not found"));
        diaryRepository.deleteById(id);
    }
}
