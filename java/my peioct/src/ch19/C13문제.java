package ch19;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import com.fasterxml.jackson.databind.ObjectMapper;

public class C13문제 {

	public static void main(String[] args) throws IOException, InterruptedException {

		String api_key = "8f3427e3df1d59a055a367213b42d54a";
		String url = "https://api.openweathermap.org/data/2.5/weather?lat=" + args[0] + "&lon=" + args[1] + "&appid="+ api_key;

		// Http Request 객체 생성
		HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();

		// Http Request 요청 / 응답 확인
		HttpClient httpClient = HttpClient.newHttpClient();

		HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
		System.out.println(response.body());

	}
}
