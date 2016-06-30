package bbs.controller;

import java.util.ArrayList;
import java.util.Map;

import bbs.dbmanage.DBManager;
import bbs.entity.Contribution;
import bbs.form.MainForm;

public class MainController implements IController {

	protected MainForm form;
	protected String selectFunction = "";
	protected Contribution contribution = null;
	@Override
	public void setForm(Map<String, String[]> paramMap) {
		selectFunction = paramMap.get("selectFunction")[0];
		System.out.println("");
		if (paramMap.get("indexNumber") != null) {
			form.setIndexNumber(paramMap.get("indexNumber")[0]);
			form.setIdCode(paramMap.get("idCode")[0]);
		}
	}

	@Override
	public String doCheck() {
		return null;
	}

	@Override
	public String doAction() {
		if (selectFunction.equals("register")) {
			contribution = new Contribution();
			return "/bbs/register.jsp";
		} else if (selectFunction.equals("check")) {
			contribution = DBManager.getContribution(form.getIdCode());
			return "/bbs/inputpassword.jsp";
		}
		
		return null;
	}

	@Override
	public boolean shouldValidate() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<String> getErrorList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAnnounceMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Contribution getEntity() {

		return contribution;
	}

}
