package bui.quocdat.meetingvideo.Listeners;

import bui.quocdat.meetingvideo.Models.User;

public interface UsersListener {

    void initiateVideoMeeting(User user);

    void initiateAudioMeeting(User user);

}
