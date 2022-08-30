package sas.study.blog.spring.di.field;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/di")
@RestController
public class FieldInjectionController {

    @Autowired
    private FieldInjectionService fieldInjectionService;

    @GetMapping("/field-injection")
    public String fieldInjection() {
        fieldInjectionService.fieldInjection();
        return "fieldInjection";
    }

}
