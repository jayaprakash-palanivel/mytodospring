package com.jp.todo.utils;

import java.io.StringWriter;
import java.util.Date;

import javax.mail.internet.MimeMessage;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import com.jp.todo.model.EmailModel;

@Service
public class SendEmailServiceImpl implements SendEmailService {
	@Autowired
	private JavaMailSender mailSender;
	@Autowired
	private VelocityEngine velocityEngine;

	VelocityContext modelValue = null;

	@Override
	public String sendEmployeeRegisterEmail(String toaddress, String bodyContent, String subject, EmailModel model) {
		String form = "support@jp.com";
		// String form = "jayaprakashpalanivel26@gmail.com"; //not work
		MimeMessagePreparator preparator = new MimeMessagePreparator() {

			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true);
				message.setTo(toaddress);
				message.setFrom(form);
				message.setSubject(bodyContent);
				message.setSentDate(new Date());
				String text = getTemplate(bodyContent, model);
				message.setText(text, true);
			}
		};
		try {
			mailSender.send(preparator);
		} catch (Exception e) {
			return "failed";
		}
		return "success";
	}

	public String getTemplate(String bodyContent, EmailModel model)
			throws ResourceNotFoundException, ParseErrorException, MethodInvocationException, Exception {
		String templateContent = null;
		StringWriter finalTemplate = new StringWriter();
		if (EmailCodes.EMPLOYEE_REGISTRATION.equalsIgnoreCase(bodyContent)) {
			modelValue = new VelocityContext();
			modelValue.put("email", model.getEmailId());
			modelValue.put("mobileNumber", model.getPhoneNumber());
			modelValue.put("userName", model.getUserName());
			modelValue.put("password", model.getPassword());
			boolean status = velocityEngine.mergeTemplate("/velocity/employeeregistration.vm", "UTF-8", modelValue,
					finalTemplate);
			if (status) {
				if (null != finalTemplate) {
					templateContent = finalTemplate.toString();
					return templateContent;
				}
			}
		}
		return null;

	}

	@Override
	public String sendTaskAssignEmail(String toAddress, String bodyContent, String subjects, EmailModel model) {
		String form = "support@jp.com";
		MimeMessagePreparator preparator = new MimeMessagePreparator() {

			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true);
				message.setTo(toAddress);
				message.setFrom(form);
				message.setSubject(subjects);
				message.setSentDate(new Date());

				String text = getTaskTemplate(bodyContent, model);
				message.setText(text, true);
			}

		};
		try {
			mailSender.send(preparator);
		} catch (Exception e) {
			return "failed";
		}
		return "success";
	}

	private String getTaskTemplate(String bodyContent, EmailModel model)
			throws ResourceNotFoundException, ParseErrorException, MethodInvocationException, Exception {
		String templateContent = null;
		StringWriter finalTemplate = new StringWriter();
		if (EmailCodes.TASK_ASSIGN.equalsIgnoreCase(bodyContent)) {
			modelValue = new VelocityContext();
			modelValue.put("userName", model.getUserName());
			modelValue.put("projectName", model.getProjectName());
			modelValue.put("emailId", model.getEmailId());
			modelValue.put("taskName", model.getTaskName());
			modelValue.put("startDate", model.getStartDate());
			modelValue.put("endDate", model.getEndDate());
			boolean status = velocityEngine.mergeTemplate("velocity/taskassign.vm", "UTF-8", modelValue, finalTemplate);
			if (status) {
				if (null != finalTemplate) {
					templateContent = finalTemplate.toString();
					return templateContent;
				}
			}
		}
		return null;
	}

}
