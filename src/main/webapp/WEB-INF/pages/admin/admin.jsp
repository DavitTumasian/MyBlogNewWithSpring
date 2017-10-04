<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>admin</title>
</head>
<body>

<c:if test="${!empty categoryMessage}">
    <p><c:out value="${categoryMessage}"/></p>
    <%--<c:remove var="${categoryMessage}" scope="session"/>--%>
</c:if>
<form:form action="/admin/admin/addCategory" method="post" commandname="add_category" role="form">
    <p>add category</p>
    <p>name: <input name="name" type="text"></p>
    <p><input type="submit" value="add"></p>
</form:form>

<form:form method="post" action="/admin/admin/addPost" commandname="add_post" role="form">
<p>add post</p>
<p>title: <input type="text" name="title"></p>
<%--<p>image: <input type="file" name="image"></p>--%>
<p>category:  <c:if test="${!empty categoryEntityList}">
    <select name="category_id" >
    <c:forEach items="${categoryEntityList}" var="categoryEntity">
    <option value="${categoryEntity.id}">
            ${categoryEntity.name}
    </option>
    </c:forEach>
</select>
    </c:if>
</p>
<p>descrition: <input type="text" name="description"></p>
<p><input type="submit" value="add"></p>
</form:form>

<a href="/admin/admin/logout"><input type="button" value="Logout"></a>
</body>
</html>
