package sas.study.blog.spring.di.constructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/di")
@RestController
public class ConstructorInjectionController {

    private ConstructorInjectionService constructorInjectionService;

    public ConstructorInjectionController(ConstructorInjectionService constructorInjectionService) {
        this.constructorInjectionService = constructorInjectionService;
    }

    @GetMapping("/constructor-injection")
    public String constructorInjection() {
        constructorInjectionService.constructorInjection();
        return "constructorInjection";
    }

}
