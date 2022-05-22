package com.springboot.webapplication.View;

import com.springboot.webapplication.client.Author;
import com.springboot.webapplication.client.AuthorController;
import com.springboot.webapplication.client.Client;
import com.springboot.webapplication.client.ClientService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import javax.annotation.security.RolesAllowed;


@Route("createAccount")
@PageTitle("New Account Creation")
@RolesAllowed("ADMIN")
public class CreateClient extends VerticalLayout {
    AuthorController control;
    TextField lastName = new TextField("LastName :");
    TextField firstname = new TextField("FirstName :");
    EmailField email = new EmailField("Email :");
    PasswordField password = new PasswordField("Password :");
    Button submit = new Button("Submit");

    FormLayout form = new FormLayout();


    public CreateClient(AuthorController control){
        this.control = control;
        setSizeFull();
        submit.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        submit.addClickListener(e -> createAuthor());

        add(new H4("Create your Account:"), configureForm(), submit);
    }

    private void createAuthor(){
        Author author = new Author(firstname.getValue(), lastName.getValue(), email.getValue(), password.getValue());
        Notification nt = Notification.show(control.create(author));
    }

    private Component configureForm (){
        form.add(firstname, lastName, email, password);
        return form;
    }

}
