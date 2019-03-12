package hello;

import io.spring.guides.gs_producing_web_service.GreetRequest;
import io.spring.guides.gs_producing_web_service.GreetResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class StudentEndpoint {

    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

    private StudentRepository studentRepository;

    @Autowired
    public StudentEndpoint(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "greetRequest")
    @ResponsePayload
    public GreetResponse greetResponse(@RequestPayload GreetRequest request) {
        GreetResponse response = new GreetResponse();
        response.setGreet(studentRepository.findStudent(request.getName()).getProgram().getName());

        return response;
    }

}
