package rest.service;

import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Repository;
import rest.entity.FirmsEntity;
import rest.entity.MarksEntity;
import rest.request.RequestParams;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class MarkServiceImpl extends Service<MarksEntity> {

    public List<MarksEntity> filterEntities(RequestParams requestParams, Class<MarksEntity> firmsEntityClass) {
        return super.filterEntities(requestParams, MarksEntity.class);
    }

    protected Disjunction getRestrictions(RequestParams requestParams) {
        String searchString = (String) requestParams.getSearch().get("value");
        return Restrictions.or(
                Restrictions.like("markName", searchString, MatchMode.ANYWHERE),
                Restrictions.like("markName", searchString, MatchMode.ANYWHERE),
                Restrictions.like("id", searchString, MatchMode.ANYWHERE)
        );
    }
}
