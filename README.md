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

# How to set up (Service port 8080 only)
### Docker Environment
Setting the datasource information of Spring Batch Meta-Table in docker environment, execute the following.

```
docker run -p 8080:8080 -e "SPRING_DATASOURCE_URL=jdbc:mariadb://meta_addr:3306/meta_database" -e "SPRING_DATASOURCE_USERNAME=scott" -e "SPRING_DATASOURCE_PASSWORD=tiger" yongs2020/springbatch-manager:1.0.0
```
### Kubernetes Environment
springbatch-manager.yaml
```
apiVersion: v1
kind: Service
metadata:
  name: springbatch-manager
spec:
  selector:
    service/name: springbatch-manager
  ports:
  - port: 8080
    protocol: TCP
    targetPort: 8080
  type: LoadBalancer
---
apiVersion: apps/v1
kind: Deployment
metadata:
  name: springbatch-manager
spec:
  replicas: 1
  selector:
    matchLabels:
      service/name: springbatch-manager
  strategy:
    type: Recreate   
  template:
    metadata:
      name: springbatch-manager
      labels:
        service/name: springbatch-manager
    spec:
      containers:
      - name: springbatch-manager
        image: yongs2020/springbatch-manager:1.0.0
        imagePullPolicy: IfNotPresent
        env:
        - name: SPRING_DATASOURCE_URL
          value: jdbc:mariadb://meta_addr:3306/meta_database 
        - name: SPRING_DATASOURCE_USERNAME
          value: scott 
        - name: SPRING_DATASOURCE_PASSWORD
          value: tiger   
        ports:
        - containerPort: 8080
```
Setting the datasource information of Spring Batch Meta-Table in kubernetes yaml file, execute the following.
```
kubectl apply -f springbatch-manager.yaml
```
### SpringBoot Environment
If you set your datasource information for spring batch meta-table in application.yml, the application is started on port 8080.

![yml](https://user-images.githubusercontent.com/13634581/156312793-3ec16573-d2c5-429b-a36c-eb392c7ba015.png)
