package com.pluralsight.NorthwindTradersSpringBoot.data;

import com.pluralsight.NorthwindTradersSpringBoot.model.Shipper;

import java.util.List;

public class ShipperDaoJdbc implements ShipperDao{

    @Override
    public List<Shipper> getAll() {
        return List.of();
    }

    @Override
    public Shipper add(Shipper shipper) {
        return null;
    }
}
