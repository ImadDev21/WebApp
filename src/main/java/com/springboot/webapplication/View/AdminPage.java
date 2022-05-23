package com.springboot.webapplication.View;

import com.springboot.webapplication.client.*;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.button.Button;
import org.atmosphere.interceptor.AtmosphereResourceStateRecovery;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.security.RolesAllowed;

import java.util.function.DoubleToLongFunction;

import static java.lang.Long.parseLong;

@Route("consult")
@PageTitle("Consultation")
@RolesAllowed("ADMIN")
public class AdminPage extends VerticalLayout{
    private AuthorController control;
    final Grid<Author> grid ;
    TextField ID = new TextField("ID :");
    TextField EMAIL = new TextField("EMAIL :");
    TextField filtertext = new TextField();
    Button update = new Button("Update");
    Button delete = new Button("Delete");
    Button Add = new Button("Add Author");
    TextField nbr = new TextField();

    public AdminPage(AuthorController control){
        this.control = control;
        this.grid = new Grid<>(Author.class);
        setSizeFull();
        configureGrid();
        update.addClickListener(e -> updateAuthors());
        delete.addClickListener(e -> deleteAuthors());
        Add.addClickListener(e-> UI.getCurrent().navigate("createAccount"));
        add(getToolbar(), getContent());
        listAuthors();
    }

    public Component getContent(){
        VerticalLayout vl1 = new VerticalLayout(ID, EMAIL, createButtonLayout());
        vl1.setWidth("15em");
        HorizontalLayout hl1 = new HorizontalLayout(grid, vl1);
        hl1.setFlexGrow(2 , grid);
        hl1.setFlexGrow(1, vl1);
        hl1.setSizeFull();

        return hl1;
    }
    private void listAuthors(){
        grid.setItems(control.getAuthor());
    }

    private void getList (){
        grid.setItems(control.getAuthorByName(filtertext.getValue()));
    }

    private void updateAuthors (){
        Notification nt = Notification.show(control.update(Long.parseLong(ID.getValue()), EMAIL.getValue()));
    }

    private void deleteAuthors (){
        Notification nt = Notification.show(control.delete(Long.parseLong(ID.getValue())));
    }

    private Component createButtonLayout() {
        update.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        delete.addThemeVariants(ButtonVariant.LUMO_ERROR);

        return new HorizontalLayout(update, delete);
    }

    private Component getToolbar() {
        filtertext.setPlaceholder("Search");
        filtertext.setClearButtonVisible(true);
        filtertext.setValueChangeMode(ValueChangeMode.LAZY);
        filtertext.addValueChangeListener(e -> getList());
        nbr.setValue(String.valueOf(control.countAuthors()));
        nbr.setReadOnly(true);
        HorizontalLayout toolbar = new HorizontalLayout(filtertext, Add, nbr);
        return toolbar;
    }

    private void configureGrid() {
        grid.setSizeFull();
        grid.getColumns().forEach(col -> col.setAutoWidth(true));
    }
}
