package com.training.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.training.dao.BookStore;
import com.training.entity.Member;

/**
 * Servlet implementation class BookServlet
 */
@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RequestDispatcher dispatcher, dispatcher1=null;
	BookStore store;

    /**
     * Default constructor. 
     */
    public BookServlet() {
        // TODO Auto-generated constructor stub
    	store=new BookStore();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String optionForm=request.getParameter("submit");
		
		if(optionForm.equals("Find Member"))
		{
			dispatcher=request.getRequestDispatcher("findMember.jsp");
			dispatcher.forward(request, response);			
		}
		else if(optionForm.equals("Find All Members"))
		{
			dispatcher=request.getRequestDispatcher("findAllMembers.jsp");
			dispatcher.forward(request, response);
		}
		else if(optionForm.equals("Add Member"))
		{
			dispatcher=request.getRequestDispatcher("addMember.jsp");
			dispatcher.forward(request, response);
		}
		else if(optionForm.equals("Remove Member"))
		{
			dispatcher=request.getRequestDispatcher("removeMember.jsp");
			dispatcher.forward(request, response);
		}
		else if(optionForm.equals("Update Member"))
		{
			dispatcher=request.getRequestDispatcher("updateMember.jsp");
			dispatcher.forward(request, response);
		}
		else if(optionForm.equals("Penalty"))
		{
			List<Member> memberList=store.findAscendingPenalty();
			
			request.setAttribute("result",memberList);
			
			dispatcher=request.getRequestDispatcher("result.jsp");
			dispatcher.forward(request, response);
		}
		
		String formSubmit=request.getParameter("submit");
		
		if(formSubmit.equals("addForm"))
		{
			Member member=new Member();
			
			member.setMemberId(Integer.parseInt(request.getParameter("memberId")));
			member.setMemberName(request.getParameter("memberName"));
			member.setAccountOpenDate(request.getParameter("accountOpenDate"));
			member.setMembershipType(request.getParameter("membershipType"));
			member.setFeesPaid(Double.parseDouble(request.getParameter("feesPaid")));
			member.setMaxBookAllowed(Integer.parseInt(request.getParameter("maxBookAllowed")));
			member.setPenalty(Double.parseDouble(request.getParameter("penalty")));
			
			if(store.addMember(member))
			{
				request.setAttribute("result", "member added successfully");
			}
			else
			{
				request.setAttribute("result", "operation unsuccessful");
			}
			
			dispatcher1=request.getRequestDispatcher("result.jsp");
			dispatcher1.forward(request, response);
			
			
		}
		
		if(formSubmit.equals("findAllForm"))
		{
			List<Member> memberList=store.findAllMembers();
			request.setAttribute("result", memberList);
			dispatcher1=request.getRequestDispatcher("result.jsp");
			dispatcher1.forward(request, response);
		}
		
		if(formSubmit.equals("findForm"))
		{
			Member member=new Member();
			Integer id=Integer.parseInt(request.getParameter("memberId"));
			member=store.findMember(id);
			request.setAttribute("result", member);
			dispatcher1=request.getRequestDispatcher("result.jsp");
			dispatcher1.forward(request, response);
		}
		
		if(formSubmit.equals("removeForm"))
		{
			if(store.removeMember(Integer.parseInt(request.getParameter("memberId"))))
			{
				request.setAttribute("result", "removed successfully");
			}
			else
			{
				request.setAttribute("result", "operation not completed");
			}
		}
		
		if(formSubmit.equals("updateForm"))
		{
			Integer oldId=Integer.parseInt(request.getParameter("oldMemberId"));
			
			Member member=new Member();
			
			member.setMemberId(Integer.parseInt(request.getParameter("memberId")));
			member.setMemberName(request.getParameter("memberName"));
			member.setAccountOpenDate(request.getParameter("accountOpenDate"));
			member.setMembershipType(request.getParameter("membershipType"));
			member.setFeesPaid(Double.parseDouble(request.getParameter("feesPaid")));
			member.setMaxBookAllowed(Integer.parseInt(request.getParameter("maxBookAllowed")));
			member.setPenalty(Double.parseDouble(request.getParameter("penalty")));

			if(store.updateMember(oldId, member))
			{
				request.setAttribute("result","update successful");
			}
			else
			{
				request.setAttribute("result","update failed");
			}
			dispatcher1=request.getRequestDispatcher("result.jsp");
			dispatcher1.forward(request,response);
			
		}
		
		
		
		//doGet(request, response);
	}

}
