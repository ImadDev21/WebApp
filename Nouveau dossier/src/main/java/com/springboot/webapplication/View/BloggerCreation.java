package com.springboot.webapplication.View;

import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import javax.annotation.security.RolesAllowed;

@Route("blog")
@RolesAllowed("ADMIN")
public class BloggerCreation extends VerticalLayout {

    public BloggerCreation() {
        add (
          new H2("create your blog now")
        );
    }
}
