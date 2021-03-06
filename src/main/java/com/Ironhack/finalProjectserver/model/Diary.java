package com.Ironhack.finalProjectserver.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private String diaryWeek;

    @OneToMany(mappedBy = "diary",cascade=CascadeType.ALL)
    private List<DiaryLog> diaryLogs;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    //@OneToOne
    //@JoinColumn(name = "diaryLogs_id")
    //private DiaryLog diaryLogs;
}
