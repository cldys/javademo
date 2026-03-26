package com.example.javademo.lesson;

import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class UserService {

    private final Map<Long, User> users = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public UserResponse createUser(UserCreateRequest request) {
        long id = idGenerator.getAndIncrement();
        User user = new User(id, request.name(), request.age());
        users.put(id, user);
        return toResponse(user);
    }

    public UserResponse getUser(long id) {
        return toResponse(findUser(id));
    }

    public UserResponse birthday(long id) {
        User user = findUser(id);
        user.haveBirthday();
        return toResponse(user);
    }

    private User findUser(long id) {
        User user = users.get(id);
        if (user == null) {
            throw new UserNotFoundException(id);
        }
        return user;
    }

    private UserResponse toResponse(User user) {
        return new UserResponse(user.getId(), user.getName(), user.getAge(), user.isAdult());
    }
}
