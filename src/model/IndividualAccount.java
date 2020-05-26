package oop.model;

import model.Account;
import model.Tariff;

public class IndividualAccount implements Account {
    private long number;
    private Person person;
    private Tariff tariff;

    public IndividualAccount(long number, Person person) {
        this.number = number;
        this.person = person;
        tariff = new IndividualsTariff(1);
    }

    public IndividualAccount(long number, Person person, IndividualsTariff tariff) {
        this.number = number;
        this.person = person;
        this.tariff = tariff;
    }

    public long getNumber() {
        return number;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Tariff getTariff() {
        return tariff;
    }

    public void setTariff(Tariff tariff) {
        this.tariff = tariff;
    }

}
