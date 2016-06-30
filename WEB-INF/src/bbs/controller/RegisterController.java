package bbs.controller;

import java.util.ArrayList;
import java.util.Map;

import bbs.entity.Contribution;
import bbs.form.RegisterForm;
import bbs.service.CheckWord;

public class RegisterController implements IController {
	
	protected RegisterForm form;
	
	ArrayList<String> errorList = null;
	
	public void setForm(Map<String, String[]> paramMap) {
		String name = paramMap.get("name")[0].trim();
		form.setName(name);
		form.setMail(paramMap.get("mail")[0]);
		form.setTitle(paramMap.get("title")[0]);
		form.setMessage(paramMap.get("message")[0]);
		form.setPassword(paramMap.get("password")[0]);
	}
	public String doCheck() {
		CheckWord checker = new CheckWord();
		checker.nameCheck(form.getName(), "名前");
		checker.mailCheck(form.getMail(), "メール");
		checker.titleCheck(form.getTitle(), "タイトル");
		checker.messageCheck(form.getMessage(), "本文");
		checker.passwordCheck(form.getPassword(), "パスワード");
		errorList = checker.getErrorList();
		return "";
	}
	public String doAction() {
		return "";
	}
	
	public boolean shouldValidate() {
		return true;
	}
	@Override
	public ArrayList<String> getErrorList() {
		// TODO Auto-generated method stub
		return errorList;
	}
	@Override
	public String getAnnounceMessage() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Contribution getEntity() {
		// TODO Auto-generated method stub
		return null;
	}

}
