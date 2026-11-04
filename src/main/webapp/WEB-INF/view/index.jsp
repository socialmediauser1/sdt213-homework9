<%@ page contentType="text/html;charset=UTF-8" session="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
   <head>
      <title>Spring MVC Tutorial</title>
   </head>

   <body>
      <h1>Spring MVC Tutorial</h1>
      <p>This page is served by the
         <b>${requestScope['jakarta.servlet.forward.servlet_path'] == '/xml' ? 'XML' : 'Java'}</b>
         configuration.</p>
      <ul>
         <li><a href="<c:url value='/sample'/>">Sample view (Java configuration)</a></li>
         <li><a href="<c:url value='/xml/'/>">Index page (XML configuration)</a></li>
         <li><a href="<c:url value='/xml/sample'/>">Sample view (XML configuration)</a></li>
      </ul>
   </body>
</html>
