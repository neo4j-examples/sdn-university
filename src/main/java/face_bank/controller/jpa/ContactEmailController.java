/**
 * 
 */
package face_bank.controller.jpa;

import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.wordnik.swagger.annotations.ApiOperation;

import face_bank.domain.jpa.ContactEmail;
import face_bank.dto.JsonObject;
import face_bank.repository.jpa.ContactEmailRepository;

/**
 * The Class ContactEmailController.
 *
 * @author yangboz
 */
@RestController
@RequestMapping("/api/contact/email")
public class ContactEmailController {

	// ==============
	// PRIVATE FIELDS
	// ==============

	// Autowire an object of type ContactEmailDao
	@Autowired
	private ContactEmailRepository _contactEmailDao;

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON)
	@ApiOperation(httpMethod = "POST", value = "Response a string describing if the contact email info is successfully created or not.")
	public JsonObject create(@RequestBody @Valid ContactEmail contact) {
		return new JsonObject(_contactEmailDao.save(contact));
	}

	@RequestMapping(method = RequestMethod.GET)
	@ApiOperation(httpMethod = "GET", value = "Response a list describing all of contact email info that is successfully get or not.")
	public JsonObject list() {
		return new JsonObject(this._contactEmailDao.findAll());
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ApiOperation(httpMethod = "GET", value = "Response a string describing if the contact email info id is successfully get or not.")
	public ContactEmail get(@PathVariable("id") long id) {
		return this._contactEmailDao.findOne(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ApiOperation(httpMethod = "PUT", value = "Response a string describing if the  contact email info is successfully updated or not.")
	public JsonObject update(@PathVariable("id") long id, @RequestBody @Valid ContactEmail contactAddress) {
//		ContactEmail find = this._contactEmailDao.findOne(id);
		contactAddress.setId(id);
		return new JsonObject(this._contactEmailDao.save(contactAddress));
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ApiOperation(httpMethod = "DELETE", value = "Response a string describing if the contact email info is successfully delete or not.")
	public ResponseEntity<Boolean> delete(@PathVariable("id") long id) {
		this._contactEmailDao.delete(id);
		return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
	}
}
