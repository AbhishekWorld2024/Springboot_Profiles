# Springboot_Profiles
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Spring Boot Profiles</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      line-height: 1.6;
      background-color: #f9f9f9;
      padding: 20px;
      color: #333;
    }
    code, pre {
      background-color: #eee;
      padding: 5px 10px;
      border-radius: 4px;
      font-family: Consolas, monospace;
    }
    h1 {
      color: #2c3e50;
    }
    h2 {
      color: #34495e;
    }
    ul {
      margin-top: 0;
    }
  </style>
</head>
<body>

  <h1>Spring Boot Profiles</h1>

  <p><strong>Spring Boot Profiles</strong> allow you to segregate parts of your application configuration and bean definitions based on different environments like <em>development</em>, <em>testing</em>, or <em>production</em>.</p>

  <h2>Why Use Spring Boot Profiles?</h2>
  <p>To manage environment-specific settings:</p>
  <ul>
    <li><strong>Dev:</strong> Use an H2 in-memory database.</li>
    <li><strong>Prod:</strong> Use MySQL/PostgreSQL.</li>
    <li><strong>Test:</strong> Use mock services or test databases.</li>
  </ul>

  <h2>Defining Profiles</h2>

  <h3>1. application-&lt;profile&gt;.properties or .yml</h3>
  <pre><code># application-dev.properties
server.port=8081
spring.datasource.url=jdbc:h2:mem:testdb
  </code></pre>

  <pre><code># application-prod.properties
server.port=8080
spring.datasource.url=jdbc:mysql://localhost:3306/proddb
  </code></pre>

  <h3>2. Activating a Profile</h3>
  <ul>
    <li>In <code>application.properties</code>:
      <pre><code>spring.profiles.active=dev</code></pre>
    </li>
    <li>As a command-line argument:
      <pre><code>java -jar myapp.jar --spring.profiles.active=prod</code></pre>
    </li>
    <li>In <code>application.yml</code>:
      <pre><code>spring:
  profiles:
    active: dev</code></pre>
    </li>
    <li>As an environment variable:
      <pre><code>export SPRING_PROFILES_ACTIVE=dev</code></pre>
    </li>
  </ul>

  <h2>Using @Profile Annotation</h2>
  <p>To conditionally load beans depending on the active profile:</p>
  <pre><code>@Configuration
@Profile("dev")
public class DevConfig {
    // dev-specific beans
}
  </code></pre>

  <pre><code>@Configuration
@Profile("prod")
public class ProdConfig {
    // prod-specific beans
}
  </code></pre>

  <h2>Summary</h2>
  <ul>
    <li>Manage environment-specific settings easily.</li>
    <li>Load different beans/configurations based on the profile.</li>
    <li>Keep your application flexible and environment-aware.</li>
  </ul>

</body>
</html>
