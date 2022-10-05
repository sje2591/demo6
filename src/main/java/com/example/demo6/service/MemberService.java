package com.example.demo6.service;

import java.util.List;

import com.example.demo6.dto.MemberDTO;

public interface MemberService {

	List<MemberDTO> selectMemberList();
	MemberDTO selectMemberdetail(String id);
	void updateMember(MemberDTO dto,String id);
	void registermember(MemberDTO dto);
	void removeMember(String paramID);
}
