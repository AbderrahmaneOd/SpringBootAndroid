package ma.projet.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

import java.util.List;

@Entity
public class Student extends User{
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    @ManyToOne
    private Filiere filiere;

    public Student() {
    }

    public Student(String username, String password, String firstName, String lastName, String email, String phone, Filiere filiere) {
        super(username, password);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.filiere = filiere;
    }

    public Student(String username, String password, List<Role> roles, String firstName, String lastName, String email, String phone, Filiere filiere) {
        super(username, password, roles);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.filiere = filiere;
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

    public Filiere getFiliere() {
        return filiere;
    }

    public void setFiliere(Filiere filiere) {
        this.filiere = filiere;
    }
}
