package lifejournal;

import lifejournal.dao.Entry;
import org.parse4j.*;

import java.util.Date;

public class test {
	static String APP_ID = "Tm6o3fOxEyVu7Cl6DbumfVrGT4q8J8QjXPo8N3tC";
	static String APP_REST_API_ID = "0eyn7DE1Ypo7iRQgMcE3gUGRfjLxTs6Z9UYxMJJP";
	public static void testFunc() {
		Parse.initialize(APP_ID, APP_REST_API_ID);
        //TODO: replace this with ParseUser. Search for ParseUser in the README for parse4j
		ParseObject userProfile = new ParseObject("UserProfile");
		userProfile.put("username", "shalin94@gmail.com");
		userProfile.put("name", "Shalin Shah");
		userProfile.put("password", "test");
		try {
			userProfile.save();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
