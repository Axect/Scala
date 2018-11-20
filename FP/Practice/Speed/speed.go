package main

func main() {
	A := make([]int, 1E+06, 1E+06)
	for i := range A {
		A[i] = i * i
	}

	s := 0
	for j := range A {
		s += A[j]
	}
	println(s)
}
