package servlets;

import Contact.ContactService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ContactListServlet", urlPatterns = "/contactlist")
public class ContactListServlet extends HttpServlet {

    private ContactService contactService = new ContactService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listSize", contactService.contactListSize());
        request.setAttribute("contacts", contactService.retrieveContacts());
        request.getRequestDispatcher("contactlist.jsp").forward(request, response);
    }
}
