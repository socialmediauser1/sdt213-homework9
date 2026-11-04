<%-- View for "/". It is mapped by the view controller, there is no Java controller for it --%>
<%-- session="false": this page needs no HTTP session, so no ;jsessionid is added to the links --%>
<%@ page contentType="text/html;charset=UTF-8" session="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
   <head>
      <title>Spring MVC Tutorial</title>
   </head>

   <body>
      <h1>Spring MVC Tutorial</h1>
      <%-- When a DispatcherServlet forwards to this JSP, the container saves the original servlet path:
           "" for the Java-config servlet (mapped to "/") and "/xml" for the XML-config servlet (mapped to "/xml/*") --%>
      <p>This page is served by the
         <b>${requestScope['jakarta.servlet.forward.servlet_path'] == '/xml' ? 'XML' : 'Java'}</b>
         configuration.</p>
      <ul>
         <%-- c:url adds the context path (/spring-mvc-basics) in front of the link --%>
         <li><a href="<c:url value='/sample'/>">Sample view (Java configuration)</a></li>
         <li><a href="<c:url value='/xml/'/>">Index page (XML configuration)</a></li>
         <li><a href="<c:url value='/xml/sample'/>">Sample view (XML configuration)</a></li>
      </ul>
   </body>
</html>
