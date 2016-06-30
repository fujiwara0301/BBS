package bbs.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bbs.entity.Contribution;

public class BbsServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("/bbs/bbs/main.jsp");
		
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/plain; charset=UTF-8");
		
		String actionSwitch = request.getParameter("actionSwitch");
		IController controller = null;
		
		/* 投稿処理実行時 */
		if (actionSwitch.equals("register")) {
			controller = new RegisterController();
		
		/* パスワード照合処理実行時 */
		} else if (actionSwitch.equals("check")) {
			controller = new CheckController();
		
		/* 削除処理実行時 */
		} else if (actionSwitch.equals("remove")) {
			controller = new RemoveController();
		
		/* 編集処理実行時 */
		} else if (actionSwitch.equals("edit")) {
			controller = new EditController();
			
		/* 一覧画面表示時 */
		} else if (actionSwitch.equals("main")) {
			controller = new MainController();
		}
		Map<String, String[]> paramMap = request.getParameterMap();
		
		if (paramMap != null) {
			controller.setForm(paramMap);
		}
		
		String sendURL = "";
		RequestDispatcher dispatcher = null;
		if (controller.shouldValidate()) {
			 sendURL = controller.doCheck();
			 
			 if (!sendURL.isEmpty()) {
				 ArrayList<String> errorList = controller.getErrorList();
				 request.setAttribute("errorList", errorList);
				 dispatcher = request.getRequestDispatcher(sendURL);
				 dispatcher.forward(request, response);
				 return;
			 }
		}
		
		sendURL = controller.doAction();
		Contribution targetData = controller.getEntity();
		if (targetData != null) {
			request.setAttribute("targetData", targetData);
		}
		dispatcher = request.getRequestDispatcher(sendURL);
		dispatcher.forward(request, response);
	}
}
