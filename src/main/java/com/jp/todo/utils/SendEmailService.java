package com.jp.todo.utils;

import com.jp.todo.model.EmailModel;

public interface SendEmailService {

	String sendEmployeeRegisterEmail(String toaddress, String bodyContent, String subject, EmailModel model);

	String sendTaskAssignEmail(String toAddress, String bodyContent, String subjects, EmailModel model);

}
