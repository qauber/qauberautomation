package com.qauber.samplecode;

import com.qauber.pagesresource.User;
import com.qauber.pagesresource.UserFactory;
import org.testng.annotations.Test;

/**
 * Created by erikfriedlander on 12/19/16.
 * Creates and activates a valid user, and saves user info in user config.
 ************* This script WIPES LOCAL USER CONFIG FILES! ****************
 *
 */
public class GenerateSAUTest {

    @Test
    public void GenerateSAUTest() {
        User user;
        UserFactory userFactory = new UserFactory();

        userFactory.wipeLocalUserConfig(); //wipe local configuration files
        user = userFactory.getUser(User.UserType.SAU); //attempt to read user from (wiped) config - if it fails, make a new user...
        user.listUserProperties();

    }
}