package com.training.entity;

public class Member {

	private int memberId;
	private String memberName;
	private String accountOpenDate;
	private String membershipType;
	private double feesPaid;
	private int maxBookAllowed;
	private double penalty;
	
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Member(int memberId, String memberName, String accountOpenDate, String membershipType, double feesPaid,
			int maxBookAllowed, double penalty) {
		super();
		this.memberId = memberId;
		this.memberName = memberName;
		this.accountOpenDate = accountOpenDate;
		this.membershipType = membershipType;
		this.feesPaid = feesPaid;
		this.maxBookAllowed = maxBookAllowed;
		this.penalty = penalty;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getAccountOpenDate() {
		return accountOpenDate;
	}

	public void setAccountOpenDate(String accountOpenDate) {
		this.accountOpenDate = accountOpenDate;
	}

	public String getMembershipType() {
		return membershipType;
	}

	public void setMembershipType(String membershipType) {
		this.membershipType = membershipType;
	}

	public double getFeesPaid() {
		return feesPaid;
	}

	public void setFeesPaid(double feesPaid) {
		this.feesPaid = feesPaid;
	}

	public int getMaxBookAllowed() {
		return maxBookAllowed;
	}

	public void setMaxBookAllowed(int maxBookAllowed) {
		this.maxBookAllowed = maxBookAllowed;
	}

	public double getPenalty() {
		return penalty;
	}

	public void setPenalty(double penalty) {
		this.penalty = penalty;
	}

	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", memberName=" + memberName + ", accountOpenDate=" + accountOpenDate
				+ ", membershipType=" + membershipType + ", feesPaid=" + feesPaid + ", maxBookAllowed=" + maxBookAllowed
				+ ", penalty=" + penalty + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountOpenDate == null) ? 0 : accountOpenDate.hashCode());
		long temp;
		temp = Double.doubleToLongBits(feesPaid);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + maxBookAllowed;
		result = prime * result + memberId;
		result = prime * result + ((memberName == null) ? 0 : memberName.hashCode());
		result = prime * result + ((membershipType == null) ? 0 : membershipType.hashCode());
		temp = Double.doubleToLongBits(penalty);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		if (accountOpenDate == null) {
			if (other.accountOpenDate != null)
				return false;
		} else if (!accountOpenDate.equals(other.accountOpenDate))
			return false;
		if (Double.doubleToLongBits(feesPaid) != Double.doubleToLongBits(other.feesPaid))
			return false;
		if (maxBookAllowed != other.maxBookAllowed)
			return false;
		if (memberId != other.memberId)
			return false;
		if (memberName == null) {
			if (other.memberName != null)
				return false;
		} else if (!memberName.equals(other.memberName))
			return false;
		if (membershipType == null) {
			if (other.membershipType != null)
				return false;
		} else if (!membershipType.equals(other.membershipType))
			return false;
		if (Double.doubleToLongBits(penalty) != Double.doubleToLongBits(other.penalty))
			return false;
		return true;
	}
	
	
	
}
