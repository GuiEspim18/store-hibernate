package br.com.store.dao;

import br.com.store.model.Category;

import javax.persistence.EntityManager;

public class CategoryDAO {

    private EntityManager em;

    public CategoryDAO (EntityManager em) {
        this.em = em;
    }

    public void create (Category category) {
        this.em.persist(category);
    }

    public void update (Category category) {
        this.em.merge(category);
    }

    public void remove(Category category) {
        category = this.em.merge(category);
        this.em.remove(category);
    }

}
