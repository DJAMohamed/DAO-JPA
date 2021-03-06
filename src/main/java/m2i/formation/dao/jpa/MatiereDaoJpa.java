package m2i.formation.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import m2i.formation.Application;
import m2i.formation.dao.IMatiereDao;
import m2i.formation.model.Difficulte;
import m2i.formation.model.Matiere;

public class MatiereDaoJpa implements IMatiereDao {

	@Override
	public List<Matiere> findAll() {
		EntityManager em = null;
		EntityTransaction tx = null;
		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			
			
			
			
			tx.commit(); 
		} catch (Exception e) {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (em != null) {
				em.close();
			}
		}
		return null;
	}

	@Override
	public Matiere find(Long id) {
		Matiere matiere = null;
		EntityManager em = null;
		EntityTransaction tx = null;
		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			matiere = em.find(Matiere.class, id);
			tx.commit(); 
		} catch (Exception e) {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (em != null) {
				em.close();
			}
		}
		return matiere;
	}

	@Override
	public void create(Matiere obj) {
		EntityManager em = null;
		EntityTransaction tx = null;
		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			em.persist(obj);
			tx.commit(); 
		} catch (Exception e) {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	@Override
	public Matiere update(Matiere obj) {
		Matiere matiere = null;
		EntityManager em = null;
		EntityTransaction tx = null;
		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			matiere = em.merge(obj);
			tx.commit(); 
		} catch (Exception e) {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (em != null) {
				em.close();
			}
		}
		return matiere;
	}

	@Override
	public void delete(Long id) {
		EntityManager em = null;
		EntityTransaction tx = null;
		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			Matiere adresse = em.find(Matiere.class, id);
			em.remove(adresse);
			tx.commit(); 
		} catch (Exception e) {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	@Override
	public List<Matiere> findAllByDifficulte(Difficulte difficulte) {
		List<Matiere> matieres = null;
		EntityManager em = null;
		EntityTransaction tx = null;
		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			matieres = (List<Matiere>) em.find(Matiere.class, difficulte);
			tx.commit(); 
		} catch (Exception e) {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (em != null) {
				em.close();
			}
		}
		return matieres;

	}
}