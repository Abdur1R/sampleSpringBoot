package com.sample.sample.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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
}