# Salesforce-Trustpilot-Java

Idea is to concept-proof that from Salesforce, one can pull contact details and trigger Trustpilot Review Requests

Note: This code is NOT supported by anyone, and shared on github for reference purpose only


Steps:

1. Create API Key and download Enterprise WSDL from Salesforce as sfdc-trustpilot.wsdl

2. Checkout SFDC's WSC from https://github.com/forcedotcom/wsc

3. java -classpath target/force-wsc-36.2.0-uber.jar com.sforce.ws.tools.wsdlc sfdc-trustpilot.wsdl enterprise.jar

4. Above enterprise.jar and force-wsc-36.2.0.jar must be kept in classpath along with sfdc-trustpilot.wsdl for SOAP client application

5. SQL Like syntax can be used in com.sforce.soap.enterprise.EnterpriseConnection's query method and ResultSet would contain relevant Java objects from the types com.sforce.soap.enterprise.sobject.*
