<%-- 
    Document   : test
    Created on : 2016-8-20, 22:54:56
    Author     : stephen
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        Place Name: ${place.name}
        <hr>
        Place Lat: ${place.lat}
        <hr>
        Place Lon: ${place.lon}
        <hr>
        Place Users: ${place.users}
        <hr>
        Place Comments: ${place.comments}
    </body>
</html>
