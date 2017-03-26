package com.cdsxt.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cdsxt.dao.BaseDao;
import com.cdsxt.service.UsersService;
import com.cdsxt.service.impl.UsersServiceImpl;

public class UsersAction extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5244696640177624780L;

	private UsersService usersService = new UsersServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		String mark = req.getParameter("mark");
		if ("add".equals(mark)) {
			this.add(req, resp);

		} else if (mark == null) {
			this.findAll(req, resp);
		} else if ("del".equals(mark)) {
			this.delete(req, resp);
		} else if ("update".equals(mark)) {
			this.update(req, resp);
		}

	}

	private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String id = req.getParameter("id");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		String age = req.getParameter("age");
		String sql = "update users set id=?,username=?,password=?,email=?,age=? where id=?";
		BaseDao.change(sql, new Object[] { id });
		req.setAttribute("users", this.usersService.findAll());
		req.getRequestDispatcher("/views/users/index.jsp").forward(req, resp);
	}

	private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String sql = "delete from users where id=?";
		BaseDao.change(sql, new Object[] { id });
		req.setAttribute("users", this.usersService.findAll());
		req.getRequestDispatcher("/views/users/index.jsp").forward(req, resp);
	}

	protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		String age = req.getParameter("age");
		String sql = "insert into users values(?,?,?,?,?)";
		BaseDao.change(sql, new Object[] { id, username, password, email, age });
		req.setAttribute("users", this.usersService.findAll());
		req.getRequestDispatcher("/views/users/index.jsp").forward(req, resp);
	}

	protected void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("users", this.usersService.findAll());
		req.getRequestDispatcher("/views/users/index.jsp").forward(req, resp);
		return;
	}

}
