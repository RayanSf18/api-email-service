# Email Service API
This is an email service API developed in Java Spring Boot, utilizing AWS SES (Simple Email Service) and adhering to the Clean Architecture pattern.

## Endpoints
### Send Email
**Method**: POST  
**Route**: /api/email  
**Request Body**:  
```
{
  "to": "test@gmail.com", 
  "subject": "Message",
  "body": "Hello world"
}
```
**Responses**:
 - Code 200 (Success)
   - Response Body: "Email sent successfully"
 - Code 500 (Error)
   - Response Body: "Error while sending email"
     
## Project Structure
The project structure follows the Clean Architecture pattern, with the following layers:

 - **adapters**: Contains implementations of adapters to handle external communication, such as AWS SES.
 - **application**: Application layer containing use cases of the application.
 - **controllers**: Responsible for receiving HTTP requests and forwarding them to use cases.
 - **core**: Contains business rules and entities of the application.
 - **infra**: Infrastructure layer to handle technical details, such as database or external services.

## Configuration
Before starting the service, you need to configure AWS SES credentials in the application.properties file. Make sure to add your credentials and configure regions and other necessary information for integration with AWS SES.
```
# AWS SES Configuration
aws.access_key_id=YOUR_ACCESS_KEY_ID
aws.secret_access_key=YOUR_SECRET_ACCESS_KEY
aws.region=YOUR_AWS_REGION
```

## Starting the Service
To start the service, ensure you have Java and Maven installed on your machine. Then, execute the following command in the project's root:
```
mvn spring-boot:run
```
The service will be available at http://localhost:8080.

## Dependencies
In addition to the standard Spring Boot dependencies, this project uses the following libraries:

 - **AWS SDK for Java**: For integration with AWS SES.
 - **Spring Web**: To handle HTTP requests.
   
Ensure that dependencies are correctly configured in the pom.xml file.

## Contributing
Feel free to contribute improvements, bug fixes, or new features. You can open a PR (Pull Request) or an issue in this repository.
