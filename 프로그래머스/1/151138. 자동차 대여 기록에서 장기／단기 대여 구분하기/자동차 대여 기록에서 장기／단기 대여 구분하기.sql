-- 코드를 입력하세요
SELECT 
    history_id,
    car_id,
    date_format(start_date, '%Y-%m-%d') as START_DATE,
    date_format(end_date, '%Y-%m-%d') as END_DATE,
    case 
        when datediff(end_date , start_date) + 1 >= 30 then '장기 대여'
        else '단기 대여'
    end as RENT_TYPE
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where start_date like '2022-09%'
order by history_id desc