package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import service.MemberService;

@WebServlet("*.do")

public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public MemberController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String requestURI = request.getRequestURI();						/*	/BATCH/student/list.do	*/
		String contextPath = request.getContextPath();						/*	/BATCH/					*/
		String command = requestURI.substring(contextPath.length() + 1);	/* student/list.do	*/
		
		ModelAndView mav = null;
		MemberService Service = null;
		switch (command) {
		case "Boardlist.do":
			mav = new ModelAndView("views/listBoard.jsp", false);
			break;
		}
		
		if (Service != null) {
			try {
				mav = Service.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if (mav != null) {
			if (mav.isRedirect()) {
				response.sendRedirect(mav.getView());
			} else {
				request.getRequestDispatcher(mav.getView()).forward(request, response);
			}
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
