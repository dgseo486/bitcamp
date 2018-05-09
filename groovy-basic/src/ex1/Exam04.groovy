package ex1

map1 = ["홍길동":20, "임꺽정":30, "유관순":16]
println map1["홍길동"]
println map1.홍길동

println map1.getClass()

map1.홍길동 = 40
println map1.홍길동

emptyMap = [:]
println emptyMap.getClass()