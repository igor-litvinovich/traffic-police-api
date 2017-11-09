package rest.service;

import org.hibernate.criterion.SimpleExpression;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Repository;
import rest.entity.UserEntity;

import javax.transaction.Transactional;

import static org.hibernate.criterion.Restrictions.eq;


@Repository
@Transactional
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class UserServiceImpl extends Service<UserEntity> {

    public UserEntity authenticate(UserEntity entity) throws Exception {
        SimpleExpression[] simpleExpressions = new SimpleExpression[2];
        simpleExpressions[0] = eq("email", entity.getEmail());
        simpleExpressions[1] = eq("password", entity.getPassword());
        UserEntity userEntity = this.findWithCriteria(UserEntity.class, simpleExpressions);
        if(userEntity == null){
            throw new Exception("Invalid credentials");
        }
        return userEntity;
    }
}
