package ex5

println "문자열 속에 '그냥문자로취급'한다."
println '문자열 속에 "그냥문자로취급"한다.'
println "큰 따옴표 \"도 그냥 문자로 사용하고 싶고, 작은 따옴표 '도 그냥 문자로 사용하고 싶다."
println (/큰 따옴표 \"도 그냥 문자로 사용하고 싶고, 작은 따옴표 '도 그냥 문자로 사용하고 싶다/)

println """
동해물과 백두산이 마르고 닳도록
하느님이 보우하사 우리나라 만세
무궁화 삼천리 화려강산
"""

name = "홍길동"
age = 20

println name + "님의 나이는 " + age + "입니다."
println "$name 님의 나이는 $age 입니다."