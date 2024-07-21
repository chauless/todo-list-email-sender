package pet.tasktrackeremailsender.mail.service;

import pet.tasktrackeremailsender.dto.EmailDto;

public interface EmailSenderService {
    /**
     * Sends an email based on the provided EmailDto object.
     *
     * @param emailDto The EmailDto object containing the email details. It includes the receiver's email, subject, and body of the email.
     */
    void sendEmail(EmailDto emailDto);
}
