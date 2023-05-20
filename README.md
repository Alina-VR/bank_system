# Some information:

## _BankSystem_
authors: Raznosilina Alina and Ermakova Elena

_This is a BankSystem. Our Clients and Banks can sign up or sign in. Clients also choose bank, account (debit or credit)
and push, withdraw or transfer amount of money. Banks can set their credit limit, fee and watch the accounts._

* this is our development branch
* here you can see the actual project code

+ required java version 11
+ our program build with maven, required version 3.8.1

### _To start the program:_
* go to the folder where you want to install the program using cd
* then type : _git clone_ _**https://gitlab.akhcheck.ru/alina.raznosilina/banksystem.git**_
* then type _**cd banksystem**_
* then type _**mvn clean package**_
* then type _**java -jar target/bankSystem-1.0.0-jar-with-dependencies.jar**_

### _To see the javadoc:_
* do the following commands from _**banksystem**_ directory
* type _**mvn install**_
* then type _**mvn javadoc:aggregate**_
* then find directory _**target/site/apidocs/org/bankSystem**_
* choose tha package and the file that you are interested in and push is using right button of your mouse
* then find option _**open in browser**_
* you will go to the site page

### _To see the javadoc:_
* our bank system has a simple interface
* all you need to do is to follow the instructions and enter symbols from brackets
* if you find any problems, please, email us
* we will be glad to do our bank system better for you


+ here are the UML Diagram and Use Case Diagram (look at _banksystem/ UML Diagram and Use Case Diagram_)
+ here are open base files (for the first time) (look at _ClientsData_, _BanksData_ and _AccountsData_)

### _Thank you for using our app!_