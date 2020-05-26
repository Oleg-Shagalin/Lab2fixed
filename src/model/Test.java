package model;

import oop.model.*;

public class Test {

    public static void lab2tests() {
        Tariff tariff = new IndividualsTariff();
        Tariff tariff1 = new IndividualsTariff(3);
        Tariff tariff2 = new IndividualsTariff(new Service[3]);

        tariff.add(1, new Service());
        for (Service s : tariff.getServices()) {
            System.out.println(s.getName());
        }

        for (int i = 0; i < 8; i ++) {
            tariff.add(new Service(String.valueOf(i), i));
        }
        for (Service s : tariff.getServices()) {
            System.out.println(s.getName());
        }

        Service service = tariff.get(1);
        System.out.println(service.getName());

        service = tariff.get("3");
        System.out.println(service.getName());

        System.out.println("hasService " + "4: " + tariff.hasService("4"));

        service = tariff.set(0, new Service());
        System.out.println(service.getName());

        service = tariff.remove(3);
        System.out.println(service.getName());

        service = tariff.remove("5");
        System.out.println(service.getName());

        System.out.println("size: " + tariff.size());

        for (Service s : tariff.sortedServicesByCost()) {
            System.out.println(s.getCost());
        }

        System.out.println(tariff.cost());


        Tariff entityTariff = new EntityTariff();
        Tariff entityTariff1 = new EntityTariff(tariff.getServices());
        entityTariff1.add(new Service());
        System.out.println(entityTariff1.remove(0).getName());
        System.out.println(entityTariff1.remove("1").getName());
        Service[] services = entityTariff1.getServices();
        services = entityTariff1.sortedServicesByCost();
        entityTariff1.add(5, new Service());
        service = entityTariff1.set(1, new Service());
        service = entityTariff1.get(0);
        service = entityTariff1.get("test");
        service = entityTariff1.remove(0);
        service = entityTariff1.remove("test");
        System.out.println(entityTariff1.cost());



        Account account = new IndividualAccount(3, new Person("Ivan", "Ivanov"));
        Account account1 = new IndividualAccount(4, new Person("Petr", "Petrov"),
                new IndividualsTariff());

        System.out.println(account.getNumber());
        System.out.println(account.getTariff().cost());


        Account entityAccount = new EntityAccount(4,"Petr");
        Account entityAccount1 = new EntityAccount(4,"Petr", entityTariff);
        System.out.println(entityAccount.getNumber());
        entityAccount.setTariff(entityTariff1);
        System.out.println(entityAccount.getTariff().cost());

        AccountsManager manager = new AccountsManager(3);
        Account[] accounts = new Account[2];
        accounts[0] = account;
        accounts[1] = entityAccount;
        AccountsManager manager1 = new AccountsManager(accounts);
        System.out.println(manager.add(account));
        System.out.println(manager.add(2, account1));
        account = manager.get(0);
        account = manager.set(2, account);
        account = manager.remove(1);
        System.out.println(manager.size());

        accounts = manager.getAccounts();
        for (Account a : accounts) {
            if (a != null)
                System.out.println(a.getNumber());
        }

        tariff = manager.getTariff(3);
        System.out.println(tariff.cost());

        tariff = manager.setTariff(3, tariff1);
        System.out.println(tariff.cost());

    }

    @org.junit.Test
    public void startTests() {
        lab2tests();
    }
}
