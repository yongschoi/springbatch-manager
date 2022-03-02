# SpringBatchManager Quickstart Guide 
It supports Batch Job management efficiently by using Spring Batch meta table information.
# version
1.0.0
# Function Summary
### Job Check
Shows the list of failed and successful jobs.

![jobcheck](https://user-images.githubusercontent.com/100505047/155977234-d51bf310-e884-4c56-95fc-64f30800480c.png)

### Job History
Details of the execution history of a specific job.

![jobhistory](https://user-images.githubusercontent.com/100505047/155977274-3c02fcda-cddd-4f3b-a6e1-c6c896c69b2c.png)

### Job Distribution
Shows the distribution of job execution by time.

![dist](https://user-images.githubusercontent.com/100505047/155977433-4c9add59-b334-42f1-8138-fcfb79d09637.png)

# How to set up
If you set your database url for spring batch meta-table in application.yml, the application is started on port 8080.

![yml](https://user-images.githubusercontent.com/100505047/155978569-b72ba16e-7856-421c-a02d-fde67f6e213d.png)

# Docker Installation
Setting the database url of Spring Batch Meta-Table in docker environment, execute the following.

```
docker run -p 8080:8080 -e "SPRING_DATASOURCE_URL=jdbc:mariadb://meta_addr:3306/meta_database" -e "SPRING_DATASOURCE_USERNAME=scott" -e "SPRING_DATASOURCE_PASSWORD=tiger" yongs2020/springbatch-manager:1.0.0
```
