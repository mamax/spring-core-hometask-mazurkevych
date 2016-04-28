package ua.epam.spring.hometask.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import ua.epam.spring.hometask.dao.AuditoriumDao;
import ua.epam.spring.hometask.domain.Auditorium;
import ua.epam.spring.hometask.service.AuditoriumService;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Maksym_Mazurkevych on 4/11/2016.
 */
@Configuration
@PropertySource({"classpath:properties/auditorium1.properties",
        "classpath:properties/auditorium2.properties"})
@Service
public class AuditoriumServiceImpl implements AuditoriumService {

    @Autowired
    private AuditoriumDao auditoriumDao;

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

    @Nonnull
    @Override
    public Set<Auditorium> getAll() {
        return auditoriumDao.getAll();
    }

    @Nullable
    @Override
    public Auditorium getByName(@Nonnull String name) {
        return auditoriumDao.getByName(name);
    }
}
