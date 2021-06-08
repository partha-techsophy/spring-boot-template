package com.techsophy.demo.restclient;

import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;

/**
 * Annotate rest client with class as argument to test
 */
@RestClientTest
public class RestClientSampleTest {

    /**
     * Initialize mock rest server
     */
//    @Autowired
//    private MockRestServiceServer server;


    /**
     * Sample code
     */
//    @Test
//    void testAThirdPartyService() {
//        server
//            .expect(once(), requestTo(startsWith("/movie-quote")))
//            .andExpect(method(HttpMethod.GET))
//            .andExpect(queryParam("page", "0"))
//            .andExpect(queryParam("pageSize", "10"))
//            .andRespond(withSuccess(new ClassPathResource("movie-quotes.json"), MediaType.APPLICATION_JSON));
//    }
}
