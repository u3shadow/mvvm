package com.u3coding.mvvmtest.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.u3coding.mvvmtest.database.UserRepository;
import com.u3coding.mvvmtest.model.User;

import java.util.List;

public class UserViewModel extends AndroidViewModel{

        private UserRepository mRepository;

        private LiveData<List<User>> mAllUsers;

        public UserViewModel (Application application) {
            super(application);
            mRepository = new UserRepository(application);
            mAllUsers = mRepository.getAllUsers();
        }

        public LiveData<List<User>> getAllUsers() { return mAllUsers; }

        public void insert(User word) { mRepository.insert(word); }
}
