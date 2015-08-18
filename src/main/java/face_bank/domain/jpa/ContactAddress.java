package face_bank.domain.jpa;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import face_bank.Constants;

@Entity
@Table(name = Constants.T_NAME_CONTACT_ADDR)
//public class ContactAddress extends VoBase {
public class ContactAddress {
//	CREATE TABLE `contact_address` (
//			  `id` varchar(40) NOT NULL,
//			  `contact_id` varchar(40) DEFAULT NULL,
//			  `formatted` varchar(255) DEFAULT NULL,
//			  `type` varchar(255) DEFAULT NULL,
//			  PRIMARY KEY (`id`),
//			  KEY `ix_contact_address_contact_2` (`contact_id`),
//			  CONSTRAINT `fk_contact_address_contact_2` FOREIGN KEY (`contact_id`) REFERENCES `contact` (`id`)
//			) ENGINE=InnoDB DEFAULT CHARSET=utf8;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="t_id")
	private long id;
	
	@Column(name="id")
	private String sid;
	private String contact_id;
	private String formatted;
	private String type;
	public String getContact_id() {
		return contact_id;
	}
	public void setContact_id(String contact_id) {
		this.contact_id = contact_id;
	}
	public String getFormatted() {
		return formatted;
	}
	public void setFormatted(String formatted) {
		this.formatted = formatted;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
}
