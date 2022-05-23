package com.springboot.webapplication.View;


import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;




@Route("")
@AnonymousAllowed   //every one can see this page
public class WelcomeView extends VerticalLayout {
    Toolbar toolbar = new Toolbar();
    H2 titre = new H2("Blogger Community");
    //Button login_button = new Button("Login", e-> UI.getCurrent().navigate("login"));
    //Button newAccount_button = new Button("New Account", e-> UI.getCurrent().navigate("createAccount"));
    HorizontalLayout hl = new HorizontalLayout(titre);

    Button createBlog_button = new Button("Create Blog", e-> UI.getCurrent().navigate("blog"));
    public WelcomeView(){
        hl.setDefaultVerticalComponentAlignment(Alignment.BASELINE);
        add(toolbar, hl, createBlog_button);

    }

}
