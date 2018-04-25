package com.u3coding.mvvmtest.database;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.u3coding.mvvmtest.model.User;
import com.u3coding.mvvmtest.model.UserDao;

import java.util.List;

public class UserRepository {

        private UserDao mUserDao;
        private LiveData<List<User>> mAllUsers;

        public UserRepository(Application application) {
            AppDatabase db = AppDatabase.getDatabase(application);
            mUserDao = db.userDao();
            mAllUsers = mUserDao.getAll();
        }

        public LiveData<List<User>> getAllUsers() {
            return mAllUsers;
        }


        public void insert (User word) {
            new insertAsyncTask(mUserDao).execute(word);
        }

        private static class insertAsyncTask extends AsyncTask<User, Void, Void> {

            private UserDao mAsyncTaskDao;

            insertAsyncTask(UserDao dao) {
                mAsyncTaskDao = dao;
            }

            @Override
            protected Void doInBackground(final User... params) {
                mAsyncTaskDao.insertAll(params[0]);
                return null;
            }
        }
    
}
