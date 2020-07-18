package course2.springresource;

import course2.springresource.service.FileService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("course2.springresource");
        FileService fileService = context.getBean(FileService.class);
        //获取网络数据
        System.out.println(fileService.getContent("http://news.baidu.com/"));
        //获取resources下文件。使用classpath读取
        String content = fileService.getContent("classpath:test.txt");
        System.out.println(content);
        //工程目录下pom.xml文件
        String content2 = fileService.getContent("file:pom.xml");
        System.out.println(content2);
    }


}
