package es.indra.travel.partner.preferences.core.interfaces.data;

import es.indra.travel.partner.preferences.core.domain.Preferences;

public interface PreferencesDataSave {


    Preferences save(Preferences preferencesToSave);
}
