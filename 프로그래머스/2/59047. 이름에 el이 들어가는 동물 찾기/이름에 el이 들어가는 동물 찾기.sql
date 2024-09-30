-- 코드를 입력하세요
-- 1. 'EL'이 들어가는 이름을 필터링 (대소문자 구분 x)
-- 2. 아ㅏ이디와 이름을 조회
-- 3. 이름순으로 정렬
SELECT ANIMAL_ID, NAME
FROM ANIMAL_INS
WHERE
    ANIMAL_TYPE = 'DOG' and
    NAME like '%el%' or '%EL%'
ORDER BY NAME
