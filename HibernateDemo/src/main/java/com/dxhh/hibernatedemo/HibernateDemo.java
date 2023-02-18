/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.dxhh.hibernatedemo;

import com.dxhh.pojo.Category;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;

/**
 *
 * @author admin
 */
public class HibernateDemo {

    public static void main(String[] args) {
        Session s = HibernateUtils.getFactory().openSession();
        Query q = s.createQuery("FROM Category");
        
        List<Category> cate = q.getResultList();
        cate.forEach(c -> {
            System.out.println(c.getName());
        });
        
        s.close();
    }
}
