package es.indra.travel.partner.preferences.core.business.logic.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import es.indra.travel.partner.preferences.core.domain.Preferences;
import es.indra.travel.partner.preferences.core.interfaces.data.PreferencesDataDelete;
import es.indra.travel.partner.preferences.core.interfaces.data.PreferencesDataSave;
import es.indra.travel.partner.preferences.core.interfaces.data.PreferencesDataUpdate;
import es.indra.travel.partner.preferences.core.interfaces.services.PreferenceServiceDelete;
import es.indra.travel.partner.preferences.core.interfaces.services.PreferenceServiceUpdate;
import es.indra.travel.partner.preferences.core.interfaces.services.PreferencesServiceSave;


@Service
public class PreferencesService implements PreferencesServiceSave, PreferenceServiceUpdate, PreferenceServiceDelete {

    @Autowired
    private PreferencesDataSave preferencesDataSave;

    @Autowired
    private PreferencesDataUpdate preferencesDataUpdate;

    @Autowired
    private PreferencesDataDelete preferencesDataDelete;

    @Override
    public Preferences delete(String userId) {
        // TODO Logica de negocio
        return preferencesDataDelete.delete(userId);
    }

    @Override
    public Preferences update(Preferences preferences) {
        // TODO Logica de negocio
        return preferencesDataUpdate.update(preferences);
    }

    @Override
    public Preferences save(Preferences preferences) {
        // TODO Logica de negocio
        return preferencesDataSave.save(preferences);
    }



}
