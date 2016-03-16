package com.trustpilot.sfdc.client;

import com.sforce.soap.enterprise.Connector;
import com.sforce.soap.enterprise.EnterpriseConnection;
import com.sforce.soap.enterprise.QueryResult;
import com.sforce.soap.enterprise.sobject.Contact;
import com.sforce.ws.ConnectionException;
import com.sforce.ws.ConnectorConfig;

public class SFClientDemo {
	private static final String USERID = "ami@trustpilot.com.tpreviews";
	private static final String PASSWORD = "Charmie12345!";
	private static final String SECURITYTOKEN = "kCdHLCa9SCI7x8AVvEhNQhez";

	public static void main(String[] args) {
		try {
			ConnectorConfig connectorConfig = new ConnectorConfig();
			connectorConfig.setUsername(USERID);
			connectorConfig.setPassword(PASSWORD + SECURITYTOKEN);
			connectorConfig.setPrettyPrintXml(true);
			connectorConfig.setTraceMessage(true);
			EnterpriseConnection connection = Connector
					.newConnection(connectorConfig);
			queryContacts(connection);
		} catch (ConnectionException e) {
			e.printStackTrace();
		}
	}

	private static void queryContacts(EnterpriseConnection connection) {
		try {
			QueryResult queryResults = connection
					.query("SELECT Id, FirstName, LastName " + "FROM Contact ");
			if (queryResults.getSize() > 0) {
				for (int i = 0; i < queryResults.getRecords().length; i++) {
					com.sforce.soap.enterprise.sobject.Contact c = (Contact) queryResults
							.getRecords()[i];
					System.out.println(c.getFirstName() + c.getLastName()
							+ c.getId());
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
