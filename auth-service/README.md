## How Migration works?
1.add below dependencies in pom.xml :
```
    <dependency>
        <groupId>org.flywaydb</groupId>
        <artifactId>flyway-core</artifactId>
        <version>7.0.1</version>
    </dependency>
```
2.add below plugin with following details as per db:
```
  <plugin>
        <groupId>org.flywaydb</groupId>
        <artifactId>flyway-maven-plugin</artifactId>
        <version>9.8.1</version>
        <configuration>
            <user>root</user>
            <password>Admin@123</password>
            <url>jdbc:mysql://localhost:3306/user_db</url>

        </configuration>
        <dependencies>
            <dependency>
                <groupId>mysql</groupId>
                <artifactId>mysql-connector-java</artifactId>
                <version>8.0.27</version>
            </dependency>
        </dependencies>
    </plugin>
```
3.In application.yml provide below values:
```
  flyway:
    baselineOnMigrate: true
    locations: classpath:db/migration
    schemas: user_db
    baselineVersion: 1
    baselineDescription: "baseline"
    enabled: true
```

4.As mentioned above, on location path keep all migrations.
  Migration file should follow naming convention V1__${task-name}
5.Now on application boot all migration should get run.Migration will get call only once and entry will be added into flyway_schema_history.