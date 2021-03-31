package in.praveenlab.phonebook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.praveenlab.phonebook.entity.Contact;
import in.praveenlab.phonebook.service.ContactService;

@Controller
public class ContactInfoController {

	ContactService contactService;

	@Autowired
	public ContactInfoController(ContactService contactService) {
		this.contactService = contactService;
	}

	@GetMapping("/")
	public String loadForm(Model model) {
		Contact contact = new Contact();
		model.addAttribute("contact", contact);
		return "contact";
	}

	@PostMapping("/save_contact")
	public String saveContact(Contact contact, Model model) {

		boolean status = contactService.saveOrUpdateContact(contact);
		if (status) {
			model.addAttribute("succMsg", "Contact created successfully!!");
		}if (status && contact.getId() > 0)  {
			model.addAttribute("succMsg", "Contact updated successfully!!");
		} else {
			model.addAttribute("failMsg", "Contact failed to create!!");
		}

		return "contact";

	}

	@GetMapping("/display_contacts")
	public String displayContacts(Model model) {

		List<Contact> contacts = contactService.getAllContact();
		model.addAttribute("contacts", contacts);

		return "display_contacts";
	}

	@GetMapping("/edit_contact")
	public String edit_contact(Model model, @RequestParam("id") Integer id) {
		Contact contact = contactService.getContactById(id);
		model.addAttribute("contact", contact);
		return "contact";
	}

	@GetMapping("/delete_contact")
	public String delete_contact(Model model, @RequestParam("id") Integer id) {

		boolean status = contactService.DeleteContactById(id);

		if (status) {
			model.addAttribute("succMsg", "Contact deleted successfully!!");
		} else {
			model.addAttribute("failMsg", "Contact failed to delete!!");
		}

		return "redirect:display_contacts";
	}
}
