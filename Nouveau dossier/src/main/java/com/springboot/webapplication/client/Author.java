package com.springboot.webapplication.client;

import com.vaadin.flow.component.html.Image;
import org.hibernate.validator.constraints.Email;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String firstName;

    private String lastName;

    private LocalDateTime dateOfBirth;

    // @Temporal(TemporalType.TIMESTAMP)
    //@GeneratedValue(strategy = )
    private LocalDateTime regestrationDate;

    private String aboutme;

    @Email
    private String email;

    private String password;

    private String phoneNumber;

    private Image authorImage;

    public Author(long id, String firstName, String lastName, LocalDateTime dateOfBirth, LocalDateTime regestrationDate, String aboutme, String email, String password, String phoneNumber, Image authorImage) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.regestrationDate = regestrationDate;
        this.aboutme = aboutme;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.authorImage = authorImage;
    }

    public Author(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDateOfBirth(LocalDateTime dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setRegestrationDate(LocalDateTime regestrationDate) {
        this.regestrationDate = regestrationDate;
    }

    public void setAboutme(String aboutme) {
        this.aboutme = aboutme;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAuthorImage(Image authorImage) {
        this.authorImage = authorImage;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDateTime getDateOfBirth() {
        return dateOfBirth;
    }

    public LocalDateTime getRegestrationDate() {
        return regestrationDate;
    }

    public String getAboutme() {
        return aboutme;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Image getAuthorImage() {
        return authorImage;
    }
}
