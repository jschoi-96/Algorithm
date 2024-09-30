-- 코드를 입력하세요
-- 1. 중성화 되어있으면 'O', 안되어있으면 'X'로 표시
-- 2. 아이디, 이름, 중성화 여부 출력
-- 3. 아이디 순으로 조회
SELECT ANIMAL_ID, NAME,
    CASE 
        WHEN SEX_UPON_INTAKE LIKE '%Neutered%' THEN 'O'
        WHEN SEX_UPON_INTAKE LIKE '%Spayed%' THEN 'O'
        ELSE 'X'
    END as 중성화
FROM ANIMAL_INS
ORDER BY ANIMAL_ID