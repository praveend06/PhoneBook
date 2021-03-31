package in.praveenlab.phonebook.service;

import java.util.List;

import in.praveenlab.phonebook.entity.Contact;

public interface ContactService {
	
	public boolean saveOrUpdateContact(Contact contact);
	
	public List<Contact> getAllContact();
	
	public Contact getContactById(Integer Id);
	
	public boolean DeleteContactById(Integer Id);
	
}
