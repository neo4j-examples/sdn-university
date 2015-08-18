package face_bank.repository.jpa;

import org.springframework.data.repository.CrudRepository;

import face_bank.domain.jpa.ContactEmail;

public interface ContactEmailRepository extends CrudRepository<ContactEmail, Long> {

}
