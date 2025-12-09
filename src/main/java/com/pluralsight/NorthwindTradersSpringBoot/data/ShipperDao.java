package com.pluralsight.NorthwindTradersSpringBoot.data;

import com.pluralsight.NorthwindTradersSpringBoot.model.Shipper;

import java.util.List;

public interface ShipperDao {
    List<Shipper> getAll();
    Shipper add(Shipper shipper);
}
