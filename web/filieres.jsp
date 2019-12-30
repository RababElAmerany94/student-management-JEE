<%-- 
    Document   : filieres
    Created on : Dec 10, 2018, 12:04:48 PM
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
        <h1> Liste des filières(admin)</h1>
           <s:form action="saveOrUpdate">
            <s:textfield name="code" label="code"/>
            <s:textfield name="nom" label="nom"/>
            <s:submit value="ADD"/>
        </s:form>
        <s:if test="%{FilieresList.size()>0}">
            <table border="1">
                    <tr>
                        <th>Code</th>
                        <th>Nom du filière</th>
                        <th>Modifier</th>
                        <th>Supprimer</th>                            
                    </tr>
                <s:iterator value="FilieresList">
                    <tr>
                        <td><s:property value="code"/></td>
                        <td>
                            <s:url id="nomf" action="listetudiant">
                                <s:param name="nomf" value="%{nom}"></s:param>
                                <s:param name="code" value="%{code}"></s:param>
                            </s:url>
                            <s:a href="%{nomf}"><s:property value="nom"/></s:a>
                        </td>
                        <td>
                            <s:url id="editURL" action="updatefiliere">
                                <s:param name="code" value="%{code}"></s:param>
                            </s:url>
                            <s:a href="%{editURL}">Update</s:a>
                        </td>
                        <td>
                            <s:url id="deleteURL" action="deletefiliere">
                                <s:param name="code" value="%{code}"></s:param>
                            </s:url>
                            <s:a href="%{deleteURL}">Supprimer</s:a>
                        </td>
                    </tr>
                </s:iterator>
            </table>
            </s:if>
    </body>
</html>
