pub fn main() {
    let mut v = vec![0; 1_000_000];
    for i in 0 .. 1_000_000 {
        v[i] = i * i;
    }

    let mut s = 0;
    for j in 0 .. 1_000_000 {
        s += j;
    }
    println!("{}", s);
}