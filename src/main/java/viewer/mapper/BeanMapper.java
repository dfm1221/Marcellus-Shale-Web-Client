package viewer.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.dozer.Mapper;
import org.dozer.MappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import viewer.model.OBJ;
import viewer.dto.BasePersistentDto;


/**
 * User: Justin Ford
 * Date: 10/8/12
 * Time: 7:27 PM
 */
@Component
public class BeanMapper {

    @Autowired
    private Mapper beanMapper;

    public <E extends OBJ, D extends BasePersistentDto> D fromEntity(E source, Class<D> destinationClass) {
        return map(source, destinationClass);
    }

    public <E extends OBJ, D extends BasePersistentDto> List<D> fromEntityList(Collection<E> source, Class<D> destinationClass) {
        List<D> results = new ArrayList<D>();
        if (source != null) {
            for(E sourceObj : source) {
                results.add(fromEntity(sourceObj, destinationClass));
            }
        }
        return results;
    }

    public <E extends OBJ, D extends BasePersistentDto> E toEntity(D source, Class<E> destinationClass) {
        return map(source, destinationClass);
    }

    public <E extends OBJ, D extends BasePersistentDto> Collection<E> toEntityCollection(Collection<D> source, Class<E> destinationClass) {
        List<E> results = new ArrayList<E>();
        if (source != null) {
            for(D sourceObj : source) {
                results.add(toEntity(sourceObj, destinationClass));
            }
        }
        return results;
    }

    public <E extends OBJ, D extends BasePersistentDto> void fromEntity(E source, D destination) {
        map(source, destination);
    }

    public <E extends OBJ, D extends BasePersistentDto> void toEntity(D source, E destination) {
        map(source, destination);
    }

    public <T> T mapReturnEmptyIfNull(Object source, Class<T> destinationClass) throws MappingException {
        T result = map(source, destinationClass);
        if (result == null) {
            try {
                result = destinationClass.newInstance();
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        return result;
    }

    /** From Mapper **/

    public <T> T map(Object source, Class<T> destinationClass) throws MappingException {
        if (source == null) {
            return null;
        }
        return beanMapper.map(source, destinationClass);
    }

    public void map(Object source, Object destination) throws MappingException {
        if (source != null) {
            beanMapper.map(source, destination);
        }
    }

    public <T> T map(Object source, Class<T> destinationClass, String mapId) throws MappingException {
        if (source == null) {
            return null;
        }
        return beanMapper.map(source, destinationClass, mapId);
    }

    public void map(Object source, Object destination, String mapId) throws MappingException {
        if (source != null) {
            beanMapper.map(source, destination, mapId);
        }
    }
}
