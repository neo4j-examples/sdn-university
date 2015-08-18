/**
 * 
 */
package face_bank.domain.jpa;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The Class InfoBase for each column with CREATED/UPDATED field.
 *
 * @author yangboz
 */
@MappedSuperclass
public class VoBase {
	// @Version
	// @Temporal(TemporalType.DATE)
	// @Column(name = "created", nullable = false)
	// @Type(type="org.joda.time.contrib.hibernate.PersistentDateTime")
	@Column(name = "CREATED", nullable = false, insertable = true, updatable = true, length = 19, precision = 0)
	@Temporal(TemporalType.TIMESTAMP)
	private Date created;

	public void setCreated(Date created) {
		this.created = created;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATED", nullable = false)
	private Date updated;

	@PrePersist
	protected void onCreate() {
		updated = created = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		updated = new Date();
	}

	public Date getCreated() {
		return created;
	}

	public Date getUpdated() {
		return updated;
	}
	
}
