package react_backend.be_project.Service;

import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import react_backend.be_project.Dto.ContactDto;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
@AllArgsConstructor
public class EmailService {

    private JavaMailSender mailSender;

    public void sendContactNotification(ContactDto contact) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo("sachinrohit153@gmail.com");
            message.setSubject("New Client - " + contact.getName());
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
                            "🌐 Website: Sanaa Interior"
            );

            mailSender.send(message);
            System.out.println("✅ Email notification sent successfully to owner!");
        } catch (Exception e) {
            System.err.println("❌ Failed to send email to owner: " + e.getMessage());
        }
    }

    public void sendUserConfirmation(ContactDto contact) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

            helper.setTo(contact.getEmail());
            helper.setSubject("Thank You for Contacting Us - Sanaa Interior");

            String htmlContent = buildHtmlEmailTemplate(contact);
            helper.setText(htmlContent, true);

            mailSender.send(message);
            System.out.println("✅ HTML confirmation email sent successfully to user: " + contact.getEmail());

        } catch (MessagingException e) {
            System.err.println("❌ Failed to send HTML email to user: " + e.getMessage());
        }
    }

    private String buildHtmlEmailTemplate(ContactDto contact) {
        String formattedTime = java.time.LocalDateTime.now()
                .format(java.time.format.DateTimeFormatter.ofPattern("dd MMM yyyy, hh:mm a"));

        return "<!DOCTYPE html>" +
                "<html lang=\"en\">" +
                "<head>" +
                "    <meta charset=\"UTF-8\">" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">" +
                "    <title>Thank You - Sanaa Interior</title>" +
                "    <style>" +
                "        body { " +
                "            font-family: 'Arial', sans-serif; " +
                "            line-height: 1.6; " +
                "            color: #333; " +
                "            max-width: 600px; " +
                "            margin: 0 auto; " +
                "            padding: 20px;" +
                "            background-color: #f9f9f9;" +
                "        }" +
                "        .header { " +
                "            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);" +
                "            color: white; " +
                "            padding: 30px; " +
                "            text-align: center; " +
                "            border-radius: 10px 10px 0 0;" +
                "        }" +
                "        .content { " +
                "            background: white; " +
                "            padding: 30px; " +
                "            border-radius: 0 0 10px 10px;" +
                "            box-shadow: 0 4px 6px rgba(0,0,0,0.1);" +
                "        }" +
                "        .details-box { " +
                "            background: #f8f9fa; " +
                "            border-left: 4px solid #667eea; " +
                "            padding: 20px; " +
                "            margin: 20px 0; " +
                "            border-radius: 5px;" +
                "        }" +
                "        .step { " +
                "            display: flex; " +
                "            align-items: center; " +
                "            margin: 15px 0; " +
                "            padding: 10px;" +
                "            background: #f0f4ff;" +
                "            border-radius: 8px;" +
                "        }" +
                "        .step-number { " +
                "            background: #667eea; " +
                "            color: white; " +
                "            width: 30px; " +
                "            height: 30px; " +
                "            border-radius: 50%; " +
                "            display: flex; " +
                "            align-items: center; " +
                "            justify-content: center; " +
                "            margin-right: 15px; " +
                "            font-weight: bold;" +
                "            flex-shrink: 0;" +
                "        }" +
                "        .footer { " +
                "            text-align: center; " +
                "            margin-top: 30px; " +
                "            padding: 20px; " +
                "            background: #2c3e50; " +
                "            color: white; " +
                "            border-radius: 10px;" +
                "        }" +
                "        .social-links a { " +
                "            color: #667eea; " +
                "            margin: 0 10px; " +
                "            text-decoration: none; " +
                "            font-weight: bold;" +
                "        }" +
                "        .highlight { " +
                "            color: #667eea; " +
                "            font-weight: bold;" +
                "        }" +
                "    </style>" +
                "</head>" +
                "<body>" +
                "    <div class=\"header\">" +
                "        <h1>✨ Thank You for Contacting Us! ✨</h1>" +
                "        <p>Your journey to beautiful spaces begins here</p>" +
                "    </div>" +
                "    " +
                "    <div class=\"content\">" +
                "        <h2>Dear <span class=\"highlight\">" + contact.getName() + "</span>,</h2>" +
                "        " +
                "        <p>Thank you for reaching out to us! We're thrilled that you're considering our interior design services to transform your space.</p>" +
                "        " +
                "        <div class=\"details-box\">" +
                "            <h3>📋 Your Submission Details:</h3>" +
                "            <p><strong>Name:</strong> " + contact.getName() + "</p>" +
                "            <p><strong>Email:</strong> " + contact.getEmail() + "</p>" +
                "            <p><strong>Phone:</strong> " + contact.getPhone() + "</p>" +
                "            <p><strong>Requirement:</strong> " + contact.getRequirement() + "</p>" +
                "            <p><strong>Submitted:</strong> " + formattedTime + "</p>" +
                "        </div>" +
                "        " +
                "        <h3>🚀 What Happens Next?</h3>" +
                "        " +
                "        <div class=\"step\">" +
                "            <div class=\"step-number\">1</div>" +
                "            <div>" +
                "                <strong>Initial Review</strong><br>" +
                "                Our team will review your requirements (within 24 hours)" +
                "            </div>" +
                "        </div>" +
                "        " +
                "        <div class=\"step\">" +
                "            <div class=\"step-number\">2</div>" +
                "            <div>" +
                "                <strong>Designer Assignment</strong><br>" +
                "                A dedicated design consultant will be assigned to your project" +
                "            </div>" +
                "        </div>" +
                "        " +
                "        <div class=\"step\">" +
                "            <div class=\"step-number\">3</div>" +
                "            <div>" +
                "                <strong>Personal Consultation</strong><br>" +
                "                We'll schedule a call to understand your vision in detail" +
                "            </div>" +
                "        </div>" +
                "        " +
                "        <div class=\"step\">" +
                "            <div class=\"step-number\">4</div>" +
                "            <div>" +
                "                <strong>Custom Proposal</strong><br>" +
                "                You'll receive a tailored design concept and proposal" +
                "            </div>" +
                "        </div>" +
                "        " +
                "        <p style=\"text-align: center; margin-top: 25px;\">" +
                "            <strong>We'll contact you within 24-48 hours to discuss your project!</strong>" +
                "        </p>" +
                "    </div>" +
                "    " +
                "    <div class=\"footer\">" +
                "        <h3>Sanaa Interior</h3>" +
                "        <p>Transforming spaces, creating dreams</p>" +
                "        <p>📧 sachinrohit153@gmail.com | 📞 9345421999</p>" +
                "        <div class=\"social-links\">" +
                "            <a href=\"#\">Instagram</a> | " +
                "            <a href=\"#\">Facebook</a> | " +
                "            <a href=\"#\">Pinterest</a>" +
                "        </div>" +
                "        <p style=\"margin-top: 15px; font-size: 12px; opacity: 0.8;\">" +
                "            &copy; 2024 Sanaa Interior. All rights reserved." +
                "        </p>" +
                "    </div>" +
                "</body>" +
                "</html>";
    }
}