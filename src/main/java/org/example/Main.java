package org.example;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner scanner = new Scanner(System.in);

        String validation;

        do {
            System.out.println("Digite seu cpf: ");
            String cpf = scanner.next();

            String url = "https://scpa-backend.prod.saude.gov.br/public/scpa-usuario/validacao-cpf/" + cpf;

            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());

            System.out.println("deseja verificar um cpf? (true/false)");
            validation = scanner.next();
        } while (!Objects.equals(validation, "false"));

        System.out.println("Vlw!");
    }
}
