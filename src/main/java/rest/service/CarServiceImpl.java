package rest.service;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Disjunction;
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
    @Override
    public List<CarEntity> filterEntities(RequestParams requestParams, Class<CarEntity> carEntityClass) {
        String searchString = (String) requestParams.getSearch().get("value");
        String resultSearchString = "%" + searchString + "%";

        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(carEntityClass);

        criteria.add(Restrictions.or(
                Restrictions.like("amRegNumber", resultSearchString),
                Restrictions.like("amColor", resultSearchString),
                Restrictions.like("amBodyNumber", resultSearchString),
                Restrictions.like("amEngineNumber", resultSearchString),
                Restrictions.like("id", resultSearchString)
        ));
        criteria.setFirstResult(requestParams.getStart());
        criteria.setMaxResults(requestParams.getLength());
        List results = criteria.list();
        return results;
    }

    @Override
    Disjunction getRestrictions(RequestParams requestParams) {
        return null;
    }
}
