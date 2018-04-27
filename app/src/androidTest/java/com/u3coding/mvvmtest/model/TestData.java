package com.u3coding.mvvmtest.model;


import com.u3coding.mvvmtest.model.User;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Utility class that holds values to be used for testing.
 */
public class TestData {

    static final User User_ENTITY = new User();
    static {
        User_ENTITY.setFirstName("test");
    }

}
