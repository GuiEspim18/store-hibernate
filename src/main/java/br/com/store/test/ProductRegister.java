package br.com.store.test;

import br.com.store.dao.CategoryDAO;
import br.com.store.dao.ProductDAO;
import br.com.store.model.Category;
import br.com.store.model.Product;
import br.com.store.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class ProductRegister {
    public static void main (String[] args) {
//        createPorduct();
        Long id = 4l;

        EntityManager em = JPAUtil.getEntityManager();

        ProductDAO productDAO = new ProductDAO(em);

        List<Product> all = productDAO.getAll();
        all.forEach(p -> System.out.println(p.getName()));


    }

    public static void createPorduct() {
        // creating a product in database
        Category cellphones = new Category("Cellphones");
        Product cellphone = new Product("Samsung S23", "Celular Samsung 23 top de linha da marca", new BigDecimal("5000"), cellphones);

        // creating the factory to persist on entity
        EntityManager em = JPAUtil.getEntityManager();

        ProductDAO productDAO = new ProductDAO(em);
        CategoryDAO categoryDAO = new CategoryDAO(em);

        // begin the transaction to database
        em.getTransaction().begin();

        // persisting on entity
        categoryDAO.create(cellphones);
        productDAO.create(cellphone);

        // on end the transaction we need to commit
        em.getTransaction().commit();

        // and than we need to close the entity manager
        em.close();
    }
}
