package model;

import oop.model.Service;

public interface Tariff {

    boolean add(Service service);
    boolean add(int index, Service service);
    Service get(int index);
    Service get(String serviceName);
    boolean hasService(String serviceName);
    Service set(int index, Service service);
    Service remove(int index);
    Service remove(String name);
    int size();
    Service[] getServices();
    Service[] sortedServicesByCost();
    double cost();

}
