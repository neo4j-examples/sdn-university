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
@Table(name = Constants.T_NAME_CONTACT)
//public class Contact extends VoBase {
public class Contact {
//	CREATE TABLE `contact` (
//			  `id` varchar(40) NOT NULL,
//			  `login_name` varchar(255) DEFAULT NULL,
//			  `display_name` varchar(255) DEFAULT NULL,
//			  `given_name` varchar(255) DEFAULT NULL,
//			  `family_name` varchar(255) DEFAULT NULL,
//			  `birthday` datetime DEFAULT NULL,
//			  `note` varchar(255) DEFAULT NULL,
//			  `last_mdf_date` datetime DEFAULT NULL,
//			  `user_id` bigint(20) DEFAULT NULL,
//			  PRIMARY KEY (`id`),
//			  KEY `ix_contact_user_1` (`user_id`),
//			  CONSTRAINT `fk_contact_user_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
//			) ENGINE=InnoDB DEFAULT CHARSET=utf8;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="t_id")
	private long id;

	private int user_id;
	
	@Column(name="id")
	private String sid;
	
	private String login_name;
	private String display_name;
	private String given_name;
	private String family_name;
	private Date birthday;
	private String note;
	private Date last_mdf_date;

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getLogin_name() {
		return login_name;
	}

	public void setLogin_name(String login_name) {
		this.login_name = login_name;
	}

	public String getDisplay_name() {
		return display_name;
	}

	public void setDisplay_name(String display_name) {
		this.display_name = display_name;
	}

	public String getGiven_name() {
		return given_name;
	}

	public void setGiven_name(String given_name) {
		this.given_name = given_name;
	}

	public String getFamily_name() {
		return family_name;
	}

	public void setFamily_name(String family_name) {
		this.family_name = family_name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Date getLast_mdf_date() {
		return last_mdf_date;
	}

	public void setLast_mdf_date(Date last_mdf_date) {
		this.last_mdf_date = last_mdf_date;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


}
