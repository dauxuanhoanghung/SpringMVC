/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dxhh.repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author admin
 */
public interface StatsRepository {
    public List<Object[]> statsByCategory();
    public List<Object[]> statsBySelling();
    public List<Object[]> statsRevenue(Date fromDate, Date toDate);
}
