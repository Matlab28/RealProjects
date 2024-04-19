package com.example.login.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class EmailService {
    private final JavaMailSender mailSender;

    public void sending(String sub, String text) {
//        SimpleMailMessage msg = new SimpleMailMessage();

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("metleb.abbaszade@gmail.com");
        msg.setFrom("matlab.abbaszada@gmail.com");
        msg.setText(text);
        msg.setSubject(sub);
        mailSender.send(msg);
    }



    //    public String sending(String text) {
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setTo("matlab.abbaszada@gmail.com");
//        message.setFrom("metleb.abbaszade@gmail.com");
//        message.setSubject("Testing my first email sender");
//        message.setText(text);
//        mailSender.send(message);
//        return "Sent successfully!";
//    }


//    public void sendEmail(EmailRequestDto dto) {
////        List<EmailEntity> list = repository.findByFirstName(firstname)
////                .orElseThrow(() -> new MessagingException("Email not found by first name - " + firstname));
////
////        List<EmailResponseDto> collected = list
////                .stream()
////                .map(m -> modelMapper.map(m, EmailResponseDto.class))
////                .toList();
//
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setTo("matlab.abbaszada@gmail.com");
//        message.setFrom("metleb.abbaszade@gmail.com");
//        message.setSubject(dto.getSubject());
//        message.setText("Hi, it's nice to see you!");
//
//        mailSender.send(message);
//        log.info("Message sent");
//    }


}
