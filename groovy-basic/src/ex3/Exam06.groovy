package ex3

compute = { m ->
    m()
}

compute({println "안녕!"})
println "-------------------------"

compute {
    println "오호라"
    println "반가비!"
}
println "-------------------------"