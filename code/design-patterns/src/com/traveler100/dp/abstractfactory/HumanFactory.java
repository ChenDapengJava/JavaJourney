package com.traveler100.dp.abstractfactory;

/**
 * @author chappell
 */
public class HumanFactory extends BaseFactory {
    @Override
    Food createFood() {
        return new Rice();
    }

    @Override
    ProtectiveEquip createProtectiveEquip() {
        return new FaceMask();
    }
}
