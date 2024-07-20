package database;

/**
 * Entry point of an application ,calls retrecords() method
 */

public class Check
{

    public static void main(String[] args)
    {
        CreateTable.createtable(); //Creates a table
        GetRecords.getrecords();

    }
}
