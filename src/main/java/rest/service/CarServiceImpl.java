package rest.service;

import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Repository;
import rest.entity.CarEntity;
import rest.request.RequestParams;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class CarServiceImpl extends Service<CarEntity> {

    public List<CarEntity> filterEntities(RequestParams requestParams, Class<CarEntity> carEntityClass) {
        return super.filterEntities(requestParams, CarEntity.class);
    }

    protected Disjunction getRestrictions(RequestParams requestParams) {
        String searchString = (String) requestParams.getSearch().get("value");
        return Restrictions.or(
                Restrictions.like("amRegNumber", searchString, MatchMode.ANYWHERE),
                Restrictions.like("amColor", searchString, MatchMode.ANYWHERE),
                Restrictions.like("amBodyNumber", searchString, MatchMode.ANYWHERE),
                Restrictions.like("amEngineNumber", searchString, MatchMode.ANYWHERE),
                Restrictions.like("id", searchString, MatchMode.ANYWHERE)
        );
    }
}
