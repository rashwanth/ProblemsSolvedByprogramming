SQL Schema
Table: Weather

+---------------+---------+
| Column Name   | Type    |
+---------------+---------+
| id            | int     |
| recordDate    | date    |
| temperature   | int     |
+---------------+---------+
id is the primary key for this table.
This table contains information about the temperature on a certain day.
 

Write an SQL query to find all dates' Id with higher temperatures compared to its previous dates (yesterday).

Return the result table in any order.

-------------------------------------------------------------------------------------------------------------
select id from
(
    select id,
    temperature,
    lag(temperature,1) over (order by recordDate) as prevTemp,
    recordDate,
    lag(recordDate,1) over (order by recordDate) as prevRecordDate from weather
) l
 where temperature>prevTemp and datediff(day,prevRecordDate,recordDate)=1
