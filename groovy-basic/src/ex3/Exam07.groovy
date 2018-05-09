package ex3

compute = { m ->
    m 10, 20
}

compute { a, b ->
    println a + b
}

compute { a, b ->
    println a + "-" + b + "=" + (a - b)
}