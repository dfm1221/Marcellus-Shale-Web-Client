package viewer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import viewer.dto.BasePersistentDto;
import viewer.mapper.BeanMapper;
import viewer.model.OBJ;

import java.util.Collection;
import java.util.List;

/**
 * User: Justin Ford
 * Date: 10/8/12
 * Time: 7:55 PM
 */
@Component
@Transactional
public abstract class BaseService {

    // custom bean mapper
    protected BeanMapper beanMapper;

    @Autowired
    public void setBeanMapper(BeanMapper beanMapper) {
        this.beanMapper = beanMapper;
    }

    /** Pass-throughs to maintain references in the code after Dozer Mapper is moved **/
    protected <E extends OBJ, D extends BasePersistentDto> D fromEntity(E source, Class<D> destinationClass) {
        return beanMapper.fromEntity(source, destinationClass);
    }

    protected <E extends OBJ, D extends BasePersistentDto> List<D> fromEntityList(Collection<E> source, Class<D> destinationClass) {
        return beanMapper.fromEntityList(source, destinationClass);
    }

    protected <E extends OBJ, D extends BasePersistentDto> E toEntity(D source, Class<E> destinationClass) {
        return beanMapper.toEntity(source, destinationClass);
    }

    protected <E extends OBJ, D extends BasePersistentDto> Collection<E> toEntityCollection(Collection<D> source, Class<E> destinationClass) {
        return beanMapper.toEntityCollection(source, destinationClass);
    }

    protected <E extends OBJ, D extends BasePersistentDto> void fromEntity(E source, D destination) {
        beanMapper.fromEntity(source, destination);
    }

    protected <E extends OBJ, D extends BasePersistentDto> void toEntity(D source, E destination) {
        beanMapper.toEntity(source, destination);
    }
}
