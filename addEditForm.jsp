<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Change list</title>
    <link rel="stylesheet" href="webjars/bootstrap/4.3.1/css/bootstrap.min.css">
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>
<div class="jumbotron">
    <div class="container">
        <h1>Apply changes</h1>
        <p>All fields with * are mandatory</p>
    </div>
</div>
<div class="container">
    <form id="form" action="/add" method="post">
        <div class="form-group">
            <label for="firstName">First name: *</label>
            <input type="text" class="form-control" id="firstName" value="${newContact.firstName}"
                   name="firstName">
        </div>
        <div class="form-group">
            <label for="lastName">Last name: *</label>
            <input type="text" class="form-control" id="lastName" value="${newContact.lastName}" name="lastName">
        </div>
        <div class="form-group">
            <label for="birthdate">Birthdate:</label>
            <input type="text" class="form-control" id="birthdate"
                   value="${newContact.birthdate}" placeholder="Enter birthdate..." name="birthdate">
        </div>
        <div class="form-group">
            <label for="company">Company:</label>
            <input type="text" class="form-control" id="company" value="${newContact.company}" placeholder="Enter company name..." name="company">
        </div>
        <div class="form-group">
            <label for="role">Role:</label>
            <select id="role" name="role">
                <option value=""></option>
                <option value="ceo">ceo</option>
                <option value="vice-president">vice-president</option>
                <option value="director">director</option>
                <option value="manager">manager</option>
                <option value="employee">employee</option>
                <option value="other">other</option>
            </select>
        </div>
        <div class="form-group">
            <label for="email">Email: *</label>
            <input type="email" class="form-control" id="email" value="${newContact.email}" name="email">
            <p class="error">${error}</p>
        </div>
        <div class="form-group">
            <label for="phone">Phone:</label>
            <input type="tel" class="form-control" id="phone" value="${newContact.phone}" placeholder="Enter phone number..." name="phone">
        </div>
        <div class="form-group">
            <label for="website">Website:</label>
            <input type="url" class="form-control" id="website" value="${newContact.website}" placeholder="Enter website URL..." name="website">
        </div>
        <p>Notes (Maximum 500 characters allowed):</p>
        <div class="form-group">
            <textarea maxlength="500" class="col-md-12 h-50" rows="5" name="notes" placeholder="Enter notes...">${newContact.notes}</textarea>
        </div>
        <button type="submit" class="btn btn-dark">Commit changes</button>
    </form>
</div>

<script src="webjars/jquery/3.5.1/jquery.min.js"></script>
<script src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script src="webjars/jquery-validation/dist/jquery.validate.min.js"></script>
<script src="webjars/jquery-validation/dist/additional-methods.min.js"></script>
<script src="form-validation.js"></script>
</body>
</html>
