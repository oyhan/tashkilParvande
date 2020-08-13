package com.gset.kish.TashkilParvande;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import com.gset.kish.TashkilParvande.Models.RequesterModel;
import com.gset.kish.TashkilParvande.Models.SmsService;
import com.gset.services.FaraPayamakSmsService;

public class NotConfirmed implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		// TODO Auto-generated method stub
		
		RequesterModel rModel = (RequesterModel)execution.getVariable("RequesterModel");
		String reason = (String)execution.getVariable("rejectReason");
//		SmsService smsService = new SmsService();
//		smsService.SendSms(rModel.telephone, rModel.fatherName);
		FaraPayamakSmsService smsService = new FaraPayamakSmsService();
		smsService.SendSms(reason, rModel.telephone);
		
		
	}

}
