# WebApp
- ### WAS에서 Session Cluster 와 DataSource 연결 테스트 하는 Web Application 입니다.
- ### Request Url List
  + <b>/session</b> : 세션테스트
  + <b>/ds</b> : WAS의 DataSource 테스트
    + 지원하는 DB
      + Oracle
      + MariaDB
      + MSSQL
      + MySQL
      
- ### Java Option
   ``` shell
   -Dwebapp.datasource.oracle=<DS Name>
   -Dwebapp.datasource.maria=<DS Name>
   -Dwebapp.datasource.mssql=<DS Name>
   -Dwebapp.datasource.mysql=<DS Name>
   -------------------------------------
   ex)
   -Dwebapp.datasource.oracle=oracleDS
   -Dwebapp.datasource.maria=mariaDS
   -Dwebapp.datasource.mssql=mssqlDS
   -Dwebapp.datasource.mysql=mysqlDS
   ```
