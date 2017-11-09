package rest.service;

import org.springframework.stereotype.Repository;
import rest.entity.UserEntity;

import javax.transaction.Transactional;

@Repository
@Transactional
public class UserService extends Service<UserEntity> {
}
