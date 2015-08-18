package face_bank.repository.jpa;

import org.springframework.data.repository.CrudRepository;

import face_bank.domain.jpa.Contact;

public interface ContactRepository extends CrudRepository<Contact, Long> {

}
