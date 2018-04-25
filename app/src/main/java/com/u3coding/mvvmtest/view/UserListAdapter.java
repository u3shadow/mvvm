package com.u3coding.mvvmtest.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.u3coding.mvvmtest.R;
import com.u3coding.mvvmtest.model.User;

import java.util.List;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.UserViewHolder> {

        class UserViewHolder extends RecyclerView.ViewHolder {
            private final TextView wordItemView;

            private UserViewHolder(View itemView) {
                super(itemView);
                wordItemView = itemView.findViewById(R.id.textView);
            }
        }

        private final LayoutInflater mInflater;
        private List<User> mUsers; // Cached copy of words

        UserListAdapter(Context context) { mInflater = LayoutInflater.from(context); }

        @Override
        public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
            return new UserViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(UserViewHolder holder, int position) {
            if (mUsers != null) {
                User current = mUsers.get(position);
                holder.wordItemView.setText(current.getFirstName());
            } else {
                // Covers the case of data not being ready yet.
                holder.wordItemView.setText("No User");
            }
        }

        void setUsers(List<User> words){
            mUsers = words;
            notifyDataSetChanged();
        }

        // getItemCount() is called many times, and when it is first called,
        // mUsers has not been updated (means initially, it's null, and we can't return null).
        @Override
        public int getItemCount() {
            if (mUsers != null)
                return mUsers.size();
            else return 0;
        }
}
