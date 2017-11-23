package rest.service;

import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Repository;
import rest.entity.UserEntity;
import rest.request.RequestParams;

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

    public List<UserEntity> filterEntities(RequestParams requestParams) {
        return super.filterEntities(requestParams, UserEntity.class);
    }

    protected Disjunction getRestrictions(RequestParams requestParams) {
        String searchString = (String) requestParams.getSearch().get("value");
        String resultSearchString = "%" + searchString + "%";
        return Restrictions.or(
                Restrictions.like("firstname", resultSearchString),
                Restrictions.like("lastname", resultSearchString),
                Restrictions.like("email", resultSearchString),
                Restrictions.like("role", resultSearchString),
                Restrictions.like("id", resultSearchString)
        );
    }
}
