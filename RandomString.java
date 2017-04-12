package helper;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * Created by Em on 4/8/2017.
 */
public class RandomString {
    public String generateRandomNameString() {
        return new BigInteger(16, new SecureRandom()).toString(64);
    }
}
