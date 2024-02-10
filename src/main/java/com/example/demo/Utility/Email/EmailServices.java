package com.example.demo.Utility.Email;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailServices {

    @Autowired
    private SmtpEmailSender smtpEmailSender;

    public void testEmail(String emailId) {

        MessageEmail email = new MessageEmail();

        email.setSubject("ALERT: BACKUP DEVICE STARTED");

        email.setTo(Collections.singletonList(emailId));
        String message = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>Activation of Backup ONT Device</title>\n" +
                "</head>\n" +
                "<body style=\"font-family: Arial, sans-serif; margin: 0; padding: 0; background-color: #f4f4f4;\">\n" +
                "    <div style=\"max-width: 600px; margin: 20px auto; padding: 20px; background-color: #ffffff; border-radius: 10px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);\">\n" +
                "        <h1 style=\"color: #333333;\">Activation of Backup ONT Device</h1>\n" +
                "        <p style=\"color: #666666;\">Hello USER_XYZ,</p>\n" +
                "        <p style=\"color: #666666;\">We are pleased to inform you that a backup ONT (Optical Network Terminal) device has been successfully activated in the network. This backup device will ensure uninterrupted connectivity in case of any primary ONT failure.</p>\n" +
                "        <p style=\"color: #666666;\">Please review the details below:</p>\n" +
                "        <ul>\n" +
                "            <li><strong>Device ID:</strong> BKUP2</li>\n" +
                "            <li><strong>Location:</strong> CHENNAI-OMRs</li>\n" +
                "            <li><strong>Status:</strong> Active</li>\n" +
                "        </ul>\n" +
                "        <p style=\"color: #666666;\">If you have any questions or concerns, please feel free to contact our support team.</p>\n" +
                "        <a href=\"[SupportLink]\" style=\"display: inline-block; background-color: #007bff; color: #ffffff; text-decoration: none; padding: 10px 20px; border-radius: 5px;\">Contact Support</a>\n" +
                "        <p style=\"margin-top: 20px; text-align: center; color: #999999; font-size: 12px;\">This is an automated email. Please do not reply to this message.</p>\n" +
                "    </div>\n" +
                "</body>\n" +
                "</html>\n";

        email.setBody(message);
        email.setHtml(true);

        smtpEmailSender.sendMessage(email);
    }
}
