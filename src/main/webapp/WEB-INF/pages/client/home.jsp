<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>home</title>
    <link rel="stylesheet" href="/pages/css/CSS.css">
</head>
<body>


<div class="header_photo">
    <img src="image/summer.jpg" alt="image" name="headerPhoto" width="960" height="250">
</div>
<br><br>
<div class="post">
    <p>ALL POSTS</p>
    <c:if test="${!empty allPosts}">
        <c:forEach items="${allPosts}" var="post">
            <table border="1px">
                <tr>
                    <td>
                            ${post.title}
                    </td>
                </tr>
                <tr>
                    <td>
                            ${post.timeStamp}
                    </td>
                </tr>
                <%--<tr>--%>
                    <%--<td>--%>
                        <%--<img src="/getImage?image=${post.image}" width="200">--%>
                    <%--</td>--%>
                <%--</tr>--%>
                <tr>
                    <td>
                            ${post.description}
                    </td>
                </tr>
            </table>
            <br><br>
        </c:forEach>
    </c:if>
</div>
<br><br>
<div class="category">
    <p> ALL CATEGORIES</p>
    <c:if test="${allCategories != null}">
        <c:forEach items="${allCategories}" var="category">
          <p>${category.name}</p>
        </c:forEach>
    </c:if>
</div>
<br><br><br><br><br><br>
<div class="admin">


    <a href="/admin/admin">admin panel</a>


</div>

</body>
</html>
