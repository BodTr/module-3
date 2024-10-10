<%--
  Created by IntelliJ IDEA.
  User: trung
  Date: 10/10/2024
  Time: 10:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Item Main</title>
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
                        Items List
                    </h2>
                </div>
                <div class="col-auto ms-auto d-print-none">
                    <button class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#modalCreateItem">
                        <svg xmlns="http://www.w3.org/2000/svg" class="icon" width="24" height="24" viewBox="0 0 24 24"
                             stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round"
                             stroke-linejoin="round">
                            <path stroke="none" d="M0 0h24v24H0z" fill="none"></path>
                            <path d="M12 5l0 14"></path>
                            <path d="M5 12l14 0"></path>

                        </svg>
                        Create
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
                        <div class="card-body border-bottom py-3">

                        </div>
                        <div class="table-responsive">
                            <table class="table card-table table-vcenter text-nowrap datatable">
                                <thead>
                                <tr>
                                    <th class="w-1">ID</th>
                                    <th>Name</th>
                                    <th>Price</th>
                                    <th>Discount</th>
                                    <th>Inventory</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${items}" var="item">
                                    <tr>
                                        <td><c:out value="${item.id}"/></td>
                                        <td><c:out value="${item.name}"/></td>
                                        <td><c:out value="${item.price}"/></td>
                                        <td><c:out value="${item.discount}"/></td>
                                        <td><c:out value="${item.inventory}"/></td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="modal modal-blur fade" id="modalCreateItem"  tabindex="-1" style="display: none;" aria-hidden="true">
    <div class="modal-dialog modal-lg modal-dialog-centered" role="document">
        <form class="modal-content" method="post" action="${pageContext.request.contextPath}/admin/items/create">
            <div class="modal-header">
                <h5 class="modal-title">Create Item</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body row row-cards">
                <div class="mb-3">
                    <label for="itemName" class="form-label required">Name</label>
                    <input
                            id="itemName"
                            type="text"
                            class="form-control"
                            placeholder="Input item name"
                            name="name"
                    />
                </div>
                <div class="mb-3">
                    <label for="itemPrice" class="form-label required">Price</label>
                    <input
                            id="itemPrice"
                            type="number"
                            class="form-control"
                            placeholder="Input item price"
                            name="price"
                    />
                </div>
                <div class="mb-3">
                    <label for="discount" class="form-label required">Choose discount</label>
                    <select class="form-select" id="discount" name="discount">
                        <option value="" selected disabled>Dicount percent</option>
                        <option value="5">5 (%)</option>
                        <option value="10">10 (%)</option>
                        <option value="15">15 (%)</option>
                        <option value="20">20 (%)</option>
                    </select>
                </div>
                <div class="mb-3">
                    <label for="inventory" class="form-label required">Inventory</label>
                    <input
                            id="inventory"
                            type="number"
                            class="form-control"
                            placeholder="Input inventory"
                            name="inventory"
                    />
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
<script src="../../static/bootstrap/js/bootstrap.bundle.js"></script>
</body>
</html>
