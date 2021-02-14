package com.joshuacodes.moneymanagerclient.api;

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
import com.joshuacodes.moneymanagerclient.model.AccountDTO;
import com.joshuacodes.moneymanagerclient.model.DeductionDTO;

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
  private static final String SAVINGS_SEARCH_ENDPOINT = ResourcesBundleReader.getString("endpoint.account.savings"); //$NON-NLS-1$


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

  public HttpStatus postBookBalance(AccountDTO export) {
    ResponseEntity<AccountDTO> responseEntityStr =
        restTemplate.postForEntity(IMPORT_ENDPOINT, export, AccountDTO.class);
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

  public DeductionDTO searchSavingsForDeduction(String deductionName) {
    ResponseEntity<DeductionDTO> responseEntity =
        restTemplate.getForEntity(
         SAVINGS_SEARCH_ENDPOINT, DeductionDTO.class, deductionName);
     System.out.println(responseEntity.getBody());
     return responseEntity.getBody();   
  }

}
