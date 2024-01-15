package br.com.store.dao;

import br.com.store.model.Product;

import javax.persistence.EntityManager;
import java.util.List;

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

    public Product getById(Long id) {
        return this.em.find(Product.class, id);
    }

    public List<Product> getAll() {
        String jpql = "SELECT p FROM Product p";
        return this.em.createQuery(jpql, Product.class).getResultList();
    }

    public List<Product> getByName(String name) {
        String jpql = "SELECT p FROM Product p WHERE p.name = ?1";
        return this.em.createQuery(jpql, Product.class)
                .setParameter("1", name)
                .getResultList();
    }

    public List<Product> getByCategory(String name) {
        String jpql = "SELECT p FROM Product p WHERE p.category.name = :name";
        return this.em.createQuery(jpql, Product.class)
                .setParameter("name", name)
                .getResultList();
    }
}
