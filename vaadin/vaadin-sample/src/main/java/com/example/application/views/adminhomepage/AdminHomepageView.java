package com.example.application.views.adminhomepage;

import javax.annotation.security.RolesAllowed;

import org.springframework.security.access.annotation.Secured;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Admin Homepage")
@Route(value = "/admin/home", layout = MainLayout.class)
@Secured("ROLE_admin")
@RolesAllowed("admin")
public class AdminHomepageView extends HorizontalLayout {

    private TextField name;
    private Button sayHello;

    public AdminHomepageView() {
        addClassName("admin-homepage-view");
        name = new TextField("Your name");
        sayHello = new Button("Say hello");
        add(name, sayHello);
        setVerticalComponentAlignment(Alignment.END, name, sayHello);
        sayHello.addClickListener(e -> {
            Notification.show("Hello " + name.getValue());
        });
    }

}
