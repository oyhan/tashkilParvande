package com.gset.kish.TashkilParvande;

import java.util.Date;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.joda.time.DateTime;

import com.gset.kish.TashkilParvande.Models.RequesterModel;
import com.gset.services.FaraPayamakSmsService;
import com.gset.services.PersianCalendar;

import ir.gset.utils.dateTime.PersianDateTime;

public class Confirmed implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		
		RequesterModel rModel = (RequesterModel)execution.getVariable("RequesterModel");
		String referralDate = (String)execution.getVariable("referralDate");
		String referralTime = (String)execution.getVariable("referralTime");
		String consideration = (String)execution.getVariable("considerations");
		
//		SmsService smsService = new SmsService();
//		smsService.SendSms(rModel.telephone, rModel.fatherName);
		FaraPayamakSmsService smsService = new FaraPayamakSmsService();
		
		String textToSend = "با سلام لطفا در تاریخ "+PersianDateTime.ToPersianStringDate(referralDate)+ " و ساعت " +referralTime +"جهت تحویل مدارک خود به سازمان منطقه آزاد کیش مراجعه کنید"+" ملاحظات: "+consideration;
		smsService.SendSms(textToSend, rModel.telephone);
		
	}

}
