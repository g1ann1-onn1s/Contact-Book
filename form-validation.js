$(function(){

    $.validator.addMethod("phoneNumber", function(value, element) {
        return this.optional(element) || value.length > 8 && (/^\+?[0-9 ]+$/g).test(value)
    }, "Please enter a valid phone number");

    $.validator.addMethod("validDate", function(value, element) {
        return this.optional(element) || (/^([0-2][0-9]|(3)[0-1])(\/)(((0)[0-9])|((1)[0-2]))(\/)(((19)[0-9][0-9])|((20)[0-2][0-9]))$/).test(value)
    }, "Please enter a valid Birthdate");

    $("#form").validate({
        rules: {
            firstName: {
                required: true
            },
            lastName: {
                required: true
            },
            birthdate: {
                validDate: true
            },
            company: {
                required: function (element) {
                    return $("#role").val().length > 0;
                }
            },
            role: {
                required: function (element) {
                    return $("#company").val().length > 0;
                }
            },
            email: {
                required: true,
                email: true,
            },
            phone: {
                phoneNumber: true
            },
            website: {
                url: true
            },
        },
        messages: {
            firstName: {
                required: "First name field is mandatory"
            },
            lastName: {
                required: "Last name field is mandatory"
            },
            birthdate: {
                min: "Please enter a valid date",
                max: "Please enter a valid date"
            },
            company: {
                required: "Company name is mandatory when role has been added"
            },
            role: {
                required: "Role is mandatory when company name has been added"
            },
            email: {
                required: "Email field is mandatory",
                date: "Please enter a valid email address"
            },
            website: {
                url: "Please enter a valid URL"
            }
        },
        errorPlacement: function (error, element) {
            if (element.is("#role")) {
                error.appendTo("#role-error")
                } else {
                error.insertAfter(element)
            }
        }
    })
});