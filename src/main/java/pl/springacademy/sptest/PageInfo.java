package pl.springacademy.sptest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class PageInfo {
    @Value("${page-info.author}")
    private String author;
    @Value("${page-info.creation-date}")
    private int creationDate;

    @EventListener(ApplicationReadyEvent.class)
    public void get(){
        System.out.println(author);
        System.out.println(creationDate);
    }
}
