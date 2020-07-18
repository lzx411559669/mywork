package org.lzx.control;
import org.lzx.model.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class MeetingRoomController {
    private static final List<MeetingRoom> meetingRooms = new ArrayList<>();
    @RequestMapping(path = "/openMeeting")
    public String openMeeting(MeetingRoom meetingRoom) {

        Date date = new Date();
      //  meetingRoom.setStartDate(date);
//        meetingRooms.add(meetingRoom);
        return "申请成功";
    }
}
