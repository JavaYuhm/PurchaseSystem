package com.example.pucrhase.components;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.HashMap;


@RequiredArgsConstructor
@Component
public class MailComponent {
    private final JavaMailSender javaMailSender;
    private SpringTemplateEngine templateEngine;

    public boolean sendMail(String title, String to, String templateName, HashMap<String, String> values) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setSubject(title);
        helper.setTo(to);

        Context context = new Context();
        values.forEach((key, value)-> context.setVariable(key,value));

        String html = templateEngine.process(templateName, context);
        helper.setText(html, true);

        javaMailSender.send(message);
        return true;
    }

}
