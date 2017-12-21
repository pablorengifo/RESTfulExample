package com.mkyong.client;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class JerseyClientPost {

	public static void main(String[] args) {

		try {

			Gson gson = new Gson();

			Client client = Client.create();

			WebResource webResource = client
					.resource("http://localhost:8443/api/bcp/axioma/stark/endorsement-letter");

			String input = "{\n" +
                    "  \"codCliente\": \"34343434 6\",\n" +
                    "  \"codLinea\": \"FAD001\",\n" +
                    "  \"codMoneda\": \"0001\",\n" +
                    "  \"codUsuario\": \"41641404\",\n" +
                    "  \"comisionCancelacion\": \"0040000\",\n" +
                    "  \"comisionDesembolso\": \"0000000\",\n" +
                    "  \"cuentaAbono\": \"193C1477574\",\n" +
                    "  \"cuentaCargo\": \"193C1477574\",\n" +
                    "  \"fechaFin\": \"18102017\",\n" +
                    "  \"fechaFirma\": \"18102017\",\n" +
                    "  \"fechaValuta\": \"18102017\",\n" +
                    "  \"importeCredito\": \"000000000410000\",\n" +
                    "  \"isAdvancePayment\": \"0\",\n" +
                    "  \"nombreBeneficiario\": \"toma20\",\n" +
                    "  \"numOficina\": \"000\",\n" +
                    "  \"tipoCartaFianza\": \"ADJ\"\n" +
                    "}\n";

			ClientResponse response = webResource.type("application/json")
					.post(ClientResponse.class, input);

			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatus());
			}

			System.out.println("Output from Server .... \n");
			String output = response.getEntity(String.class);
			System.out.println(output);

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

}
