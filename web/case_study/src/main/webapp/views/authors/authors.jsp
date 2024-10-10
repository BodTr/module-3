
<%--
  Created by IntelliJ IDEA.
  User: trung
  Date: 10/8/2024
  Time: 2:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Authors Main</title>
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
                    <button class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#modalCreateAuthor">
                        <svg xmlns="http://www.w3.org/2000/svg" class="icon" width="24" height="24" viewBox="0 0 24 24"
                             stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round"
                             stroke-linejoin="round">
                            <path stroke="none" d="M0 0h24v24H0z" fill="none"></path>
                            <path d="M12 5l0 14"></path>
                            <path d="M5 12l14 0"></path>

                        </svg>
                        Thêm Tác giả
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
                            <h3 class="card-title">Tác giả</h3>
                        </div>
                        <div class="card-body border-bottom py-3">
                            <div class="d-flex">
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
                            </div>
                        </div>
                        <div class="table-responsive">
                            <table class="table card-table table-vcenter text-nowrap datatable">
                                <thead>
                                <tr>
                                    <th class="w-1">ID</th>
                                    <th>Name</th>
                                    <th>Date of Birth</th>
                                    <th>Bio</th>
                                    <th></th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${authors}" var="author">
                                    <tr>
                                        <td><c:out value="${author.id}"/></td>
                                        <td><c:out value="${author.name}"/></td>
                                        <td><c:out value="${author.birthDate}"/></td>
                                        <td><c:out value="${author.bio}"/></td>
                                        <td class="text-end">
                                            <span class="d-sm-inline">
                                              <a
                                                      class="btn btn-danger btn-icon"
                                                      data-toggle="tooltip"
                                                      data-placement="bottom"
                                                      title="Xóa tác giả"
                                                      onclick="return confirm('Are you sure?')"
                                                      href="${pageContext.request.contextPath}/admin/authors/delete?id=<c:out value="${author.id}"/> "
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
                                                    title="Sửa tác giả"
                                                    data-bs-toggle="modal"
                                                    data-bs-target="#modalEditAuthor"
                                                    onClick="editAuthor(this)"
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
                                            <a class="page-link" href="/admin/authors?page=<c:out value="${i}" />"><c:out
                                                    value="${i}"/></a>
                                        </li>
                                    </c:if>
                                    <c:if test="${currentPage != i}">
                                        <li class="page-item">
                                            <a class="page-link" href="/admin/authors?page=<c:out value="${i}" />"><c:out
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
<div class="modal modal-blur fade" id="modalCreateAuthor"  tabindex="-1" style="display: none;" aria-hidden="true">
    <div class="modal-dialog modal-lg modal-dialog-centered" role="document">
        <form class="modal-content" method="post" action="${pageContext.request.contextPath}/admin/authors/create">
            <div class="modal-header">
                <h5 class="modal-title">Thêm mới tác giả</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body row row-cards">
                <div class="mb-3">
                    <label for="authorName" class="form-label">Tên tác giả</label>
                    <input
                            id="authorName"
                            type="text"
                            class="form-control"
                            placeholder="Nhập tên tác giả"
                            name="name"
                    />
                </div>
                <div class="mb-3">
                    <label for="birthDate" class="form-label">Ngày sinh</label>
                    <input
                            id="birthDate"
                            type="date"
                            class="form-control"
                            name="birthDate"
                    />
                </div>
                <div class="mb-3">
                    <label for="bio" class="form-label">Tiểu sử</label>
                    <textarea class="form-control" rows="4" id="bio" placeholder="Nhập tiểu sử tác giả" name="bio"></textarea>
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
<div class="modal modal-blur fade" id="modalEditAuthor"  tabindex="-1" style="display: none;" aria-hidden="true">
    <div class="modal-dialog modal-lg modal-dialog-centered" role="document">
        <form class="modal-content" method="post" action="${pageContext.request.contextPath}/admin/authors/update">
            <div class="modal-header">
                <h5 class="modal-title">Thêm mới tác giả</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body row row-cards">
                <div class="mb-3" style="display: none">
                    <input type="text" id="editAuthorId" name="id" />
                </div>
                <div class="mb-3">
                    <label for="editAuthorName" class="form-label">Tên tác giả</label>
                    <input
                            id="editAuthorName"
                            type="text"
                            class="form-control"
                            placeholder="Nhập tên tác giả"
                            name="name"
                    />
                </div>
                <div class="mb-3">
                    <label for="editBirthDate" class="form-label">Ngày sinh</label>
                    <input
                            id="editBirthDate"
                            type="date"
                            class="form-control"
                            name="birthDate"
                    />
                </div>
                <div class="mb-3">
                    <label for="editBio" class="form-label">Tiểu sử</label>
                    <textarea class="form-control" rows="4" id="editBio" placeholder="Nhập tiểu sử tác giả" name="bio"></textarea>
                </div>
            </div>
            <div class="modal-footer">
                <a href="#" class="btn btn-link link-secondary" data-bs-dismiss="modal">
                    Cancel
                </a>
                <input class="btn btn-primary ms-auto" type="submit" value="Edit" />
            </div>
        </form>
    </div>
</div>
<script>
    function editAuthor(el) {
        console.log(el)
        const row = el.parentNode.parentNode;
        // Lấy tên người dùng từ ô thứ hai của hàng
        const authorId = row.cells[0].innerText;
        const authorName = row.cells[1].innerText;
        const authorBirthDate = row.cells[2].innerText;
        const authorBio = row.cells[3].innerText;
        // Hiển thị tên người dùng ra console
        console.log( authorName + "-authorName," + authorBirthDate + "-authorBirthDate," + authorBio + "-authorBio");
        document.getElementById("editAuthorName").value = authorName
        document.getElementById("editBirthDate").value = authorBirthDate
        document.getElementById("editBio").value = authorBio // editAuthorId
        document.getElementById("editAuthorId").value = authorId
        console.log(document.getElementById("editAuthorId").value)

    }
</script>
<script src="../../static/bootstrap/js/bootstrap.bundle.js"></script>
</body>
</html>
