<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"
         isELIgnored="false" isErrorPage="true"
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Arvo:ital,wght@0,400;0,700;1,700&display=swap" rel="stylesheet">
        <title>Home</title>
    </head>


    <title>Not-Found</title>

<style>
    body {
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
    }
    .im{
        background-image: url("https://pixelz.cc/wp-content/uploads/2018/07/404-not-found-graffiti-uhd-4k-wallpaper.jpg");
        background-size: cover;
        background-position: center;
        position: fixed;
        top: 0;
        left: 0;
        width: 100%;
        height: 100%;
        z-index: -1;
        overflow-y: auto;
    }
    .d{
        display: flex; justify-content: center; align-items: center;
        background-color: white;
        border-radius: 15px;
        padding: 5px;
    }

</style>

<body >



<div class="im"></div>
<%
    response.setHeader("Cache-Control","no-cache, no-store, must-revalidate");
    session.invalidate();
    response.setHeader("Pragma", "no-cache");
%>


<div class="d" >
        <form class="form-inline" action="/setCookie" method="post" >
            <table>
                <tr>
                    <td style=" display: flex; justify-content: center; align-items: center;" >
                        <h5>Ooops,It seems you got lost 🚧</h5>
                    </td>
                    <td style=" display: flex; justify-content: center; align-items: center;">
                        <h5>Don't worry, You have still chance to get home 🧐</h5>
                    </td>
                    <td style=" display: flex; justify-content: center; align-items: center;">
                        <input type="hidden" >
                     <input type="submit" style="padding-right:50px ;padding-left: 50px;color: white;background-color: cadetblue;border-radius: 5px" value="Get Home">

                    </td>

                </tr>
            </table>
        </form>
</div>

</body>
</html>