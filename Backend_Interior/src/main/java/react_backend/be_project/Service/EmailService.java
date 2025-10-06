package react_backend.be_project.Service;

import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import react_backend.be_project.Dto.ContactDto;

@Service
@AllArgsConstructor
public class EmailService {

    private JavaMailSender mailSender;

    public void sendContactNotification(ContactDto contact) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo("sachinrohit153@gmail.com"); // Change to owner's email
            message.setSubject("New Client - Interior Website");
            String formattedTime = java.time.LocalDateTime.now()
                    .format(java.time.format.DateTimeFormatter.ofPattern("dd-MMM-yyyy hh:mm a"));

            message.setText(
                    "🔔 New Contact Form Submission Received!\n\n" +
                            "📋 Contact Details:\n" +
                            "——————————————————\n" +
                            "👤 Name: " + contact.getName() + "\n" +
                            "📧 Email: " + contact.getEmail() + "\n" +
                            "📞 Phone: " + contact.getPhone() + "\n" +
                            "💬 Requirement: " + contact.getRequirement() + "\n\n" +
                            "⏰ Received at: " + formattedTime + "\n" +
                            "🌐 Website: Interior Design Portfolio"
            );

            mailSender.send(message);
            System.out.println("✅ Email notification sent successfully!");
        } catch (Exception e) {
            System.err.println("❌ Failed to send email: " + e.getMessage());
        }
    }
}