package net.passioncloud.bootstrap;

public class Application {
    public static void main(String[] args) {
        DevelopmentOnlyCustomerService customerService = new DevelopmentOnlyCustomerService();
        Demo.workWithCustomerService(Application.class, customerService);
    }
}
