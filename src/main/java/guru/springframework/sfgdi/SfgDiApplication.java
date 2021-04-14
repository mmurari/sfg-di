package guru.springframework.sfgdi;

import guru.springframework.sfgdi.controller.ConstructorInjectedController;
import guru.springframework.sfgdi.controller.MyController;
import guru.springframework.sfgdi.controller.PropertyInjectedController;
import guru.springframework.sfgdi.controller.SetterInjectedController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SfgDiApplication {
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SfgDiApplication.class, args);
		MyController myController = (MyController) ctx.getBean("myController");
		String greeting = myController.sayHello();
		System.out.println(greeting);

		System.out.println("--------property");
		PropertyInjectedController pic = (PropertyInjectedController) ctx.getBean("propertyInjectedController");
		System.out.println(pic.getGreting());

		System.out.println("--------setter");
		SetterInjectedController sic = (SetterInjectedController) ctx.getBean("setterInjectedController");
		System.out.println(sic.getGreeting());

		System.out.println("--------constructor");
		ConstructorInjectedController cic = (ConstructorInjectedController) ctx.getBean("constructorInjectedController");
		System.out.println(cic.getGreeting());
	}
}
