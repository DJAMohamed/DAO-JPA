package m2i.formation.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import m2i.formation.Application;
import m2i.formation.dao.IPersonneDao;
import m2i.formation.model.Matiere;
import m2i.formation.model.Personne;

public class PersonneDaoJpa implements IPersonneDao {

	@Override
	public List<Personne> findAll() {
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
	public Personne find(Long id) {
		Personne personne = null;
		EntityManager em = null;
		EntityTransaction tx = null;
		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			personne = em.find(Personne.class, id);
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
		return personne;

	}

	@Override
	public void create(Personne obj) {
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
	public Personne update(Personne obj) {
		Personne personne = null;
		EntityManager em = null;
		EntityTransaction tx = null;
		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			personne = em.merge(obj);
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
		return personne;

	}

	@Override
	public void delete(Long id) {
		EntityManager em = null;
		EntityTransaction tx = null;
		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			Personne personne = em.find(Personne.class, id);
			em.remove(personne);
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
	
}