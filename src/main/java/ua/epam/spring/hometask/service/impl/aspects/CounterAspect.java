package ua.epam.spring.hometask.service.impl.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by Maksym_Mazurkevych on 4/27/2016.
 */
@Component
@Aspect
public class CounterAspect {

    private Map<Class<?>, Integer> counter;

    public void countHowManyTimesEachEventAccessedByName(){

    }

    public void counthowManyTimesPricesQueried(){

    }

    public void countHowManyTimesTicketsBooked(){

    }
}
