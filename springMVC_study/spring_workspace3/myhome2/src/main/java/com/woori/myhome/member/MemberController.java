package com.woori.myhome.member;

import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MemberController {

	//Ajax�� ȣ������ �����͸� JSON ���·� �����Ѵ� 
	@Resource(name="memberService")
	MemberService service;
	
	
	//http://localhost:9000/myhome/member/isDuplicate?userid=test
	@RequestMapping(value="/member/isDuplicate")
	@ResponseBody  //����� JSON  ���·� ����Ѵ�. Ajax�Լ� ȣ���Ҷ� �Լ� �տ� ������̼��� �־�� �Ѵ� 
	public HashMap<String, String> isDuplicate(MemberDto dto)
	{
		HashMap<String, String> result = new HashMap<String, String>();
		
		if(service.isDuplicate(dto))
		{
			result.put("result", "fail");
		}
		else
		{
			result.put("result", "success");
		}
		
		return result;
	}
	
	@RequestMapping(value="/member/register")
	public String member_register()
	{
		return "/member/register";
	}
	
	@RequestMapping(value="/member/insert")
	@ResponseBody  //����� JSON  ���·� ����Ѵ�. Ajax�Լ� ȣ���Ҷ� �Լ� �տ� ������̼��� �־�� �Ѵ� 
	public HashMap<String, String> member_insert(MemberDto dto)
	{
		HashMap<String, String> result = new HashMap<String, String>();
		
		service.insert(dto);
		result.put("result", "success");
		
		return result;
	}
	
	@RequestMapping(value="/member/logon")
	public String member_logon()
	{
		return "/member/logon";
	}
	
	@RequestMapping(value="/member/logon_proc")
	@ResponseBody  //����� JSON  ���·� ����Ѵ�. Ajax�Լ� ȣ���Ҷ� �Լ� �տ� ������̼��� �־�� �Ѵ� 
	public HashMap<String, String> member_logon_proc(MemberDto dto, HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		
		HashMap<String, String> result = new HashMap<String, String>();
		
		MemberDto resultDto = service.logon(dto);
		if( resultDto == null)
			result.put("result", "fail1"); //���̵� ���� ���� 
		else 
		{
			if(resultDto.getPasswd().contentEquals(dto.getPasswd()))
			{
				result.put("result", "success");
				session.setAttribute("userid", resultDto.getUserid());
				session.setAttribute("username", resultDto.getUsername());
				session.setAttribute("email", resultDto.getEmail());			
			}
			else
				result.put("result", "fail2"); //�н����� ����ġ 
		}
		
		return result;
	}
	
}









