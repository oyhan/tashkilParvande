package com.gset.kish.TashkilParvande;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import com.gset.kish.TashkilParvande.Models.RequesterModel;
import com.gset.services.FaraPayamakSmsService;

public class Confirmed implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		
		RequesterModel rModel = (RequesterModel)execution.getVariable("RequesterModel");
		String referralDate = (String)execution.getVariable("referralDate");
//		SmsService smsService = new SmsService();
//		smsService.SendSms(rModel.telephone, rModel.fatherName);
		FaraPayamakSmsService smsService = new FaraPayamakSmsService();
		smsService.SendSms(referralDate, rModel.telephone);
		
	}

}
