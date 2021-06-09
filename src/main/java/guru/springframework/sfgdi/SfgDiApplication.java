package guru.springframework.sfgdi;

import guru.springframework.sfgdi.config.ConstructorBindingConfig;
import guru.springframework.sfgdi.config.SfgConfig;
import guru.springframework.sfgdi.controllers.*;
import guru.springframework.sfgdi.datasource.FakeDatasource;
import guru.springframework.sfgdi.services.PrototypeBean;
import guru.springframework.sfgdi.services.SingletonBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableConfigurationProperties(ConstructorBindingConfig.class)
@ComponentScan(basePackages = {"guru.springframework.sfgdi", "com.springframework.pets"})
public class SfgDiApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(SfgDiApplication.class, args);

        PetController petController = ctx.getBean("petController", PetController.class);
        System.out.println("--- The Best Pet is ---");
        System.out.println(petController.whichPetIsTheBest());

        I18nController i18nController = (I18nController) ctx.getBean("i18nController");
        System.out.println(i18nController.sayHello());

        MyController myController = (MyController) ctx.getBean("myController");

        System.out.println("------- Primary Bean");
        System.out.println(myController.sayHello());

        System.out.println("------ Property");
        PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx.getBean("propertyInjectedController");
        System.out.println(propertyInjectedController.getGreeting());

        System.out.println("--------- Setter");
        SetterInjectedController setterInjectedController = (SetterInjectedController) ctx.getBean("setterInjectedController");
        System.out.println(setterInjectedController.getGreeting());

        System.out.println("-------- Constructor");
        ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) ctx.getBean("constructorInjectedController");
        System.out.println(constructorInjectedController.getGreeting());

        System.out.println("======== Bean Scopes============");
        SingletonBean singletonBean1 = ctx.getBean(SingletonBean.class);
        System.out.println("singletonBean1.getMyScope() = " + singletonBean1.getMyScope());
        SingletonBean singletonBean2 = ctx.getBean(SingletonBean.class);
        System.out.println("singletonBean2.getMyScope() = " + singletonBean2.getMyScope());

        PrototypeBean proto1 = ctx.getBean(PrototypeBean.class);
        System.out.println("proto1.getMyScope() = " + proto1.getMyScope());
        PrototypeBean proto2 = ctx.getBean(PrototypeBean.class);
        System.out.println("proto2.getMyScope() = " + proto2.getMyScope());

        System.out.println("======== Fake DS ============");
        FakeDatasource ds = ctx.getBean(FakeDatasource.class);
        System.out.println("ds.getUsername = " + ds.getUsername());
        System.out.println("ds.getPassword() = " + ds.getPassword());

        System.out.println("======== SFG config ============");
        SfgConfig config = ctx.getBean(SfgConfig.class);
        System.out.println("config.getUsername() = " + config.getUsername());
        System.out.println("config.getPassword() = " + config.getPassword());

        System.out.println("======== Constructor Binding config ============");
        ConstructorBindingConfig consConf = ctx.getBean(ConstructorBindingConfig.class);
        System.out.println("config.getUsername() = " + consConf.getUsername());
        System.out.println("config.getPassword() = " + consConf.getPassword());
    }

}
