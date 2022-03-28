package com.sip.ams.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sip.ams.entities.Etudiant;

@Controller
public class firstcontroller {
@RequestMapping("/first")
	public String home(Model m)
{
	String nom ="safouene nasri";
	String universite = "ENSI";
	String email = "safouenov@gmail.com";
	String tel = "+21658623166";


	m.addAttribute("name",nom);
	m.addAttribute( "myUniversite",universite);
	m.addAttribute("mail", email);
	m.addAttribute("telephone", tel);

	ArrayList<String> cours = new ArrayList<>();
	cours.add("java OCA");
	cours.add("java OCP");
	cours.add("Spring");
	cours.add("Microservices");
	m.addAttribute("cours", cours);
return"/home/app";
	}
@RequestMapping("/list")
public String etudiant(Model m) {
	ArrayList<Etudiant> students = new ArrayList<>();
	students.add (new Etudiant("ala", 25, "alla@gmail.com", "tunis", 20220300));
	students.add (new Etudiant("safouene", 28, "safouene@gmail.com", "sfax", 25630252));
	students.add (new Etudiant("mahdi", 23, "mahdi@gmail.com", "sousse", 55621036));
	m.addAttribute("students", students);
	

	return "home/etudiant";
}
@RequestMapping("/add")
public String addetudiant(Model m) {
	return "home/addstudent";
}
}

