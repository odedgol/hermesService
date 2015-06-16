package com.ebay.model.bdo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AGG_RESEND")
public class AggregationResendDO {

	public AggregationResendDO() {
	}

	@Id
	@Column(name = "EPID")
	private String epid;

	public AggregationResendDO(String epid) {
		this.epid = epid;
	}

	public String getEpid() {
		return epid;
	}

	public void setEpid(String epid) {
		this.epid = epid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((epid == null) ? 0 : epid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		AggregationResendDO other = (AggregationResendDO) obj;
		if (epid == null) {
			if (other.epid != null) {
				return false;
			}
		} else if (!epid.equals(other.epid)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "AggregationResend [epid=" + epid + "]";
	}

}
