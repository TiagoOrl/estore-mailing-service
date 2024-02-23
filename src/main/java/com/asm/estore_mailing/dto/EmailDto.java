package com.asm.estore_mailing.dto;

import com.asm.estore_mailing.entity.EmailModel;
import lombok.Data;

import java.io.Serializable;

@Data
public class EmailDto implements Serializable {
    private String ownerRef;
    private String from;
    private String to;
    private String subject;
    private String text;

    public EmailModel toEntity() {
        return new EmailModel(from, to, subject, text);
    }
}
