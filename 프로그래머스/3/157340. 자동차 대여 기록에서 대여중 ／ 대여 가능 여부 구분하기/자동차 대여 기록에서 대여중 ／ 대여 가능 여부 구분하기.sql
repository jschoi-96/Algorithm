-- 코드를 입력하세요
SELECT car_id, 
    MAX(CASE WHEN '2022-10-16' BETWEEN DATE_FORMAT(START_DATE, '%Y-%m-%d') 
        AND DATE_FORMAT(END_DATE, '%Y-%m-%d')
        THEN '대여중'
        ELSE '대여 가능'
    END) AS 'AVAILABILITY'
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
group by car_id 
order by car_id desc