package com.sample.app.config;

import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.core.env.Environment;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.server.Neo4jServer;
import org.springframework.data.neo4j.server.RemoteServer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableNeo4jRepositories("com.sample.app.neo4j.repository")
@EnableTransactionManagement
public class DatabaseConfigurationNeo4j extends Neo4jConfiguration {

	@Autowired
	private Environment environment;

	@Override
	public SessionFactory getSessionFactory() {
		return new SessionFactory("com.sample.app.neo4j.domain");
	}

	@Bean
	public Neo4jServer neo4jServer() {		
		String host = environment.getProperty("spring.neo4j.host");
		String username = environment.getProperty("spring.neo4j.username");
		String password = environment.getProperty("spring.neo4j.password");

		return new RemoteServer(host, username, password);
	}

	@Override
	@Bean
	@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
	public Session getSession() throws Exception {
		return super.getSession();
	}
}
