<%-- 
    Document   : formulaire_etudiant
    Created on : Dec 10, 2018, 12:04:03 PM
    Author     : Rabab
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style.css">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>update_etudiant</h1>
        <s:form action="saveOrUpdateEtudiant">
                <s:textfield name="idEleve" label="Code Eleve" readonly="true" />
                <s:textfield name="nom" label="Nom eleve"/>
                <s:textfield name="prenom" label="Prenom"/>
                <s:textfield name="tel" label="Tele"/>
                <s:textfield name="email" label="Email"/>
                <s:textfield name="dateNaissance" label="Date de naissance"/>
                <s:textfield name="lieuNaissance" label="Lieu de Naissance"/>
                <s:textfield name="code" label="filiere" />
            <s:submit value="update"/>
            </s:form>
    </body>
</html>
