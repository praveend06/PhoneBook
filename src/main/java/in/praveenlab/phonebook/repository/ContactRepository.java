/**
 * 
 */
package in.praveenlab.phonebook.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.praveenlab.phonebook.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Serializable> {

}
