# REST Tic Tac Toe exercise

This is the starting point for the REST Tic Tac Toe exercise.

The project is composed by three modules:
- [server](server/) - implementation of service
- [contract](contract/) - exchanged messages definition
- [client](client/) - invocation of service

See the README for each module. Start at contract, then go to server, and finally go to the client.

----
## Functionality
The functionality was ****fully**** implemented:
When the client connects to the server, it sends a request to check if the previous game has finished. If so, it will send another request to reset the board, if not, it will just continue playing the previous game.


You must first install the `contract` module by using the following command:
```
cd contract; mvn clean install; cd ..
```

To compile and run each module (`server` and `client`) run ```mvn clean compile exec:java``` in the corresponding folder.
Example:
```
cd server; mvn clean compile exec:java
cd client; mvn clean compile exec:java
```


----

## Authors

**Group A22**

58524 [João Filipe Pereira Sousa](mailto:joao.sousa@tecnico.ulisboa.pt)

89475 [João Miguel Do Ó Matos Soares](mailto:joao.m.soares@tecnico.ulisboa.pt)

89479 [João Pedro Borges Lopes](mailto:joaopedrolopes@tecnico.ulisboa.pt)


----

For help, please contact:

[SD Faculty](mailto:leic-sod@disciplinas.tecnico.ulisboa.pt)
