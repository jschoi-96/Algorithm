-- 코드를 입력하세요
-- 1. 입양을 간 기록이 있고, 보호소에 들어온 기록이 없는 조건 필터링
-- 2. 해당 동물의 ID와 이름을 조회
-- 3. ID순으로 조회


SELECT O.ANIMAL_ID, O.NAME
FROM ANIMAL_OUTS O
LEFT JOIN ANIMAL_INS I
ON O.ANIMAL_ID = I.ANIMAL_ID
WHERE I.ANIMAL_ID IS NULL
ORDER BY O.ANIMAL_ID