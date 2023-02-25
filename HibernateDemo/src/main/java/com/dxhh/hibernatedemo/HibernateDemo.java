/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.dxhh.hibernatedemo;

import com.dxhh.pojo.Product;
import com.dxhh.repository.ProductRepository;
import com.dxhh.repository.StatsRepository;
import com.dxhh.repository.impl.ProductRepositoryImpl;
import com.dxhh.repository.impl.StatsRepositoryImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author admin
 */
public class HibernateDemo {

    public static void main(String[] args) {
        ProductRepository pr = new ProductRepositoryImpl();
        Map<String, String> params = new HashMap<>();
        params.put("fromPrice", "11000000");
        params.put("toPrice", "25000000");
        List<Product> products = pr.getProducts(params);
        products.forEach(x -> System.out.printf("%15s - %8.1f - %s\n", x.getName(), x.getPrice(), x.getCategory().getName()));
        System.out.println("=============================\n\n");
        
        StatsRepository stats = new StatsRepositoryImpl();
        List<Object[]> res = stats.statsByCategory();
        for (Object[] x : res) {
            System.out.printf("%2s - %15s: %s\n", x[0], x[1], x[2]);
        }
        
        System.out.println("=============================\n\n");
        
        List<Object[]> rev = stats.statsRevenue(null, null);
        for (Object[] x : rev) {
            System.out.printf("%2s - %15s: %,.1f\n", x[0], x[1], x[2]);
        }
        
        System.out.println("=============================\n\n");
        
        List<Object[]> top = stats.statsBySelling();
        for (Object[] x : top) {
            System.out.printf("%2s - %15s: %s\n", x[0], x[1], x[2]);
        }
    }
}
