<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/mytag.tld"  %>
<html>
    <head>
        <title>
            Metro Lines
        </title>
    </head>
 
    <body>
        <h1>
<lines='<%= request.getParameter("lines") %>' />
        </h1>
    </body>
</html>