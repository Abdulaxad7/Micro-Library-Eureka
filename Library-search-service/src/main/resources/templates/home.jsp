<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org" xmlns:ctx="http://www.w3.org/1999/xhtml">
<head>
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
<style>
    .d{
        display: flex; justify-content: center; align-items: center;
        background-color: white;
    }
    .background{
        background-image: url("https://i.redd.it/4vztk5m7p9651.jpg");
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
</style>


<body>
<div class="background"></div>
<div class="d">
<nav class="navbar navbar-light bg-light text-center d-flex align-items-center justify-content-center">
    <form class="form-inline" action="/text" method="post" >
        <table>

        <tr>
        <td style="display: flex; justify-content: center; align-items: center;"></td>
            <td style=" display: flex; justify-content: center; align-items: center;">
        <input class="form-control mr-sm-2" type="search" placeholder="Search" name="text" style="padding-right: 300px" aria-label="Search">
        </td>
            <td>
        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
            </td>
        </tr>
        </table>
    </form>
</nav>
</div>


<div style="padding-top: 50px"></div>
<div class="text-center d-flex align-items-center justify-content-center" >
        <table>
            <tbody>
        <tr th:each="book : ${books}" >
                <td></td>
                <td>
                <div class="card mb-3" style="max-width: 540px;display: flex;  align-items: center;justify-content: space-between">
                    <table>
                        <tbody>
                        <tr>
                            <td>
                                <div class="row g-0">
                                    <div class="col-md-8">
                                        <div class="card-body">
                                           <h4>Book name</h4> <h6 th:text="${book.title}"></h6>
                                            <br>
                                          <h4>Book authors</h4> <h6 th:text="${book.getAuthors()}"></h6>
                                            <br>
                                            <br>
                                            <br>
                                            <div th:if="${book.getPublishedDate() != null and book.getPublishedDate() != ''}">
                                                <h5>Published</h5>
                                                <p th:text="${book.getPublishedDate()}"></p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </td>
                    <td>
                               <div class="col-md-4" >
                                    <p style="justify-content: space-between">
                                    <img th:src="${book.thumbnailUrl}" width="200" height="200">
                               </div>
                    </td>
                </tr>
            </tbody>
            </table>
                    <form action="/bookInfo" method="post">
                        <input type="hidden" name="isbn" th:value="${book.getIsbn()}">
                        <button style="height: 40px;width: 540px;background-color: cadetblue;" type="submit" class="btn"><p style="color: white">Book Info</p></button>
                    </form>
                </div>
                </td>
    </tr>
    </tbody>
</table>
</div>
</body>
</html>
