package com.codegyme.demo_springboot_mysql.repository.impl;

import com.codegyme.demo_springboot_mysql.model.Customer;
import com.codegyme.demo_springboot_mysql.repository.CustomerRepository;
import org.hibernate.sql.Select;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
@Repository
@Transactional
public class CustomerRepositoryImpl implements CustomerRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Customer> findAll() {
        TypedQuery<Customer> query = em.createQuery("select c from  Customer c ", Customer.class);
        return query.getResultList();
    }

    @Override
    public Customer findById(String id) {
        TypedQuery<Customer> query = em.createQuery("select c from  Customer c where c.id=:id", Customer.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void save(Customer model) {
        if (model.getId() != null) {
            em.merge(model);
        } else {
            em.persist(model);
        }
    }


    @Override
    public void delete(String id) {
        Customer customer = findById(id);
        if (customer != null) {
            em.remove(customer);
        }
    }
}
