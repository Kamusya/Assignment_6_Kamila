package com.company;

public class Database {
// The Database class defines the `getInstance` method that lets
// clients access the same instance of a database connection
// throughout the program.

        // The field for storing the singleton instance should be
        // declared static.
    private static Database instance=new Database();
// The singleton's constructor should always be private to
// prevent direct construction calls with the `new`
// operator.
    private Database(){}
// Some initialization code, such as the actual
// connection to a database server.
// ...

// The static method that controls access to the singleton
// instance.
public static Database getInstance() {
    if (Database.instance == null){
        Database.instance = new Database();}
    return Database.instance;
}
    // Ensure that the instance hasn't yet been
    // initialized by another thread while this one
    // has been waiting for the lock's release
// Finally, any singleton should define some business logic
// which can be executed on its instance.
}