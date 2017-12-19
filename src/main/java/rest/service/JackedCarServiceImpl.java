package rest.service;

import org.hibernate.Session;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Repository;
import rest.entity.CarEntity;
import rest.entity.DriversEntity;
import rest.entity.JackedCarsEntity;
import rest.request.RequestParams;

import javax.transaction.Transactional;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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

    @Override
    public JackedCarsEntity update(JackedCarsEntity entity) {
        Session session = sessionFactory.getCurrentSession();
        CarEntity carEntity = this.getCarById(entity.getAmsById().get(0).getId());
        DriversEntity driverEntity = this.getDriverById(entity.getDriversById().get(0).getId());
        List<CarEntity> cars = new ArrayList<>();
        List<DriversEntity> drivers = new ArrayList<>();
        driverEntity.setJackedCarsByJackedCarId(entity);
        carEntity.setJackedCarsByJackedCarId(entity);
        session.merge(carEntity);
        session.merge(driverEntity);
        cars.add(carEntity);
        drivers.add(driverEntity);
        entity.setDriversById(drivers);
        entity.setAmsById(cars);
        session.merge(entity);
        return entity;
    }

    //TODO should be refactored. made due to the lack of time.
    private CarEntity getCarById(String id) {
        Session session = sessionFactory.getCurrentSession();
        CarEntity item = session.byId(CarEntity.class).load(id);
        return item;
    }

    //TODO should be refactored. made due to the lack of time.
    private DriversEntity getDriverById(String id) {
        Session session = sessionFactory.getCurrentSession();
        DriversEntity item = session.byId(DriversEntity.class).load(id);
        return item;
    }
}
