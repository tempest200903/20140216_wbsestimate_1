package com.github.tempest200903;

import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.util.tester.FormTester;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.Before;
import org.junit.Test;

public class MyPageTest {

	private WicketTester tester;

	@Before
	public void setUp() {
		tester = new WicketTester();
	}

	@Test
	public void testMyPage() {
		// ページのレンダリングをテストするためのテスト・ケース
		tester.startPage(MyPage.class);
		tester.assertRenderedPage(MyPage.class);

		// ページ・コンポーネントをテストするためのテスト・ケース
		tester.assertComponent("myForm:firstName", TextField.class);
		tester.assertComponent("myForm:lastName", TextField.class);
		tester.assertLabel("myForm:firstNameLabel", "First Name");
		tester.assertLabel("myForm:lastNameLabel", "Last Name");

	}

	// OnClick ユーザー・アクションをテストするためのテスト・ケース
	@Test
	public void testOnClickAction() {
		tester.startPage(MyPage.class);

		// click link and render
		tester.clickLink("nextPage");
		tester.assertRenderedPage(NextPage.class);
		tester.assertLabel("nextPageMessage", "Hello!");
	}

	// フォームをサブミットするユーザー・アクションをテストするためのテスト・ケース
	@Test
	public void testFormSubmit() {
		tester.startPage(MyPage.class);
		// Create the FormTester object
		FormTester ft = tester.newFormTester("myForm");

		// Set the input values on the field elements
		ft.setValue("firstName", "Kumar");
		ft.setValue("lastName", "Nadar");

		// Submit the form once the form is completed
		ft.submit("Submit");

		// Check the rendered page on form submission
		tester.assertRenderedPage(MyPage.class);
		// verify the message on the rendered page
		// tester.assertInfoMessages(new String[] { "MyPage" });
	}

}
