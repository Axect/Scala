package main

import (
	"fmt"
	"time"
)

func main() {
	start := time.Now()
	A := make([]int, 1E+06, 1E+06)
	for i := range A {
		A[i] = i * i
	}
	elapsed := time.Since(start)
	fmt.Println(elapsed)
}
