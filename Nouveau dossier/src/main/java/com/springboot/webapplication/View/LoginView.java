package com.springboot.webapplication.View;

import com.springboot.webapplication.client.Client;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
@Route("login")
@PageTitle("Login Page")
public class LoginView extends VerticalLayout implements BeforeEnterObserver {
    private final LoginForm login = new LoginForm();

    public LoginView(){
        setSizeFull();
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);
        // the next path :
        login.setAction("login");
        add(login);
    }


    @Override
    public void beforeEnter(BeforeEnterEvent event) {
        if(event.getLocation().getQueryParameters().getParameters().containsKey("error")){
            login.setError(true);
        }
    }
}
