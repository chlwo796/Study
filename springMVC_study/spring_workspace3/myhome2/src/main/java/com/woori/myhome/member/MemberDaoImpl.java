package com.woori.myhome.member;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("memberDao")
public class MemberDaoImpl implements MemberDao{

	@Autowired
	SqlSessionTemplate sm;
	
	@Override
	public boolean isDuplicate(MemberDto dto) {
		
		Integer result = sm.selectOne("Member_isDuplicate", dto);
		//selectOne - Object 반환 int 로 바도 못받고 Integer -> int
		if(result==0)
			return false; //중복안됐다 사용가능
		return true; //사용불가 
	}

	@Override
	public void insert(MemberDto dto) {
		sm.insert("Member_insert", dto);
		
	}

	@Override
	public MemberDto logon(MemberDto dto) {
		
		return sm.selectOne("Member_logon", dto);
	}

}






