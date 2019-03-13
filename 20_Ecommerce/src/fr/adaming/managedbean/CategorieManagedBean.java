package fr.adaming.managedbean;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import fr.adaming.model.Categorie;
import fr.adaming.service.ICategorieService;

@ManagedBean(name = "catMB")
@RequestScoped

public class CategorieManagedBean implements Serializable {

	// Déclaration des attributs
	private Categorie cat;

	// transformation de l'association UML en JAVA
	@EJB
	private ICategorieService catService;

	// constructeur
	public CategorieManagedBean() {
		this.cat = new Categorie();
	}

	// getters & setters
	public Categorie getCat() {
		return cat;
	}

	public void setCat(Categorie cat) {
		this.cat = cat;
	}

	// Déclaration des méthodes métiers

	public String ajouterCategorie() {
		
		Categorie catIn = catService.addCategorie(cat);
		
		if (catIn != null){
			return "accueilAdmin";
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("Echec de l'ajout de la catégorie"));

			return "ajoutCategorie";
		}
	}
	
	public String supprimerCategorie() {
		
		int verifSupprimer = catService.deleteCategorie(cat);
		
		if (verifSupprimer != 0) {
			return "accueilAdmin";
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("Echec de la suppression de la catégorie"));

			return "supprCategorie";
		}
	}
	
	public String modifierCategorie() {
		
		int verifModifier = catService.updateCategorie(cat);
		
		if (verifModifier != 0 ){
			return "accueilAdmin";
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("Echec de la modification de la catégorie"));

			return "modifCategorie";
		
		}
	}
	
}