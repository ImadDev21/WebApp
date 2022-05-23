package com.springboot.webapplication.View;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.contextmenu.ContextMenu;
import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.atmosphere.interceptor.AtmosphereResourceStateRecovery;

public class Toolbar extends HorizontalLayout {

    Span title;


    MenuBar menu = new MenuBar();

    public Toolbar () {


        menu.addItem("login", e-> UI.getCurrent().navigate("login"));
        menu.addItem("new", e-> UI.getCurrent().navigate("createAccount"));
        menu.addItem("logout", e-> UI.getCurrent().navigate("logout"));
        add(menu);
    }
}
