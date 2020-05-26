package model;

import oop.model.Service;

public class EntityTariff implements Tariff {

    private int size = 0;
    private Node head;
    private Node tail;

    public EntityTariff() {
        head = null;
        tail = null;
    }

    public EntityTariff(Service[] services) {

        int numNew = services.length;
        if (numNew != 0) {
            Node pred = tail, succ = null;

            for (Service service : services) {
                Node newNode = new Node(pred, service, null);
                if (pred == null)
                    head = newNode;
                else
                    pred.next = newNode;
                pred = newNode;
            }

            tail = pred;
            size += numNew;
        }

    }

    private static class Node {
        Service value;
        Node next;
        Node previous;

        Node(Node previous, Service element, Node next) {
            this.value = element;
            this.next = next;
            this.previous = previous;
        }
    }

    private boolean addService(Service service) {
        final Node l = tail;
        final Node newNode = new Node(l, service, null);
        tail = newNode;
        if (l == null)
            head = newNode;
        else
            l.next = newNode;
        size++;

        return true;
    }

    private boolean addService(int index, Service service) {
        if (index == size) {
            final Node l = tail;
            final Node newNode = new Node(l, service, null);
            tail = newNode;
            if (l == null)
                head = newNode;
            else
                l.next = newNode;
            size++;
        }
        else {
            Node succ = node(index);
            final Node pred = succ.previous;
            final Node newNode = new Node(pred, service, succ);
            succ.previous = newNode;
            if (pred == null)
                head = newNode;
            else
                pred.next = newNode;
            size++;
        }

        return true;
    }

    private Node node(int index) {
        if (index < (size >> 1)) {
            Node x = head;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node x = tail;
            for (int i = size - 1; i > index; i--)
                x = x.previous;
            return x;
        }
    }

    private Service getService(int index) {
        return node(index).value;
    }

    @Override
    public boolean add(Service service) {
        return addService(service);
    }

    @Override
    public boolean add(int index, Service service) {
        return addService(index, service);
    }

    @Override
    public Service get(int index) {
        return getService(index);
    }

    @Override
    public Service get(String serviceName) {
        for (Node x = head; x != null; x = x.next) {
            if (x.value.getName().equals(serviceName))
                return x.value;
        }

        return null;
    }

    @Override
    public boolean hasService(String serviceName) {
        for (Node x = head; x != null; x = x.next) {
            if (x.value.getName().equals(serviceName))
                return true;
        }

        return false;
    }

    @Override
    public Service set(int index, Service service) {
        return setService(index, service);
    }

    @Override
    public Service remove(int index) {
        return removeService(index);
    }

    private Service setService(int index, Service service) {
        Node x = node(index);
        Service oldVal = x.value;
        x.value = service;
        return oldVal;
    }

    private Service removeService(int index) {
        return unlink(node(index));
    }

    private Service unlink(Node x) {
        final Service element = x.value;
        final Node next = x.next;
        final Node prev = x.previous;

        if (prev == null) {
            head = next;
        } else {
            prev.next = next;
            x.previous = null;
        }

        if (next == null) {
            tail = prev;
        } else {
            next.previous = prev;
            x.next = null;
        }

        x.value = null;
        size--;
        return element;
    }

    @Override
    public Service remove(String name) {
        Service service;
        for (Node x = head; x != null; x = x.next) {
            if (x.value.getName().equals(name)) {
                for (Node y = head; y != null; y = y.next) {
                    if (x.value.equals(y.value)) {
                        service = x.value;
                        unlink(y);
                        return service;
                    }
                }
            }
        }

        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Service[] getServices() {
        Service[] services = new Service[size];
        int i = 0;
        for (Node x = head; x != null; x = x.next)
            services[i++] = x.value;
        return services;
    }

    @Override
    public Service[] sortedServicesByCost() {
        Service[] temp = getServices();

        for (int i = temp.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (temp[j].getCost() > temp[j+1].getCost()) {
                    Service service = temp[j];
                    temp[j] = temp[j+1];
                    temp[j+1] = service;
                }
            }
        }

        return temp;
    }

    @Override
    public double cost() {
        double cost = 0;

        for (Node x = head; x != null; x = x.next)
            cost += x.value.getCost();

        return cost;
    }

}
