package ua.epam.spring.hometask.service.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import ua.epam.spring.hometask.domain.Auditorium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Maksym_Mazurkevych on 4/26/2016.
 */
@Configuration
@PropertySource({"classpath:properties/auditorium1.properties",
        "classpath:properties/auditorium2.properties"})
public class AuditoriumConfiguration {

    @Autowired
    private Environment env;

    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    private Auditorium createAuditorium(String prefix) {
        String nameString = env.getProperty(prefix + ".name");
        String strNumberOfSeats = env.getProperty(prefix + ".numberOfSeats");
        Integer[] integers = env.getProperty(prefix + ".vipSeats", Integer[].class);
        Set<Long> integerSet = new HashSet<Long>();

        for(int i = 0; i<integers.length; i++) {
            integerSet.add(Long.valueOf(integers[i]));
        }

        Auditorium auditorium = new Auditorium();
        auditorium.setName(nameString);
        auditorium.setNumberOfSeats(Integer.valueOf(strNumberOfSeats));
        auditorium.setVipSeats(integerSet);
        return auditorium;
    }

    @Bean
    public Auditorium auditorium1() {
        return createAuditorium("auditorium1");
    }

    @Bean
    public Auditorium auditorium2() {
        return createAuditorium("auditorium2");
    }

    @Bean
    public List<Auditorium> auditoriumsList() {
        return Arrays.asList(auditorium1(), auditorium2());
    }

}
