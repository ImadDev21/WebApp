package com.springboot.webapplication.View;

import com.springboot.webapplication.client.Client;
import com.springboot.webapplication.client.ClientController;
import com.springboot.webapplication.client.ClientService;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.button.Button;
import org.atmosphere.interceptor.AtmosphereResourceStateRecovery;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.security.RolesAllowed;

import static java.lang.Long.parseLong;

@Route("consult")
@PageTitle("Consultation")
@RolesAllowed("ADMIN")
public class AdminPage extends VerticalLayout{
    private ClientController control;
    final Grid<Client> grid ;
    TextField ID = new TextField("ID :");
    TextField EMAIL = new TextField("EMAIL :");
    TextField filtertext = new TextField();
    Button update = new Button("Update");
    Button delete = new Button("Delete");
    Button Add = new Button("ADD Client");

    public AdminPage(ClientController control){
        this.control = control;
        this.grid = new Grid<>(Client.class);
        setSizeFull();
        configureGrid();
        update.addClickListener(e -> updateClients());
        delete.addClickListener(e -> deleteClients());
        Add.addClickListener(e -> addClients());
        add(getToolbar(), getContent());
        listClients();
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
    private void listClients(){
        grid.setItems(control.getClient());
    }

    private void updateClients (){
        Notification nt = Notification.show(control.update(Long.parseLong(ID.getValue())));
    }

    private void deleteClients (){
        Notification nt = Notification.show(control.delete(Long.parseLong(ID.getValue())));
    }

    private void addClients (){
        Notification nt = Notification.show(control.create(EMAIL.getValue(), ID.getValue()));
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


        HorizontalLayout toolbar = new HorizontalLayout(filtertext, Add);
        return toolbar;
    }

    private void configureGrid() {
        grid.setSizeFull();
        grid.getColumns().forEach(col -> col.setAutoWidth(true));
    }
}
