package com.traveler100.dp.abstractfactory;

/**
 * @author chappell
 */
public class UsaFactory extends BaseFactory {
    @Override
    Food createFood() {
        return new Junk();
    }

    @Override
    ProtectiveEquip createProtectiveEquip() {
        return new Rags();
    }
}
