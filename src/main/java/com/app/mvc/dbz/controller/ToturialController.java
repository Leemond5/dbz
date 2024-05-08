package com.app.mvc.dbz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.mvc.dbz.entities.Tutorial;
import com.app.mvc.dbz.services.TutorialService;



@Controller
public class ToturialController {
	@Autowired
	TutorialService tutorialService;

	@GetMapping("/tutorial")
	public String getTutorial(Model model) {
		List<Tutorial> tutorials = tutorialService.getAllTutorial();
		model.addAttribute("tutorialList", tutorials);
		return "tutorial/index";
	}

	@PostMapping("/create")
	public String createTutorial(@RequestParam("title") String title, @RequestParam("description") String description) {
		tutorialService.createTutorial(title, description);
		return "index";

	}
	@GetMapping("/tutorial/{id}")
	public String deleteTutorial(@PathVariable int id) {
		String result ="redirect:/tutorial";
		tutorialService.delectTutorial(id);
		return result;
	}
	
}
