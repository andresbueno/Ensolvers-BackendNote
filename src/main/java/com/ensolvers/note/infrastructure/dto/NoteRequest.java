package com.ensolvers.note.infrastructure.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class NoteRequest {
    private String title;
    private String content;

}
