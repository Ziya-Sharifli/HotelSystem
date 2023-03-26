# HotelSystem

Made as a group project while studying at Dokuz Eylul University Izmir. [DEUCENG Website](https://ceng.deu.edu.tr)

Java terminal program that can do the following:

1. Add rooms
2. Add employees
3. Add customers
4. Add reservations
5. List all of the above
6. Search for customers by their name
5. Various of statistics

The program can execute from commands using `commands.txt` file.

You can put the following commands to the `commands.txt` file in this form:

1. `addRoom;number-of-rooms;type;aircondition;balcony;price`
2. `addEmployee;name;surname;gender;birthdate;addresstext;district;city;phone;job;salary`
3. `addCustomer;name;surname;gender;birthdate;addresstext;district;city;phone`
4. `addReservation;customer-id;room-id;start-date;end-date`
5. `deleteEmployee;employee-id`
6. `listRooms`
7. `listEmployees`
8. `listCustomers`
9. `listReservations`
10. `statistics`
11. `searchCustomer;string`

What's not working? (All work in progress)

1. `searchCustomer` command only supports * and not ?
2. `statistics` command only 50% works.
3. `searchRoom` command is yet to be implemented.
4. `simulation` command is yet to be implemented.
