package com.xblzer.dp.abstractfactory;

/**
 * @author 行百里者
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
