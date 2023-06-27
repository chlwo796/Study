package com.ezen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.dto.MemberDto;
import com.ezen.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService<String, MemberDto> {

	@Autowired
	MemberMapper<String, MemberDto> member;

	@Override
	public void register(MemberDto v) throws Exception {
		member.insert(v);
	}

	@Override
	public void remove(String k) throws Exception {
		member.delete(k);
	}

	@Override
	public void modify(MemberDto v) throws Exception {
		member.update(v);
	}

	@Override
	public MemberDto get(String k) throws Exception {
		return member.select(k);
	}

	@Override
	public List<MemberDto> get() throws Exception {
		return member.selectall();
	}
}