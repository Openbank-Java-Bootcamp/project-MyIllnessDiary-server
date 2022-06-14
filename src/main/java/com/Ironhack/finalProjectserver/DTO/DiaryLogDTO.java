package com.Ironhack.finalProjectserver.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DiaryLogDTO {
    private int crisisNumber;
    private String crisisType;
    private int duration;
    private String mood;
    private String comments;
    private String doctorName;
    private Long diaryId;
}
