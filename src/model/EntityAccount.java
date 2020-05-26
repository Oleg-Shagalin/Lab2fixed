package model;

import oop.model.Service;

public class EntityAccount implements Account {

    private long number;
    private String name;
    private Tariff tariff;

    public EntityAccount(long number, String name) {
        this.number = number;
        this.name = name;

        Service[] services = new Service[1];
        services[0] = new Service();
        tariff = new EntityTariff(services);
    }

    public EntityAccount(long number, String name, Tariff tariff) {
        this.number = number;
        this.name = name;
        this.tariff = tariff;
    }

    @Override
    public long getNumber() {
        return number;
    }

    @Override
    public Tariff getTariff() {
        return tariff;
    }

    @Override
    public void setTariff(Tariff tariff) {
        this.tariff = tariff;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
