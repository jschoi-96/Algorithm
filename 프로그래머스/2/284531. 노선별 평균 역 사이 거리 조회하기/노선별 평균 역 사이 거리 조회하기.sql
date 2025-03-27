-- 코드를 작성해주세요
-- 조건: 노선, 총 누계 거리, 평균 역 사이 거리
-- 테이블: SUBWAY_DISTANCE
-- 조건: 총 누계 거리는 둘째자리 반올림, 평균 역 사이는 셋째 자리 반올림
-- km단위 추가
-- 정렬: 누계 거리를 기준으로 내림차순
SELECT 
    ROUTE, 
    CONCAT(ROUND(SUM(D_BETWEEN_DIST), 1), 'km') AS TOTAL_DISTANCE,
    CONCAT(ROUND(AVG(D_BETWEEN_DIST), 2), 'km') AS AVERAGE_DISTANCE
FROM 
    SUBWAY_DISTANCE
GROUP BY 
    ROUTE
ORDER BY
    SUM(D_BETWEEN_DIST) DESC