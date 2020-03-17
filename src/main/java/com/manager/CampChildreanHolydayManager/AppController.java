package com.manager.CampChildreanHolydayManager;


import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AppController {
	

	
	@RequestMapping( "/")
	  String indexAccueil(){
	    return "Accueil";
	  }
	
	@RequestMapping("/P-Fixe")
	  String indexProgrammeFixe(){
	    return "P-Fixe";
	  }
	@RequestMapping("/P-Pedaogique")
	  String indexProgrammePedaogique(){
	    return "P-Pedaogique";
	  }
	
	@RequestMapping("/p-General")
	  String indexProgrammeGeneral(){
	    return "p-General";
	  }
	
	@RequestMapping("/connexion")
	  String indexConnexion(){
	    return "connexion";
	  }
		          ////////////Personne//////////////
	
	  @Autowired
	    private PersonneService service;
	  // enregistre new personne
	  @RequestMapping("/Ajouter_Personne")
	  public String showNewProductPage(Model model) {
		  Personne personne = new Personne();
	      model.addAttribute("personne", personne);
	       
	      return "new_personne";
	  }
	  // enregistre  new inscription
	  @RequestMapping(value = "/save", method = RequestMethod.POST)
	  public String savePersonne(@ModelAttribute("personne") Personne personne) {
	      service.save(personne);
	       
	      return "redirect:/Ajouter_Personne";
	  }
	  //affiche la liste de personne
	  @RequestMapping("/affiche_personne")
	  public String viewHomePage( Model model) {
		  List<Personne> listPersonne = service.listAll();
		  model.addAttribute("listPersonne",listPersonne);
		  return "affiche_personne";
		  
	  }
	 //page edit
	  @RequestMapping("/personne/edit/{id}")
	  public ModelAndView showEditPersonnePage(@PathVariable(name = "id") int id) {
	      ModelAndView mav = new ModelAndView("edit_personne");
	      Personne personne = service.get(id);
	      mav.addObject("personne", personne);
	      return mav;
	  }
	  
	
	  
	  // page delete de personne
	  @RequestMapping("/personne/delete/{id}")
	  public String deletePersonne(@PathVariable(name = "id") int id) {
	      service.delete(id);
	      return "redirect:/affiche_personne";       
	  }
	  
	  								/*Benificier*/
	  
	  @Autowired
	    private BenificierService Bservice;
	  
	  // enregistre new Benificier
	  @RequestMapping("/Ajouter_Benificier")
	  public String showNewBenificierPage(Model model) {
		  Benificier benificier = new Benificier();
	      model.addAttribute("benificier", benificier);
	       
	      return "new_benificier";
	  }
	  
	  // enregistre  new Benificier
	  @RequestMapping(value = "/save2", method = RequestMethod.POST)
	  public String saveBenificier(@ModelAttribute("benificier") Benificier benificier) {
	      Bservice.save(benificier);
	       
	      return "redirect:/inscriptionBenificier";
	  }
	
	  //affiche la liste de Benificier
	  @RequestMapping("/affiche_Benificier")
	  public String viewPage( Model model) {
		  List<Benificier> listBenificier = Bservice.listAll();
		  model.addAttribute("listBenificier",listBenificier);
		  return "affiche_benificier";
		  
	  }
	
	 //page edit
	  @RequestMapping("/benificier/edit/{id}")
	  public ModelAndView showEditBenificierPage(@PathVariable(name = "id") int id) {
	      ModelAndView mav = new ModelAndView("edit_benificier");
	      Benificier benificier = Bservice.get(id);
	      mav.addObject("benificier", benificier);
	      return mav;
	  }
	  
	 
	  // page delete Benificier
	  @RequestMapping("/benificier/delete/{id}")
	  public String deleteBenificier(@PathVariable(name = "id") int id) {
	      Bservice.delete(id);
	      return "redirect:/affiche_Benificier";       
	  }
	  
	  
	  
	  						////// FicheMedicale  /////

	  @Autowired
	    private FicheMedicaleService FMservice;
	  // enregistre new Fiche Medicale
	  @RequestMapping("/Ajouter_fiche_medicale")
	  public String showNewFicheMedicalePage(Model model) {
		  FicheMedicale fichemedicale = new FicheMedicale();
	      model.addAttribute("fichemedicale", fichemedicale);
	       
	      return "new_fichemedicale";
	  }
	  // enregistre  new inscription 
	  @RequestMapping(value = "/saveFicheMedicale", method = RequestMethod.POST)
	  public String saveFicheMedicale(@ModelAttribute("fichemedicale") FicheMedicale fichemedicale) {
	      FMservice.save(fichemedicale);
	       
	      return "redirect:/Ajouter_fiche_medicale";
	  }
	  //affiche la liste de Fiche Medicale
	  @RequestMapping("/affiche_fichemedicale")
	  public String viewPageFicheMedicale( Model model) {
		  List<FicheMedicale> listFicheMedicale = FMservice.listAll();
		  model.addAttribute("listFicheMedicale",listFicheMedicale);
		  return "affiche_FicheMedicale";
		  
	  }
	  
	  						////////programmealimentaire////////
	  @Autowired
	    private ProgrammeAlimentaireService PAservice;
	  // enregistre  programme alimentaire
	  @RequestMapping("/programmealimentaire")
	  public String showNewProgrammeAlimentairePage(Model model) {
		  ProgrammeAlimentaire programmealimentaire = new ProgrammeAlimentaire();
	      model.addAttribute("programmealimentaire", programmealimentaire);
	       
	      return "new_programmealimentaire";
	  }
	  // enregistre  new inscription
	  @RequestMapping(value = "/saveprogrammealimentaire", method = RequestMethod.POST)
	  public String saveProgrammeAlimentaire(@ModelAttribute("programmealimentaire") ProgrammeAlimentaire programmealimentaire) {
	      PAservice.save(programmealimentaire);
	       
	      return "redirect:/programmealimentaire";
	  }
	  //affiche la liste de programme alimentaire
	  @RequestMapping("/affiche_programmealimentaire")
	  public String viewHomeProgrammeAlimentairePage( Model model) {
		  List<ProgrammeAlimentaire> listProgrammeAlimentaire = PAservice.listAll();
		  model.addAttribute("listProgrammeAlimentaire",listProgrammeAlimentaire);
		  return "affiche_programmealimentaire";
		  
	  }
	 //page edit
	  @RequestMapping("/programmealimentaire/edit/{id}")
	  public ModelAndView showEditProgrammeAlimentairePage(@PathVariable(name = "id") int id) {
	      ModelAndView mav = new ModelAndView("edit_programmealimentaire");
	      ProgrammeAlimentaire programmealimentaire = PAservice.get(id);
	      mav.addObject("programmealimentaire", programmealimentaire);
	      return mav;
	  }
	  
	
	  
	  // page delete de programme alimentaire
	  @RequestMapping("/programmealimentaire/delete/{id}")
	  public String deleteProgrammeAlimentaire(@PathVariable(name = "id") int id) {
	      service.delete(id);
	      return "redirect:/";       
	  }
	  
	  //choose file
	  @RequestMapping("/")
	  public class FileUploadController {

	      @GetMapping
	      public String main() {
	          return "index";
	      }

	      @PostMapping
	      public String upload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
	          redirectAttributes.addFlashAttribute("message", "You successfully uploaded " + file.getOriginalFilename() + "!");

	          return "redirect:/";
	      }
	  }
	  //download file
	  
	  							//////Activite///////
	  @Autowired
	    private ActiviteService Aservice;
	  // enregistre new Activite
	  @RequestMapping("/activite")
	  public String showNewActivitePage(Model model) {
		  Activite activite = new Activite();
	      model.addAttribute("activite", activite);
	       
	      return "new_activite";
	  }
	  // enregistre  new activite
	  @RequestMapping(value = "/saveactivite", method = RequestMethod.POST)
	  public String saveActivite(@ModelAttribute("activite") Activite activite) {
	      Aservice.save(activite);
	       
	      return "redirect:/activite";
	  }
	//affiche la liste de activite
	  @RequestMapping("/affiche_activite")
	  public String viewHomeactivitePage( Model model) {
		  List<Activite> listActivite = Aservice.listAll();
		  model.addAttribute("listActivite",listActivite);
		  return "affiche_activite";
		  
	  }
	 //page edit activite id
	  @RequestMapping("/activite/edit/{id}")
	  public ModelAndView showEditActivitePage(@PathVariable(name = "id") int id) {
	      ModelAndView mav = new ModelAndView("edit_activite");
	      Activite activite = Aservice.get(id);
	      mav.addObject("activite", activite);
	      return mav;
	  }
	  
	
	  
	  // page delete de activite
	  @RequestMapping("/activite/delete/{id}")
	  public String deleteActivite(@PathVariable(name = "id") int id) {
	      Aservice.delete(id);
	      return "redirect:/affiche_activite";       
	  }
	  
	  
	  					/////Moniteur//////
	  
	  @Autowired
	    private MoniteurService Mservice;
	  // enregistre new personne
	  @RequestMapping("/moniteur")
	  public String showNewMoniteurPage(Model model) {
		  Moniteur moniteur = new Moniteur();
	      model.addAttribute("moniteur", moniteur);
	       
	      return "new_moniteur";
	  }
	  // enregistre  new inscription
	  @RequestMapping(value = "/savemoniteur", method = RequestMethod.POST)
	  public String saveMoniteur(@ModelAttribute("moniteur") Moniteur moniteur) {
	      Mservice.save(moniteur);
	       
	      return "redirect:/moniteur";
	  }
	  //affiche la liste de personne
	  @RequestMapping("/affiche_moniteur")
	  public String viewHomeMoniteurPage( Model model) {
		  List<Moniteur> listMoniteur = Mservice.listAll();
		  model.addAttribute("listMoniteur",listMoniteur);
		  return "affiche_moniteur";
		  
	  }
	 //page edit
	  @RequestMapping("/moniteur/edit/{id}")
	  public ModelAndView showEditMoniteurPage(@PathVariable(name = "id") int id) {
	      ModelAndView mav = new ModelAndView("edit_moniteur");
	      Moniteur moniteur = Mservice.get(id);
	      mav.addObject("moniteur", moniteur);
	      return mav;
	  }
	  
	
	  
	  // page delete de personne
	  @RequestMapping("/moniteur/delete/{id}")
	  public String deleteMoniteur(@PathVariable(name = "id") int id) {
	      Mservice.delete(id);
	      return "redirect:/affiche_moniteur";       
	  }
	  
}
