package com.ebay.response;

public class DbResendResponse {

	private String epid;
	private ResendStatus resendStatus;

	public DbResendResponse(String epid, ResendStatus resendStatus) {
		this.epid = epid;
		this.resendStatus = resendStatus;
	}

	public String getEpid() {
		return epid;
	}

	public void setEpid(String epid) {
		this.epid = epid;
	}

	public ResendStatus getResendStatus() {
		return resendStatus;
	}

	public void setResendStatus(ResendStatus resendStatus) {
		this.resendStatus = resendStatus;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((epid == null) ? 0 : epid.hashCode());
		result = prime * result
				+ ((resendStatus == null) ? 0 : resendStatus.hashCode());
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
		DbResendResponse other = (DbResendResponse) obj;
		if (epid == null) {
			if (other.epid != null) {
				return false;
			}
		} else if (!epid.equals(other.epid)) {
			return false;
		}
		if (resendStatus != other.resendStatus) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "ResendResponse [epid=" + epid + ", resendStatus="
				+ resendStatus + "]";
	}

}
