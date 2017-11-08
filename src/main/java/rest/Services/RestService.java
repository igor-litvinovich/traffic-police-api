package rest.Services;

import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface RestService<T> {
    List<T> getAll(Class<T> clazz);
}
