<%-- 
    Document   : filiere
    Created on : Dec 10, 2018, 12:04:39 PM
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
        <h1> Liste des etudiants</h1>           
            <table border="1">
                    <tr>
                        <th>Code Eleve</th>
                        <th>Nom eleve</th>
                        <th>Prenom</th>
                        <th>Tele</th>
                        <th>Email</th>
                        <th>Date de naissance</th>
                        <th>Lieu de Naissance</th>
                        <th>filieres</th>
                    </tr>
                <s:iterator value="EtudiantList">                   
                    <tr>
                        <td><s:property value="idEleve"/></td>
                        <td><s:property value="nom"/></td>
                        <td><s:property value="prenom"/></td>
                        <td><s:property value="tel"/></td>
                        <td><s:property value="email"/></td>
                        <td><s:property value="dateNaissance"/></td>
                        <td><s:property value="lieuNaissance"/></td>
                        <s:iterator value="filieres">
                            <td><s:property value="code"/></td>
                        </s:iterator>
                        <td>
                            <s:url id="editURL" action="updateEtudiant">
                                <s:param name="idEleve" value="%{idEleve}"></s:param>
                                <s:param name="code" value="%{filieres.code}"></s:param>
                            </s:url>
                            <s:a href="%{editURL}">Update</s:a>
                        </td>
                        <td>
                            <s:url id="deleteURL" action="deleteEtudiant">
                                <s:param name="idEleve" value="%{idEleve}"></s:param>                                
                                <s:param name="code" value="%{filieres.code}"></s:param>
                            </s:url>
                            <s:a href="%{deleteURL}">Supprimer</s:a>
                        </td>
                    </tr>
                </s:iterator>
            </table>
            <s:form action="saveOrUpdateEtudiant">
                <s:textfield name="idEleve" label="Code Eleve"/>
                <s:textfield name="code" label="filiere" value="%{filieres.code}" type="readonly"/>
                <s:textfield name="nom" label="Nom eleve"/>
                <s:textfield name="prenom" label="Prenom"/>
                <s:textfield name="tel" label="Tele"/>
                <s:textfield name="email" label="Email"/>
                <s:textfield name="dateNaissance" label="Date de naissance"/>
                <s:textfield name="lieuNaissance" label="Lieu de Naissance"/>                
                <s:submit value="ADD"/>
            </s:form>
    </body>
</html>
