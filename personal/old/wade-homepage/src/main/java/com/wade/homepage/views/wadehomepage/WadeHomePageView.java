package com.wade.homepage.views.wadehomepage;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;
import com.wade.homepage.views.MainLayout;
import com.vaadin.flow.router.RouteAlias;

@PageTitle("Wade Home Page")
@Route(value = "homepage", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
public class WadeHomePageView extends HorizontalLayout {

    private TextField name;
    private Button sayHello;

    public WadeHomePageView() {
        addClassName("wade-home-page-view");
        name = new TextField("Your name");
        sayHello = new Button("Say hello");
        add(name, sayHello);
        setVerticalComponentAlignment(Alignment.END, name, sayHello);
        sayHello.addClickListener(e -> {
            Notification.show("Hello " + name.getValue());
        });
    }

}
