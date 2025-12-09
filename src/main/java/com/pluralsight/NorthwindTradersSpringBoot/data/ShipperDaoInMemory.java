package com.pluralsight.NorthwindTradersSpringBoot.data;

import com.pluralsight.NorthwindTradersSpringBoot.model.Shipper;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Primary
public class ShipperDaoInMemory implements ShipperDao {
    private List<Shipper> shippers;


    private int nextId = 1;


    public ShipperDaoInMemory() {
        this.shippers = new ArrayList<>();
    }

    @Override
    public List<Shipper> getAll() {
        shippers.add(new Shipper(1, "FedEx", "772-807-9090"));
        shippers.add(new Shipper(2, "Ship", "100-997-9900"));
        shippers.add(new Shipper(3, "QuickSend", "809-889-1119"));
        shippers.add(new Shipper(4, "ImHereShipping", "171-343-2233"));
        shippers.add(new Shipper(5, "UPS", "323-900-1224"));
        return shippers;
    }

    @Override
    public Shipper add(Shipper shipper) {
        shipper.setShipperId(nextId++);
        shippers.add(shipper);
        return shipper;
    }
}
