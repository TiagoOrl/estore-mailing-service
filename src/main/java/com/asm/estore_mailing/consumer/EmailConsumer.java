package com.asm.estore_mailing.consumer;

import com.asm.estore_mailing.dto.EmailDto;
import com.asm.estore_mailing.service.MailingService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {
    private final MailingService emailService;

    @Autowired
    public EmailConsumer(MailingService mailingService) {
        this.emailService = mailingService;
    }

    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void listen(@Payload EmailDto dto) {
        emailService.sendEmail(dto.toEntity());
        System.out.println("Received new message...");
    }
}
