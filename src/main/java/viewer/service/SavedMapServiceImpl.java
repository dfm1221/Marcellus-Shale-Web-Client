package viewer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import viewer.dao.SavedMapDao;
import viewer.dto.SavedMapDto;
import viewer.model.SavedMap;

/**
 * User: Justin Ford
 * Date: 10/8/12
 * Time: 8:27 PM
 */

@Service
public class SavedMapServiceImpl extends BaseService implements SavedMapService{

    @Autowired
    SavedMapDao savedMapDao;

    @Override
    public SavedMapDto createSavedMap(SavedMapDto savedMapDto) {
        // create User entity
        SavedMap savedMap = toEntity(savedMapDto, SavedMap.class);

        savedMapDao.create(savedMap);
        return beanMapper.fromEntity(savedMap, SavedMapDto.class);
    }

    @Override
    public SavedMapDto updateSavedMap(SavedMapDto savedMapDto) {
        return null;
    }
}
