<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Acı Sözlük - Kaydol</title>
<link rel="stylesheet" href="stil/style.css">

</head>
<body>
	<header class="nav">
		<div>Acı Sözlük</div>
		<div>
			<form class="search-f" action="/acisozluk/search">
				<input class="search-i" type="text" name="q" placeholder="Acı Sözlükte Ara...">	
				<button type="submit" class="search-b">
					<svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="#000000" class="w-6 h-6">
  						<path stroke-linecap="round" stroke-linejoin="round" d="M21 21l-5.197-5.197m0 0A7.5 7.5 0 105.196 5.196a7.5 7.5 0 0010.607 10.607z" />
					</svg>
				</button>	
			</form>
		</div>
		<div>
			<a href="/acisozluk/login">Giriş</a>
			<a href="/acisozluk/register">Kaydol</a>
		</div>
	</header>
	<main class="">
	
		<% String hataMsj = (String)request.getAttribute("hataMesaji"); %>
	
		<%
			if(hataMsj != null) {%>
			
				<p class="err-msg"> <%= hataMsj %> </p>
			
			<%}

		%>
		<form action="/acisozluk/register" method="post" class="reg-form">
			<label for="username">Kullanıcı Adı: </label>
			<input id="username" type="text" name="username" placeholder="Kullanıcı Adı Seçin...">
			<label for="password">Şifre: </label>
			<input id="password" type="password" name="password" placeholder="Şifre Seçin...">
			<input type="submit" value="Kaydol">
		</form>
	</main>
</body>
</html>