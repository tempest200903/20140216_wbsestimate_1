package com.github.tempest200903;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

public class PersonTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testSave() {
		try {
			Session session = HibernateUtil.getSessionFactory()
					.getCurrentSession();
			session.beginTransaction();

			Person person = new Person();

			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
