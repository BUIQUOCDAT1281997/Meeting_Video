package bui.quocdat.meetingvideo.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import bui.quocdat.meetingvideo.Listeners.UsersListener;
import bui.quocdat.meetingvideo.Models.User;
import bui.quocdat.meetingvideo.R;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UserViewHolder> {

    private List<User> users;
    private UsersListener usersListener;

    public UsersAdapter(List<User> users, UsersListener usersListener) {
        this.users = users;
        this.usersListener = usersListener;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new UserViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.item_container_user,
                        parent,
                        false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        holder.serUserData(users.get(position));
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    class UserViewHolder extends RecyclerView.ViewHolder {

        TextView textFirstChar, textUserName, textEmail;
        ImageView imageAudioMeeting, imageVideoMeeting;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            textFirstChar = itemView.findViewById(R.id.item_tv_first_char);
            textEmail = itemView.findViewById(R.id.item_tv_email);
            textUserName = itemView.findViewById(R.id.item_tv_user_name);
            imageAudioMeeting = itemView.findViewById(R.id.item_iv_call);
            imageVideoMeeting = itemView.findViewById(R.id.item_iv_video);
        }

        void serUserData(User user) {
            textFirstChar.setText(user.firstName.substring(0,1));
            textUserName.setText(String.format("%s %s", user.firstName, user.lastName));
            textEmail.setText(user.email);
            imageVideoMeeting.setOnClickListener(view -> usersListener.initiateVideoMeeting(user));
            imageAudioMeeting.setOnClickListener(view -> usersListener.initiateAudioMeeting(user));
        }
    }
}
