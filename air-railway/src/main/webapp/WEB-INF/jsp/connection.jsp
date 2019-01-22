<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>night_sky</title>
    <link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css"/>
    <link href="./css/style.css" rel="stylesheet"/>
    <script src="./lib/jquery-3.3.1.min.js" charset="utf-8"></script>
</head>
<body>
    <div>
        <c:if test="${connections != null}">
            <p>${connections}</p>
        </c:if>
    </div>
    <div>
        <a href="/routes">Back</a>
    </div>
</body>
</html>