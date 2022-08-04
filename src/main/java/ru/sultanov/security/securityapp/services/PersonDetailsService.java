package ru.sultanov.security.securityapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.sultanov.security.securityapp.models.Person;
import ru.sultanov.security.securityapp.repositories.PeopleRepository;
import ru.sultanov.security.securityapp.security.PersonDetails;

import java.util.Optional;

@Service
//С помощью UserDetailsService даем понять сприг секюрити что этот сервис для него
public class PersonDetailsService implements UserDetailsService {

    PeopleRepository peopleRepository;

    @Autowired
    public PersonDetailsService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Person> person = peopleRepository.findByUsername(username);

        //Проверяем не пуст ли наш персон
        // Если нет, то возвращаем PersonDetails с завернутым в него персоном

        if (person.isEmpty()) {
            throw new UsernameNotFoundException("User not found");
        }

        return new PersonDetails(person.get());
    }
}
