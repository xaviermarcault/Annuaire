package com.actorep.control;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.actorep.dao.ActeurRepository;
import com.actorep.dao.ServicesRepository;
import com.actorep.model.Acteur;
import com.actorep.model.Adresse;
import com.actorep.model.Categorie;
import com.actorep.model.Employe;
import com.actorep.model.Etat;
import com.actorep.model.Individu;
import com.actorep.model.Organisation;
import com.actorep.model.Parametre;
import com.actorep.model.Pays;
import com.actorep.model.Photo;
import com.actorep.model.Role;
import com.actorep.model.Services;
import com.actorep.model.Ville;
import com.actorep.service.IActorepServiceIndividu;
import com.actorep.service.IActorepServiceOrganisation;
import com.actorep.service.IActorepServiceAdresse;
import com.actorep.service.IActorepServiceCategorie;
import com.actorep.service.IActorepServiceEmploye;
import com.actorep.service.IActorepServiceEtat;
import com.actorep.service.IActorepServiceParametre;
import com.actorep.service.IActorepServicePays;
import com.actorep.service.IActorepServicePhoto;
import com.actorep.service.IActorepServiceRole;
import com.actorep.service.IActorepServiceServices;
import com.actorep.service.IActorepServiceVille;

@Controller
public class ActorepController {

	@Autowired
	private IActorepServiceIndividu actorepServiceIndividu;
	@Autowired
	private IActorepServiceOrganisation actorepServiceOrganisation;
	@Autowired
	private IActorepServiceEmploye actorepServiceEmploye;
	@Autowired
	private IActorepServiceRole actorepServiceRole;
	@Autowired
	private IActorepServiceAdresse actorepServiceAdresse;
	@Autowired
	private IActorepServiceVille actorepServiceVille;
	@Autowired
	private IActorepServicePays actorepServicePays;
	@Autowired
	private IActorepServiceCategorie actorepServiceCategorie;
	@Autowired
	private IActorepServicePhoto actorepServicePhoto;
	@Autowired
	private IActorepServiceServices actorepServiceServices;
	@Autowired
	private IActorepServiceEtat actorepServiceEtat;
	@Autowired
	private IActorepServiceParametre actorepServiceParametre;
	@Autowired
	private ActeurRepository acteurRepository;
	@Autowired
	private ServicesRepository servicesRepository;

	// ******************************************************
	// Méthodes
	// ******************************************************

	/*
	 * public Model addObject(Object object, String string, Model model) { object =
	 * new Object(); return model.addAttribute("string", object); }
	 */

	public Model addPhoto(Model model) {
		Photo photo = new Photo();
		return model.addAttribute("photo", photo);
	}

	public Model addEtat(Model model) {
		Etat etat = new Etat();
		return model.addAttribute("etat", etat);
	}

	public Model addAdresse(Model model) {
		Adresse adresse = new Adresse();
		return model.addAttribute("adresse", adresse);
	}

	public Model addServices(Model model) {
		Services services = new Services();
		return model.addAttribute("services", services);
	}

	public Model addCategorie(Model model) {
		Categorie categorie = new Categorie();
		return model.addAttribute("categorie", categorie);
	}

	public Model addEmploye(Model model) {
		Employe employe = new Employe();
		return model.addAttribute("employe", employe);
	}

	public Model addRole(Model model) {
		Role role = new Role();
		return model.addAttribute("role", role);
	}

	public Model addPays(Model model) {
		Pays pays = new Pays();
		return model.addAttribute("pays", pays);
	}

	public Model addVille(Model model) {
		Ville ville = new Ville();
		return model.addAttribute("ville", ville);
	}

	public Model addParametre(Model model) {
		Parametre parametre = new Parametre();
		return model.addAttribute("parametre", parametre);
	}

	public Model listPhotos(Model model) {
		Collection<Photo> listPhotos = actorepServicePhoto.listPhotos();
		return model.addAttribute("listPhotos", listPhotos);
	}

	public Model listServices(Model model) {
		Collection<Services> listServices = actorepServiceServices.listServices();
		return model.addAttribute("listServices", listServices);
	}

	public Model listEtats(Model model) {
		Collection<Etat> listEtats = actorepServiceEtat.listEtats();
		return model.addAttribute("listEtats", listEtats);
	}

	public Model listCategories(Model model) {
		Collection<Categorie> listCategories = actorepServiceCategorie.listCategories();
		return model.addAttribute("listCategories", listCategories);
	}

	public Model listAdresses(Model model) {
		Collection<Adresse> listAdresses = actorepServiceAdresse.listAdresses();
		return model.addAttribute("listAdresses", listAdresses);
	}

	public Model listRoles(Model model) {
		Collection<Role> listRoles = actorepServiceRole.listRoles();
		return model.addAttribute("listRoles", listRoles);
	}

	// *****************************************************
	// Page d'Accueil Frontend
	// *****************************************************
	
	@RequestMapping("/")
	public String viewHomePage(Model model,@RequestParam (name="page",defaultValue="0")int page,
			@RequestParam(name="motCle",defaultValue="")String mc) {
		
		/* listServices(model); */
	
				Page<Services>lastServices=
				actorepServiceServices.findByServiceLibelleContains(mc, PageRequest.of(0, 3,Direction.DESC,"serviceId"));
				model.addAttribute("lastServices", lastServices);
				
				Page<Organisation>lastOrganisations=
				actorepServiceOrganisation.findByOrganisationNomContains(mc, PageRequest.of(0, 3,Direction.DESC,"acteurId"));
				model.addAttribute("lastOrganisations", lastOrganisations);
				
				
		return "index";
	}
	
	@RequestMapping(value = "/res", method = RequestMethod.GET)
	public String viewSearch(Model model,@RequestParam (name="page",defaultValue="0")int page,
			@RequestParam(name="motCle",defaultValue="")String mc){
		
		model.addAttribute("motCle",mc);
		
		
		Page<Organisation>lastOrganisations=
		actorepServiceOrganisation.findByOrganisationNomContains(mc, PageRequest.of(0, 3,Direction.DESC,"acteurId"));
		model.addAttribute("lastOrganisations", lastOrganisations);
				
		return "resultat";
		
	}
	
	// ****************************************************
	// Affichage Organisation
	// ****************************************************
	
	@RequestMapping("/affichageOrgaFront")
	public String showOrgaFrontEnd(Model model) {
		Collection<Organisation> listOrganisations = actorepServiceOrganisation.listOrganisations();
		model.addAttribute("listOrganisations", listOrganisations);

		addPhoto(model);
		listPhotos(model);
		addServices(model);
		listServices(model);
		
		Collection<Individu> listIndividus = actorepServiceIndividu.listIndividus();
		model.addAttribute("listIndividus", listIndividus);

		listPhotos(model);
		addPhoto(model);
		listServices(model);
		addServices(model);

		
		return "affichageOrgaFront";	
	}
	
		// ****************************************************
		// Affichage Services
		// ****************************************************
	
	@RequestMapping("/affichageServicesFront")
	public String showServicesFrontEnd(Model model) {
		
		listServices(model);
		
		return "affichageServicesFront";		
	}
	
	
	        //****************************************************
			// Affichage Services par Organisation
			// ****************************************************
	
	@RequestMapping ("/affichageServicesOrga/{id}")
	public String showServicesOrga (Model model, @PathVariable(name = "id") int id, 
			@RequestParam (name="page",defaultValue="0")int page,
			@RequestParam(name="motCle",defaultValue="")String mc) {
		  
		
		  Organisation organisation = actorepServiceOrganisation.getOrganisation(id);
		  model.addAttribute("organisation", organisation);
		  
		  Page<Organisation>lastOrganisations=
					actorepServiceOrganisation.findByOrganisationNomContains(mc, 
							PageRequest.of(0, 3,Direction.DESC,"acteurId"));
					model.addAttribute("lastOrganisations", lastOrganisations);
		
		return "affichageServicesOrga";
		
	}
	

    //****************************************************
	// Affichage Services Détails
	// ****************************************************

@RequestMapping ("/affichageServicesDetails/{id}")
public String showServicesDetails (Model model, @PathVariable(name = "id") int id, 
	@RequestParam (name="page",defaultValue="0")int page,
	@RequestParam(name="motCle",defaultValue="")String mc) {
  

  Services service = actorepServiceServices.getService(id);
  model.addAttribute("service", service);
   
  
return "/affichageServicesDetails";

}
	
	// *****************************************************
	// Page Backend
	// *****************************************************

	@RequestMapping("/backend")
	public String viewBackHomePage(Model model) {

		return "backend";
	}
	
	// ****************************************************
	// INDIVIDU
	// ****************************************************

	@RequestMapping("/individu")
	public String showIndividuPage(Model model) {

		Collection<Individu> listIndividus = actorepServiceIndividu.listIndividus();
		model.addAttribute("listIndividus", listIndividus);

		listPhotos(model);
		addPhoto(model);
		listServices(model);
		addServices(model);

		return "individu";
	}

	@RequestMapping("/new/individu")
	public String showNewIndividuPage(Model model) {

		Individu individu = new Individu();
		model.addAttribute("individu", individu);

		listEtats(model);
		addEtat(model);
		listCategories(model);
		addCategorie(model);
		listAdresses(model);
		addAdresse(model);

		return "new_individu";
	}

	@RequestMapping(value = "/save/individu", method = RequestMethod.POST)
	public String saveIndividu(@ModelAttribute("individu") Individu individu) {
		actorepServiceIndividu.saveIndividu(individu);

		return "redirect:/individu";
	}

	@RequestMapping("/edit/individu/{id}")
	public ModelAndView showEditIndividuPage(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("edit_individu");
		Individu individu = actorepServiceIndividu.getIndividu(id);
		mav.addObject("individu", individu);

		Collection<Etat> listEtats = actorepServiceEtat.listEtats();
		mav.addObject("listEtats", listEtats);

		Etat etat = new Etat();
		mav.addObject("etat", etat);

		Collection<Categorie> listCategories = actorepServiceCategorie.listCategories();
		mav.addObject("listCategories", listCategories);

		Categorie categorie = new Categorie();
		mav.addObject("categorie", categorie);

		Collection<Adresse> listAdresses = actorepServiceAdresse.listAdresses();
		mav.addObject("listAdresses", listAdresses);

		Adresse adresse = new Adresse();
		mav.addObject("adresse", adresse);

		return mav;
	}

	@RequestMapping("/delete/individu/{id}")
	public String deleteIndividu(@PathVariable(name = "id") int id) {
		actorepServiceIndividu.deleteIndividu(id);

		return "redirect:/individu";
	}

	// ****************************************************
	// ORGANISATION
	// ****************************************************

	@RequestMapping("/organisation")
	public String showOrganisationPage(Model model) {

		Collection<Organisation> listOrganisations = actorepServiceOrganisation.listOrganisations();
		model.addAttribute("listOrganisations", listOrganisations);

		addPhoto(model);
		listPhotos(model);
		addServices(model);
		listServices(model);

		return "organisation";
	}

	@RequestMapping("/new/organisation")
	public String showNewOrganisationPage(Model model) {

		Organisation organisation = new Organisation();
		model.addAttribute("organisation", organisation);

		listEtats(model);
		addEtat(model);
		listCategories(model);
		addCategorie(model);
		listAdresses(model);
		addAdresse(model);

		return "new_organisation";
	}

	@RequestMapping(value = "/save/organisation", method = RequestMethod.POST)
	public String saveOrganisation(@ModelAttribute("organisation") Organisation organisation) {
		actorepServiceOrganisation.saveOrganisation(organisation);

		return "redirect:/organisation";
	}

	@RequestMapping("/edit/organisation/{id}")
	public ModelAndView showEditOrganisationPage(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("edit_organisation");
		Organisation organisation = actorepServiceOrganisation.getOrganisation(id);
		mav.addObject("organisation", organisation);

		Collection<Etat> listEtats = actorepServiceEtat.listEtats();
		mav.addObject("listEtats", listEtats);

		Etat etat = new Etat();
		mav.addObject("etat", etat);

		Collection<Categorie> listCategories = actorepServiceCategorie.listCategories();
		mav.addObject("listCategories", listCategories);

		Categorie categorie = new Categorie();
		mav.addObject("categorie", categorie);

		Collection<Adresse> listAdresses = actorepServiceAdresse.listAdresses();
		mav.addObject("listAdresses", listAdresses);

		Adresse adresse = new Adresse();
		mav.addObject("adresse", adresse);

		return mav;
	}

	@RequestMapping("/delete/organisation/{id}")
	public String deleteOrganisation(@PathVariable(name = "id") int id) {
		actorepServiceOrganisation.deleteOrganisation(id);

		return "redirect:/organisation";
	}

	// ****************************************************
	// EMPLOYE
	// ****************************************************

	@RequestMapping("/employe")
	public String showEmployePage(Model model) {
		Collection<Employe> listEmployes = actorepServiceEmploye.listEmployes();
		model.addAttribute("listEmployes", listEmployes);
		return "employe";
	}

	@RequestMapping("/new/employe")
	public String showNewEmployePage(Model model) {

		addEmploye(model);
		listRoles(model);
		addRole(model);

		return "new_employe";
	}

	@RequestMapping(value = "/save/employe", method = RequestMethod.POST)
	public String saveEmploye(@ModelAttribute("employe") Employe employe) {
		actorepServiceEmploye.saveEmploye(employe);

		return "redirect:/employe";
	}

	@RequestMapping("/edit/employe/{id}")
	public ModelAndView showEditEmployePage(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("edit_employe");
		Employe employe = actorepServiceEmploye.getEmploye(id);
		mav.addObject("employe", employe);

		Collection<Role> listRoles = actorepServiceRole.listRoles();
		mav.addObject("listRoles", listRoles);

		return mav;
	}

	@RequestMapping("/delete/employe/{id}")
	public String deleteEmploye(@PathVariable(name = "id") int id) {
		actorepServiceEmploye.deleteEmploye(id);

		return "redirect:/employe";
	}

	// *****************************************************
	// ROLE
	// *****************************************************

	@RequestMapping("/role")
	public String showRolePage(Model model) {

		listRoles(model);

		return "role";
	}

	@RequestMapping("/new/role")
	public String showNewRolePage(Model model) {

		addRole(model);

		return "new_role";
	}

	@RequestMapping(value = "/save/role", method = RequestMethod.POST)
	public String saveRole(@ModelAttribute("role") Role role) {
		actorepServiceRole.saveRole(role);

		return "redirect:/role";
	}

	@RequestMapping("/edit/role/{id}")
	public ModelAndView showEditRolePage(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("edit_role");
		Role role = actorepServiceRole.getRole(id);
		mav.addObject("role", role);

		Collection<Role> listRoles = actorepServiceRole.listRoles();
		mav.addObject("listRoles", listRoles);

		return mav;
	}

	@RequestMapping("/delete/role/{id}")
	public String deleteRole(@PathVariable(name = "id") int id) {
		actorepServiceRole.deleteRole(id);

		return "redirect:/role";
	}

	// *****************************************************
	// ADRESSE
	// *****************************************************

	@RequestMapping("/adresse")
	public String showAdressePage(Model model) {

		listAdresses(model);

		return "adresse";
	}

	@RequestMapping("/new/adresse")
	public String newAdressePage(Model model) {

		addAdresse(model);

		Collection<Ville> listVilles = actorepServiceVille.listVilles();
		model.addAttribute("listVilles", listVilles);

		return "new_adresse";
	}

	@RequestMapping(value = "/save/adresse", method = RequestMethod.POST)
	public String saveAdresse(@ModelAttribute("adresse") Adresse adresse) {
		actorepServiceAdresse.saveAdresse(adresse);

		return "redirect:/adresse";
	}

	@RequestMapping("/edit/adresse/{id}")
	public ModelAndView showEditAdressePage(@PathVariable(name = "id") int id) {

		Adresse adresse = actorepServiceAdresse.getAdresse(id);
		ModelAndView mav = new ModelAndView("edit_adresse");
		mav.addObject("adresse", adresse);

		Collection<Ville> listVilles = actorepServiceVille.listVilles();
		mav.addObject("listVilles", listVilles);

		Collection<Pays> listPays = actorepServicePays.listPays();
		mav.addObject("listPays", listPays);

		return mav;
	}

	@RequestMapping("/delete/adresse/{id}")
	public String deleteAdresse(@PathVariable(name = "id") int id) {
		actorepServiceAdresse.deleteAdresse(id);

		return "redirect:/adresse";
	}

	// *****************************************************
	// VILLE
	// *****************************************************

	@RequestMapping("/ville")
	public String showVillePage(Model model) {
		Collection<Ville> listVilles = actorepServiceVille.listVilles();
		model.addAttribute("listVilles", listVilles);

		addPays(model);

		return "ville";
	}

	@RequestMapping("/new/ville")
	public String showNewVillePage(Model model) {

		addVille(model);
		addPays(model);

		Collection<Pays> listPays = actorepServicePays.listPays();
		model.addAttribute("listPays", listPays);

		return "new_ville";
	}

	@RequestMapping(value = "/save/ville", method = RequestMethod.POST)
	public String saveVille(@ModelAttribute("ville") Ville ville) {
		actorepServiceVille.saveVille(ville);

		return "redirect:/ville";
	}

	@RequestMapping("/edit/ville/{id}")
	public ModelAndView showEditVillePage(@PathVariable(name = "id") int id) {
		Ville ville = actorepServiceVille.getVille(id);
		ModelAndView mav = new ModelAndView("edit_ville");
		mav.addObject("ville", ville);

		Collection<Pays> listPays = actorepServicePays.listPays();
		mav.addObject("listPays", listPays);

		return mav;
	}

	@RequestMapping("/delete/ville/{id}")
	public String deleteVille(@PathVariable(name = "id") int id) {
		actorepServiceVille.deleteVille(id);

		return "redirect:/ville";
	}

	// *****************************************************
	// PAYS
	// *****************************************************

	@RequestMapping("/pays")
	public String showPaysPage(Model model) {
		Collection<Pays> listPays = actorepServicePays.listPays();
		model.addAttribute("listPays", listPays);
		return "pays";
	}

	@RequestMapping("/new/pays")
	public String showNewPaysPage(Model model) {

		addPays(model);

		return "new_pays";
	}

	@RequestMapping(value = "/save/pays", method = RequestMethod.POST)
	public String savePays(@ModelAttribute("pays") Pays pays) {
		actorepServicePays.savePays(pays);

		return "redirect:/pays";
	}

	@RequestMapping("/edit/pays/{id}")
	public ModelAndView showEditPaysPage(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("edit_pays");
		Pays pays = actorepServicePays.getPays(id);
		mav.addObject("pays", pays);

		Collection<Pays> listPays = actorepServicePays.listPays();
		mav.addObject("listPays", listPays);

		return mav;
	}

	@RequestMapping("/delete/pays/{id}")
	public String deletePays(@PathVariable(name = "id") int id) {
		actorepServicePays.deletePays(id);

		return "redirect:/pays";
	}

	// *****************************************************
	// CATEGORIE
	// *****************************************************

	@RequestMapping("/categorie")
	public String showCategoriePage(Model model) {

		listCategories(model);

		return "categorie";
	}

	@RequestMapping("/new/categorie")
	public String showNewCategoriePage(Model model) {

		addCategorie(model);

		return "new_categorie";
	}

	@RequestMapping(value = "/save/categorie", method = RequestMethod.POST)
	public String saveCategorie(@ModelAttribute("categorie") Categorie categorie) {
		actorepServiceCategorie.saveCategorie(categorie);

		return "redirect:/categorie";
	}

	@RequestMapping("/edit/categorie/{id}")
	public ModelAndView showEditCategoriePage(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("edit_categorie");
		Categorie categorie = actorepServiceCategorie.getCategorie(id);
		mav.addObject("categorie", categorie);

		Collection<Categorie> listCategories = actorepServiceCategorie.listCategories();
		mav.addObject("listCategories", listCategories);

		return mav;
	}

	@RequestMapping("/delete/categorie/{id}")
	public String deleteCategorie(@PathVariable(name = "id") int id) {
		actorepServiceCategorie.deleteCategorie(id);

		return "redirect:/categorie";
	}

	// *****************************************************
	// PHOTO
	// *****************************************************

	@RequestMapping("/photo")
	public String showPhotoPage(Model model) {

		listPhotos(model);

		return "photo";
	}

	@RequestMapping("/new/photo")
	public String showNewPhotoPage(Model model) {

		addPhoto(model);

		return "new_photo";
	}

	@RequestMapping(value = "/save/photo", method = RequestMethod.POST)
	public String savePhoto(@ModelAttribute("photo") Photo photo) {
		actorepServicePhoto.savePhoto(photo);

		return "redirect:/photo";
	}

	@RequestMapping("/edit/photo/{id}")
	public ModelAndView showEditPhotoPage(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("edit_photo");
		Photo photo = actorepServicePhoto.getPhoto(id);
		mav.addObject("photo", photo);

		return mav;
	}

	@RequestMapping("/delete/photo/{id}")
	public String deletePhoto(@PathVariable(name = "id") int id) {
		actorepServicePhoto.deletePhoto(id);

		return "redirect:/photo";
	}

	// *****************************************************
	// SERVICES
	// *****************************************************

	@RequestMapping("/services")
	public String showServicesPage(Model model) {

		listServices(model);

		return "services";
	}

	@RequestMapping("/new/services")
	public String showNewServicesPage(Model model) {

		addServices(model);

		return "new_services";
	}

	@RequestMapping(value = "/save/services", method = RequestMethod.POST)
	public String saveServices(@ModelAttribute("services") Services services) {
		actorepServiceServices.saveService(services);

		return "redirect:/services";
	}

	@RequestMapping("/edit/services/{id}")
	public ModelAndView showEditServicesPage(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("edit_services");
		Services services = actorepServiceServices.getService(id);
		mav.addObject("services", services);

		Acteur acteur = new Acteur();
		mav.addObject("acteur", acteur);
		
		Organisation organisation = new Organisation();
		mav.addObject("organisation", organisation);

		return mav;
	}

	@RequestMapping("/delete/services/{id}")
	public String deleteServices(@PathVariable(name = "id") int id) {
		actorepServiceServices.deleteService(id);

		return "redirect:/services";
	}

	// ****************************************************
	// ETAT
	// ****************************************************

	@RequestMapping("/etat")
	public String showEtatPage(Model model) {

		listEtats(model);

		return "etat";
	}

	@RequestMapping("/new/etat")
	public String showNewEtatPage(Model model) {

		addEtat(model);

		return "new_etat";
	}

	@RequestMapping(value = "/save/etat", method = RequestMethod.POST)
	public String saveEtat(@ModelAttribute("etat") Etat etat) {
		actorepServiceEtat.saveEtat(etat);

		return "redirect:/etat";
	}

	@RequestMapping("/edit/etat/{id}")
	public ModelAndView showEditEtatPage(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("edit_etat");
		Etat etat = actorepServiceEtat.getEtat(id);
		mav.addObject("etat", etat);

		return mav;
	}

	@RequestMapping("/delete/etat/{id}")
	public String deleteEtat(@PathVariable(name = "id") int id) {
		actorepServiceEtat.deleteEtat(id);

		return "redirect:/etat";
	}

	// ****************************************************
	// PARAMETRE
	// ****************************************************

	@RequestMapping("/parametre")
	public String showParametrePage(Model model) {
		Collection<Parametre> listParametres = actorepServiceParametre.listParametres();
		model.addAttribute("listParametres", listParametres);
		return "parametre";
	}

	@RequestMapping("/new/parametre")
	public String showNewParametrePage(Model model) {

		addParametre(model);

		return "new_parametre";
	}

	@RequestMapping(value = "/save/parametre", method = RequestMethod.POST)
	public String saveParametre(@ModelAttribute("parametre") Parametre parametre) {
		actorepServiceParametre.saveParametre(parametre);

		return "redirect:/parametre";
	}

	@RequestMapping("/edit/parametre/{id}")
	public ModelAndView showEditParameterPage(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("edit_parametre");
		Parametre parametre = actorepServiceParametre.getParametre(id);
		mav.addObject("parametre", parametre);

		return mav;
	}

	@RequestMapping("/delete/parametre/{id}")
	public String deleteParametre(@PathVariable(name = "id") int id) {
		actorepServiceParametre.deleteParametre(id);

		return "redirect:/parametre";
	}

}
