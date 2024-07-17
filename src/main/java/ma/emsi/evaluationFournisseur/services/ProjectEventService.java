package ma.emsi.evaluationFournisseur.services;

import ma.emsi.evaluationFournisseur.entities.ProjectEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;

@Service
public class ProjectEventService {
    @Autowired
    private SimpMessagingTemplate messagingTemplate;
    public void sendProjectEvent(ProjectEvent projectEvent) {
        messagingTemplate.convertAndSend("/topic/projectEvent", projectEvent);
    }
    @Bean
    public Consumer<ProjectEvent> projectEventConsumer()
    {
        return (input)->{
            System.out.println("***************");
            System.out.println(input.toString());
            System.out.println("***************");
            sendProjectEvent(input);
        };
    }

}
