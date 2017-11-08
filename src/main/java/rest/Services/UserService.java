package rest.Services;

import org.springframework.stereotype.Repository;
import rest.models.User;

import javax.transaction.Transactional;

@Repository
@Transactional
public class UserService extends Service<User> {
}
