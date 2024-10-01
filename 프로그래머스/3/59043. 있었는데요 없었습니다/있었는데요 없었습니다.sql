-- 코드를 입력하세요
-- 1. 보호 시작일보다 입양일이 빠른 (즉, 양쪽의 데이터 값을 알아야 하나?)
SELECT O.ANIMAL_ID, O.NAME
FROM ANIMAL_OUTS O
INNER JOIN ANIMAL_INS I
ON O.ANIMAL_ID = I.ANIMAL_ID
WHERE O.DATETIME < I.DATETIME
ORDER BY I.DATETIME