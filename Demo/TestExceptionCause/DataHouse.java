package com.mooc.week6.TestExceptionCause;

public class DataHouse {
    public static void FindData(long ID) throws DataHouseException{
        if(ID > 0 && ID < 1000){
            System.out.println("id: " + ID);
        }else{
            throw new DataHouseException("cannot find the id");
        }
    }
}

class DataHouseException extends Exception{
    public DataHouseException(String message){
        super(message);
    }
}
