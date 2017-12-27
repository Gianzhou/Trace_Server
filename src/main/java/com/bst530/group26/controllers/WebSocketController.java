package com.bst530.group26.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.bst530.group26.model.Group;
import com.bst530.group26.model.GroupMember;
import com.bst530.group26.model.Point;
import com.bst530.group26.model.RequestMessage;
import com.bst530.group26.model.ResponseMessage;
import com.bst530.group26.repositories.GroupMemberRepository;
import com.bst530.group26.repositories.GroupRepository;
import com.bst530.group26.repositories.PointRepository;

import java.util.List;


@Controller
public class WebSocketController {
    @Autowired
    private SimpMessagingTemplate template;
    @Autowired
    private PointRepository pointRepository;
    @Autowired
    private GroupMemberRepository groupMemberRepository;
    @Autowired
    private GroupRepository groupRepository;

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public String greeting(String message) throws Exception {
        return new String("Welcome");
    }

    @MessageMapping("/{groupID}/changeLocation")
    public void changeLocation(@Payload RequestMessage requestMessage, @DestinationVariable long groupID){
        long user_id = requestMessage.getSenderID();
        long group_id = requestMessage.getGroupID();
        double latitude = requestMessage.getLatitude();
        double longitude = requestMessage.getLongitude();
        boolean insert = false;

        GroupMember member = groupMemberRepository.findOne(user_id);
        Group group = groupRepository.findOne(group_id);

        Point newPoint = new Point(group.getID(), member.getId(), latitude, longitude);
        List<Point> points = pointRepository.findAllByGroupIdAndGroupMemberId(group_id, user_id);
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
