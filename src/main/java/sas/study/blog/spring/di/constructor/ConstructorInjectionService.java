package sas.study.blog.spring.di.constructor;

import org.springframework.stereotype.Service;

@Service
public class ConstructorInjectionService {
/*

    private ConstructorInjectionController constructorInjectionController;

    public ConstructorInjectionService(ConstructorInjectionController constructorInjectionController) {
        this.constructorInjectionController = constructorInjectionController;
    }
*/

    public void constructorInjection() {
        System.out.println("constructorInjectionService.constructorInjection() 호출");
    }
}
