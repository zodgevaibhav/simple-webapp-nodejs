package lean.spring.createobject_ioc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("resource/student-bean.xml");
		
		((StudentService)context.getBean("student")).printNames(); //Get bean of type object and type cast
		
		context.getBean("student",StudentService.class).printNames(); //get bean by sending type. Dependency injected consttructor-args value
		
		context.close(); //Close the context after use
		
		context.refresh(); //Create context again if closed
		
		
		context.getBean("studentWithDependencyInjected",StudentService.class).printNames(); //consttructor-args object
		
		System.out.println(context.getBean("setterInjectionInTeacherClass",Teachers.class).getClassName()); //Setter injection
		System.out.println(context.getBean("setterInjectionInTeacherClass",Teachers.class).getTeacherName());//Setter injection

		System.out.println(context.getBean("setterInjectionFromPropertiesFile",Teachers.class).getTeacherName());//Setter injection from properties file
		
		context.getBean("StudentBeanWithPrototypeScope",StudentBeanPrototypeScopeDemo.class); //prototype scope 1
		context.getBean("StudentBeanWithPrototypeScope",StudentBeanPrototypeScopeDemo.class); //prototype scope 2
		context.getBean("StudentBeanWithPrototypeScope",StudentBeanPrototypeScopeDemo.class); //prototype scope 3
		
		context.getBean("StudentBeanWithBeanInitDestroy",StudentBeanPrototypeScopeDemo.class); //prototype scope 3

		context.close();
	}
}