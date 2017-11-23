package rest.service;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Repository;
import rest.entity.CountriesEntity;
import rest.request.RequestParams;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class CountryServiceImpl  extends Service<CountriesEntity>{

    @Override
    public List<CountriesEntity> filterEntities(RequestParams requestParams, Class<CountriesEntity> clazz) {
        String searchString = (String) requestParams.getSearch().get("value");
        String resultSearchString = "%" + searchString + "%";

        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(clazz);

        criteria.add(Restrictions.or(
                Restrictions.like("countryName", resultSearchString),
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
