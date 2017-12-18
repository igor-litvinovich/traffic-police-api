package rest.service;

import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Repository;
import rest.entity.DriversEntity;
import rest.entity.FirmsEntity;
import rest.request.RequestParams;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class FirmServiceImpl extends Service<FirmsEntity> {

    public List<FirmsEntity> filterEntities(RequestParams requestParams, Class<FirmsEntity> firmsEntityClass) {
        return super.filterEntities(requestParams, FirmsEntity.class);
    }

    protected Disjunction getRestrictions(RequestParams requestParams) {
        String searchString = (String) requestParams.getSearch().get("value");
        return Restrictions.or(
                Restrictions.like("firmName", searchString, MatchMode.ANYWHERE),
                Restrictions.like("firmName", searchString, MatchMode.ANYWHERE),
                Restrictions.like("id", searchString, MatchMode.ANYWHERE)
        );
    }
}
