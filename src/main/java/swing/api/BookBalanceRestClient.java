package swing.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import model.BookBalanceExport;

/**
 * {@code BookBalanceRestClient} Class
 * 
 * <br>
 * Rest Client for Managing Book Balances. This class to should be used to POST
 * or Get Resources from backend via rest end points. </br>
 * 
 * @since 2019-12-16
 * @author Rabito, Joshua
 *
 */
public class BookBalanceRestClient {
	private static final String IMPORT_ENDPOINT = "http://localhost:8080/import";
	private RestTemplate restTemplate;

	private BookBalanceRestClient() {
		// enforce use of factory method
		restTemplate = new RestTemplate();
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		converter.setSupportedMediaTypes(Collections.singletonList(MediaType.APPLICATION_JSON));
		messageConverters.add(converter);
		restTemplate.setMessageConverters(messageConverters);
	}

	public static BookBalanceRestClient getInstance() {
		return new BookBalanceRestClient();
	}

	public HttpStatus postBookBalance(BookBalanceExport export) {
		ResponseEntity<HttpStatus> responseEntityStr = restTemplate.postForEntity(IMPORT_ENDPOINT, export, HttpStatus.class);
		
		return responseEntityStr.getStatusCode();
	     
	}

}
