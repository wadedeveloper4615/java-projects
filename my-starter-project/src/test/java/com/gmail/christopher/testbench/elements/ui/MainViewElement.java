package com.gmail.christopher.testbench.elements.ui;

import com.vaadin.flow.component.applayout.testbench.AppLayoutElement;
import com.gmail.christopher.testbench.elements.components.AppNavigationElement;

public class MainViewElement extends AppLayoutElement {

	public AppNavigationElement getMenu() {
		return $(AppNavigationElement.class).first();
	}

}
