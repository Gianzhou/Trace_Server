package com.bst530.group26.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.bst530.group26.models.database.*;
import com.bst530.group26.models.messages.*;
import com.bst530.group26.repository.*;

import java.util.ArrayList;
import java.util.List;


@Controller
public class WebSocketController {
    @Autowired
    private SimpMessagingTemplate template;
    @Autowired
    private PointRepository pointRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private GroupRepository groupRepository;

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public String greeting(String message) throws Exception {
        return new String("Welcome");
    }

    /*
     * the role to mark current location is that the distance is longer than 100
     * the point would save and the procedure would execute through Repository
     */
    @MessageMapping("/{groupID}/changeLocation")
    public void changeLocation(@Payload RequestMessage requestMessage, @DestinationVariable long groupID){
        long user_id = requestMessage.getSenderID();
        long group_id = requestMessage.getGroupID();
        double latitude = requestMessage.getLatitude();
        double longitude = requestMessage.getLongitude();
        boolean insert = false;

        
        
// add the point to the user
        List<Point> points = new ArrayList<Point>(pointRepository.findAllByUserId(user_id));
        User user = userRepository.findOne(user_id);
        Point newPoint = new Point(user, latitude, longitude);
       
        if(points.size() > 0){
            //Get distance between two points
            Point lastPoint = points.get(points.size() - 1);

            //meters
            double distance = newPoint.distanceFrom(lastPoint);
            if(distance >= 100){
             
                 pointRepository.save(newPoint);
                insert = true;
            }
        }else{
        	 
             pointRepository.save(newPoint);
            insert = true;
        }
        ResponseMessage responseMessage = new ResponseMessage(user_id, group_id, latitude, longitude, insert);
        template.convertAndSend("/topic/" + groupID + "/locationChanged", responseMessage);
    }
}
