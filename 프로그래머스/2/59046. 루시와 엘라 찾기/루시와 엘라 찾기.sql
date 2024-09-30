-- 코드를 입력하세요
-- 1. Lucy,... 동물 이름 필터링
-- 2. 아이디, 이름, 성별 및 중성화 필터링
-- 3. 아이디 순으로 오름차순
SELECT ANIMAL_ID, NAME, SEX_UPON_INTAKE
FROM ANIMAL_INS
WHERE NAME IN ('Lucy', 'Ella', 'Pickle', 'Rogan', 'Sabrina','Mitty')
ORDER BY ANIMAL_ID