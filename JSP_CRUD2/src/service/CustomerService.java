package service;

import model.Customer;

import java.util.*;

public class CustomerService {
    private static final Map<Integer, Customer> listCUSTOMER = new HashMap<Integer, Customer>();

    static {
        initCustomers();
    }

    private static void initCustomers() {
        Customer cus1 = new Customer(1, "Nguyen Anh Duc", "0985654951", "duc@gmail.com");
        Customer cus2 = new Customer(2, "Nguyen Van Nam", "0854963654", "Nam@gmail.com");
        Customer cus3 = new Customer(3, "Le Anh Van", "08888777854", "Minh@gmail.com");
        Customer cus4 = new Customer(4, "Nguyen Van Duc", "0951456354", "ducminh@gmail.com");
        Customer cus5 = new Customer(5, "Nam Van Van", "0852654975", "Minh254@gmail.com");
        Customer cus6 = new Customer(6, "Van Anh Hao", "0123696555", "Hao@gmail.com");
        Customer cus7 = new Customer(7, "Nguyen Anh Tai", "0852965415", "Tai@gmail.com");
        Customer cus8 = new Customer(8, "Nguyen Tam An", "0123456987", "An@gmail.com");
        listCUSTOMER.put(cus1.getId(),cus1);
        listCUSTOMER.put(cus2.getId(),cus2);
        listCUSTOMER.put(cus3.getId(),cus3);
        listCUSTOMER.put(cus4.getId(),cus4);
        listCUSTOMER.put(cus5.getId(),cus5);
        listCUSTOMER.put(cus6.getId(),cus6);
        listCUSTOMER.put(cus7.getId(),cus7);
        listCUSTOMER.put(cus8.getId(),cus8);


    }

    public static Customer getCustomer(int customerId) {
        return listCUSTOMER.get(customerId);
    }
    public static void addCustomer(Customer customer) {
         listCUSTOMER.put(customer.getId(),customer);

    }
    public static Customer updateAndCreateCustomer(Customer customer) {
        listCUSTOMER.put(customer.getId(),customer);
        return customer;
    }
    public static void deleteCustomer(int customerId) {
         listCUSTOMER.remove(customerId);
    }

    public static List<Customer> getAllCustomer() {
        Collection<Customer> c = listCUSTOMER.values();
        List<Customer> list = new ArrayList<>();
        list.addAll(c);
        return list;
    }


}
