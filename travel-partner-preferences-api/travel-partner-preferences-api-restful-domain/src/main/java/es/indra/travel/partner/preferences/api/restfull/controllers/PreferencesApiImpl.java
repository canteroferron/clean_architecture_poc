package es.indra.travel.partner.preferences.api.restfull.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import es.indra.travel.partner.preferences.api.restfull.PreferencesApiDelegate;
import es.indra.travel.partner.preferences.core.domain.Preferences;
import es.indra.travel.partner.preferences.core.interfaces.services.PreferenceServiceDelete;
import es.indra.travel.partner.preferences.core.interfaces.services.PreferenceServiceUpdate;
import es.indra.travel.partner.preferences.core.interfaces.services.PreferencesServiceSave;


@Controller
public class PreferencesApiImpl implements PreferencesApiDelegate {

    @Autowired
    private PreferencesServiceSave preferencesServiceSave;

    @Autowired
    private PreferenceServiceUpdate preferenceServiceUpdate;

    @Autowired
    private PreferenceServiceDelete preferenceServiceDelete;


    @Override
    public ResponseEntity<Preferences> addPreferences(Preferences preferencesDto) {

        //Conversion to domain
        Preferences preferences = new Preferences();
        preferences.setUserId(preferencesDto.getUserId());
        preferences.setDescription(preferencesDto.getDescription());

        Preferences preferencesStored = preferencesServiceSave.save(preferences);

        //Convert to api
        Preferences preferencesDtoToReturn = new Preferences();
        preferencesDtoToReturn.setUserId(preferencesStored.getUserId());
        preferencesDtoToReturn.setDescription(preferencesStored.getDescription());

        return ResponseEntity.status(HttpStatus.OK).body(preferencesDtoToReturn);
    }


    @Override
    public ResponseEntity<Preferences> updatePreferences(Preferences preferencesDto) {
        //Conversion to domain
        Preferences preferences = new Preferences();
        preferences.setUserId(preferencesDto.getUserId());
        preferences.setDescription(preferencesDto.getDescription());

        Preferences preferencesUpdate = preferenceServiceUpdate.update(preferences);

        //Convert to api
        Preferences preferencesDtoToReturn = new Preferences();
        preferencesDtoToReturn.setUserId(preferencesUpdate.getUserId());
        preferencesDtoToReturn.setDescription(preferencesUpdate.getDescription());

        return ResponseEntity.status(HttpStatus.OK).body(preferencesDtoToReturn);
    }

    @Override
    public ResponseEntity<Void> deletePreferences(String userId) {

        preferenceServiceDelete.delete(userId);

        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
