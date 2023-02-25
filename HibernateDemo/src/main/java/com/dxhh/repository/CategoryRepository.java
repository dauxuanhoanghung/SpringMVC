/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dxhh.repository;

import com.dxhh.pojo.Category;
import java.util.List;
import java.util.Map;

/**
 *
 * @author admin
 */
public interface CategoryRepository {
    List<Category> getCategories(Map<String, String> params);
}
