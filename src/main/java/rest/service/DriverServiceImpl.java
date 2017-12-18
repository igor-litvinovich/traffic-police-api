package rest.service;

import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Repository;
import rest.entity.DriversEntity;
import rest.request.RequestParams;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class DriverServiceImpl extends Service<DriversEntity> {

    public List<DriversEntity> filterEntities(RequestParams requestParams, Class<DriversEntity> driversEntityClass) {
        return super.filterEntities(requestParams, DriversEntity.class);
    }

    protected Disjunction getRestrictions(RequestParams requestParams) {
        String searchString = (String) requestParams.getSearch().get("value");
        return Restrictions.or(
                Restrictions.like("driverFio", searchString, MatchMode.ANYWHERE),
                Restrictions.like("driverAdress", searchString, MatchMode.ANYWHERE),
                Restrictions.like("driverPassport", searchString, MatchMode.ANYWHERE),
                Restrictions.like("driverRules", searchString, MatchMode.ANYWHERE),
                Restrictions.like("driverCategory", searchString, MatchMode.ANYWHERE),
                Restrictions.like("id", searchString, MatchMode.ANYWHERE)
        );
    }
}
