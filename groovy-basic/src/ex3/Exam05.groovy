package ex3

printMap = { m ->
    for(e in m) {
        println e.key + "=" + e.value
    }
}

myMap = ["홍길동":20, "임꺽정":30, "유관순":16]
printMap(myMap)
println "---------------------------"

printMap "홍길동":20, "임꺽정":30, "유관순":16
println "---------------------------"

printMap ("홍길동":20, "임꺽정":30, "유관순":16)
println "---------------------------"

printMap 홍길동:20, 임꺽정:30, 유관순:16
println "---------------------------"