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
    background-image: url("https://wallpapers.com/images/hd/3840-x-2160-nature-mv4djiexi3jzga5h.jpg");
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

.container{
    background-color: white;
    border-radius: 10px;
    padding-top: 10px;
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

<div style="padding-top: 100px"></div>

<div class="container">
    <table>

        <tr>
            <td>
                <h5>Book title</h5>
            </td>
        </tr>
        <tr>
            <td>
                <p th:text="${books.title}"></p>
            </td>
        </tr>



        <div th:if="${books.getCategories() != null and books.getCategories() != ''}">
        <tr>
            <td>
                <h5>Book category</h5>
            </td>
        </tr>
        <tr>
            <td>
                <p th:text="${books.getCategories()}"></p>
            </td>
        </tr>
            </div>



        <div th:if="${(books.longDescription != null and books.longDescription != '')&&(
                       books.shortDescription != null and books.shortDescription != '')}">
        <tr>
            <td>
                <h5>Book description</h5>

            </td>
        </tr>
        <tr>
            <td>
                <p th:text="${books.shortDescription}"></p>
                <p th:text="${books.longDescription}"></p>
            </td>
        </tr>
        </div>



        <tr>
            <td>
                <h5>Book authors</h5>

            </td>
        </tr>
        <tr>
            <td>
                <p th:text="${books.authors}"></p>
            </td>
        </tr>



        <div th:if="${books.pageCount != null and books.pageCount != '0'}">
        <tr>
            <td>
                <h5>Pages</h5>
            </td>
        </tr>
        <tr>
            <td>
                <p th:text="${books.pageCount}"></p>
            </td>
        </tr>
       </div>



        <div th:if="${books.publishedDate != null and books.publishedDate != ''}">
        <tr>
            <td>
                <h5>Published date</h5>

            </td>
        </tr>
        <tr>
            <td>
                <p th:text="${books.publishedDate}"></p>
            </td>
        </tr>
        </div>
        <tr>
            <td>
                <h5>ISBN</h5>

            </td>
        </tr>
        <tr>
            <td>
                <p th:text="${books.isbn}"></p>
            </td>
            <td>
                <form action="/buy"  method="post" th:object="${books}">

                    <input type="hidden" th:field="${books.title}" />
                    <input type="hidden" th:field="${books.isbn}" />
                    <input type="hidden"  th:field="${books.thumbnailUrl}" />
                    <input type="hidden"  th:field="${books.shortDescription}" />

                    <input type="submit" name="books" style="background-color: lightgreen;color: white"  value="Buy Now">                </form>
            </td>
        </tr>


    </table>
</div>
<br>

</body>
</html>
