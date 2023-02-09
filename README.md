# WebApp
- ### WAS에서 Session Cluster 와 DataSource 연결 테스트 하는 Web Application 입니다.
- ### Spring Boot로 만듬.
- ### Request Url List
  + <b>/session</b> : 세션테스트
  + <b>/ds</b> : WAS의 DataSource 테스트
      
- ### Java Option (WAS에 적용)
   ``` shell
   -Dwebapp.datasource.list=<DS Name>,<DS Name>,......,<DS Name>
   -------------------------------------
   ex)
   -Dwebapp.datasource.list=oracleDS,mariaDS,mssqlDS,mysqlDS
