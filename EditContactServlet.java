package servlets;

import Contact.Contact;
import Contact.ContactService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EditContactServlet", urlPatterns = "/edit")
public class EditContactServlet extends HttpServlet {
    private ContactService contactService = new ContactService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("newContact", contactService.editContact(new Contact(request.getParameter("modifiedOn"))));
        contactService.deleteContact(new Contact(request.getParameter("modifiedOn")));
        request.getRequestDispatcher("/addEditForm.jsp").forward(request, response);
    }
}
