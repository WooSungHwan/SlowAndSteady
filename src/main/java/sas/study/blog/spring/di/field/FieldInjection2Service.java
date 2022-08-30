package sas.study.blog.spring.di.field;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
//@Service
public class FieldInjection2Service {

    private final FieldInjectionService fieldInjectionService;

    public int doSomething() {
        int fieldInjectionServiceResult = fieldInjectionService.doSomething();
        System.out.println("fieldInjection2Service.doSomething() 호출");
        return fieldInjectionServiceResult;
    }
}
