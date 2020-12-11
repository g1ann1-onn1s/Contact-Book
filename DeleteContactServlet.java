package servlets;

import Contact.Contact;
import Contact.ContactService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteContactServlet", urlPatterns = "/delete")
public class DeleteContactServlet extends HttpServlet {
   private ContactService contactService = new ContactService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        contactService.deleteContact(new Contact(request.getParameter("modifiedOn")));
        response.sendRedirect("/contactlist");
    }
}
