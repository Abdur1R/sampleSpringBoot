package com.sample.sample.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/jobs")
public class JobsController {

    @GetMapping("/amazon")
    public ResponseEntity<String> AmazonJobs() {
        String url = "https://www.amazon.jobs/en/search.json?offset=0&result_limit=100&sort=relevant&latitude=38.89037&longitude=-77.03196&loc_group_id=&loc_query=United%20States&base_query=&city=&country=USA&region=&county=&query_options=&";

        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", "application/json, text/plain, */*");
        headers.add("Accept-Language", "en-GB,en-US;q=0.9,en;q=0.8,tr;q=0.7");
        headers.add("Connection", "keep-alive");
        headers.add("Cookie", "__Host-mons-sid=133-9906859-9103461; preferred_locale=en-US; ...");
        headers.add("Referer", "https://www.amazon.jobs/en/search?offset=0&result_limit=10&...");
        headers.add("Sec-Fetch-Dest", "empty");
        headers.add("Sec-Fetch-Mode", "cors");
        headers.add("Sec-Fetch-Site", "same-origin");
        headers.add("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/128.0.0.0 Safari/537.36");
        headers.add("sec-ch-ua", "\"Chromium\";v=\"128\", \"Not;A=Brand\";v=\"24\", \"Google Chrome\";v=\"128\"");
        headers.add("sec-ch-ua-mobile", "?0");
        headers.add("sec-ch-ua-platform", "\"Windows\"");

        HttpEntity<String> entity = new HttpEntity<>(headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        return ResponseEntity.ok(response.getBody());
    }

    @GetMapping("/apple")
    public ResponseEntity<String> searchJobs() {
        String csrfUrl = "https://jobs.apple.com/api/csrfToken";
        String searchUrl = "https://jobs.apple.com/api/role/search";

        RestTemplate restTemplate = new RestTemplate();

        // Step 1: Fetch CSRF Token
        HttpHeaders csrfHeaders = new HttpHeaders();
        csrfHeaders.set("accept", "*/*");
        csrfHeaders.set("accept-language", "en-GB,en-US;q=0.9,en;q=0.8,tr;q=0.7");
        csrfHeaders.set("cache-control", "no-cache");
        csrfHeaders.set("referer", "https://jobs.apple.com/en-us/search?sort=relevance&key=develop+software+engineer&location=united-states-USA");
        csrfHeaders.set("sec-ch-ua", "\"Chromium\";v=\"128\", \"Not;A=Brand\";v=\"24\", \"Google Chrome\";v=\"128\"");
        csrfHeaders.set("sec-ch-ua-mobile", "?0");
        csrfHeaders.set("sec-ch-ua-platform", "\"Windows\"");
        csrfHeaders.set("sec-fetch-dest", "empty");
        csrfHeaders.set("sec-fetch-mode", "cors");
        csrfHeaders.set("sec-fetch-site", "same-origin");
        csrfHeaders.set("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/128.0.0.0 Safari/537.36");

        HttpEntity<String> csrfEntity = new HttpEntity<>(csrfHeaders);
        ResponseEntity<String> csrfResponse = restTemplate.exchange(csrfUrl, HttpMethod.GET, csrfEntity, String.class);
        String csrfToken = csrfResponse.getHeaders().getFirst("X-Apple-CSRF-Token");

        // Step 2: Use CSRF Token in Job Search API
        HttpHeaders searchHeaders = new HttpHeaders();
        searchHeaders.set("accept", "*/*");
        searchHeaders.set("accept-language", "en-GB,en-US;q=0.9,en;q=0.8,tr;q=0.7");
        searchHeaders.set("cache-control", "no-cache");
        searchHeaders.set("content-type", "application/json");
        searchHeaders.set("x-apple-csrf-token", csrfToken);
        // Set other headers as necessary

        String requestBody = "{\"query\":\"\",\"filters\":{\"keyword\":[\"develop\",\"software\",\"engineer\"],\"postingpostLocation\":[\"postLocation-USA\"],\"range\":{\"standardWeeklyHours\":{\"start\":null,\"end\":null}}},\"page\":1,\"locale\":\"en-us\",\"sort\":\"relevance\"}";

        HttpEntity<String> searchEntity = new HttpEntity<>(requestBody, searchHeaders);
        ResponseEntity<String> searchResponse = restTemplate.exchange(searchUrl, HttpMethod.POST, searchEntity, String.class);

        return ResponseEntity.ok(searchResponse.getBody());
    }

    @GetMapping("/alljobs")
    public ResponseEntity<String> fetchJobs(@RequestParam(required = false) String title,
                                            @RequestParam(required = false) String startDate,
                                            @RequestParam(required = false) String endDate,
                                            @RequestParam(required = false) String location) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Api-Key YOUR_API_KEY");
        headers.add("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/128.0.0.0 Safari/537.36");
        headers.add("Accept", "application/json, text/plain, */*");
        headers.add("Accept-Language", "en-GB,en-US;q=0.9,en;q=0.8,tr;q=0.7");
        headers.add("Connection", "keep-alive");
        String url = "https://jobdataapi.com/api/jobs/";
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(url);
//                .queryParam("title", title)
//                .queryParam("location", location)
//                .queryParam("published_since", startDate)
//                .queryParam("published_until",endDate);
        if(!(title == null || title.isEmpty())) {
            uriBuilder.queryParam("title", title);
        }
        if(!(location == null || location.isEmpty())) {
            uriBuilder.queryParam("location", location);
        }
        if(!(startDate == null || startDate.isEmpty())) {
            uriBuilder.queryParam("published_since", startDate);
        }
        if(!(endDate== null || endDate.isEmpty())) {
            uriBuilder.queryParam("published_until", endDate);
        }
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(uriBuilder.toUriString(), HttpMethod.GET, entity, String.class);
        return ResponseEntity.ok(response.getBody());
    }
}
