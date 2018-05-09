package ex3

int plus(int a, int b) {
    return a + b;
}

def plus2(a, b) {
    a + b
}

println plus(100, 200)
println plus2(100, 200)

sum = plus 100, 200
println sum

sum = plus2 100, 200
println sum
