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
		// [2014-02-22 土 21:24] ページのレンダリングをテストするためのテスト・ケース
		// cf. http://www.ibm.com/developerworks/jp/web/library/wa-aj-wicket/
		tester.startPage(MyPage.class);
		tester.assertRenderedPage(MyPage.class);

		// [2014-02-22 土 21:24] ページ・コンポーネントをテストするためのテスト・ケース
		// cf. http://www.ibm.com/developerworks/jp/web/library/wa-aj-wicket/
		tester.assertComponent("myForm:firstName", TextField.class);
		tester.assertComponent("myForm:lastName", TextField.class);
		tester.assertLabel("myForm:firstNameLabel", "First Name");
		tester.assertLabel("myForm:lastNameLabel", "Last Name");

	}

	// [2014-02-22 土 21:24] OnClick ユーザー・アクションをテストするためのテスト・ケース
	// cf. http://www.ibm.com/developerworks/jp/web/library/wa-aj-wicket/
	@Test
	public void testOnClickAction() {
		tester.startPage(MyPage.class);

		// click link and render
		tester.clickLink("nextPage");
		tester.assertRenderedPage(NextPage.class);
		tester.assertLabel("nextPageMessage", "Hello!");
	}

	// [2014-02-22 土 21:24] フォームをサブミットするユーザー・アクションをテストするためのテスト・ケース
	// cf. http://www.ibm.com/developerworks/jp/web/library/wa-aj-wicket/
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

		// [2014-02-22 土 21:24] この先はよく分からない。保留。
		// verify the message on the rendered page
		// tester.assertInfoMessages(new String[] { "MyPage" });
	}

}
