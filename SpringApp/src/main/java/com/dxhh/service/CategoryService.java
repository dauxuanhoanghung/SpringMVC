/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dxhh.service;

import com.dxhh.pojo.Category;
import java.util.List;
import java.util.Map;

/**
 *
 * @author admin
 */
public interface CategoryService {
    List<Category> getCategories(Map<String, String> params);
}
