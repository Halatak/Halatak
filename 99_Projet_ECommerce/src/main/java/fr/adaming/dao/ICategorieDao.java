package fr.adaming.dao;
import java.util.List;

import fr.adaming.model.Categorie;

public interface ICategorieDao {

	public Categorie addCategorie(Categorie cat);
	
	public int deleteCategorie(Categorie cat);
	
	public int updateCategorie(Categorie cat);
	
	public List<Categorie> getAllCategorie();
	
	public Categorie getCategorieById(Categorie cat);
	
}
