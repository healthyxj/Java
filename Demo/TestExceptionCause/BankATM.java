package com.mooc.week6.TestExceptionCause;

public class BankATM {
    public static void GetBalanceInfo(long ID)throws MyAppException{
        try{
            DataHouse.FindData(ID);
        }catch(DataHouseException e){
            throw new MyAppException("Invalid id", e);
        }
    }
}

class MyAppException extends Exception{
    public MyAppException(String message){
        super(message);
    }
    public MyAppException(String message, Exception cause){
        super(message, cause);
    }
}
