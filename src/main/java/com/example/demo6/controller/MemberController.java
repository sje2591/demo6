package com.example.demo6.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo6.dto.MemberDTO;
import com.example.demo6.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	MemberService memberService;

	@RequestMapping("/member/list")
	public ModelAndView memberlist() {
		ModelAndView mv = new ModelAndView("/member/list");
		List<MemberDTO> list = memberService.selectMemberList();
		mv.addObject("list", list);
		return mv;
	}
	
	@RequestMapping("/member/register-form")
	public ModelAndView insertFormMember() {
		ModelAndView mv = new ModelAndView("/member/registerForm");
		return mv;
	}
	
	@RequestMapping("/member/register")
	public ModelAndView insertMember(MemberDTO dto, HttpServletRequest request) {
		memberService.registermember(dto);
		ModelAndView mv = new ModelAndView("redirect:" + request.getContextPath() + "/member/list");
		return mv;
	}
	
	@RequestMapping("/")
	public ModelAndView main() {
		ModelAndView mv = new ModelAndView("/main");
		return mv;
	}

	@RequestMapping("/member/detail")
	public ModelAndView memberdetail(@RequestParam String id) {
		ModelAndView mv = new ModelAndView("/member/detail");
		MemberDTO member = memberService.selectMemberdetail(id);
		mv.addObject("member", member);
		return mv;
	}

	@RequestMapping("/member/update-form")
	public ModelAndView updateform(@RequestParam String id) {
		ModelAndView mv = new ModelAndView("/member/updateForm");
		mv.addObject("id", id);
		return mv;
	}

	@RequestMapping("/member/update")
	public ModelAndView updatemember(MemberDTO dto, @RequestParam String hiddenid) {
		ModelAndView mv = new ModelAndView("redirect:/member/list");
		memberService.updateMember(dto,hiddenid);
		return mv;
	}
	
	@RequestMapping("/member/delete-form")
	public ModelAndView deleteMember(
			@RequestParam String id) {
		memberService.removeMember(id);
		ModelAndView mv = new ModelAndView("redirect:/member/list");
		return mv;
	}
}