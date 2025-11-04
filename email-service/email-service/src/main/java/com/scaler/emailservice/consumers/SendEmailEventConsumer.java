package com.scaler.emailservice.consumers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.scaler.emailservice.dtos.SendEmailEventDto;
import com.scaler.emailservice.utils.EmailUtil;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.util.Properties;

@Service
public class SendEmailEventConsumer {
    @Autowired
    private ObjectMapper objectMapper;

    @KafkaListener(topics = "sendEmailEvent",  groupId = "emailServiceGroup")
    public void handleSendEmailEvent(String message) throws JsonProcessingException {
        SendEmailEventDto eventDto = objectMapper.readValue(
                message,
                SendEmailEventDto.class
        );

        String subject = eventDto.getSubject();
        String body = eventDto.getBody();
        String toEmail = eventDto.getToEmail();

        //Send an Email.
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
        props.put("mail.smtp.port", "587"); //TLS Port
        props.put("mail.smtp.auth", "true"); //enable authentication
        props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS

        //create Authenticator object to pass in Session.getInstance argument
        Authenticator auth = new Authenticator() {
            //override the getPasswordAuthentication method
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(
                        "raushansingh747@gmail.com",
                        "lkrsvufateplymjp");
            }
        };
        Session session = Session.getInstance(props, auth);

        EmailUtil.sendEmail(session, toEmail, subject, body);
    }

    public void handleOrderConfirmationEmailEvent() {

    }
}
