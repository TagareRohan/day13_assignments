package com.training.interfaces;

import java.util.List;

import com.training.entity.Member;

public interface BookNewOperations extends BookOperations {

	public List<Member> findAscendingPenalty();
	public List<Member> findDescendingPenalty();
	
}
