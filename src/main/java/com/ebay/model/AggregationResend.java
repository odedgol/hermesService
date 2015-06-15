package com.ebay.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="AGG_RESEND")
public class AggregationResend {
	
	@Id
	@Column(name="EPID")
	private String epid;

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
		AggregationResend other = (AggregationResend) obj;
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
