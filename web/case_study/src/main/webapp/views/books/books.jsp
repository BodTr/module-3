<%--
  Created by IntelliJ IDEA.
  User: trung
  Date: 10/5/2024
  Time: 2:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Books Main</title>
    <link rel="stylesheet" href="../../static/tabler/css/tabler.min.css"/>
    <link rel="stylesheet" href="../../static/tabler/css/tabler-flags.min.css"/>
    <link rel="stylesheet" href="../../static/tabler/css/tabler-payments.min.css"/>
    <link rel="stylesheet" href="../../static/tabler/css/tabler-vendors.min.css"/>
    <link rel="stylesheet" href="../../static/tabler/css/demo.min.css"/>

</head>
<body>
<%@ include file="../layouts/navbar.jsp" %>
<div class="page-wrapper">
    <div class="page-header d-print-none">
        <div class="container-xl">
            <div class="row g-2 align-items-center">
                <div class="col">
                    <h2 class="page-title">
                        TR Book store
                    </h2>
                </div>
                <div class="col-auto ms-auto d-print-none">
                    <button class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#modalCreateBook">
                        <svg xmlns="http://www.w3.org/2000/svg" class="icon" width="24" height="24" viewBox="0 0 24 24"
                             stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round"
                             stroke-linejoin="round">
                            <path stroke="none" d="M0 0h24v24H0z" fill="none"></path>
                            <path d="M12 5l0 14"></path>
                            <path d="M5 12l14 0"></path>

                        </svg>
                        Thêm sách
                    </button>
                </div>
            </div>
        </div>
    </div>
    <div class="page-body">
        <div class="container-xl">
            <div class="row row-cards">
                <div class="col-12">
                    <div class="card">
                        <div class="card-header">
                            <h3 class="card-title">Sách</h3>
                        </div>
                        <div class="card-body border-bottom py-3">
<%--                            <div class="d-flex">--%>
<%--                                <div class="text-muted">--%>
<%--                                    Show--%>
<%--                                    <div class="mx-2 d-inline-block">--%>
<%--                                        <input type="text" class="form-control form-control-sm" value="8" size="3"--%>
<%--                                               aria-label="Invoices count">--%>
<%--                                    </div>--%>
<%--                                    entries--%>
<%--                                </div>--%>
<%--                                <div class="ms-auto text-muted">--%>
<%--                                    Search:--%>
<%--                                    <div class="ms-2 d-inline-block">--%>
<%--                                        <input type="text" class="form-control form-control-sm"--%>
<%--                                               aria-label="Search invoice">--%>
<%--                                    </div>--%>
<%--                                </div>--%>
<%--                            </div>--%>
                        </div>
                        <div class="table-responsive">
                            <table class="table card-table table-vcenter text-nowrap datatable">
                                <thead>
                                <tr>
                                    <th class="w-1">ID</th>
                                    <th>Title</th>
                                    <th>Author</th>
                                    <th style="display: none;">AuthorId</th>
                                    <th>Publisher</th>
                                    <th>ISBN</th>
                                    <th>Genre</th>
                                    <th>Pages</th>
                                    <th>Price</th>
                                    <th></th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${books}" var="book">
                                    <tr>
                                        <td><c:out value="${book.id}"/></td>
                                        <td><c:out value="${book.title}"/></td>
                                        <td><c:out value="${book.author}"/></td>
                                        <td style="display: none"><c:out value="${book.authorId}" /></td>
                                        <td><c:out value="${book.publisher}"/></td>
                                        <td><c:out value="${book.isbn}"/></td>
                                        <td><c:out value="${book.genre}"/></td>
                                        <td><c:out value="${book.pages_count}"/></td>
                                        <td><c:out value="${book.price}"/></td>
                                        <td class="text-end">
                                            <span class="d-sm-inline">
                                              <a
                                                      class="btn btn-danger btn-icon"
                                                      data-toggle="tooltip"
                                                      data-placement="bottom"
                                                      title="Xóa sách"
                                                      onclick="return confirm('Are you sure?')"
                                                      href="${pageContext.request.contextPath}/admin/books/delete?id=<c:out value="${book.id}"/> "
                                              >
                                                <svg
                                                        xmlns="http://www.w3.org/2000/svg"
                                                        class="icon icon-tabler icon-tabler-trash"
                                                        width="24"
                                                        height="24"
                                                        viewBox="0 0 24 24"
                                                        stroke-width="2"
                                                        stroke="currentColor"
                                                        fill="none"
                                                        stroke-linecap="round"
                                                        stroke-linejoin="round"
                                                >
                                                  <path stroke="none" d="M0 0h24v24H0z" fill="none"/>
                                                  <path d="M4 7l16 0"/>
                                                  <path d="M10 11l0 6"/>
                                                  <path d="M14 11l0 6"/>
                                                  <path
                                                          d="M5 7l1 12a2 2 0 0 0 2 2h8a2 2 0 0 0 2 -2l1 -12"
                                                  />
                                                  <path d="M9 7v-3a1 1 0 0 1 1 -1h4a1 1 0 0 1 1 1v3"/>
                                                </svg>
                                              </a>
                                            </span>
                                            <a
                                                    href="#"
                                                    class="btn btn-info btn-icon"
                                                    data-toggle="tooltip"
                                                    data-placement="bottom"
                                                    title="Sửa sách"
                                                    data-bs-toggle="modal"
                                                    data-bs-target="#modalEditBook"
                                                    onClick="editBook(this)"
                                            >
                                                <svg
                                                        xmlns="http://www.w3.org/2000/svg"
                                                        class="icon icon-tabler icon-tabler-edit"
                                                        width="24"
                                                        height="24"
                                                        viewBox="0 0 24 24"
                                                        stroke-width="2"
                                                        stroke="currentColor"
                                                        fill="none"
                                                        stroke-linecap="round"
                                                        stroke-linejoin="round"
                                                >
                                                    <path stroke="none" d="M0 0h24v24H0z" fill="none"/>
                                                    <path
                                                            d="M7 7h-1a2 2 0 0 0 -2 2v9a2 2 0 0 0 2 2h9a2 2 0 0 0 2 -2v-1"
                                                    />
                                                    <path
                                                            d="M20.385 6.585a2.1 2.1 0 0 0 -2.97 -2.97l-8.415 8.385v3h3l8.385 -8.415z"
                                                    />
                                                    <path d="M16 5l3 3"/>
                                                </svg>
                                            </a>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        <div class="card-footer d-flex align-items-center">
<%--                            <p class="m-0 text-muted">Showing <span>1</span> to <span>8</span> of <span>16</span>--%>
<%--                                entries</p>--%>
                            <ul class="pagination m-0 ms-auto">
                                <c:forEach var="i" begin="1" end="${totalPages}">
                                    <c:if test="${currentPage == i}">
                                        <li class="page-item active">
                                            <a class="page-link" href="/admin/books?page=<c:out value="${i}" />"><c:out
                                                    value="${i}"/></a>
                                        </li>
                                    </c:if>
                                    <c:if test="${currentPage != i}">
                                        <li class="page-item">
                                            <a class="page-link" href="/admin/books?page=<c:out value="${i}" />"><c:out
                                                    value="${i}"/></a>
                                        </li>

                                    </c:if>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="modal modal-blur fade" id="modalCreateBook"  tabindex="-1" style="display: none;" aria-hidden="true">
    <div class="modal-dialog modal-lg modal-dialog-centered" role="document">
        <form class="modal-content" method="post" action="${pageContext.request.contextPath}/admin/books/create">
            <div class="modal-header">
                <h5 class="modal-title">Thêm mới sách</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body row row-cards">
                <div class="col-md-6">
                    <div class="mb-3">
                        <label for="bookTitle" class="form-label">Tên sách</label>
                        <input
                                id="bookTitle"
                                type="text"
                                class="form-control"
                                placeholder="Nhập tên sách"
                                name="title"
                        />
                    </div>

                    <div class="mb-3">
                        <label for="authorId" class="form-label required">Chọn tác giả</label>
                        <select class="form-select" id="authorId" name="authorId">
                            <option value="" selected disabled>Danh sách tác giả</option>
                            <c:forEach items="${authors}" var="author">
                                <option value="<c:out value="${author.id}" />"><c:out value="${author.name}" /></option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="mb-3">
                        <label for="publisher" class="form-label">Nhà xuất bản</label>
                        <input
                                id="publisher"
                                type="text"
                                class="form-control"
                                placeholder="Nhập tên nhà xuất bản"
                                name="publisher"
                        />
                    </div>
                    <div class="mb-3">
                        <label for="isbn" class="form-label">Mã ISBN</label>
                        <input
                                id="isbn"
                                type="text"
                                class="form-control"
                                placeholder="Nhập mã isbn"
                                name="isbn"
                        />
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="mb-3">
                        <label for="genre" class="form-label">Thể loại</label>
                        <input
                                id="genre"
                                type="text"
                                class="form-control"
                                placeholder="Nhập thể loại sách"
                                name="genre"
                        />
                    </div>
                    <div class="mb-3">
                        <label for="pages_count" class="form-label">Số trang</label>
                        <input
                                id="pages_count"
                                type="number"
                                class="form-control"
                                placeholder="Nhập số trang"
                                name="pages_count"
                        />
                    </div>
                    <div class="mb-3">
                        <label for="price" class="form-label">Giá</label>
                        <input
                                id="price"
                                type="number"
                                class="form-control"
                                placeholder="Nhập giá"
                                name="price"
                        />
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <a href="#" class="btn btn-link link-secondary" data-bs-dismiss="modal">
                    Cancel
                </a>
                <input class="btn btn-primary ms-auto" type="submit" value="Create" />
            </div>
        </form>
    </div>
</div>
<div class="modal modal-blur fade" id="modalEditBook"  tabindex="-1" style="display: none;" aria-hidden="true">
    <div class="modal-dialog modal-lg modal-dialog-centered" role="document">
        <form class="modal-content" method="post" action="${pageContext.request.contextPath}/admin/books/update">
            <div class="modal-header">
                <h5 class="modal-title">Edit Book Infor</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body row row-cards">
                <div class="mb-3" style="display: none">
                    <input type="text" id="editbookId" name="id" />
                </div>
                <div class="col-md-6">
                    <div class="mb-3">
                        <label for="editbookTitle" class="form-label">Tên sách</label>
                        <input
                                id="editbookTitle"
                                type="text"
                                class="form-control"
                                placeholder="Nhập tên sách"
                                name="title"
                        />
                    </div>

                    <div class="mb-3">
                        <label for="editauthorId" class="form-label required">Chọn tác giả</label>
                        <select class="form-select" id="editauthorId" name="authorId">
                            <option value="" selected disabled>Danh sách tác giả</option>
                            <c:forEach items="${authors}" var="author">
                                <option value="<c:out value="${author.id}" />"><c:out value="${author.name}" /></option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="mb-3">
                        <label for="editpublisher" class="form-label">Nhà xuất bản</label>
                        <input
                                id="editpublisher"
                                type="text"
                                class="form-control"
                                placeholder="Nhập tên nhà xuất bản"
                                name="publisher"
                        />
                    </div>
                    <div class="mb-3">
                        <label for="editisbn" class="form-label">Mã ISBN</label>
                        <input
                                id="editisbn"
                                type="text"
                                class="form-control"
                                placeholder="Nhập mã isbn"
                                name="isbn"
                        />
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="mb-3">
                        <label for="editgenre" class="form-label">Thể loại</label>
                        <input
                                id="editgenre"
                                type="text"
                                class="form-control"
                                placeholder="Nhập thể loại sách"
                                name="genre"
                        />
                    </div>
                    <div class="mb-3">
                        <label for="editpages_count" class="form-label">Số trang</label>
                        <input
                                id="editpages_count"
                                type="number"
                                class="form-control"
                                placeholder="Nhập số trang"
                                name="pages_count"
                        />
                    </div>
                    <div class="mb-3">
                        <label for="editprice" class="form-label">Giá</label>
                        <input
                                id="editprice"
                                type="number"
                                class="form-control"
                                placeholder="Nhập giá"
                                name="price"
                        />
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <a href="#" class="btn btn-link link-secondary" data-bs-dismiss="modal">
                    Cancel
                </a>
                <input class="btn btn-primary ms-auto" type="submit" value="Update" />
            </div>
        </form>
    </div>
</div>
<script>
    function editBook(el) {
        const row = el.parentNode.parentNode;
        const bookId = row.cells[0].innerText;
        const bookTitle = row.cells[1].innerText;
        const bookAuthor = row.cells[2].innerText;
        const bookAuthorID = row.cells[3].innerText;
        const bookPublisher = row.cells[4].innerText;
        const bookIsbn = row.cells[5].innerText;
        const bookGenre = row.cells[6].innerText;
        const bookPages = row.cells[7].innerText;
        const bookPrice = row.cells[8].innerText;

        document.getElementById("editbookId").value = bookId;
        document.getElementById("editbookTitle").value = bookTitle;
        document.getElementById("editauthorId").value = bookAuthorID;
        document.getElementById("editpublisher").value = bookPublisher;
        document.getElementById("editisbn").value = bookIsbn;
        document.getElementById("editgenre").value = bookGenre;
        document.getElementById("editpages_count").value = bookPages;
        document.getElementById("editprice").value = bookPrice;
    }
</script>
<script src="../../static/bootstrap/js/bootstrap.bundle.js"></script>
</body>
</html>
