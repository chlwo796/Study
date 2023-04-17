package org.zerock.web.dao;

import org.zerock.web.vo.MemberVo;

public interface MemberDAO {

	public String getTime();
	
	public void insertMember(MemberVo vo);
}
