package mc.acisozluk.servlet;

import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import mc.acisozluk.repository.UserRepository;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

	UserRepository userRepo = new UserRepository();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if (username == null || username.isBlank()) {
			request.setAttribute("hataMesaji", "Kullanıcı Adı Boş Bırakılamaz");
			request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
			return;
		} 
		if (password == null || password.isBlank()) {
			request.setAttribute("hataMesaji", "Şifre Boş Bırakılamaz");
			request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
			return;
		} 
		if(!userRepo.checkUser(username)) {
			request.setAttribute("hataMesaji", "Bu kullanıcı adında bir kayıt yok! '"+username+"'");
			request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
			return;
		}
		if(!userRepo.checkPassword(username, password)) {
			request.setAttribute("hataMesaji", "Hatalı şifre!");
			request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
			return;
		}
		
		HttpSession session = request.getSession(true);
		session.setAttribute("loggedInUser", username);
		response.sendRedirect("/acisozluk/home");
	}

}
