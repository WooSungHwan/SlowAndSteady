package sas.study.blog.spring.di.field;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/di")
@RestController
public class FieldInjectionController {

    private FieldInjectionService fieldInjectionService;

    @Autowired
    public void setFieldInjectionService(FieldInjectionService fieldInjectionService) {
        this.fieldInjectionService = fieldInjectionService;
    }

    @GetMapping("/field-injection")
    public String fieldInjection() {
        int result = fieldInjectionService.doSomething();
        return "fieldInjection " + result;
    }

}
