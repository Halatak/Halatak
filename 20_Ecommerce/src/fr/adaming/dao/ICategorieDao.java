package fr.adaming.dao;

import fr.adaming.model.Categorie;

@Local
public interface ICategorieDao {

	public Categorie addCategorie(Categorie cat);
	
	public int deleteCategorie(Categorie cat);
	
	public int updateCategorie(Categorie cat);
	
	
}