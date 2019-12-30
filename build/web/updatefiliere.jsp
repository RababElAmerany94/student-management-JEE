<%-- 
    Document   : formulaire_filieres
    Created on : Dec 10, 2018, 10:56:10 AM
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
        <h1>update_filiere</h1>   
         <s:form action="saveOrUpdate">
            <s:textfield name="code" label="code" readonly="true" />
            <s:textfield name="nom" label="nom"/>
            <s:submit value="Update"/>
        </s:form>
    </body>
</html>
