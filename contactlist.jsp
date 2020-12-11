<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>My Contact Book</title>
    <link rel="stylesheet" href="webjars/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
</head>
<body>
<div class="jumbotron jumbotron-fluid">
    <div class="container container-fluid">
        <h1 class="h1">My Contact Book</h1>
        <p>Welcome to My Contact Book, this is the list of your contacts</p>
    </div>
</div>
<div class="container-fluid">
    <p class="text-right">There are <b>${listSize}</b> contacts in your list</p>
    <table class="table table-striped">
        <thead class="thead-dark">
            <tr>
                <th>Full name</th>
                <th>Birth Date</th>
                <th>Company</th>
                <th>Role</th>
                <th>Email</th>
                <th>Phone</th>
                <th>Website</th>
                <th>Notes</th>
                <th>Last Modified</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${contacts}" var="contact">
                <tr>
                    <th>${contact.firstName} ${contact.lastName}</th>
                    <th>${contact.birthdate}</th>
                    <th>${contact.company}</th>
                    <th>${contact.role}</th>
                    <th><a href="mailto:${contact.email}">${contact.email}</a></th>
                    <th><a href="tel:${contact.phone}">${contact.phone}</a></th>
                    <th><a href="${contact.website}">${contact.website}</a></th>
                    <th><p title="${contact.notes}">${contact.abbrNotes}</p></th>
                    <th>${contact.modifiedOn}</th>
                    <th class="d-flex justify-content-around">
                        <a href="/edit?modifiedOn=${contact.modifiedOn}"><i class='fas fa-edit'></i></a>
                        <a id="deleteContact" href="/delete?modifiedOn=${contact.modifiedOn}" data-toggle="modal" data-target="#confirmationModal"><i class="fas fa-trash"></i></a>
                    </th>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
<div class="container d-flex">
    <a href="/add" class="btn btn-dark align-self-end">Add new contact</a>
</div>


<div class="modal fade" id="confirmationModal" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Confirm Deletion</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>Are you sure you want to delete this contact?</p>
            </div>
            <div class="modal-footer">
                <a id="delete" href=""><button type="button" class="btn btn-primary">Delete</button></a>
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>

<script src="webjars/jquery/3.5.1/jquery.min.js"></script>
<script src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script>
    $('#confirmationModal').on('show.bs.modal', function (event) {
        $("#delete").attr("href", $(event.relatedTarget).attr("href"));
    })
</script>


</body>
</html>