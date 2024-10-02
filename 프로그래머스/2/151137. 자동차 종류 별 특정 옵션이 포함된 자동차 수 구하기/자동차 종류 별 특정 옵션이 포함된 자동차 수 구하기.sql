-- 코드를 입력하세요
-- 1. 하나 이상의 옵션인 자동차를 필터링
-- 2. 
SELECT CAR_TYPE, COUNT(*) as CARS 
FROM CAR_RENTAL_COMPANY_CAR
WHERE 
   OPTIONS REGEXP '통풍시트|열선시트|가죽시트'
GROUP BY CAR_TYPE
ORDER BY CAR_TYPE