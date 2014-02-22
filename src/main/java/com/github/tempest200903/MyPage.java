package com.github.tempest200903;

import java.io.Serializable;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.Model;

public class MyPage extends WebPage {

	public MyPage() {
		Form form = new Form("myForm");
		add(form);
		form.add(new Label("firstNameLabel", "First Name"));
		form.add(new Label("lastNameLabel", "Last Name"));

		Model<Serializable> firstNameModel = Model.of();
		form.add(new TextField("firstName", firstNameModel));
		Model<Serializable> lastNameModel = Model.of();
		form.add(new TextField("lastName", lastNameModel));

		form.add(new Button("Submit"));

		add(new Link("nextPage") {
			public void onClick() {
				setResponsePage(new NextPage("Hello!"));
			}
		});
	}

}
