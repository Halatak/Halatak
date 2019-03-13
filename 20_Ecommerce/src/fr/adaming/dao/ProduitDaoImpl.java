package fr.adaming.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.adaming.model.Categorie;
import fr.adaming.model.Produit;

public class ProduitDaoImpl implements IProduitDao {

	@PersistenceContext(unitName="PU_EC") //cette annotation permet d'injecter un em instanci� par le conteneur ejb
	private EntityManager em;
	
	@Override
	public Produit addProduit(Produit prod) {
		em.persist(prod);
		return prod;
	}

	@Override
	public int deleteProduit(Produit prod) {
		String req="DELETE Produit p WHERE p.id=:pId";
		//recuperer un objet de type query
		Query queryListe=em.createQuery(req);
		
		queryListe.setParameter("pId", prod.getIdProduit());
		return queryListe.executeUpdate();
	}

	@Override
	public int updateProduit(Produit prod) {
		String req="UPDATE Produit p SET p.designation=:pDesignation, p.description=:pDescription, p.prix=:pPrix, p.quantite=:pQuantite, p.selectionne=:pSelectionne, p.photo=:pPhoto WHERE p.id=:pId";
		//recuperer un objet de type query
		Query queryListe=em.createQuery(req);
		
		//passage des parametres
		queryListe.setParameter("pDesignation", prod.getDesignation());
		queryListe.setParameter("pDescription", prod.getDescription());
		queryListe.setParameter("pPrix", prod.getPrix());
		queryListe.setParameter("pQuantite", prod.getQuantite());
		queryListe.setParameter("pSelectionne", prod.isSelectionne());
		queryListe.setParameter("pPhoto", prod.getPhoto());
		queryListe.setParameter("pId", prod.getIdProduit());
		
		return queryListe.executeUpdate();
	}
	

	@Override
	public Produit getProduit(Produit prod) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Produit> getAllProduits() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Produit> getProdByCat(Categorie cat) {
		// TODO Auto-generated method stub
		return null;
	}

}
