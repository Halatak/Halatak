package fr.adaming.service;

import java.util.List;

import javax.ejb.Local;

import fr.adaming.model.Categorie;
import fr.adaming.model.Produit;

@Local
public interface IProduitService {

	public Produit addProduit(Produit prod, Categorie cat);
	
	public int deleteProduit(Produit prod, Categorie cat);
	
	public int updateProduit(Produit prod, Categorie cat);
	
	public Produit getProduit(Produit prod, Categorie cat);
		
	public List<Produit> getAllProduits();
	
	public List<Produit> getProdByCat(Categorie cat);
	
	public List<Produit> getProdByIdCat(Categorie cat);
}
