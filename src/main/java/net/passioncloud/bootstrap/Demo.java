package net.passioncloud.bootstrap;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Demo {
    public static void workWithCustomerService(Class<?> label, CustomerService customerService) {
       log.info("=======");
       log.info(label.getName());
       log.info("========");

       var res1 = customerService.save("Mary Jane");
       res1.forEach(c -> log.info("save " + c));
       log.info("=== save 1 done");
       var res2 = customerService.save("English", "Paula", "Timothy Ojong");
       res2.forEach(c -> System.out.println("Again saved " + c));

    }
}
