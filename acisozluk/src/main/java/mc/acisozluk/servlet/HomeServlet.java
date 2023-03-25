package mc.acisozluk.servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import mc.acisozluk.model.Baslik;
import mc.acisozluk.repository.BaslikRepository;
import mc.acisozluk.connection.SesFactory;

@WebServlet(urlPatterns = {"/home"}, loadOnStartup = 1)
public class HomeServlet extends HttpServlet {
	
	BaslikRepository baslikRepo = new BaslikRepository();
	
	@Override
	public void init() {
		// hibernate i ayağa kaldır
		System.out.println("----------HIBERNATE--------");
		SesFactory.getInstance();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Baslik> basliklar = baslikRepo.findAll();
		
		request.setAttribute("basliklar", basliklar);
		
		HttpSession session = request.getSession(false);
		if(session != null) {
			String loggedUsername = (String) session.getAttribute("loggedInUser");
			System.out.println("Giriş yapmış kullanıcı: " + loggedUsername);
		}else {
			System.out.println("Açılmış bir oturum yok");
		}
		
		request
			.getRequestDispatcher("/WEB-INF/view/index.jsp")
			.forward(request, response);
	}

}
