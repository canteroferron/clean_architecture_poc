package es.indra.travel.partner.preferences.core.interfaces.services;

import es.indra.travel.partner.preferences.core.domain.Preferences;

public interface PreferenceServiceDelete {


    Preferences delete(String userId);
}
