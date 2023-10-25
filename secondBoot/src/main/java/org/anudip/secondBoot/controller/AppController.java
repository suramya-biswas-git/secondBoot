package org.anudip.secondBoot.controller;

import java.util.List;

import org.anudip.secondBoot.service.FiboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController 
public class AppController {
	@Autowired
	FiboService fService;
	
	@GetMapping("/index")
		public ModelAndView showIndexPage() {
			return new ModelAndView("indexPage");
		}
	@GetMapping("/fibo")
	public  ModelAndView showFiboEntryPage() {
		return new ModelAndView("fiboEntryPage");
	}
	
	@PostMapping("/fibo")
	public  ModelAndView openFiboShowPage(@RequestParam("mynum") int n) {
		List<Integer> fiboList=fService.generateFiboSeries(n);
		ModelAndView mv=new ModelAndView("fiboShowPage");
		mv.addObject("myfibo",fiboList);
		return mv;
		
	}
	

}
