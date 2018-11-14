<%-- 
    Document   : Jeu
    Created on : 14 nov. 2018, 13:44:16
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
        <hr>
        <h1>Hello ${customer}, Devine mon nombre</h1>
        <p>Essai n°${essai}</p>
        <p>${tentative}</p>
        <form method="POST">
            <p>Devine un nombre entre ${mini} et ${maxi}</p>
            <p>Trop ${hauteur}</p>
        <label>
            Ta proposition :
            <input name="nombre" type="number">
        </label>
            <input name="deviner" value="Deviner" type="SUBMIT">
        </form>
            </hr>
    </body>
</html>
