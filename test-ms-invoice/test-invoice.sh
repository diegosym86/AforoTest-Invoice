echo **************************************************************
echo Generate JAR
echo **************************************************************
mvnw clean package -DskipTests
echo **************************************************************
echo BUILD AND PUSH Docker
echo **************************************************************
docker stop app-invoices
docker rm  app-invoices
echo **************************************************************
docker  build -t jhonarizaifx/test-ms-invoice .
docker push  jhonarizaifx/test-ms-invoice
echo **************************************************************
echo run image 
docker run -p 8001:8001 --name app-invoices --network aforo255-test -d jhonarizaifx/test-ms-invoice
echo *************************************************************
echo End Process
echo *************************************************************