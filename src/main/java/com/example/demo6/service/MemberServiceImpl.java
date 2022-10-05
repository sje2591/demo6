package com.example.demo6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo6.dto.MemberDTO;
import com.example.demo6.mapper.MemberMapper;
@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	MemberMapper memberMapper;
	public  List<MemberDTO> selectMemberList() {
		// TODO Auto-generated method stub
		return memberMapper.selectMemberList();
	}
	@Override
	public MemberDTO selectMemberdetail(String id) {
		// TODO Auto-generated method stub
		return memberMapper.selectMemberDetail(id);
	}
	@Override
	public void updateMember(MemberDTO dto,String id) {
		// TODO Auto-generated method stub
		 memberMapper.updateMember(dto, id);
	}
	@Override
	public void registermember(MemberDTO dto) {
		// TODO Auto-generated method stub
		memberMapper.insertmember(dto);
	}
	@Override
	public void removeMember(String paramID) {
		// TODO Auto-generated method stub
		memberMapper.deleteMember(paramID);
	}
	}