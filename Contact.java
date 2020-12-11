package Contact;

import java.util.Objects;

public class Contact {
    private String firstName;
    private String lastName;
    private String birthdate;
    private String company;
    private String role;
    private String email;
    private String phone;
    private String website;
    private String notes;
    private String abbrNotes;
    private String createdOn;
    private String modifiedOn;

    public Contact(String firstName, String lastName, String birthdate, String company, String role, String email, String phone, String website, String notes, String abbrNotes, String createdOn, String modifiedOn) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.company = company;
        this.role = role;
        this.email = email;
        this.phone = phone;
        this.website = website;
        this.notes = notes;
        this.abbrNotes = abbrNotes;
        this.createdOn = createdOn;
        this.modifiedOn = modifiedOn;
    }

    public Contact(String modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getAbbrNotes() {
        return abbrNotes;
    }

    public void setAbbrNotes(String longNotes) {
        this.abbrNotes = longNotes;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public String getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(String modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthdate=" + birthdate +
                ", company='" + company + '\'' +
                ", role='" + role + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", website='" + website + '\'' +
                ", notes='" + notes + '\'' +
                ", abbrNotes='" + abbrNotes + '\'' +
                ", createdOn='" + createdOn + '\'' +
                ", modifiedOn='" + modifiedOn + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return modifiedOn.equals(contact.modifiedOn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(modifiedOn);
    }
}
