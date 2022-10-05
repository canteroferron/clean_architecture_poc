package es.indra.travel.partner.preferences.api.grpc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import es.indra.travel.partner.preferences.api.grpc.services.PreferencesServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;

@Component
public class PreferencesGRPCLauncher implements CommandLineRunner {

    @Autowired
    private PreferencesServiceImpl preferencesServiceImpl;

    @Override
    public void run(String... args) throws Exception {
        Server server =
            ServerBuilder
                .forPort(8091)
                .addService(preferencesServiceImpl)
                .addService(ProtoReflectionService.newInstance())
                .build();

        System.out.println("Starting server...");
        server.start();
        System.out.println("Server started!");
        server.awaitTermination();

    }

}
