package org.enquete.app.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class ContactsView implements Serializable {

	private static final long serialVersionUID = 5944808088082332382L;

	private Contact contact;

	private List<Contact> contacts;

	@PostConstruct
	public void init() {
		contact = new Contact();
		contacts = new ArrayList<Contact>();
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public String saveContact() {
		if (!contacts.contains(contact)) {
			contacts.add(contact);
		}

		return "pm:list?transition=flip";
	}

	public void deleteContact() {
		if (contacts.contains(contact)) {
			contacts.remove(contact);
		}
	}

	public String prepareNewContact() {
		contact = new Contact();

		return "pm:edit?transition=flip";
	}

}