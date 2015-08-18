package face_bank.repository.jpa;

import org.springframework.data.repository.CrudRepository;

import face_bank.domain.jpa.ContactOrganization;

public interface ContactOrganizationRepository extends CrudRepository<ContactOrganization, Long> {

}
