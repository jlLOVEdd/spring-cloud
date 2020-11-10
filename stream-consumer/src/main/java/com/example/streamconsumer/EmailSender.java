package com.example.streamconsumer;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EmailSender implements Sender {

    @Value("${email.to}")
    private String to;

    @Value("${email.from}")
    private String from;

    @Value("${email.password}")
    private String password;


    @Override
    public void sender(String code) {
        try {
            HtmlEmail email = new HtmlEmail();
            email.setCharset("utf-8");
            email.setHostName("smtp.163.com");
            email.addTo(to);
            email.setFrom(from);
            email.setAuthentication(from, password);
            email.setSubject("验证码");
            email.setMsg("您的验证码是：" + code);
            email.send();
        } catch (EmailException e) {
            System.out.println(e);
        }
    }

}
