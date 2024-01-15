package br.com.store.dao;

import br.com.store.model.Product;

import javax.persistence.EntityManager;

public class ProductDAO {

    private EntityManager em;

    public ProductDAO(EntityManager em) {
        this.em = em;
    }

    public void create(Product product) {
        this.em.persist(product);
    }

    public void update(Product product) {
        this.em.merge(product);
    }

    public void remove(Product product) {
        product = this.em.merge(product);
        this.em.remove(product);
    }
}
