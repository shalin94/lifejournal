package lifejournal.dao;

import org.parse4j.ParseClassName;
import org.parse4j.ParseObject;
import org.parse4j.ParseUser;

import java.util.Date;
import java.util.UUID;

/**
 * Created by chintan on 9/28/14.
 */
@ParseClassName("Entry")
public class Entry extends ParseObject {
    private Date entryDate;
    private String content;
    private ParseUser parent;

    //TODO: maybe move this to UserFactory?
    public static Entry createNewInstance() {
        return (Entry)ParseObject.create(Entry.class.getName());
    }

    //TODO: maybe move this to UserFactory?
    public static Entry createInstance(ParseUser user, Date date, String content) {
        Entry e = Entry.createNewInstance();
        e.setParent(user);
        e.setContent(content);
        e.setEntryDate(date);
        return e;
    }

    public Date getEntryDate() {
        return getDate("entryDate");
    }

    public void setEntryDate(Date entryDate) {
        put("entryDate", entryDate);
    }

    public String getContent() {
        return getString("content");
    }

    public void setContent(String contents) {
        put("contents", contents);
    }

    public String getId() {
        return this.getObjectId();
    }

    public void setId(String id) {
        this.setObjectId(id);
    }

    public ParseUser getParent() {
        return (ParseUser)getParseObject("parent");
    }

    public void setParent(ParseUser user) {
        put("parent", user);
    }
}
