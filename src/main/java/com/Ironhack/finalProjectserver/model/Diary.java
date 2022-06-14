package com.Ironhack.finalProjectserver.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Diary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate diaryDate;
    private String comments;
    private String doctorName;
    @OneToMany(mappedBy = "diary",cascade=CascadeType.ALL)
    private List<DiaryLog> diaryLogs;
}
