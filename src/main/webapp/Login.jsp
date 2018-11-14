<%-- 
    Document   : Vue
    Created on : 14 nov. 2018, 13:24:02
    Author     : pedago
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Bienvenue dans le jeu</h1>
        <hr>
        <h2>${joueurs} joueur(s) connecté(s)</h2>
        <form method="POST">
		
        <label>
            Ton prénom :
            <input name="playerName">
        </label>
            <input name="action" value="Connexion" type="SUBMIT">
        </form>
            </hr>
    </body>
</html>
