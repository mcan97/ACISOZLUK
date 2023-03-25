package mc.acisozluk.servlet;

import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import mc.acisozluk.model.User;
import mc.acisozluk.repository.UserRepository;

@WebServlet(urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {

	private UserRepository userRepository = new UserRepository();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// form html i dön
		request.getRequestDispatcher("/WEB-INF/view/register.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if (username == null || username.isBlank()) {
			request.setAttribute("hataMesaji", "Kullanıcı Adı Boş Bırakılamaz");
			request.getRequestDispatcher("/WEB-INF/view/register.jsp").forward(request, response);
			return;
		} 
		if (password == null || password.isBlank()) {
			request.setAttribute("hataMesaji", "Şifre Boş Bırakılamaz");
			request.getRequestDispatcher("/WEB-INF/view/register.jsp").forward(request, response);
			return;
		} 
		if (!userRepository.isUnique(username)) {
			request.setAttribute("hataMesaji", "Bu kullanıcı adı ("+username+") alınmış");
			request.getRequestDispatcher("/WEB-INF/view/register.jsp").forward(request, response);
			return;
		} 

		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		userRepository.save(user);

		HttpSession session = request.getSession(true);
		
		session.setAttribute("loggedInUser", username);
		
		response.sendRedirect("/acisozluk/home");
		

	}

}
