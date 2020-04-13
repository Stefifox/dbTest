# MySQL DATABASES Test
### A bored afternoon in my house
This is a little test of databases Java and MySQL's Table, in this README I provide some examples of my Table and some codes for implement Databases in Java applications.

----

# Installation
This code requires:
- MySQL Server [Link](https://dev.mysql.com/downloads/mysql/)
- Connector/J [Link](https://dev.mysql.com/downloads/connector/j/)
- JRE and JDK [Link](https://www.java.com/it/download/) [Link](https://www.oracle.com/java/technologies/javase-jdk14-downloads.html)

For windows users I suggest to use MySQL installer [Link](https://dev.mysql.com/downloads/installer/)

----

# Creating a Database and Table
## and uses
First you need to make a Database and Table, you need to start mysql using root account.

Open terminal and type:

Linux (I use Ubuntu 18)

```mysql -u root -p```

Windows

```mysqlsh -u root -p```

Now we can make a new Database

```mysql> CREATE DATABASE [database_name];```

If windows show JS after *mysql* use *\sql* command.

Selecting your Database

```USE [database_name];```

Now creating a new table with

```CREATE TABLE [table_name] ([field name] [Var type], [another filed name] [another var type]);```

for example

```CREATE TABLE events (id INT, event_name VARCHAR(20), event_description VARCHAR(256));```

If we use ```DESCRIBE [table_name];``` the command return the type and list of fields; in my case:

```DESCRIBE events;```

```
+-------------------+--------------+------+-----+---------+-------+
| Field             | Type         | Null | Key | Default | Extra |
+-------------------+--------------+------+-----+---------+-------+
| id                | int(11)      | YES  |     | NULL    |       |
| event_name        | varchar(20)  | YES  |     | NULL    |       |
| event_description | varchar(256) | YES  |     | NULL    |       |
+-------------------+--------------+------+-----+---------+-------+
```

If you want view the values contains in the fiedls you can use ```SELECT * FROM [table_name]``` in my case:

```SECLECT * FROM events;```

```
+------+--------------+-----------------------+
| id   | event_name   | event_description     |
+------+--------------+-----------------------+
|    1 | test         | this is a description |
|    2 | Another test | this is a description |
+------+--------------+-----------------------+
```

In this case I have insert 2 row in my table.

For more option or example please read the official tutorials provided in official documentations. [Link](https://dev.mysql.com/doc/refman/8.0/en/database-use.html)

----
# Java code

Adding to build path the correct library:
- Search the path of Connector/J installed in your computer. In my case ```C:\Program Files (x86)\MySQL\Connector J 8.0``` .
- Open your IDE and in build path settings add *mysql-connector-java-[version].jar* .
- Select apply and close.

In java Main class import the Driver
```
try{
	Class.forName("com.mysql.cj.jdbc.Driver");
}catch (ClassNotFoundException e){
	e.printStackTrace();
}
```

Now we need to connect of our database, for do this we can use a String for database URL, and two Strings for Username and Password.

```
public static String connectorUrl = "jdbc:mysql://localhost:3306/provaDB?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"; //Replace "provaDB" with your DB name and UTC with your Timezone
public static String tableName = "event"; // Replace with your table name

public static String User = "root"; // Replace with your DB User
public static String Pass = "root"; // Replace with your DB user password 
```

And now we can start to add, remove or edit our database's row.

Some example are provided in DBConnection.java file. [Link](https://github.com/Stefifox/dbTest/blob/master/src/stefifox/test/DBConnection.java)