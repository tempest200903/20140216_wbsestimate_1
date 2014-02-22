package com.github.tempest200903;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;

public class NextPage extends WebPage {

	public NextPage(String string) {
		add(new Label("nextPageMessage", "Hello!"));
	}

}
