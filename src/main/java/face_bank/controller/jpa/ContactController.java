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

import face_bank.domain.jpa.Contact;
import face_bank.dto.JsonObject;
import face_bank.repository.jpa.ContactRepository;

/**
 * The Class AlarmController.
 *
 * @author yangboz
 */
@RestController
@RequestMapping("/api/contact")
public class ContactController {

	// ==============
	// PRIVATE FIELDS
	// ==============

	// Autowire an object of type ContactDao
	@Autowired
	private ContactRepository _contactDao;

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON)
	@ApiOperation(httpMethod = "POST", value = "Response a string describing if the alarm info is successfully created or not.")
	public JsonObject create(@RequestBody @Valid Contact contact) {
		return new JsonObject(_contactDao.save(contact));
	}

	@RequestMapping(method = RequestMethod.GET)
	@ApiOperation(httpMethod = "GET", value = "Response a list describing all of alarm info that is successfully get or not.")
	public JsonObject list() {
		return new JsonObject(this._contactDao.findAll());
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ApiOperation(httpMethod = "GET", value = "Response a string describing if the alarm info id is successfully get or not.")
	public Contact get(@PathVariable("id") long id) {
		return this._contactDao.findOne(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ApiOperation(httpMethod = "PUT", value = "Response a string describing if the  alarm info is successfully updated or not.")
	public JsonObject update(@PathVariable("id") long id, @RequestBody @Valid Contact contact) {
//		Contact find = this._contactDao.findOne(id);
//		contact.setId(id);//XXX
		return new JsonObject(this._contactDao.save(contact));
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ApiOperation(httpMethod = "DELETE", value = "Response a string describing if the alarm info is successfully delete or not.")
	public ResponseEntity<Boolean> delete(@PathVariable("id") long id) {
		this._contactDao.delete(id);
		return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
	}
}
