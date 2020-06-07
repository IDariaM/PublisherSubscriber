package idariam.PublisherSubscriber.controller;

import idariam.PublisherSubscriber.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublisherController {
    private final PublisherService publisherService;

    @Autowired //shows the necessity to inject the dependence here
    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @GetMapping //method created for testing the services sending GET requests to publisher service to make it send POST
    public void getRequest() {
        publisherService.sendRequest();
    }
}
