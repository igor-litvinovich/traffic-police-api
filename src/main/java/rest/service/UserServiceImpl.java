package rest.service;

import org.hibernate.criterion.*;
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
        return Restrictions.or(
                Restrictions.like("firstname", searchString, MatchMode.ANYWHERE),
                Restrictions.like("lastname", searchString, MatchMode.ANYWHERE),
                Restrictions.like("email", searchString, MatchMode.ANYWHERE),
                Restrictions.like("role", searchString, MatchMode.ANYWHERE),
                Restrictions.like("id", searchString, MatchMode.ANYWHERE)
        );
    }
}
