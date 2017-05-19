package tr.com.mebitech.presentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tr.com.mebitech.entity.Meeting;
import tr.com.mebitech.service.interfaces.MeetingService;

@RestController
@RequestMapping("meeting")
public class MeetingRestController {
	@Autowired
	private MeetingService meetingService;

	@RequestMapping(value="insert", method=RequestMethod.POST)
	public Meeting insertMeeting(@RequestBody Meeting meeting) {
		return meetingService.insertMeeting(meeting);
	}

	@RequestMapping(value="update", method=RequestMethod.POST)
	public Meeting updateMeeting(@RequestBody Meeting meeting) {
		return meetingService.updateMeeting(meeting);
	}

	@RequestMapping(value="delete", method=RequestMethod.POST)
	public boolean deleteMeeting(@RequestBody Meeting meeting) {
		return meetingService.deleteMeeting(meeting);
	}

	@RequestMapping(value="getall", method=RequestMethod.POST)
	public List<Meeting> getAllMeeting() {
		return meetingService.getAllMeeting();
	}
}
