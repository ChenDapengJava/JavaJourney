package com.traveler100.dp.abstractfactory;

/**
 * @author 行百里者
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
