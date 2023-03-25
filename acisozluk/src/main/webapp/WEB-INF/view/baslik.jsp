<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Acı Sözlük - Yeni Başlık</title>
<link rel="stylesheet" href="stil/style.css">
</head>
<body>
	<% String hataMsj = (String)request.getAttribute("hataMesaji"); %>
	
		<%
			if(hataMsj != null) {%>
			
				<p class="err-msg"> <%= hataMsj %> </p>
			
			<%}

		%>
		<form action="/acisozluk/newbaslik" method="post" class="reg-form">
			<label for="baslik">Başlık: </label>
			<textarea id="baslik" name="baslik" placeholder="Yeni Bir Başlık Açın.."></textarea>
			<input type="submit" value="Oluştur">
		</form>
</body>
</html>