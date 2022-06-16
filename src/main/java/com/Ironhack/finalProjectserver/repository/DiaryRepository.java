package com.Ironhack.finalProjectserver.repository;

import com.Ironhack.finalProjectserver.model.Diary;
import com.Ironhack.finalProjectserver.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiaryRepository extends JpaRepository<Diary,Long> {

    @Query(value="SELECT diary.id, diary.diary_week, user.id FROM diary INNER JOIN user ON diary.user_id = user.id WHERE user.id = :id",nativeQuery = true)
    List<Diary> findAllByUser_id(@Param("id") Long id);

    List<Diary> findAllByUser(User user);
}
