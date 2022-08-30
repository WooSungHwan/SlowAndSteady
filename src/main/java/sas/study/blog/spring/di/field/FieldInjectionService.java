package sas.study.blog.spring.di.field;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FieldInjectionService {

    @Autowired
    private FieldInjectionController fieldInjectionController;

    public void fieldInjection() {
        System.out.println("fieldInjectionService.fieldInjection() 호출");
    }
}
