package com.example.demo6.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo6.dto.MemberDTO;
@Mapper
public interface MemberMapper {
	
	List<MemberDTO> selectMemberList();
	MemberDTO  selectMemberDetail(@Param("ID") String id);
	void updateMember(@Param("member") MemberDTO dto, @Param("ID") String id);
	void insertmember(MemberDTO dto);
	void deleteMember(@Param("paramID") String paramID);
}