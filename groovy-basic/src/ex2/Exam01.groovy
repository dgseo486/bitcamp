package ex2

a = 70

if(a < 19)
    println "미성년"
else if(a >= 19 && a < 65)
    println "성년"
else 
    println "노인"
    
println a < 19 ? "미성년" : "성년"


