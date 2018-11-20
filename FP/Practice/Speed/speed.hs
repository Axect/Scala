main :: IO ()
main = do
    let a = [1 .. 1000000]
    let res = foldr (+) 0 (map (^2) a)
    print $ res