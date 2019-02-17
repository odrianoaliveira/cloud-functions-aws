package tech.adriano.cloudfunctions;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.cloud.function.context.FunctionRegistration;
import org.springframework.cloud.function.context.FunctionType;
import org.springframework.cloud.function.context.FunctionalSpringApplication;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.support.GenericApplicationContext;
import tech.adriano.cloudfunctions.fn.FactorialFn;

@SpringBootConfiguration
public class CloudFunctionsApplication implements ApplicationContextInitializer<GenericApplicationContext> {

    public static void main(String[] args) {
        FunctionalSpringApplication.run(CloudFunctionsApplication.class, args);
    }

    @Override
    public void initialize(GenericApplicationContext context) {
        context.registerBean("factorial", FunctionRegistration.class,
                () -> new FunctionRegistration<>(FactorialFn.factorial())
                        .type(FunctionType.from(Integer.class)
                                .to(Integer.class)));
    }

}
