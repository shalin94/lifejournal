package lifejournal;

import lifejournal.dao.Entry;
import org.parse4j.ParseException;
import org.parse4j.ParseQuery;
import org.parse4j.ParseUser;

import java.util.Date;
import java.util.List;

/**
 * Created by chintan on 9/28/14.
 */
public class Database {
    public static String storeJournalEntry(String userEmailAddress, Date entryDate, String entry) {
        //search for the user
        ParseUser user = findUserByEmail(userEmailAddress);
        Entry e = Entry.createInstance(user, entryDate, entry);
        try {
            e.save();
            return e.getId();
        } catch (ParseException e1) {
            e1.printStackTrace();
        }
        return null;
    }

    public static ParseUser findUserByEmail(String userEmail) {
        ParseQuery<ParseUser> query = ParseQuery.getQuery(ParseUser.class);
        query.whereEqualTo("email", userEmail);
        try {
            List<ParseUser> users =  query.find();
            if(users.size() > 1) {
                throw new ParseException(new Throwable("Multiple values found where expecting a single return value"));
            }
            return users.get(0);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }

}
