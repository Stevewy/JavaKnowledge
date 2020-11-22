<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<div style="text-align: center">
    <form action="${pageContext.request.contextPath}/login" method="post">
        选择:
        <input type="checkbox" name="type" value="一"> 一 <br>
        <input type="checkbox" name="type" value="二"> 二 <br>
        <input type="checkbox" name="type" value="三"> 三 <br>
        <input type="submit">
    </form>
</div>
</body>
</html>
