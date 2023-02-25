/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dxhh.repository.impl;

import com.dxhh.hibernatedemo.HibernateUtils;
import com.dxhh.pojo.Product;
import com.dxhh.repository.ProductRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;

/**
 *
 * @author admin
 */
public class ProductRepositoryImpl implements ProductRepository {

    @Override
    public List<Product> getProducts(Map<String, String> params) {
        try (Session s = HibernateUtils.getFactory().openSession()) {
            CriteriaBuilder builder = s.getCriteriaBuilder();
            CriteriaQuery<Product> q = builder.createQuery(Product.class);
            Root<Product> root = q.from(Product.class);
            q.select(root);
            List<Predicate> predicates = new ArrayList<>();
            
            //Filter by keyword
            String kw = params.get("kw");
            if (kw != null){
                Predicate p = builder.like(root.get("name").as(String.class), String.format("%%%s%%", kw));
                predicates.add(p);
            }

            // Filter by price
            String fromPrice = params.get("fromPrice");
            String toPrice = params.get("toPrice");

            if (fromPrice != null && !fromPrice.isEmpty()) {
                Predicate p = builder.greaterThanOrEqualTo(root.get("price").as(Double.class),
                        Double.parseDouble(fromPrice));
                predicates.add(p);
            }

            if (toPrice != null && !toPrice.isEmpty()) {
                Predicate p = builder.lessThanOrEqualTo(root.get("price").as(Double.class), Double.parseDouble(toPrice));
                predicates.add(p);
            }
            q.where(predicates.toArray(Predicate[]::new));
            Query query = s.createQuery(q);
            return query.getResultList();
        }
    }
    
    
}
