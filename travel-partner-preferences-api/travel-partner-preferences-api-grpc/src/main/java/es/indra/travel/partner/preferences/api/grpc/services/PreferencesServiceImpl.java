package es.indra.travel.partner.preferences.api.grpc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import es.indra.travel.partner.preferences.api.grpc.PreferencesDeleteRequest;
import es.indra.travel.partner.preferences.api.grpc.PreferencesRequest;
import es.indra.travel.partner.preferences.api.grpc.PreferencesResponse;
import es.indra.travel.partner.preferences.api.grpc.PreferencesServiceGrpc.PreferencesServiceImplBase;
import es.indra.travel.partner.preferences.core.domain.Preferences;
import es.indra.travel.partner.preferences.core.interfaces.services.PreferenceServiceDelete;
import es.indra.travel.partner.preferences.core.interfaces.services.PreferenceServiceUpdate;
import es.indra.travel.partner.preferences.core.interfaces.services.PreferencesServiceSave;
import io.grpc.stub.StreamObserver;

@Component
public class PreferencesServiceImpl extends PreferencesServiceImplBase {

    @Autowired
    private PreferencesServiceSave preferencesServiceSave;

    @Autowired
    private PreferenceServiceUpdate preferenceServiceUpdate;

    @Autowired
    private PreferenceServiceDelete preferenceServiceDelete;


    @Override
    public void addPreferences(PreferencesRequest request, StreamObserver<PreferencesResponse> responseObserver) {


        Preferences preferencesToSave = new Preferences();
        preferencesToSave.setUserId(request.getUserId());
        preferencesToSave.description(request.getDescription());

        Preferences preferenceSaved = preferencesServiceSave.save(preferencesToSave);

        PreferencesResponse preferencesResponse =
            PreferencesResponse
                .newBuilder()
                .setDescription(preferenceSaved.getDescription())
                .setUserId(preferenceSaved.getUserId())
                .build();

        responseObserver.onNext(preferencesResponse);
        responseObserver.onCompleted();
    }


    @Override
    public void updatePreferences(PreferencesRequest request, StreamObserver<PreferencesResponse> responseObserver) {
        Preferences preferencesToUpdate = new Preferences();
        preferencesToUpdate.setUserId(request.getUserId());
        preferencesToUpdate.description(request.getDescription());

        Preferences preferencesUpdated = preferencesServiceSave.save(preferencesToUpdate);

        PreferencesResponse preferencesResponse =
            PreferencesResponse
                .newBuilder()
                .setDescription(preferencesUpdated.getDescription())
                .setUserId(preferencesUpdated.getUserId())
                .build();

        responseObserver.onNext(preferencesResponse);
        responseObserver.onCompleted();
    }


    @Override
    public void deletePreferences(
        PreferencesDeleteRequest request,
        StreamObserver<PreferencesResponse> responseObserver) {

        Preferences preferencesDeleted = preferenceServiceDelete.delete(request.getUserId());

        PreferencesResponse preferencesResponse =
            PreferencesResponse
                .newBuilder()
                .setDescription(preferencesDeleted.getDescription())
                .setUserId(preferencesDeleted.getUserId())
                .build();

        responseObserver.onNext(preferencesResponse);
        responseObserver.onCompleted();
    }
}
