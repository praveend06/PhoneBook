package in.praveenlab.phonebook.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import in.praveenlab.phonebook.entity.Contact;
import in.praveenlab.phonebook.properties.AppProperties;
import in.praveenlab.phonebook.service.ContactService;

@Controller
public class ContactInfoController {

	ContactService contactService;
	AppProperties props;

	@Autowired
	public ContactInfoController(ContactService contactService, AppProperties props) {
		this.contactService = contactService;
		this.props = props;
	}

	@GetMapping("/")
	public String loadForm(Model model) {
		Contact contact = new Contact();
		model.addAttribute("contact", contact);
		return "contact";
	}

	@PostMapping("/save_contact")
	public String saveContact(Contact contact, Model model) {
        Map<String, String> messages = props.getMessages();
        Integer cid = contact.getId();
		boolean status = contactService.saveOrUpdateContact(contact);
		if (status && cid <= 0) {
			model.addAttribute("succMsg", messages.get("succMsg"));
		}else if (status)  {
			model.addAttribute("succMsg", messages.get("succUpdatedMsg"));
		}else {
			model.addAttribute("failMsg", messages.get("failMsg"));
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
	public String delete_contact(@RequestParam("id") Integer id, RedirectAttributes rd) {
		Map<String, String> messages = props.getMessages();
		boolean status = contactService.DeleteContactById(id);

		if (status) {
			rd.addFlashAttribute("succMsg", messages.get("deletedSuccMSg"));
		} else {
			rd.addFlashAttribute("failMsg", messages.get("deletedErrMSg"));
		}

		return "redirect:display_contacts";
	}
}
