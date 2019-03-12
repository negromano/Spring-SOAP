package hello;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

import io.spring.guides.gs_producing_web_service.Program;
import io.spring.guides.gs_producing_web_service.Student;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class StudentRepository {
    private static final Map<String, Student> students = new HashMap<>();

    @PostConstruct
    public void initData() {
        Program p = new Program();
        p.setId(1);
        p.setName("Ingeniería de Sistemas");

        Student juan = new Student();
        juan.setId("1");
        juan.setName("Juan Pablo");
        juan.setLastname("Rodríguez Morales");
        juan.setProgram(p);

        students.put(juan.getId(), juan);
    }

    public Student findStudent(String name) {
        Assert.notNull(name, "The student's name must not be null");
        return students.get(name);
    }
}