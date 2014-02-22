package com.github.tempest200903;

import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.WebPage;

public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;

	public HomePage(final PageParameters parameters) {
		super(parameters);

		String version = getApplication().getFrameworkSettings().getVersion();
		System.out.println("version =: " + version);

		Label label = new Label("version", version);
		add(label);

		// TODO Add your page's components here
		

	}
}
