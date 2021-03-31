package in.praveenlab.phonebook.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import in.praveenlab.phonebook.entity.Contact;
import in.praveenlab.phonebook.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {

	ContactRepository contactRepository;
	
	public ContactServiceImpl(ContactRepository contactRepository) {
		this.contactRepository = contactRepository;
	}
	
	@Override
	public boolean saveOrUpdateContact(Contact contact) {
		
		Contact saveObj = contactRepository.save(contact);
		
		//return (saveObj!=null)?true:false;
		return saveObj != null;
	}

	@Override
	public List<Contact> getAllContact() {		
		
		return contactRepository.findAll();
	}

	@Override
	public Contact getContactById(Integer Id) {
		
		Optional<Contact> findbyId = contactRepository.findById(Id);
			if(findbyId != null) {
				return findbyId.get();
			}
		
		return null;
	}

	@Override
	public boolean DeleteContactById(Integer Id) {
		boolean isDeleted = false;
		try{
			contactRepository.deleteById(Id);
			isDeleted = true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return isDeleted;
	}
	

}
