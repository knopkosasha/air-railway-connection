<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>

<head>
    <title>night_sky</title>
    <meta name="description" content="website description"/>
    <meta name="keywords" content="website keywords, website keywords"/>
    <meta http-equiv="content-type" content="text/html; charset=windows-1252"/>
    <link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css"/>
    <link href="./css/style.css" rel="stylesheet"/>
    <script src="./lib/jquery-3.3.1.min.js" charset="utf-8"></script>
</head>

<body>
<div id="main">
    <div id="header">
        <div id="logo">
            <div id="logo_text">
                <!-- class="logo_colour", allows you to change the colour of the text -->
                <h1><a href="routes.jsp">con<span class="logo_colour">nect</span></a></h1>
                <h2>Making you closer</h2>
            </div>
        </div>
    </div>
    <div id="site_content">

        <div id="content">

            <h1>Welcome to Connect</h1>
            <form method="post" action="/connection" id="search_form">
                <label>
                    <select name="firstRouteId">
                        <c:forEach var="map" items="${routes}">
                            <option value="${map.key}">${map.value}</option>
                        </c:forEach>
                    </select>
                </label>
                <p>
                    <input id="destination" class="search" type="text" name="destination" value="city"/>
                    <a href="javascript:document.search_form.submit()">
                        <input name="search" type="image" style="border: 0; margin: 0 0 -9px 5px;"
                               src="./img/search.png" alt="Search" title="Search"/>
                    </a>
                </p>
            </form>
        </div>
    </div>
    <div id="footer">
        <p>Copyright &copy; night_sky | <a href="http://validator.w3.org/check?uri=referer">HTML5</a> | <a
                href="http://jigsaw.w3.org/css-validator/check/referer">CSS</a> | <a
                href="http://www.html5webtemplates.co.uk">design from HTML5webtemplates.co.uk</a></p>
    </div>
</div>


</body>
</html>
