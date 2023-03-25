package mc.acisozluk.servlet;

import java.io.IOException;

import mc.acisozluk.model.Baslik;
import mc.acisozluk.model.User;
import mc.acisozluk.repository.BaslikRepository;
import mc.acisozluk.repository.UserRepository;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

/**
 * Servlet implementation class EntryServlet
 */
@WebServlet(urlPatterns = "/newbaslik")
public class BaslikServlet extends HttpServlet {

	BaslikRepository baslikRepo = new BaslikRepository();
	UserRepository userRepo = new UserRepository();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/baslik.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String baslik = request.getParameter("baslik");
		
		if (baslik == null || baslik.isBlank()) {
			request.setAttribute("hataMesaji", "Başlık alanı boş bırakılamaz");
			request.getRequestDispatcher("/WEB-INF/view/baslik.jsp").forward(request, response);
			return;
		} 
		
		User author = userRepo
				.findByUsername(
						(String) request
						.getSession(false)
						.getAttribute("loggedInUser"));
		
		Baslik b = new Baslik();
		b.setAuthor(author);
		b.setIsim(baslik);
		
		baslikRepo.save(b);
		
		response.sendRedirect("/acisozluk/home");
	}

}
