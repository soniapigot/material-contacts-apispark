package net.apispark.webapi.db;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import net.apispark.webapi.representation.Contact;

public class ContactPersistenceTest {
	
	@Before
	public void deleteAllData(){
		for(int i = 0; i<ContactPersistence.INSTANCE.getContacts().size(); i++) 
			ContactPersistence.INSTANCE.deleteContact(ContactPersistence.INSTANCE.getContacts().get(i).getId());
		}
	
	@Test
	public void added_contact_is_correct() {
		//given
		Contact c1 = new Contact();
		c1.setFirstName("Sonia");
		c1.setLastName("PIGOT");
		c1.setGender("female");
		//when
		ContactPersistence.INSTANCE.addContact(c1);
		//then
		Assert.assertNotNull(c1.getId());
	}
	
	@Test
	public void added_contact_is_well_retrieved_by_id() {
		//given
		Contact c1 = new Contact();
		c1.setFirstName("Sonia");
		c1.setLastName("PIGOT");
		c1.setGender("female");
		ContactPersistence.INSTANCE.addContact(c1);
		//when
		Contact c2 = ContactPersistence.INSTANCE.getContact(c1.getId());
		//then
		Assert.assertEquals(c1.getId(), c2.getId());
	}
	
	@Test
	public void added_contact_list() {
		//given
		Contact c1 = new Contact();
		c1.setFirstName("Sonia");
		c1.setLastName("PIGOT");
		c1.setGender("female");
		ContactPersistence.INSTANCE.addContact(c1);
		Contact c2 = new Contact();
		c1.setFirstName("Baptiste");
		c1.setLastName("MAILLOT");
		c1.setGender("male");
		ContactPersistence.INSTANCE.addContact(c2);
		//when
		List<Contact> listActual = ContactPersistence.INSTANCE.getContacts();
		//then
		List<Contact> listExpected = new ArrayList<Contact>();
		listExpected.add(c1);
		listExpected.add(c2);
		Assert.assertEquals(listExpected, listActual);		
	}

}
