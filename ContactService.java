package Contact;

import java.util.ArrayList;
import java.util.List;

public class ContactService {
    private static List<Contact> contacts = new ArrayList<Contact>();
    static {
    }

    public List<Contact> retrieveContacts() {
        return contacts;
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public void deleteContact(Contact contact) { contacts.remove(contact); }

    public Contact editContact(Contact contact) {
        int i = contacts.indexOf(contact);
        return contacts.get(i);
    }

    public int contactListSize() {
        return contacts.size();
    }
}
