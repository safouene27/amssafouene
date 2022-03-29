package com.sip.ams.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sip.ams.entities.Etudiant;

@Controller
public class firstcontroller {
static 	ArrayList<Etudiant> students = new ArrayList<>();
	static {
		students.add (new Etudiant("ala", 25, "alla@gmail.com", "tunis", 20220300));
		students.add (new Etudiant("safouene", 28, "safouene@gmail.com", "sfax", 25630252));
		students.add (new Etudiant("mahdi", 23, "mahdi@gmail.com", "sousse", 55621036));
		
}
	@RequestMapping("/first")
	public String home(Model m)
{
	String nom ="safouene nasri";
	String universite = "ENSI";
	String email = "saf@gmail.com";
	String tel = "+21622563599";


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
	m.addAttribute("students", students);
	return "home/etudiant";
	
	}
@RequestMapping("/add")
public String addetudiant(Model m) {
	return "home/addstudent";
	}

@PostMapping("/save")
public String saveEtudiant(@RequestParam ("nom") String nom,
		@RequestParam ("age") int age,
		@RequestParam ("adresse") String adresse,
		@RequestParam ("email") String email,
		@RequestParam ("tel") int tel) 
{
	Etudiant temp = new Etudiant (nom,age,email,adresse,tel);
	students.add(temp);
	return "redirect:list";
}

@GetMapping("/delete/{email}")
//@ResponseBody
public String deleteetudiant(@PathVariable("email")String mail) {
	Etudiant temp=null ;
	for (Etudiant e : students)
	{
		if(e.getEmail().equals(mail)) {
			temp = e;
					}
		}
	students.remove(temp);
	return "redirect:../list";
	}

}

