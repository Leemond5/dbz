package com.app.mvc.dbz.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.mvc.dbz.entities.Tutorial;
import com.app.mvc.dbz.repository.ToturialRepository;

@Service
public class ToturialServiceImpl implements TutorialService {
	@Autowired
	ToturialRepository tutorialRepository;
	@Override
	public Tutorial createTutorial(String title, String description) {
		Tutorial tutorial = new Tutorial();
		tutorial.setTitle(title);
		tutorial.setDescription(description);
		tutorialRepository.save(tutorial);
		return tutorial;
	}
	@Override
	public List<Tutorial> getAllTutorial() {
		List<Tutorial> tutorialList = null;
		tutorialList = tutorialRepository.findAll();
		return tutorialList;
	}
	@Override
	public void delectTutorial (int id) {
//		Tutorial tutorial = tutorialRepository.findById(id).get();
		tutorialRepository.deleteById(id);
//		return tutorial;
	}
}
