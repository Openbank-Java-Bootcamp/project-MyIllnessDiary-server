package com.Ironhack.finalProjectserver.controller;

import com.Ironhack.finalProjectserver.model.Diary;
import com.Ironhack.finalProjectserver.model.User;
import com.Ironhack.finalProjectserver.repository.DiaryRepository;
import com.Ironhack.finalProjectserver.repository.UserRepository;
import com.Ironhack.finalProjectserver.service.impl.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DiaryController {
    @Autowired
    private DiaryRepository diaryRepository;

    @Autowired
    private DiaryService diaryService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/diaries/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Diary getDiaryById(@PathVariable(name = "id") Long diaryId) {
        return diaryService.findById(diaryId);
    }

    @GetMapping("/diaries/users")
    @ResponseStatus(HttpStatus.OK)
    public List<Diary> search(@RequestParam String id) {

            System.out.println("beep");
            User user = userRepository.findById(Long.parseLong(id)).get();
            return diaryRepository.findAllByUser(user);
    }


    @GetMapping("/diaries")
    @ResponseStatus(HttpStatus.OK)
    public List<Diary> getDiaries() {
        return diaryRepository.findAll();
    }

    @PostMapping("/diaries")
    @ResponseStatus(HttpStatus.CREATED)
    public void addDiary(@RequestBody @Valid Diary diary, Authentication authentication){
        diaryService.saveDiary(diary, authentication);
    }

    @PutMapping("/diaries/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateDiary(@PathVariable Long id,@RequestBody @Valid Diary diary){
        diaryService.update(id, diary);
    }

    @DeleteMapping("/diaries/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDiary(@PathVariable Long id) {
        diaryService.deleteDiary(id);
    }
}
