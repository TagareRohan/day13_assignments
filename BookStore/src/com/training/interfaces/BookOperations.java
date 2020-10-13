package com.training.interfaces;

import com.training.entity.Member;

import java.util.*;

public interface BookOperations {

	public boolean addMember(Member member);
	public boolean removeMember(int memberId);
	public Member findMember(int memberId);
	public List<Member> findAllMembers();
	public boolean updateMember(int memberId,Member newMember);
	
}
