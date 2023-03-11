/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dxhh.repository.impl;

import com.dxhh.pojo.Category;
import com.dxhh.repository.CategoryRepository;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author admin
 */
@Repository
@Transactional
public class CategoryRepositoryImpl implements CategoryRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Category> getCategories(Map<String, String> params) {
        Session s = sessionFactory.getObject().getCurrentSession(); 
        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery<Category> q = builder.createQuery(Category.class);
        Root<Category> root = q.from(Category.class);
        q.select(root);

        Query query = s.createQuery(q);
        return query.getResultList();
        
    }
    
}
