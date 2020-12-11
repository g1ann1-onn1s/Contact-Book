package servlets;

import Contact.Contact;
import Contact.ContactService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "addContactServlet", urlPatterns = "/add")
public class addContactServlet extends HttpServlet {

    private ContactService contactService = new ContactService();
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String birthdate = request.getParameter("birthdate");
        String company = request.getParameter("company");
        String role = request.getParameter("role");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String website = request.getParameter("website");
        String notes = request.getParameter("notes");
        String abbrNotes = notes.length() > 200 ? notes.substring(0, 200) + "..." : notes;
        String createdOn = dtf.format(LocalDateTime.now());
        String modifiedOn = dtf.format(LocalDateTime.now());

        if (contactService.retrieveContacts().stream().anyMatch(o -> o.getEmail().equals(request.getParameter("email")))) {
            Contact newContact = new Contact(firstName, lastName, birthdate, company, role, email, phone, website, notes, abbrNotes, createdOn, modifiedOn);
            request.getSession().setAttribute("newContact", newContact);
            request.getSession().setAttribute("error", "This email already exists, please enter another email address");
            response.sendRedirect("/add");
        } else {
            contactService.addContact(new Contact(firstName, lastName, birthdate, company, role, email, phone, website, notes, abbrNotes, createdOn, modifiedOn));
            response.sendRedirect("/contactlist");
            HttpSession session = request.getSession(false);
            if (session != null) {
                session.invalidate();
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/addEditForm.jsp").forward(request,response);
    }
}
