<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List,mc.acisozluk.model.Baslik"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Acı Sözlük - Anasayfa</title>
<link rel="stylesheet" href="stil/style.css">

</head>
<body>
	<% session = request.getSession(false); %>
	<header class="nav">
		<div> <span>AcıSözlük</span> 

			<%  
			if(session != null && session.getAttribute("loggedInUser") != null){
			%> <a href="/acisozluk/newbaslik">Yeni Başlık</a> <% } %></div>
		<div>
			<form class="search-f" action="/acisozluk/search">
				<input class="search-i" type="text" name="q" placeholder="Acı Sözlük Ara...">	
				<button type="submit" class="search-b">
					<svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="#000000" class="w-6 h-6">
  						<path stroke-linecap="round" stroke-linejoin="round" d="M21 21l-5.197-5.197m0 0A7.5 7.5 0 105.196 5.196a7.5 7.5 0 0010.607 10.607z" />
					</svg>
				</button>	
			</form>
		</div>
		<%  
			if(session == null || session.getAttribute("loggedInUser") == null){
		%>
			<div>
				<a href="/acisozluk/login">Giriş</a>
				<a href="/acisozluk/register">Kaydol</a>
			</div>
		<% } else { %> 
			<div>
				<a href="#"> <%= session.getAttribute("loggedInUser") %> </a>
				<a href="/acisozluk/logout">Çıkış</a>
			</div>
		 <%}%>
	</header>
	<% List<Baslik> basliklar = (List<Baslik>) request.getAttribute("basliklar"); %>
	<main class="main-content ">
		<div class="basliklar ">
			<% for(Baslik b : basliklar){ %>
				<a href="/acisozluk/basliklar/<%= b.getId() %>"> <%= b.getIsim() +" "+ b.getEntries().size() %> </a> <br>
			 <% } %>
		</div>
		<div class="entryler ">sağ</div>
	</main>
</body>
</html>