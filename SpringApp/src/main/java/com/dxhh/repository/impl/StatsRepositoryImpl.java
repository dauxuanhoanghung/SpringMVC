///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package com.dxhh.repository.impl;
//
//import com.dxhh.hibernatedemo.HibernateUtils;
//import com.dxhh.pojo.Category;
//import com.dxhh.pojo.OrderDetail;
//import com.dxhh.pojo.Product;
//import com.dxhh.repository.StatsRepository;
//import java.util.Date;
//import java.util.List;
//import java.util.Map;
//import javax.persistence.Query;
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Root;
//import org.hibernate.Session;
//import org.springframework.stereotype.Repository;
//
///**
// *
// * @author admin
// */
//@Repository
//public class StatsRepositoryImpl implements StatsRepository {
//
//    @Override
//    public List<Object[]> statsByCategory() {
//        try(Session s = HibernateUtils.getFactory().openSession()) {
//            CriteriaBuilder builder = s.getCriteriaBuilder();
//            CriteriaQuery<Object[]> q = builder.createQuery(Object[].class);
//            //from product
//            Root productRoot = q.from(Product.class);
//            //from category
//            Root categoryRoot = q.from(Category.class);
//            
//            //SELECT c.id, c.name, count(p.id)
//            q.multiselect(categoryRoot.get("id"), categoryRoot.get("name"), 
//                            builder.count(productRoot.get("id")));
//            //where p.id = c.id
//            q.where(builder.equal(productRoot.get("category"), categoryRoot.get("id")));
//            //group by c.id
//            q.groupBy(categoryRoot.get("id"));
//            
//            Query query = s.createQuery(q);
//            return query.getResultList();
//        }
//    }
//
//    @Override
//    public List<Object[]> statsRevenue(Date fromDate, Date toDate) {
//        try(Session s = HibernateUtils.getFactory().openSession()) {
//            CriteriaBuilder builder = s.getCriteriaBuilder();
//            CriteriaQuery<Object[]> q = builder.createQuery(Object[].class);
//            //from product
//            Root<Product> productRoot = q.from(Product.class);
//            //from order_detail
//            Root<OrderDetail> orderDetailRoot = q.from(OrderDetail.class);
//            
//            //SELECT p.id, p.name, sum(p.num * p.unitprice)
//            q.multiselect(productRoot.get("id"), productRoot.get("name"), 
//                            builder.sum(builder.prod(orderDetailRoot.get("num"), orderDetailRoot.get("unitPrice"))));
//            //where od.id = p.id
//            q.where(builder.equal(orderDetailRoot.get("product"), productRoot.get("id")));
//            //group by p.id
//            q.groupBy(productRoot.get("id"));
//            
//            Query query = s.createQuery(q);
//            return query.getResultList();
//        }
//    }
//
//    @Override
//    public List<Object[]> statsBySelling() {
//        try(Session s = HibernateUtils.getFactory().openSession()) {
//            CriteriaBuilder builder = s.getCriteriaBuilder();
//            CriteriaQuery<Object[]> q = builder.createQuery(Object[].class);
//            //from product
//            Root<Product> productRoot = q.from(Product.class);
//            //from order_detail
//            Root<OrderDetail> orderDetailRoot = q.from(OrderDetail.class);
//            
//            //SELECT p.id, p.name, sum(p.num * p.unitprice)
//            q.multiselect(productRoot.get("id"), productRoot.get("name"), 
//                            builder.sum(orderDetailRoot.get("num")));
//            //where od.id = p.id
//            q.where(builder.equal(orderDetailRoot.get("product"), productRoot.get("id")));
//            //group by p.id
//            q.groupBy(productRoot.get("id"));
//            q.orderBy(builder.desc(builder.sum(orderDetailRoot.get("num"))));
//            Query query = s.createQuery(q);
//            return query.getResultList();
//        }
//    }
//
//    
//    
//}
