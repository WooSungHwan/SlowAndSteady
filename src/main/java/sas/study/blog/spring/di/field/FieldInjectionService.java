package sas.study.blog.spring.di.field;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class FieldInjectionService {

//    private final FieldInjection2Service fieldInjection2Service;

    public int doSomething() {
        System.out.println("fieldInjectionService.doSomething() 호출");
        return 0;
//        return fieldInjection2Service.doSomething();
    }
}
