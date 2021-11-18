package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.BoardDao;
import dto.BoardDTO;

public class MemberListService implements MemberService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		List<BoardDTO> list = BoardDao.getInstance().selectBoardList();
		
		request.setAttribute("list", list);
		
		return new ModelAndView("views/list.jsp" , false);

	}

}
