package swing.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import model.AccountDTO;
import model.BookBalanceExport;

/**
 * {@code BookBalanceRestClient} Class
 * 
 * <br>
 * Rest Client for Managing Book Balances. This class to should be used to POST or Get Resources
 * from backend via rest end points. </br>
 * 
 * @since 2019-12-16
 * @author Rabito, Joshua
 *
 */
@ApplicationScoped
public class BookBalanceRestClient {
  private static final String IMPORT_ENDPOINT = ResourcesBundleReader.getString("endpoint.account.import"); //$NON-NLS-1$
  private static final String EXPORT_ENDPOINT = ResourcesBundleReader.getString("endpoint.account.export"); //$NON-NLS-1$

  private RestTemplate restTemplate;

  public BookBalanceRestClient() {
    // enforce use of factory method
    restTemplate = new RestTemplate();
    List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
    MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
    converter.setSupportedMediaTypes(Collections.singletonList(MediaType.APPLICATION_JSON));
    messageConverters.add(converter);
    restTemplate.setMessageConverters(messageConverters);
  }

  public HttpStatus postBookBalance(BookBalanceExport export) {
    ResponseEntity<BookBalanceExport> responseEntityStr =
        restTemplate.postForEntity(IMPORT_ENDPOINT, export, BookBalanceExport.class);

    return responseEntityStr.getStatusCode();

  }


  public AccountDTO loadFinances(String accountName, Date dateCreated) {
    ResponseEntity<AccountDTO> responseEntity =
       restTemplate.getForEntity(
        EXPORT_ENDPOINT, AccountDTO.class,
        accountName, dateCreated);
    System.out.println(responseEntity.getBody());
    return responseEntity.getBody();
  }

}
