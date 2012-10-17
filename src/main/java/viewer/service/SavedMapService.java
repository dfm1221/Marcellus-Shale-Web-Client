package viewer.service;

import viewer.dto.SavedMapDto;

/**
 * Created with IntelliJ IDEA.
 * User: Justin Ford
 * Date: 10/8/12
 * Time: 8:26 PM
 */
public interface SavedMapService {

    SavedMapDto createSavedMap(SavedMapDto savedMapDto);

    SavedMapDto updateSavedMap(SavedMapDto savedMapDto);

}
