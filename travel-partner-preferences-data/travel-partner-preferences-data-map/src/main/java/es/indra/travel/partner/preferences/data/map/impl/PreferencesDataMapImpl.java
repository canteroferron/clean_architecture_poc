package es.indra.travel.partner.preferences.data.map.impl;

import java.util.Map;
import org.springframework.stereotype.Component;
import com.google.common.collect.Maps;
import es.indra.travel.partner.preferences.core.domain.Preferences;
import es.indra.travel.partner.preferences.core.interfaces.data.PreferencesDataDelete;
import es.indra.travel.partner.preferences.core.interfaces.data.PreferencesDataSave;
import es.indra.travel.partner.preferences.core.interfaces.data.PreferencesDataUpdate;

@Component
public class PreferencesDataMapImpl implements PreferencesDataSave, PreferencesDataUpdate, PreferencesDataDelete {


    private final Map<String, Preferences> storeByUserId = Maps.newHashMap();

    @Override
    public Preferences delete(String userId) {
        return storeByUserId.remove(userId);
    }

    @Override
    public Preferences update(Preferences preferencesToUpdate) {
        storeByUserId.put(preferencesToUpdate.getUserId(), preferencesToUpdate);
        return preferencesToUpdate;
    }

    @Override
    public Preferences save(Preferences preferencesToSave) {
        storeByUserId.put(preferencesToSave.getUserId(), preferencesToSave);
        return preferencesToSave;
    }

}
