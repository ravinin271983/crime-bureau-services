# Crime Bureau Backend Services
This is backend services project for Crime Bureau App, which was developed for college students. 

# How to run
Import project into your IDE<br />
Update application.properties file as per your database configuration<br />
Find CrimeBureauApplicationLauncher in you IDE and run as Java Application <br/>

# How to test
Create Investigating Officer:<br/>
curl --location 'http://localhost:8080/investigatingofficer' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "Ravindra Verma",
	"officerId": "ravin.in@gmail.com", 
    "dept": "IT", 
    "contact": "8800372326", 
    "role": "IT Dev"
}'<br/>
List Investigating Officer: <br/>
curl --location 'http://localhost:8080/investigatingofficer'<br/>
<br/>
Create Victim:<br/>
curl --location 'http://localhost:8080/victim' \
--header 'Content-Type: application/json' \
--data '{
    "name": "Victim 1", 
    "contactNo": "9999999999",
    "address": "Noida"
}'<br/>
List Victim: <br/>
curl --location 'http://localhost:8080/victim'<br/>
<br/>
Create Evidence:
curl --location 'http://localhost:8080/evidence' \
--header 'Content-Type: application/json' \
--data '{
	"evidenceType": "Video", 
    "evidenceDetails": "Video showing crime."
}'
List Evidence: <br/>
curl --location 'http://localhost:8080/evidence'<br/>
<br/>
Create Suspect:<br/>
curl --location 'http://localhost:8080/suspect' \
--header 'Content-Type: application/json' \
--data '{
    "name": "Abc", 
    "gender": "Male",
    "address": "Noida",
    "age": "37",
    "crimeHistory": "Theft"
}'<br/>
List Suspect: <br/>
curl --location 'http://localhost:8080/suspect'<br/>
Create Case:<br/>
curl --location 'http://localhost:8080/cases' \
--header 'Content-Type: application/json' \
--data '{
    "description": "Test Case for testing purpose",
    "investigatingOfficerId": 1,
    "suspectIds": [1,2],
    "victimIds": [1,2],
    "status": "OPEN",
    "dateReported": "2025-04-20T05:55:14.232Z",
    "evidenceIds": [1,2]
}'<br/>
List Case: <br/>
curl --location 'http://localhost:8080/cases'<br/>
