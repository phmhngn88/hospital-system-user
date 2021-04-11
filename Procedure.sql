
--XEM NGUOI DUNG HE THONG
create or replace PROCEDURE show_system_user
(v_TABLE OUT SYS_REFCURSOR)

AS
BEGIN
    open V_TABLE FOR
    SELECT *
    FROM all_users
    order by created DESC;
End;

--XEM ROLE HE THONG
GRANT SELECT ANY DICTIONARY TO HOSPITALDBA;
create or replace PROCEDURE show_system_role
(v_TABLE OUT SYS_REFCURSOR)

AS
BEGIN
    open V_TABLE FOR
    SELECT *
    FROM DBA_ROLES
    ORDER BY ROLE_ID DESC;
End;

--XEM QUYEN CUA NGUOI DUNG
CREATE OR REPLACE PROCEDURE view_user_priviledge
(v_TABLE OUT  SYS_REFCURSOR)
AS
BEGIN
OPEN v_TABLE FOR
SELECT USER_TAB_PRIVS.*
FROM USER_TAB_PRIVS
WHERE OWNER = 'HOSPITALDBA';
End;


--CAP QUYEN -- THAM SO(username, table, priviledge, grant_option (true/false), column('ALL COLUMN' = khong phan quyen tren cot)
CREATE OR REPLACE PROCEDURE grant_priviledge(
    v_USER IN NVARCHAR2,
    v_TABLE IN NVARCHAR2,
    v_privil IN NVARCHAR2,
    v_GRANT_OPTION IN NVARCHAR2,
    v_COLUMN IN NVARCHAR2  
)
AUTHID CURRENT_USER
IS
    user_name NVARCHAR2(20)  	:= v_USER;
    grant_table NVARCHAR2(20) 		:= v_TABLE;
    grant_privil NVARCHAR2(20)     := v_privil;
    grant_column NVARCHAR2(20)     := v_COLUMN;
    grant_option NVARCHAR2(20)        := v_GRANT_OPTION;
    lv_stmt   NVARCHAR2 (1000);
BEGIN
    IF grant_column = 'ALL COLUMNS' THEN
        IF grant_option = 'TRUE' THEN
            lv_stmt := 'GRANT ' || grant_privil || ' ON ' || grant_table || ' TO ' || user_name || ' WITH GRANT OPTION';
        ELSE
            lv_stmt := 'GRANT ' || grant_privil || ' ON ' || grant_table || ' TO ' || user_name;
        END IF;
    ELSE
        IF grant_option= 'TRUE' THEN
            lv_stmt := 'GRANT ' || grant_privil || '(' || grant_column || ') ' ||  ' ON ' || grant_table || ' TO ' || user_name || ' WITH GRANT OPTION';
        ELSE
            lv_stmt := 'GRANT ' || grant_privil || '(' || grant_column || ') ' || ' ON ' || grant_table || ' TO ' || user_name;
        END IF;
    END IF;
    --DBMS_OUTPUT.put_line(lv_stmt);
    EXECUTE IMMEDIATE ( lv_stmt ); 
END;

BEGIN
    grant_priviledge('NV001', 'DICHVU', 'SELECT', 'TRUE', 'ALL COLUMNS');
END;

--THU QUYEN
CREATE OR REPLACE PROCEDURE revoke_priviledge(
    v_USER IN NVARCHAR2,
    v_TABLE IN NVARCHAR2,
    v_privil IN NVARCHAR2
)
AUTHID CURRENT_USER
IS
    user_name NVARCHAR2(20)  	:= v_USER;
    rv_table NVARCHAR2(20) 		:= v_TABLE;
    rv_privil NVARCHAR2(20)     := v_privil;
    lv_stmt   NVARCHAR2 (1000);
BEGIN
    lv_stmt := 'REVOKE ' || rv_privil || ' ON ' || rv_table || ' FROM ' || user_name;
    EXECUTE IMMEDIATE ( lv_stmt ); 
END;

BEGIN
    revoke_priviledge('C##TEST1', 'DICHVU', 'INSERT');
END;


--THU QUYEN
CREATE OR REPLACE PROCEDURE revoke_role(
    v_USER IN NVARCHAR2,
    V_ROLE IN NVARCHAR2
)
AUTHID CURRENT_USER
IS
    user_name NVARCHAR2(20)  	:= v_USER;
    RV_ROLE NVARCHAR2(20)     := V_ROLE;
    lv_stmt   NVARCHAR2 (1000);
BEGIN
    lv_stmt := 'REVOKE ' || RV_ROLE || ' FROM ' || user_name;
    EXECUTE IMMEDIATE ( lv_stmt ); 
END;

--Xem thong tin ve role cua user
CREATE OR REPLACE PROCEDURE view_user_roles
(v_TABLE OUT  SYS_REFCURSOR)
AS
BEGIN
OPEN v_TABLE FOR
SELECT
  DBA_ROLE_PRIVS.*
FROM
  DBA_ROLE_PRIVS, all_users
WHERE all_users.username = dba_role_privs.grantee;
end;