package com.asm.estore_mailing.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
public class EmailModel {
    private String from;
    private String to;
    private String subject;
    private String text;
    private LocalDateTime sent;

    public EmailModel(String from, String to, String subject, String text) {
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.text = text;
    }
}
