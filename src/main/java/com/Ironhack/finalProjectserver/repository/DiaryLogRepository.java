package com.Ironhack.finalProjectserver.repository;

import com.Ironhack.finalProjectserver.model.DiaryLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiaryLogRepository extends JpaRepository<DiaryLog,Long> {
}
