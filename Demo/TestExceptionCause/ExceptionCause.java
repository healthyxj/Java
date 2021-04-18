package com.mooc.week6.TestExceptionCause;

public class ExceptionCause {
    public static void main(String[] args) {
        try{
            BankATM.GetBalanceInfo(123L);    //123
            //BankATM.GetBalanceInfo(123456L);
            /*
            Something wrong: com.mooc.week6.TestExceptionCause.MyAppException: Invalid id
            cause: com.mooc.week6.TestExceptionCause.DataHouseException: cannot find the id
             */
        }catch(Exception e){
            System.out.println("Something wrong: "  + e);
            System.out.println("cause: " + e.getCause());
        }
    }
}
