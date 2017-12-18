package rest.service;

        import org.hibernate.criterion.Disjunction;
        import org.hibernate.criterion.MatchMode;
        import org.hibernate.criterion.Restrictions;
        import org.springframework.context.annotation.EnableAspectJAutoProxy;
        import org.springframework.stereotype.Repository;
        import rest.entity.DriversEntity;
        import rest.entity.JackedCarsEntity;
        import rest.request.RequestParams;

        import javax.transaction.Transactional;
        import java.time.format.DateTimeFormatter;
        import java.util.Date;
        import java.util.List;

@Repository
@Transactional
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class JackedCarServiceImpl extends Service<JackedCarsEntity> {

    public List<JackedCarsEntity> filterEntities(RequestParams requestParams, Class<JackedCarsEntity> jackedCarsEntityClass) {
        return super.filterEntities(requestParams, JackedCarsEntity.class);
    }

    protected Disjunction getRestrictions(RequestParams requestParams) {
        String searchString = (String) requestParams.getSearch().get("value");
        return Restrictions.or(
                Restrictions.like("jcAdditional", searchString, MatchMode.ANYWHERE),
                Restrictions.like("jcFoundDate", searchString, MatchMode.ANYWHERE),
                Restrictions.like("driverCategory", searchString, MatchMode.ANYWHERE),
                Restrictions.like("id", searchString, MatchMode.ANYWHERE)
        );
    }
}
