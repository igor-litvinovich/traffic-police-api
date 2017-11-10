package rest.service;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Repository;
import rest.entity.UserEntity;

import javax.transaction.Transactional;
import java.util.List;

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
        if (userEntity == null) {
            throw new Exception("Invalid credentials");
        }
        return userEntity;
    }

    @Override
    public List<UserEntity> filterEntities(String searchString) {
        String resultSearchString = "%" + searchString + "%";
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(UserEntity.class);
        criteria.add(Restrictions.or(
                Restrictions.like("firstname", resultSearchString),
                Restrictions.like("lastname", resultSearchString),
                Restrictions.like("email", resultSearchString),
                Restrictions.like("role", resultSearchString),
                Restrictions.like("id", resultSearchString)
        ));
        List results = criteria.list();
        return results;
    }
}
