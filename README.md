# MySQL Database Test
This is a little test of Java databases and MySQL tables. In this README I provide some examples of my tables and some snippets in order to implement databases in Java applications.

----

# Downloads
This code requires:
- **MySQL Server**: [Download](https://dev.mysql.com/downloads/mysql/)
- **Connector/J**: [Download](https://dev.mysql.com/downloads/connector/j/)
- **JRE and JDK**: [Download](https://www.java.com/it/download/) [Link](https://www.oracle.com/java/technologies/javase-jdk14-downloads.html)

For **Windows** users I suggest using **MySQL installer**: [Download](https://dev.mysql.com/downloads/installer/)

----

# How to create the database, its tables and how to use them
The first thing you need to do is start mysql using the root account.

Open the terminal and enter the following commands:

**Linux** (I use Ubuntu 18.10)

```mysql -u root -p```

**Windows**

```mysqlsh -u root -p```

Now, we can create the database:

```mysql> CREATE DATABASE [database_name];```

If windows shows JS after *mysql*, use the *\sql* command.

Select your Database:

```USE [database_name];```

Now, create a new table with:

```CREATE TABLE [table_name] ([field name] [Var type], [another filed name] [another var type]);```

Here's an example:

```CREATE TABLE events (id INT, event_name VARCHAR(20), event_description VARCHAR(256));```

We can use ```DESCRIBE [table_name];``` to show all the fields and their type; 
Here's what it returns in my case:

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

If you want to show all the values contained in each field you can use ```SELECT * FROM [table_name]```. That's what it gives to me as a result:

```SELECT * FROM events;```

```
+------+--------------+-----------------------+
| id   | event_name   | event_description     |
+------+--------------+-----------------------+
|    1 | test         | this is a description |
|    2 | Another test | this is a description |
+------+--------------+-----------------------+
```

In this case I have inserted 2 rows in my table.

For more options or other examples, please read the official tutorials provided in the official documentation. Here's the link: [Documentation](https://dev.mysql.com/doc/refman/8.0/en/database-use.html).

----
# Syntax

How to add the library to the build path:
- Search for the path of Connector/J installed on your computer. In my case it's ```C:\Program Files (x86)\MySQL\Connector J 8.0``` .
- Open your favorite IDE and add the following in the build path settings: *mysql-connector-java-[version].jar* .
- Apply and close.

After that, we have to import Driver in our Main class, just like this:
```
try{
	Class.forName("com.mysql.cj.jdbc.Driver");
}catch (ClassNotFoundException e){
	e.printStackTrace();
}
```

Now we need to connect to our database. In order to do this we can use a String for the database URL, and two Strings for both Username and Password.

```
public static String connectorUrl = "jdbc:mysql://localhost:3306/provaDB?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"; //Replace "provaDB" with your DB name and UTC with your Timezone
public static String tableName = "event"; // Replace with your table name

public static String User = "root"; // Replace with your DB User
public static String Pass = "root"; // Replace with your DB user password 
```

We can finally start to add, remove or edit our database rows.

Some other examples are provided into my DBConnection.java file: [Link](https://github.com/Stefifox/dbTest/blob/master/src/stefifox/test/DBConnection.java)
