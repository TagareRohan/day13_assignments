package com.training.dao;

import java.sql.*;
import java.util.*;

import com.training.entity.Member;
import com.training.interfaces.BookNewOperations;
import com.training.utility.ConnectionUtility;


public class BookStore implements BookNewOperations {

	private List<Member> memberList;
	private Connection derbyConnection;
	
	
	
	public BookStore() {
		super();
		// TODO Auto-generated constructor stub
		
		this.memberList = new ArrayList<Member>();
		
		this.derbyConnection=ConnectionUtility.getDerbyConnection();
	}


	@Override
	public boolean addMember(Member member) {
		// TODO Auto-generated method stub
		
		
		String sql="insert into invoice values(?,?,?,?,?,?,?)";
		PreparedStatement pstmt = null;
		
		try
		{
			pstmt.setInt(1,member.getMemberId());
			pstmt.setString(2, member.getMemberName());
			pstmt.setString(3, member.getAccountOpenDate());
			pstmt.setString(4,member.getMembershipType());
			pstmt.setDouble(5, member.getFeesPaid());
			pstmt.setInt(6, member.getMaxBookAllowed());
			pstmt.setDouble(7, member.getPenalty());
			pstmt=this.derbyConnection.prepareStatement(sql);
			ResultSet result = pstmt.executeQuery();
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return this.memberList.add(member);
		
		
	}

	@Override
	public boolean removeMember(int memberId) {
		// TODO Auto-generated method stub
		
		
		String sql="delete from members where memberId=?";
		PreparedStatement pstmt = null;
		
		try
		{
			pstmt.setInt(1,memberId);
			pstmt=this.derbyConnection.prepareStatement(sql);
			ResultSet result = pstmt.executeQuery();
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		for(Member mem:memberList)
		{
			if(mem.getMemberId()==memberId)
			{
				this.memberList.remove(mem);
				return true;
			}
		}
		
		return false;
		
	}

	@Override
	public Member findMember(int memberId) {
		// TODO Auto-generated method stub
		
		String sql="select * from members where memberId=?";
		PreparedStatement pstmt=null;
		ResultSet result=null;
		Member member=null;
		
		try {
			pstmt.setInt(1,memberId);
			pstmt=this.derbyConnection.prepareStatement(sql);
			result = pstmt.executeQuery();
			
			
			while(result.next())
			{
				
				int Id=result.getInt("memberId");
				String memberName=result.getString("memberId");
				String accountOpenDate=result.getString("memberId");
				String membershipType=result.getString("memberId");
				double feesPaid=result.getDouble("memberId");
				int maxBookAllowed=result.getInt("memberId");
				double penalty=result.getDouble("memberId");
				
				member=new Member(Id,memberName,accountOpenDate,membershipType,
						feesPaid,maxBookAllowed,penalty);
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		return member;
	}

	@Override
	public List<Member> findAllMembers() {
		// TODO Auto-generated method stub
		
		
		String sql="select * from members";
		
		PreparedStatement pstmt = null;
		
		try
		{
			pstmt=this.derbyConnection.prepareStatement(sql);
			ResultSet result = pstmt.executeQuery();
			Member member; 
			
			while(result.next())
			{
				int Id=result.getInt("memberId");
				String memberName=result.getString("memberId");
				String accountOpenDate=result.getString("memberId");
				String membershipType=result.getString("memberId");
				double feesPaid=result.getDouble("memberId");
				int maxBookAllowed=result.getInt("memberId");
				double penalty=result.getDouble("memberId");
				
				member=new Member(Id,memberName,accountOpenDate,membershipType,
						feesPaid,maxBookAllowed,penalty);
				
				this.memberList.add(member);
			}
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return this.memberList;
		
		
	}

	@Override
	public boolean updateMember(int memberId,Member newMember) {
		// TODO Auto-generated method stub
		
		String sql="update members set memberId=?, memberName=?, accountOpenDate=?,"
				+ "membershipType=?,feesPaid=?,maxBookAllowed=?,"
				+"penalty=? where memberId=?";
		
		try {
			PreparedStatement pstmt=this.derbyConnection.prepareStatement(sql);
			
			pstmt.setInt(1,memberId);
			pstmt.setInt(2,newMember.getMemberId());
			pstmt.setString(3,newMember.getMemberName());
			pstmt.setString(4,newMember.getAccountOpenDate());
			pstmt.setString(5,newMember.getMembershipType());
			pstmt.setDouble(6,newMember.getFeesPaid());
			pstmt.setInt(7,newMember.getMaxBookAllowed());
			pstmt.setDouble(8,newMember.getPenalty());
			pstmt=this.derbyConnection.prepareStatement(sql);
			  
			int i=pstmt.executeUpdate();
			
			if(i!=0)
			{
				return true;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
		
	}

	@Override
	public List<Member> findAscendingPenalty() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Member> findDescendingPenalty() {
		// TODO Auto-generated method stub
		return null;
	}

}