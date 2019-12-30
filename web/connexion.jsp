<%-- 
    Document   : index
    Created on : Dec 8, 2018, 6:05:26 PM
    Author     : Rabab
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Form</title>      
        <link rel="stylesheet" href="style.css">
     <style type="text/css">
     .colbox {
          margin-left: 0px;
          margin-right: 0px;
     }</style>
    </head>
    <header>
        <jsp:include page="include/header.html"/>        
    </header> 
    <body> 
        <fieldset>
            <legend>Login</legend>
            <s:form action="connectUser" >
                <s:textfield name="login" label="LOGIN" />
                <s:password name="password" label="Password"/>
                <s:submit value="Login"/>
            </s:form>
           
        </fieldset>
    </body>
    <footer>
        <jsp:include page="include/footer.html"/>
    </footer>
</html>
