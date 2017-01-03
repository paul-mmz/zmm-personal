package com.paul.spring.configs;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

@Configuration
@ComponentScan("com.paul.spring.configs")
@PropertySource("classpath:conf/test.properties")
public class ELConfigWithMain {

	@Value("I love you")
	private String normal;

	@Value("#{systemProperties['os.name']}")
	private String osName;

	@Value("#{demoSingletionService.another}")
	private String fromDemoSingtion;

	@Value("classpath:conf/test.txt")
	private Resource testFile;

	@Value("http://www.baidu.com")
	private Resource testUrl;

	@Value("${book.name}")
	private String bookName;
	
	@Autowired
	private Environment environment;
	
	public static PropertySourcesPlaceholderConfigurer propertyConfigure(){
		return new PropertySourcesPlaceholderConfigurer();
	}

	public void output() {

		try {
			System.out.println(normal);
			System.out.println(osName);
			System.out.println(fromDemoSingtion);
			System.out.println(IOUtils.toString(testFile.getInputStream()));
			System.out.println(IOUtils.toString(testUrl.getInputStream()));
			System.out.println(bookName);
			System.out.println(environment.getProperty("book.author"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ELConfigWithMain.class);

		ELConfigWithMain bean = context.getBean(ELConfigWithMain.class);

		bean.output();

		context.close();
	}
}
