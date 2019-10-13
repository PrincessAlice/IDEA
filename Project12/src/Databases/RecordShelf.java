package Databases;

import Classes.Record;
import Classes.User;

import java.util.ArrayList;
import java.util.List;

public class RecordShelf {
    private List<Record> recordList = new ArrayList<>();

    private static RecordShelf instance = new RecordShelf();
    public static RecordShelf getInstance(){
        return instance;
    }
    public boolean contains(User user, String ISBN) {
        for(Record record:recordList){
            if(record.is(user,ISBN)){
                return true;
            }
        }
        return false;
    }

    public void putRecord(User user, String ISBN) {
        Record record = new Record(user.getId(),ISBN);
        recordList.add(record);
    }
}
