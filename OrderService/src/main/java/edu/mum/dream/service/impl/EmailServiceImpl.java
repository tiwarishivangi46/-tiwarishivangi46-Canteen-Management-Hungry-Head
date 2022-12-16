
package edu.mum.dream.service.impl;

import java.util.Locale;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import edu.mum.dream.domain.Order;
import edu.mum.dream.service.EmailService;

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private SpringTemplateEngine templateEngine;

	public void sendOrderReceivedMail(final String recipientName, final String recipientEmail, Order order,
			final Locale locale) throws MessagingException {

		final Context thymeContext = new Context(locale);
		thymeContext.setVariable("name", recipientName);
		thymeContext.setVariable("order", order);

		final MimeMessage mimeMessage = this.mailSender.createMimeMessage();
		final MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, "UTF-8");
		message.setSubject("Order Details");
		message.setTo(recipientEmail);

		final String htmlContent = this.templateEngine.process("orderReceivedMail", thymeContext);
		message.setText(htmlContent, true /* isHtml */);
		this.mailSender.send(mimeMessage);

	}

}
