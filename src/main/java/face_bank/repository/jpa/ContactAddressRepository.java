package face_bank.repository.jpa;

import org.springframework.data.repository.CrudRepository;

import face_bank.domain.jpa.ContactAddress;

public interface ContactAddressRepository extends CrudRepository<ContactAddress, Long> {

}
