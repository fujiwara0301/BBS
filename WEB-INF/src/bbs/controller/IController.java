package bbs.controller;

import java.util.ArrayList;
import java.util.Map;

import bbs.entity.Contribution;

public interface IController {
	
	public void setForm(Map<String, String[]> paramMap);
	public String doCheck();
	public String doAction();
	public boolean shouldValidate();
	public ArrayList<String> getErrorList();
	public String getAnnounceMessage();
	public Contribution getEntity();
}
