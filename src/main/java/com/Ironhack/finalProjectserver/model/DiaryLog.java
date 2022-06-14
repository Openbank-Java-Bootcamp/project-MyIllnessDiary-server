package com.Ironhack.finalProjectserver.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DiaryLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int crisisNumber;
    private String crisisType;
    private int duration;
    private String mood;
    private String comments;
    private String doctorName;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="diary_id")
    private Diary diary;
}
