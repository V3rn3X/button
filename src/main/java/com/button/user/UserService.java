package com.button.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

private final UserRepository repository;

    void saveUsers(List<User> users){
        log.debug("Saving a list of employees");
        repository.saveAll(users);
    }

}
