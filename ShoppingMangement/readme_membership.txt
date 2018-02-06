Membership framework:

1. Set up environment:
	- Download and install Java Cryptography Extension (JCE) Unlimited Strength Jurisdiction Policy Files 8
	for Encryption. URL: http://www.oracle.com/technetwork/java/javase/downloads/jce8-download-2133166.html
	
2. Config file 
	- Config some parameter in the config.java. 
	path:\ASD_Project\ShoppingMangement\src\main\java\framework\membership\Config.java
3. Implement hook method
	- Login: extends AbstractLogin and override 1 method: String extractPasswordFromDataBase(String username)
	call template method boolean login(String username, String password) 
	- Signup: extends AbstractSignUp and override 