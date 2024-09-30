-- 코드를 입력하세요
-- 1. 2022년 9월에 속하는 대여 기록을 필터링
-- 2. 대여 기간 차이를 구하기
-- 3. 새로운 컬럼 RENT_TYPE을 추가
-- 4. 30일 이상인 경우 장기 대여, 미만인 경우 단기 대여
-- 5. 대여 기록 ID로 내림차순

SELECT HISTORY_ID, 
    CAR_ID, 
    DATE_FORMAT(START_DATE, '%Y-%m-%d') as START_DATE, 
    DATE_FORMAT(END_DATE, '%Y-%m-%d') as END_DATE,
    CASE WHEN DATEDIFF(END_DATE, START_DATE) + 1 >= 30 THEN '장기 대여'
    ELSE '단기 대여' END as RENT_TYPE
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE START_DATE BETWEEN '2022-09-01' and '2022-09-30'
ORDER BY HISTORY_ID desc